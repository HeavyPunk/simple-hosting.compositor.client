package models

class CreateServerRequest(
    vmImageUri: String,
    vmName: String,
    vmAvailableRamBytes: Long,
    vmAvailableDiskBytes: Long,
    vmAvailableSwapBytes: Long,
    vmExposePorts: Array[String])

class StopServerRequest(
    vmId: String
)

class StartServerRequest(
    vmId: String
)
