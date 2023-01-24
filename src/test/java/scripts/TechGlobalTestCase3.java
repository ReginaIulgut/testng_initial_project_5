package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalTestCase3 extends TechGlobalBase{
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @Test(priority = 1, description = "Validate Login Form card valid login and then logout")
    public void validateLoginForm() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();
        techGlobalLoginFormPage.logoutButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }

    @Test(priority = 2, description = "Validate TechGlobal Login Form card " +
            "Forgot Password? " +
            "Link and Reset Password page")
    public void validateForgotPassword() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.forgotPasswordLink.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeader.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordMessage.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordSubmitButton.isDisplayed());
    }

    @Test(priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateResetPasswordLink() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.forgotPasswordLink.click();
        techGlobalLoginFormPage.emailInputBox.sendKeys(TestData.emailForResetPassword);
        techGlobalLoginFormPage.resetPasswordSubmitButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.confirmationMessage.isDisplayed());
    }

    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong username")
    public void validateInvalidUsername(){
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessageUsername.isDisplayed());
    }

    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong password")
    public void validateInvalidPassword(){
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessagePassword.isDisplayed());
    }

    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "both wrong credentials")
    public void validateInvalidUsernameAndPassword(){
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessageUsername.isDisplayed());
    }
}
