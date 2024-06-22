package BridgePattern.Ex4;

public class Button extends Component{
    private Mediator dialog;
    public Button(Mediator dialog) {
        super(dialog);
    }
}
