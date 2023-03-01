package models

class CreateServerResponse(
    vmId: String
)

class StartServerResponse(
    vmId: String,
    vmWhiteIp: String,
    vmWhitePorts: Array[String]
)

class StopServerResponse(
    success: Boolean
)
