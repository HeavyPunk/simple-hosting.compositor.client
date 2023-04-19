package io.github.heavypunk.compositor.client.models

import com.fasterxml.jackson.annotation.JsonProperty


class CreateServerRequest(
    @JsonProperty("image") val vmImageUri: String,
    @JsonProperty("name") val vmName: String,
    @JsonProperty("ram") val vmAvailableRamBytes: Long,
    @JsonProperty("disk") val vmAvailableDiskBytes: Long,
    @JsonProperty("swap") val vmAvailableSwapBytes: Long,
    @JsonProperty("internal-ports") val vmExposePorts: Array[String]
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[CreateServerRequest])
        val obj = other.asInstanceOf[CreateServerRequest]
        vmImageUri.equals(obj.vmImageUri) && vmName.equals(obj.vmName) && vmAvailableRamBytes.equals(obj.vmAvailableRamBytes) && vmAvailableDiskBytes.equals(obj.vmAvailableDiskBytes) && vmAvailableSwapBytes.equals(obj.vmAvailableSwapBytes)
    }
}

class StopServerRequest(
    @JsonProperty("vm-id") val vmId: String
){

    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[StopServerRequest])
        val obj = other.asInstanceOf[StopServerRequest]
        obj.vmId.equals(vmId)
    }
}

class StartServerRequest(
    @JsonProperty("vm-id") val vmId: String
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[StartServerRequest])
        val obj = other.asInstanceOf[StartServerRequest]
        obj.vmId.equals(vmId)
    }
}

class RemoveServerRequest(
    @JsonProperty("vm-id") val vmId: String
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[RemoveServerRequest])
        val obj = other.asInstanceOf[RemoveServerRequest]
        obj.vmId.equals(vmId)
    }
}
