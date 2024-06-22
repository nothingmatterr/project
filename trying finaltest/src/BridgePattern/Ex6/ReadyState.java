package BridgePattern.Ex6;

public class ReadyState extends State {
    protected AudioPlayer player;
    public ReadyState(AudioPlayer player) {
        super(player);
    }
    @Override
    public void clickLock() {
        player.changeState(new LockedState(player));
    }
    @Override
    public void clickNext() {
        player.nextSong();
    }
    @Override
    public void clickPrevious() {
        player.previousSong();
    }
}
