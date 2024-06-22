package BridgePattern.Exp2;

public class PasteCommand extends Command {
    protected Application app;
    protected Editor editor;
    public PasteCommand(Application app, Editor editor) {
        super(app,editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(app.clipboard);
        return true;
    }
}
