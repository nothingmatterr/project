package BridgePattern.Ex3;

public class Panel extends Container {
    private String modalHelpText;
    public Panel(String modalHelpText) {
        super(modalHelpText);
    }
    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            System.out.println(modalHelpText);
        }
        else {
            super.showHelp();
        }
    }
}
