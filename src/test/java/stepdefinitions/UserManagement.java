package stepdefinitions;

import HHPages.HHLandingPage;
import Actions.*;
import Tasks.FetchOTP;
import Tasks.FetchSignUpOTP;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;

import static HHPages.ProfilePage.*;

public class UserManagement {
    Actor user = MyCast.user();

    @Given("User requests an OTP for {string}")
    public void theUserRequestsAnOTPFor(String mobileno) throws InterruptedException {
        user.attemptsTo(EnterValueInto.MobileNoField(mobileno));
        Thread.sleep(2000);
        user.attemptsTo(Click.on("//button"));
        Thread.sleep(10000);
    }

    @When("User retrieves Mobile OTP")
    public void theUserRetrievesTheOTP() {
        user.wasAbleTo(FetchOTP.fromCognitoForLogin());
    }

    @When("User retrieves the Mobile OTP for SIGNUP")
    public void theUserRetrievesTheMobileOtpForSIGNUP() {
        user.wasAbleTo(FetchSignUpOTP.fromCognitoForLogin());
    }

    @And("User logs in with OTP")
    public void theUserLogsInWithOTP() throws InterruptedException {
        user.attemptsTo(EnterValueInto.MobileNoField(user.recall("OTP")));
        user.attemptsTo(Click.on("//button[text()='Submit OTP']"));
        Thread.sleep(10000);
    }

    @Then("Verify user is logged in")
    public void verifyUserIsLoggedIn() {
        user.attemptsTo(Ensure.that(HHLandingPage.LoginBtn).isDisplayed());
    }

    @Then("Verify user profile icon is displayed")
    public void verifyUserProfileiconIsDisplayed() {
        user.wasAbleTo(Ensure.that(ProfileIcon).isDisplayed());
    }

    @Then("Verify user registration page should display")
    public void verifyUserRegistrationPageShouldDisplay() {
        user.wasAbleTo(Ensure.that(RegistrationForm).isDisplayed());
    }

    @Then("User clicks on Categories icon")
    public void userClicksOnCategoriesIcon() {
        user.attemptsTo(Click.on(CategoriesIcon));
    }

    @Then("user clicks on proceed to Email Button")
    public void userClicksOnProceedToEmailButton() {
        user.attemptsTo(Click.on(By.xpath("//button[contains(text(),'Proceed with ')]")));
    }

    @When("user enters email id {string}")
    public void userEntersEmailId(String mail) throws InterruptedException {

        int randomInt = (int) (Math.random() * 100);
        System.out.println("Random Integer (0-99): " + randomInt);
        user.attemptsTo(EnterValueInto.enterhemail(mail + randomInt +"@gmail.com"));
        Thread.sleep(2000);
        user.attemptsTo(Click.on("//button"));
        Thread.sleep(10000);
    }

    @Then("Verify user can see the message as {string}")
    public void verifyUserCanSeeTheMessageAs(String arg0) {
        user.wasAbleTo(Ensure.that(InvalidUserMessage).isDisplayed());
        String textMessage = InvalidUserMessage.getName();
        System.out.println(textMessage);

    }

    @Then("Verify user can see Email text field")
    public void verifyUserCanSeeEmailTextField() {
        user.wasAbleTo(Ensure.that(EmailId).isDisplayed());
        String email = EmailId.getName();
        System.out.println(email);
    }

    @And("User can see the message {string}")
    public void userCanSeeTheMessage(String arg0) {

        user.wasAbleTo(Ensure.that(OTPMessage).isDisplayed());

    }

    @And("User can see the GET OTP button is enabled")
    public void userCanSeeTheGETOTPButtonIsEnabled() {

        user.wasAbleTo(Ensure.that(GetOTP).isDisplayed());

    }

    @Then("User can see the change number link")
    public void userCanSeeTheChangeNumberLink() {
        user.wasAbleTo(Click.on(By.xpath("//span[text()='Change']")));
    }

    @Then("user clicks on profile button")
    public void userClicksOnProfileButton() {

        user.wasAbleTo(Click.on(By.xpath("//button[@type=\"button\"]/ancestor::div[@class='MuiListItemIcon-root mui-qwko1u']")));
    }

    @Then("verify User name in the profile section")
    public void verifyTheUserNameInTheProfileSection() {

        user.wasAbleTo(Ensure.that(UserName).isDisplayed());
    }

    @When("User retrieves Email OTP")
    public void userRetrievesEmailOTP() {

        user.wasAbleTo(FetchSignUpOTP.fromCognitoForLogin());


    }

    @Then("user clicked on Accept Checkbox")
    public void userClickedOnAcceptCheckbox() {
        user.wasAbleTo(Click.on(CheckBox));
    }

    @Then("user clicks on Get OTP button")
    public void userClicksOnGetOTPButton() {
        user.wasAbleTo(Click.on(GetOTP));
    }
}
