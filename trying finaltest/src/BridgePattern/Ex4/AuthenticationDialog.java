package BridgePattern.Ex4;

import org.w3c.dom.Text;

public class AuthenticationDialog implements Mediator {
    private String title;
    private Checkbox loginOrRegisterChkBx;
    private Textbox loginUsername, loginPasswork;
    private Textbox registrationUsername, registrationPassword, registrationEmail;
    private Button okBtn, cancelBtn;
    private boolean founds;
    public AuthenticationDialog(String title) {
        this.title = title;
        loginOrRegisterChkBx = new Checkbox(this);
        loginUsername = new Textbox(this);
        loginPasswork = new Textbox(this);
        registrationUsername = new Textbox(this);
        registrationPassword = new Textbox(this);
        registrationEmail = new Textbox(this);
        okBtn = new Button(this);
    }
    public void notify(Component sender, String event) {
        if (sender == loginOrRegisterChkBx && event == "check") {
            if (loginOrRegisterChkBx.checked) {
                title = "Login in";
            }
            else {
                title = "Register";
            }
        }
        if (sender == okBtn && event == "click") {
            if (loginOrRegisterChkBx.checked) {
                founds  = findUser();
            }
            if (!founds) {
                showError();
            }
            else {

            }
        }
    }
    private boolean findUser() {
        return false;
    }
    private void showError() {
        System.out.println("User name is not corret");
    }
    private void createUser() {

    }
    private void loginUser() {
        
    }
}
