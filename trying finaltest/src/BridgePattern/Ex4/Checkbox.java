package BridgePattern.Ex4;

public class Checkbox extends Component{
    private Mediator dialog;
    boolean checked;
    public Checkbox(Mediator dialog) {
        super(dialog);
    }
    public boolean checkBox() {
        dialog.notify(this, "check");
        return true;
    }
    public boolean isChecked() {
        return checked;
    }
    public void setChecked() {
        this.checked = checked;
    }
}
