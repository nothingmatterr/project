package BridgePattern.Exp2;

public class CopyCommand extends Command {
    protected String text;
    protected Editor editor;
    protected Application app;
    public CopyCommand(Application app, Editor editor) {
        super(app,editor);
    }
    @Override
    public boolean execute() {
        app.clipboard = editor.getSelection();
        return false;
    }

}
