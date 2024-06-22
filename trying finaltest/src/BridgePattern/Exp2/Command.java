package BridgePattern.Exp2;

public abstract class Command {
    protected Application app;
    protected Editor editor;
    protected String text;
    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }
    public void saveBackup() {
        String backUp = editor.text;
    }
    public abstract boolean execute();
}
