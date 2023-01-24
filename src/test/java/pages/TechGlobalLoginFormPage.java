package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalLoginFormPage extends TechGlobalBasePage {
    public TechGlobalLoginFormPage() {
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement heading;

    @FindBy(css = "label[for='username']")
    public WebElement usernameLabel;

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "success_lgn")
    public WebElement successLogin;

    @FindBy(id = "error_message")
    public WebElement errorMessageUsername;

    @FindBy(id = "error_message")
    public WebElement errorMessagePassword;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordHeader;

    @FindBy (xpath = "//input[@id='email']/../label")
    public WebElement resetPasswordMessage;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "submit")
    public WebElement resetPasswordSubmitButton;

    @FindBy(id = "confirmation_message")
    public WebElement confirmationMessage;
}