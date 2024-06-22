package BridgePattern.Exp2;

public class UndoCommand extends Command {
    protected Application app;
    protected Editor editor;
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }
    @Override
    public boolean execute() {
        saveBackup();
        app.undo;
    }
}
