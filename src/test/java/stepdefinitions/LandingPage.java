package stepdefinitions;

import HHPages.HHLandingPage;
import Actions.NavigateTo;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import Actions.*;

import static stepdefinitions.BasePage.userAcceptsCoookiesPopUpBoxInEvolution;


public class LandingPage {

    Actor user = MyCast.user();


    @Given("User has launched HH URL")
    public void userHasLaunchedHHURL(){
        user.wasAbleTo(NavigateTo.theHHLandingPage());
    }

    @Then("User verify login button is visible")
    public void userVerifyLoginButtonIsVisible(){
        //user.wasAbleTo(Ensure.that(HHLandingPage.LOGO).isDisplayed());
        user.wasAbleTo(Ensure.that(HHLandingPage.LoginBtn).isDisplayed());
    }



    @And("User click on {string} Input field using {string}")
    public void userClickOnInputFieldUsing(String elementAttribute, String attributeType) {
        user.wasAbleTo(ClickOn.inputField(attributeType,elementAttribute));
    }

    @Then("User has launched HH URL in new tab")
    public void userHasLaunchedHHURLInNewTab() {
        new CommonUtils().switshToNewWindow();
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
        userAcceptsCoookiesPopUpBoxInEvolution();
    }

    @And("User has launched CMS url in new tab")
    public void userHasLaunchedCMSUrlInNewTab() {
        new CommonUtils().switshToNewWindow();
        user.wasAbleTo(NavigateTo.theCMSLoginPage());
    }

}
