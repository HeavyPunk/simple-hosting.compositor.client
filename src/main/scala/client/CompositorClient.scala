package client

import models.CreateServerResponse
import models.CreateServerRequest
import models.StopServerRequest
import models.StopServerResponse

class CompositorClient {
    def createServer(request: CreateServerRequest): CreateServerResponse = {
        CreateServerResponse("")
    }

    def stopServer(request: StopServerRequest): StopServerResponse = {
        StopServerResponse(true)
    }
}
