package client

import io.github.heavypunk.compositor.client.settings.ClientSettings
import java.net.URI
import io.github.heavypunk.compositor.client.models.CreateServerRequest
import io.github.heavypunk.compositor.client.CommonCompositorClient
import java.time.Duration

class CompositorClientTests extends munit.FunSuite{
  test("Create server request") {
    val settings = new ClientSettings(new URI("http://localhost:8080"), "compositors")
    val client = new CommonCompositorClient(settings)
    val resp = client.createServer(new CreateServerRequest(
      "kirieshki/simple-hosting-minecraft-vanilla:preview-23.03.23.1",
      "kirieshki-main",
      322122547,
      1000000000,
      0,
      Array("8989:8989/tcp", "25565/tcp")
    ), Duration.ofMinutes(2))
    assert(resp.vmId != None && resp.vmId != "")
  }
}
