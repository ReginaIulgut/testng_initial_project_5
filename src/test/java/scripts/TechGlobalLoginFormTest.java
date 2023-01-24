package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;

public class TechGlobalLoginFormTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @Test(priority = 1, description = "Validate Login Form card")
    public void validateLoginForm() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        // Validate user can see heading and text is 'Login Form'
        Assert.assertTrue(techGlobalLoginFormPage.heading.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.heading.getText(), "Login Form");

        // Validate user can see username label and input box
        Assert.assertTrue(techGlobalLoginFormPage.usernameLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginFormPage.usernameInputBox.isDisplayed());

        // Validate user can see password label and input box
        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginFormPage.passwordInputBox.isDisplayed());

        // Validate user can see 'LOGIN' button
        Assert.assertEquals(techGlobalLoginFormPage.loginButton.getText(), "LOGIN");
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());

        // Validate user can see 'Forgot Password' link
        Assert.assertEquals(techGlobalLoginFormPage.forgotPasswordLink.getText(), "Forgot Password?");
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isDisplayed());
    }
}