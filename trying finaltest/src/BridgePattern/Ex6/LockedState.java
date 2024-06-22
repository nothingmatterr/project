package BridgePattern.Ex6;

public class LockedState extends State {
    protected AudioPlayer player;
    public LockedState(AudioPlayer player) {
        super(player);
    }
    @Override
    public void clickLock() {
        if (player.playing) {
            player.changeState(new PlayingState(player));
        }
        else {
            player.changeState(new ReadyState(player));
        }
    }
    @Override
    void clickPlay() {

    }

    @Override
    void clickNext() {

    }

    @Override
    void clickPrevious() {

    }


}
