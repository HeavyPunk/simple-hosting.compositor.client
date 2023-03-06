package models

import com.google.gson.annotations.SerializedName

class CreateServerResponse(
    @SerializedName("vm-id") val vmId: String
){
    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[CreateServerResponse])
        val obj = other.asInstanceOf[CreateServerResponse]
        obj.vmId.equals(vmId)
}

class StartServerResponse(
    @SerializedName("vm-id") val vmId: String,
    @SerializedName("ip") val vmWhiteIp: String,
    @SerializedName("ports") val vmWhitePorts: Array[String]
){
    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[StartServerResponse])
        val obj = other.asInstanceOf[StartServerResponse]
        obj.vmId.equals(vmId)
        && obj.vmWhiteIp.equals(vmWhiteIp)
        && obj.vmWhitePorts.equals(vmWhitePorts)
}

class StopServerResponse(
    @SerializedName("success") val success: Boolean   
){
    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[StopServerResponse])
        val obj = other.asInstanceOf[StopServerResponse]
        obj.success.equals(success)
}
