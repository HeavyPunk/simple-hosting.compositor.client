package io.github.heavypunk.compositor.client

import java.time.OffsetTime
import io.github.heavypunk.compositor.client.models.CreateServerResponse
import io.github.heavypunk.compositor.client.models.StopServerRequest
import io.github.heavypunk.compositor.client.models.StopServerResponse
import io.github.heavypunk.compositor.client.models.CreateServerRequest
import io.github.heavypunk.compositor.client.models.RemoveServerResponse
import io.github.heavypunk.compositor.client.models.StartServerResponse
import io.github.heavypunk.compositor.client.models.StartServerRequest
import io.github.heavypunk.compositor.client.models.RemoveServerRequest

trait CompositorClient {
  def createServer(request: CreateServerRequest, timeout: OffsetTime): CreateServerResponse
  def stopServer(request: StopServerRequest, timeout: OffsetTime): StopServerResponse
  def startServer(request: StartServerRequest, timeout: OffsetTime): StartServerResponse
  def removeServer(request: RemoveServerRequest, timeout: OffsetTime): RemoveServerResponse
}
