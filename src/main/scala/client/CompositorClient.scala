package client

import java.time.OffsetTime
import models.CreateServerResponse
import models.StopServerRequest
import models.StopServerResponse
import models.CreateServerRequest
import models.RemoveServerResponse
import models.StartServerResponse
import models.StartServerRequest
import models.RemoveServerRequest

trait CompositorClient {
  def createServer(request: CreateServerRequest, timeout: OffsetTime): CreateServerResponse
  def stopServer(request: StopServerRequest, timeout: OffsetTime): StopServerResponse
  def startServer(request: StartServerRequest, timeout: OffsetTime): StartServerResponse
  def removeServer(request: RemoveServerRequest, timeout: OffsetTime): RemoveServerResponse
}
