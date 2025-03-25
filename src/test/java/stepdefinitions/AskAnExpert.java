package stepdefinitions;

import Actions.ClickOn;
import Actions.EnterValueInto;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.JavascriptExecutor;

import static HHPages.AskAnExpert.*;

public class AskAnExpert {
    Actor user = MyCast.user();
    @When("Click on Ask An Expert from the primary menu")
    public void clickOnAskAnExpertFromThePrimaryMenu() {
        user.attemptsTo(ClickOn.AAELabelinPrimarymenu());
    }

    @And("Clicks on Post a Query button")
    public void clicksOnPostAQueryButton() {
        user.attemptsTo(ClickOn.PostAQuery());
    }

    @And("User selects speciality in Choose a Specialty dropdown")
    public void userSelectsSpecialityInChooseASpecialtyDropdown() {
        user.attemptsTo(ClickOn.theGivenField(Specialty));
        user.attemptsTo(EnterValueInto.SpecialtyAndHitEnter("Dental"));

    }

    @And("User Enters {string} in textbox")
    public void userEntersQueryInTextbox(String query) {
        user.attemptsTo(EnterValueInto.QueryTextArea(query));
    }

    @And("User clicks on Submit Query button")
    public void userClicksOnSubmitQueryButton() {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        user.attemptsTo(ClickOn.SubmitQuery());
    }

    @And("Verify post success popup is displayed")
    public void verifyPostSuccessPopupIsDisplayed() {
        user.attemptsTo(Ensure.that(SuccessPopUp).isDisplayed());
    }

    @And("User clicks on MyQueries tab")
    public void userClicksOnMyQueriesTab() {
        user.attemptsTo(ClickOn.MyQueries());
    }

    @And("User verify {string} with answer is available")
    public void userVerifyWithAnswerIsAvailable(String query) {
        user.attemptsTo(Ensure.that(AnswerOfQuestion.of(query)).isDisplayed());
    }

}
