package client

import models.CreateServerResponse
import models.CreateServerRequest
import models.StopServerRequest
import models.StopServerResponse
import java.time.OffsetTime
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.URI
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import settings.ClientSettings
import com.google.gson.Gson
import java.net.http.HttpRequest.BodyPublishers

class CommonCompositorClient(val clientSettings: ClientSettings) extends CompositorClient {
    
    def createServer(request: CreateServerRequest, timeout: OffsetTime): CreateServerResponse = {
        val apiUri = clientSettings.apiUri.getPath()
        val endpoint = CommonCompositorClient.createServerPath
        val serializer = new Gson()
        var req = HttpRequest.newBuilder(URI.create(apiUri + endpoint))
            .POST(BodyPublishers.ofString(serializer.toJson(request)))
            .header("Authorization", s"Bearer ${clientSettings.apiKey}")
            .build();
        val client = HttpClient.newBuilder()
            .build()
        val resp = client.send(req, BodyHandlers.ofString())
        val statusCode = mapStatusCode(resp.statusCode())
        if statusCode == StatusCode.InternalServerError then
            throw new java.lang.RuntimeException(s"Create server returns a ${statusCode}")
        val body = serializer.fromJson(resp.body(), classOf[CreateServerResponse])

        return body
    }

    def stopServer(request: StopServerRequest, timeout: OffsetTime): StopServerResponse = {
        StopServerResponse(true)
    }
}

object CommonCompositorClient {
  val createServerPath = "/server/create"
  val stopServerPath = "/server/stop"
}

enum StatusCode(code: Int) {
    case UnknownStatusCode extends StatusCode(-1)
    case BadRequest extends StatusCode(400)
    case Unauthorized extends StatusCode(401)
    case PaymentRequired extends StatusCode(402)
    case Forbidden extends StatusCode(403)
    case InternalServerError extends StatusCode(500)
    case NotImplemented extends StatusCode(501)
    case ServiceUnavailable extends StatusCode(503)
}

def mapStatusCode(code: Int): StatusCode = {
    val map = Map(
        -1 -> StatusCode.UnknownStatusCode,
        400 -> StatusCode.BadRequest,
        401 -> StatusCode.Unauthorized,
        402 -> StatusCode.PaymentRequired,
        403 -> StatusCode.Forbidden,
        500 -> StatusCode.InternalServerError,
        501 -> StatusCode.NotImplemented,
        503 -> StatusCode.ServiceUnavailable
    )
    map.getOrElse(code, StatusCode.UnknownStatusCode)
}
