package io.github.heavypunk.compositor.client

import io.github.heavypunk.compositor.client.models.CreateServerResponse
import io.github.heavypunk.compositor.client.models.CreateServerRequest
import io.github.heavypunk.compositor.client.models.StopServerRequest
import io.github.heavypunk.compositor.client.models.StopServerResponse
import java.time.OffsetTime
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.URI
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import io.github.heavypunk.compositor.client.settings.ClientSettings
import java.net.http.HttpRequest.BodyPublishers
import io.github.heavypunk.compositor.client.models.StartServerRequest
import io.github.heavypunk.compositor.client.models.StartServerResponse
import io.github.heavypunk.compositor.client.models.RemoveServerRequest
import io.github.heavypunk.compositor.client.models.RemoveServerResponse
import java.time.Duration
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.databind.DeserializationFeature

class CommonCompositorClient(
    val clientSettings: ClientSettings,
) extends CompositorClient {
    val jsonizer = JsonMapper.builder()
        .addModule(DefaultScalaModule)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .build()

    def createServer(request: CreateServerRequest, timeout: Duration): CreateServerResponse = {
        val apiUri = clientSettings.apiUri.toString
        val endpoint = CommonCompositorClient.createServerPath
        val content = jsonizer.writeValueAsString(request)
        val req = HttpRequest.newBuilder(URI.create(apiUri + endpoint))
            .POST(BodyPublishers.ofString(content))
            .header("Authorization", s"Bearer ${clientSettings.apiKey}")
            .build();
        val client = HttpClient.newBuilder()
            .build()
        val resp = client.send(req, BodyHandlers.ofString())
        if (resp.statusCode() == 500)
            throw new java.lang.RuntimeException(s"Create server returns a ${resp.statusCode()}")
        val body = jsonizer.readValue(resp.body(), classOf[CreateServerResponse])

        body
    }

    def stopServer(request: StopServerRequest, timeout: Duration): StopServerResponse = {
        val apiUri = clientSettings.apiUri.toString;
        val endpoint = CommonCompositorClient.stopServerPath

        val content = jsonizer.writeValueAsString(request)
        val req = HttpRequest.newBuilder(URI.create(apiUri + endpoint))
            .POST(BodyPublishers.ofString(content))
            .header("Authorization", s"Bearer ${clientSettings.apiKey}")
            .build();
        val client = HttpClient.newBuilder()
            .build()
        val resp = client.send(req, BodyHandlers.ofString())
        if (resp.statusCode() == 500)
            throw new java.lang.RuntimeException(s"Stop server returns a ${resp.statusCode()}")
        val body = jsonizer.readValue(resp.body(), classOf[StopServerResponse])

        body
    }

    def startServer(request: StartServerRequest, timeout: Duration): StartServerResponse = {
        val apiUri = clientSettings.apiUri.toString
        val endpoint = CommonCompositorClient.startServerPath

        val content = jsonizer.writeValueAsString(request)
        val req = HttpRequest.newBuilder(URI.create(apiUri + endpoint))
            .POST(BodyPublishers.ofString(content))
            .header("Authorization", s"Bearer ${clientSettings.apiKey}")
            .build()
        val client = HttpClient.newBuilder()
            .build()
        val resp = client.send(req, BodyHandlers.ofString())
        if (resp.statusCode() == 500)
            throw new RuntimeException(s"Start server returns a ${resp.statusCode()}")
        val body = jsonizer.readValue(resp.body(), classOf[StartServerResponse])
        body
    }

    def removeServer(request: RemoveServerRequest, timeout: Duration): RemoveServerResponse = {
        val apiUri = clientSettings.apiUri.toString
        val endpoint = CommonCompositorClient.removeServerPath

        val content = jsonizer.writeValueAsString(request)
        val req = HttpRequest.newBuilder(URI.create(apiUri + endpoint))
            .POST(BodyPublishers.ofString(content))
            .header("Authorization", s"Bearer ${clientSettings.apiKey}")
            .build()
        val client = HttpClient.newBuilder()
            .build()
        val resp = client.send(req, BodyHandlers.ofString())
        if (resp.statusCode() == 500)
            throw new RuntimeException(s"Start server returns a ${resp.statusCode()}")
        val body = jsonizer.readValue(resp.body(), classOf[RemoveServerResponse])
        body
    }
}

object CommonCompositorClient {
  val createServerPath = "/server/create"
  val stopServerPath = "/server/stop"
  val startServerPath = "/server/start"
  val removeServerPath = "/server/remove"
}

