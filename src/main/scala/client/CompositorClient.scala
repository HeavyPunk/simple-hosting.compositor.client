package client

import java.time.OffsetTime
import models.CreateServerResponse
import models.StopServerRequest
import models.StopServerResponse
import models.CreateServerRequest

trait CompositorClient {
  def createServer(request: CreateServerRequest, timeout: OffsetTime): CreateServerResponse
  def stopServer(request: StopServerRequest, timeout: OffsetTime): StopServerResponse
}
