package BridgePattern.Exp2;

public class CommandHistory extends Command {
    private Command[] history;
    protected Application app;
    protected Editor editor;
    public CommandHistory(Application app, Editor editor, Command[] history) {
        super(app, editor);
        this.history = history;
    }

    public Command[] push(Command command) {
        Command[] newHistory = new Command[history.length + 1];
        for (int i = 0; i < history.length - 1; i++) {
           newHistory[i] = history[i];
        }
        newHistory[history.length] = command;
        return newHistory;
    }
}
