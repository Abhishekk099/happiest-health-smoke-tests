package stepdefinitions;


import Actions.NavigateTo;
import Actions.ClickOn;
import Actions.EnterValueInto;
import HHPages.HHVideoPage;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HHVideopage {

    Actor user = MyCast.user();


    @Given("User is in video page")
    public void userIsInVideoPage() {
        new CommonUtils().maximizeTheWindow();
        user.wasAbleTo(NavigateTo.theHHVideoPage());
    }


    @Then("Verify user can see {string} Breadcrumb is visible")
    public void verifyUserCanSeeBreadcrumbIsVisible(String breadcrumbtitle) {
        user.wasAbleTo(Ensure.that(HHVideoPage.Breadcrumb.of(breadcrumbtitle)).isDisplayed());
    }

    @Then("Verify user can see {int} article by default")
    public void verifyUserCanSeeArticleByDefault(int count) {

        Integer noOfTilesAvailable= new HHVideoPage().getAvailableTilesNumber();
        user.attemptsTo(Ensure.that(noOfTilesAvailable).isEqualTo(count));
        user.wasAbleTo(Ensure.that(HHVideoPage.TILES).isDisplayed());
    }

    @Then("Verify user can see All article has {string}")
    public void verifyUserCanSeeAllArticleHas(String locater) {
        Ensure.enableSoftAssertions();
        List<WebElement> tiles= new HHVideoPage().getAvailableTiles();
        for(WebElement tile : tiles){
            System.out.println("Hi ---->"+tile.getText());
            user.attemptsTo(Ensure.that(HHVideoPage.TILES).containsElements(By.xpath(locater)));
            user.attemptsTo(Ensure.that(HHVideoPage.TILES.inside(locater)).isEnabled());

        }
        Ensure.reportSoftAssertions();
    }

    @When("user clicked on title of the video")
    public void userClickedOnTitleOfTheVideo() {
        user.wasAbleTo(Ensure.that(HHVideoPage.FirstVideo).isDisplayed());
        user.attemptsTo(ClickOn.firstVideoInListingPage());

    }



    @Then("Verify the breadcrumb is displayed")
    public void verifyTheBreadcrumbIsDisplayed() {
        user.wasAbleTo(Ensure.that(HHVideoPage.Breadcrumb.of("Videos")).isDisplayed());
        user.wasAbleTo(Ensure.that(HHVideoPage.VideoCategoryBreadcrumb).isDisplayed());
        user.wasAbleTo(Ensure.that(HHVideoPage.VideoTitleBreadcrumb).isDisplayed());}

    @And("Verify the video play button is displayed")
    public void verifyTheVideoPlayButtonIsDisplayed() {
        user.wasAbleTo(Ensure.that(HHVideoPage.PlayButton).isDisplayed());
    }


    @Then("Verify like share comment strip is displayed")
    public void verifyLikeShareCommentStripIsDisplayed() {
        user.wasAbleTo(Ensure.that(HHVideoPage.LSCStrip).isDisplayed());
    }

    @And("Verify the speaker section is displayed with name image")
    public void verifyTheSpeakerSectionIsDisplayedWithNameImage() {
        user.wasAbleTo(Ensure.that(HHVideoPage.Speaker).isDisplayed());
        user.wasAbleTo(Ensure.that(HHVideoPage.SpeakerName).isDisplayed());
        user.wasAbleTo(Ensure.that(HHVideoPage.SpeakerImage).isDisplayed());
    }

    @Then("User can see share your experience section")
    public void userCanSeeShareYourExperienceSection() {
        user.wasAbleTo(Ensure.that(HHVideoPage.CommentSection).isDisplayed());

    }


    @And("User is able to enter details in response field")
    public void userIsAbleToEnterDetailsInNameField() {
        user.wasAbleTo(Ensure.that(HHVideoPage.EnterResponse).isDisplayed());
        user.wasAbleTo(ClickOn.response());
        user.attemptsTo(EnterValueInto.enterresponse("Good"));

    }

    @And("User is able to enter details in enter name field as {string}")
    public void userIsAbleToEnterDetailsInEmailFieldAs(String name) {
        user.wasAbleTo(Ensure.that(HHVideoPage.EnterName).isDisplayed());
        user.wasAbleTo(ClickOn.entername());
        user.attemptsTo(EnterValueInto.entername(name));
    }

    @And("User is able to enter the details in email field")
    public void userIsAbleToEnterTheDetailsInEmailField() {
        user.wasAbleTo(Ensure.that(HHVideoPage.EnetrEmail).isDisplayed());
        user.wasAbleTo(ClickOn.Email());
        user.attemptsTo(EnterValueInto.enterhemail("akhilavmane@gmail.com"));
    }

    @And("User is able to click on post comment")
    public void userIsAbleToClickOnPostComment() {
        user.wasAbleTo(Ensure.that(HHVideoPage.PostComment).isDisplayed());
        user.attemptsTo(ClickOn.PostCommentbutton());
    }

    @And("Verify posted comment is shown with name {string}")
    public void verifyPostedCommentIsShownWithName(String name) throws InterruptedException {
        Thread.sleep(10000);
        user.wasAbleTo(Ensure.that(HHVideoPage.CommentUserName).hasText(name));
    }


}
