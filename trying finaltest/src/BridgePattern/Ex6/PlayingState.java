package BridgePattern.Ex6;

public class PlayingState extends State {
    protected AudioPlayer player;
    protected Event event;
    public PlayingState(AudioPlayer player) {
        super(player);
    }
    @Override
    public void clickLock() {
        player.changeState(new LockedState(player));
    }
    @Override
    public void clickPlay() {
        player.stopPlayback();
        player.changeState(new ReadyState(player));
    }
    @Override
    public void clickNext() {
        if (event.Click()) {
            player.nextSong();
        }
        else {
            player.fastForward(5);
        }
    }
    @Override
    public void clickPrevious() {
        if (event.Click()) {
            player.previousSong();
        }
        else {
            player.rewind(5);
        }
    }
}
