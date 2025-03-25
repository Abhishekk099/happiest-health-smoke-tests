package stepdefinitions;

import Actions.ClickOn;
import CMSPages.CMSHomePage;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import Actions.*;


import static HHPages.ArticlePage.*;


public class CMSArticlePage {
    Actor user = MyCast.user();

    @Then("User Verifies AddNewPost button is clickable")
    public void verifyAddNewPostButtonIsClickable() {
        user.wasAbleTo(Ensure.that(CMSPages.CMSArticlePage.AddNewPost).isEnabled());
    }

    @And("User clicks on AddNewPost link")
    public void userClicksOnAddNewPostLink() {
        user.wasAbleTo(ClickOn.theAddNwePostUnderArticle());
    }

    @And("User Verifies {string} is displayed")
    public void userVerifiesIsDisplayed(String ExpectedString) {
        user.wasAbleTo(Ensure.that(CMSPages.CMSArticlePage.AddNewArticleHeader).hasText(ExpectedString));
    }

    @Then("User enters {string} into Add Title")
    public void userEntersIntoAddTitle(String title) {
        user.wasAbleTo(EnterValueInto.theAddTitleField(title));
    }

    @Then("User enters {string} into Body")
    public void userEntersIntoBody(String content){
        user.wasAbleTo(EnterValueInto.switchToFrame(CMSPages.CMSArticlePage.BodyFrame));
        user.wasAbleTo(EnterValueInto.theAddBodyField(content));
        user.wasAbleTo(EnterValueInto.switchToDefaultFrame());

    }

    @Then("User selects {string} checkbox")
    public void userSelects(String category) {
        user.wasAbleTo(ClickOn.theCatagoryCheckbox(category));

    }

    @Then("User enters {string} in {string} input field")
    public void userEntersInInputField(String text, String label) {
    	user.attemptsTo(Scroll.to(CMSPages.CMSArticlePage.InputboxWithLabel.of(label)));
        user.wasAbleTo(EnterValueInto.theGivenInputField(text,label));
    }


    @Then("User enters {string} in Expert Text field")
    public void userEntersInExpertTextField(String Experts) {
        user.wasAbleTo(EnterValueInto.theExpertField(Experts));
    }

    @And("User publishes the Article")
    public void userPublishesTheArticle() {
        user.attemptsTo(Scroll.to(CMSPages.CMSArticlePage.PublishButton));
        user.wasAbleTo(ClickOn.thePublishButton());
    }

    @And("User Verifies {string} confirmation is displayed")
    public void userVerifiesConfirmationIsDisplayed(String PostConfirmation) {
        user.wasAbleTo(Ensure.that(CMSHomePage.PostConfirmation).isDisplayed());
    }

    @And("User verifies {string} checkbox is selectable")
    public void userVerifiesCheckboxIsSelectable(String checkBoxLabel ) {
        user.wasAbleTo(Ensure.that(CMSPages.CMSArticlePage.CheckboxWithLabel.of(checkBoxLabel)).isEnabled());
    }

    @Then("User selects {string} in Select Related Posts field")
    public void userSelectsInSelectRelatedPostsField(String value) {
        user.attemptsTo(ClickOn.theSelectRelatedPost());
        System.out.println(CMSPages.CMSArticlePage.SelectRelatedPosts.toString());
        user.attemptsTo(SelectFromOptions.byVisibleText(value).from(CMSPages.CMSArticlePage.SelectRelatedPosts));
    }

    @Then("User enters Add Image link for {string}")
    public void userEntersAddImageLinkFor(String value) {
        user.attemptsTo(Scroll.to(CMSPages.CMSArticlePage.AddImagelink.of(value)));
        user.wasAbleTo(ClickOn.theAddImageLink(value));

    }
    @When("User clicks on article with article name {string}")
    public void userClicksOnArticleWithArticleName(String articleName) {
        user.wasAbleTo(ClickOn.articleUsingLinkName(articleName));
    }

    @Then("User Verify Article {string} title is displayed")
    public void userVerifyArticleTitleIsDisplayed(String articleName) {
        user.wasAbleTo(Ensure.that(ArticleNameInDetailPage.of(articleName)).isDisplayed());
    }

    @Then("User Verify Article {string} content is displayed")
    public void userVerifyArticleContentIsDisplayed(String content) {
        user.wasAbleTo(Ensure.that(ArticleContentInDetailPage.of(content)).isDisplayed());

    }

    @Then("User Verify Article {string} excerpt is displayed")
    public void userVerifyArticleExcerptIsDisplayed(String excerpt) {
        user.wasAbleTo(Ensure.that(ArticleExcerptInDetailPage.of(excerpt)).isDisplayed());

    }


}
