## http-client for simple-hosting-compositor service

### Compile

Run `./build.sh`

### Install

Just reference your project to `build/simple-hosting-compositor-client.jar`

### Usage
 There are some examples:
```
var settings = new ClientSettings(new URI("https://your-compositor-url"));
var client = new CommonCompositorClient(settings);

var createRes = client.createServer(new CreateServerRequest(
    vmImageUri: "your-account/server",
    vmName: "VirtualMachine_1",
    vmAvailableRamBytes: 1024 * 1024 * 1024,
    vmAvailableDiskBytes: 1024 * 1024 * 1024 * 4,
    vmAvailableSwapBytes: 0,
    vmExposePorts: new String[]{"25565/tcp"}
), null);
var startRes = client.startServer(new StartServerRequest(
    vmId: createRes.vmId
));
```

