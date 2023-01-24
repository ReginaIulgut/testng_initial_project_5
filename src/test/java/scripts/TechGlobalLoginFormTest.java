package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalLoginFormTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();

        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
    }

    @Test(priority = 1, description = "Validate Login Form card")
    public void validateLoginForm() {
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        Assert.assertTrue(techGlobalLoginFormPage.heading.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.heading.getText(), "Login Form");

        Assert.assertTrue(techGlobalLoginFormPage.usernameLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginFormPage.usernameInputBox.isDisplayed());

        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginFormPage.passwordInputBox.isDisplayed());

        Assert.assertEquals(techGlobalLoginFormPage.loginButton.getText(), "LOGIN");
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());

        Assert.assertEquals(techGlobalLoginFormPage.forgotPasswordLink.getText(), "Forgot Password?");
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isDisplayed());
    }

    @Test(priority = 2, description = "Validate Login Form card valid login")
    public void validLoginForm() {
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.successLogin.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }
    @Test(priority = 3, description = "Validate Login Form card valid login and then logout")
    public void validateLoginAndLogoutForm() {
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();
        techGlobalLoginFormPage.logoutButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }

    @Test(priority = 4, description = "Validate TechGlobal Login Form card " +
            "Forgot Password? " +
            "Link and Reset Password page")
    public void validateForgotPassword() {
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.forgotPasswordLink.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeader.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordMessage.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordSubmitButton.isDisplayed());
    }

    @Test(priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateResetPasswordLink() {
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.forgotPasswordLink.click();
        techGlobalLoginFormPage.emailInputBox.sendKeys(TestData.emailForResetPassword);
        techGlobalLoginFormPage.resetPasswordSubmitButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.confirmationMessage.isDisplayed());
    }

    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong username")
    public void validateInvalidUsername(){
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessageUsername.isDisplayed());
    }

    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong password")
    public void validateInvalidPassword(){
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessagePassword.isDisplayed());
    }

    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "both wrong credentials")
    public void validateInvalidUsernameAndPassword(){
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessageUsername.isDisplayed());
    }
}