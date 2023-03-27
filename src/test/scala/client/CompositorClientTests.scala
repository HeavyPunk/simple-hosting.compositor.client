package client

import io.github.heavypunk.compositor.client.settings.ClientSettings
import java.net.URI
import com.google.gson.Gson
import io.github.heavypunk.compositor.client.models.CreateServerRequest

class CompositorClientTests extends munit.FunSuite{
  test("Serialize create server request") {
    val json = new Gson()
    val res = json.toJson(new CreateServerRequest(
      "image-uri",
      "vm",
      1024 * 1024 * 1024,
      1024 * 1024 * 1024 * 5,
      0,
      Array()
    ))
    assertEquals(res, "{\"vmImageUri\":\"image-uri\",\"vmName\":\"vm\",\"vmAvailableRamBytes\":1073741824,\"vmAvailableDiskBytes\":1073741824,\"vmAvailableSwapBytes\":0,\"vmExposePorts\":[]}")
  }

  test("Deserialize create server request") {
    val json = new Gson()
    val res = json.fromJson(
      "{\"vmImageUri\":\"image-uri\",\"vmName\":\"vm\",\"vmAvailableRamBytes\":1073741824,\"vmAvailableDiskBytes\":1073741824,\"vmAvailableSwapBytes\":0,\"vmExposePorts\":[]}",
      classOf[CreateServerRequest]
    )
    var etalon = new CreateServerRequest(
      "image-uri",
      "vm",
      1024 * 1024 * 1024,
      1024 * 1024 * 1024 * 5,
      0,
      Array()
    )
    assertEquals(res, etalon)
  }
}
