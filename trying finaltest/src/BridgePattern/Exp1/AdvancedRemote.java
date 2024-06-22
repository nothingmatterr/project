package BridgePattern.Exp1;

public class AdvancedRemote  extends Remote {
    protected Device device;
    public AdvancedRemote(Device device) {
        super(device);
    }
    public void mute() {
        device.setVolume(0);
    }
}
