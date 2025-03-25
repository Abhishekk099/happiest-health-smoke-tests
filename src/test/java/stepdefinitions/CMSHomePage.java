package stepdefinitions;

import HHPages.ArticlePage;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import Actions.*;



public class CMSHomePage {
    Actor user = MyCast.user();

    @Then("User Verify dashboard field is displayed")
    public void userVerifyDashboardFieldIsDisplayed() {
        user.wasAbleTo(Ensure.that(CMSPages.CMSHomePage.Dashboard).isDisplayed());
    }

    @And("User clicks on article link")
    public void userClicksOnArticleLink() {
        user.wasAbleTo(ClickOn.theArticleLink());
    }

    @Then("User Verify Article Link is displayed")
    public void userVerifyArticleLinkIsDisplayed() {
        user.wasAbleTo(Ensure.that(CMSPages.CMSHomePage.Articles).isDisplayed());
    }

    @And("User clicks on {string} link")
    public void userClicksOnLink(String content) {
        user.wasAbleTo(ClickOn.theContentLink(content));

    }

    @Then("User Verify {string} Link is displayed")
    public void userVerifyLinkIsDisplayed(String content) {
        user.wasAbleTo(Ensure.that(CMSPages.CMSHomePage.Content(content)).isDisplayed());

    }
    @Then("User Verify article with article name {string} is displayed")
    public void userVerifyArticleWithArticleNameIsDisplayed(String articleName) {
        user.wasAbleTo(Ensure.that(ArticlePage.ArticleWithArticleName.of(articleName)).isDisplayed());

    }


    @Then("User Verifies {string} link is clickable")
    public void userVerifiesLinkIsClickable(String linkName) {
        user.wasAbleTo(Ensure.that(CMSPages.CommonObjects.getLinkUsingLinkName(linkName)).isEnabled());
    }

    @Then("User Verify {string} text is displayed")
    public void userVerifyTextIsDisplayed(String text) {
        user.wasAbleTo(Ensure.that(CMSPages.CommonObjects.getTargetOfText(text)).isDisplayed());
    }

 	@Then("User Verify {string} Link is not displayed")
    public void userVerifyLinkIsnotDisplayed(String content) {
        Boolean flag=CMSPages.CMSHomePage.Content(content).isVisibleFor(user);
        user.wasAbleTo(Ensure.that(flag).isFalse());

    }
}
