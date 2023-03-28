package io.github.heavypunk.compositor.client.models

import com.fasterxml.jackson.annotation.JsonProperty


class CreateServerResponse(
    @JsonProperty("vm-id") val vmId: String
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[CreateServerResponse])
        val obj = other.asInstanceOf[CreateServerResponse]
        obj.vmId.equals(vmId)
    }
}

class StartServerResponse(
    @JsonProperty("vm-id") val vmId: String,
    @JsonProperty("ip") val vmWhiteIp: String,
    @JsonProperty("ports") val vmWhitePorts: Array[String]
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[StartServerResponse])
        val obj = other.asInstanceOf[StartServerResponse]
        obj.vmId.equals(vmId) && obj.vmWhiteIp.equals(vmWhiteIp) && obj.vmWhitePorts.equals(vmWhitePorts)
    }
}

class StopServerResponse(
    @JsonProperty("success") val success: Boolean   
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[StopServerResponse])
        val obj = other.asInstanceOf[StopServerResponse]
        obj.success.equals(success)
    }
}

class RemoveServerResponse(
    @JsonProperty("success") val success: Boolean,
    @JsonProperty("error") val error: String
){
    override def equals(other: Any): Boolean = {
        other.getClass().equals(classOf[RemoveServerResponse])
        val obj = other.asInstanceOf[RemoveServerResponse]
        obj.success.equals(success) && obj.error.equals(error)
    }
}
