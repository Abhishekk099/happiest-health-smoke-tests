package stepdefinitions;

import Actions.*;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;


public class CMSLoginPage {

    Actor user = MyCast.user();

    @Given("User has launched CMS URL")
    public void userHasLaunchedCMSURL() {
        new CommonUtils().maximizeTheWindow();
        user.wasAbleTo(NavigateTo.theCMSLoginPage());
    }

    @When("User enters email value as {string}")
    public void userEntersEmailValueAs(String email) {
        user.wasAbleTo(EnterValueInto.theUsernameField(email));
    }

    @And("User enters password value as {string}")
    public void userEntersPasswordValueAs(String password) {
        user.wasAbleTo(EnterValueInto.thePasswordField(password));
    }




}
