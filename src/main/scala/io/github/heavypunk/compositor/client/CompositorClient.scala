package io.github.heavypunk.compositor.client

import io.github.heavypunk.compositor.client.models.CreateServerResponse
import io.github.heavypunk.compositor.client.models.StopServerRequest
import io.github.heavypunk.compositor.client.models.StopServerResponse
import io.github.heavypunk.compositor.client.models.CreateServerRequest
import io.github.heavypunk.compositor.client.models.RemoveServerResponse
import io.github.heavypunk.compositor.client.models.StartServerResponse
import io.github.heavypunk.compositor.client.models.StartServerRequest
import io.github.heavypunk.compositor.client.models.RemoveServerRequest
import java.time.Duration

trait CompositorClient {
  def createServer(request: CreateServerRequest, timeout: Duration): CreateServerResponse
  def stopServer(request: StopServerRequest, timeout: Duration): StopServerResponse
  def startServer(request: StartServerRequest, timeout: Duration): StartServerResponse
  def removeServer(request: RemoveServerRequest, timeout: Duration): RemoveServerResponse
}
