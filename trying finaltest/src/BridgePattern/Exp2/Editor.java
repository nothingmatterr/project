package BridgePattern.Exp2;

public class Editor {
    protected String text;
    public Editor(String text) {
        this.text = text;
    }
    public String getSelection() {
        return text;
    }
    public String deleteSelection() {
        this.text = null;
        return text;
    }
    public Editor replaceSelection(String text1) {
        this.text = text1;
        return this;
    }

}
