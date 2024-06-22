package BridgePattern.Ex6;

public class Event {
    protected int pointerClick;
    public boolean Click() {
        if (pointerClick >= 2) {
            return true;
        }
        return false;
    }
}
