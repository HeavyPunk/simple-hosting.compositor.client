package models

import com.google.gson.annotations.SerializedName

class CreateServerRequest(
    @SerializedName("image-uri") val vmImageUri: String,
    @SerializedName("name") val vmName: String,
    @SerializedName("ram") val vmAvailableRamBytes: Long,
    @SerializedName("disk") val vmAvailableDiskBytes: Long,
    @SerializedName("swap") val vmAvailableSwapBytes: Long,
    @SerializedName("ports") val vmExposePorts: Array[String]
){
    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[CreateServerRequest])
        val obj = other.asInstanceOf[CreateServerRequest]
        vmImageUri.equals(obj.vmImageUri)
        && vmName.equals(obj.vmName)
        && vmAvailableRamBytes.equals(obj.vmAvailableRamBytes)
        && vmAvailableDiskBytes.equals(obj.vmAvailableDiskBytes)
        && vmAvailableSwapBytes.equals(obj.vmAvailableSwapBytes)

}

class StopServerRequest(
    @SerializedName("vm-id") val vmId: String
){

    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[StopServerRequest])
        val obj = other.asInstanceOf[StopServerRequest]
        obj.vmId.equals(vmId)

}

class StartServerRequest(
    @SerializedName("vm-id") val vmId: String
){
    override def equals(other: Any): Boolean = 
        other.getClass().equals(classOf[StartServerRequest])
        val obj = other.asInstanceOf[StartServerRequest]
        obj.vmId.equals(vmId)
}
