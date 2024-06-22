package BridgePattern.Exp2;

public class CutCommand extends Command{
    protected String text;
    protected Editor editor;
    protected Application app;
    public CutCommand(Application app, Editor editor) {
        super(app,editor);
    }
    @Override
    public boolean execute() {
        saveBackup();
        app.clipboard = editor.getSelection();
        return true;
    }
}
