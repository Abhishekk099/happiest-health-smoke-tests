package stepdefinitions;

import Utils.MyCast;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;



public class ArticlePage{

    Actor user = MyCast.user();

    @Then("User validate {string} author")
    public void userValidateAuthor( String author) {
        WebDriver driver = Serenity.getDriver();
        String authorText = driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Written by " + author + "')]")).getText();
        user.wasAbleTo(Ensure.that(authorText).isEqualToIgnoringCase("Written by " + author));
    }



    @Then("User verify {string} is displayed in Hero Section")
    public void userVerifyIsDisplayedInHeroSection(String article) {
        user.wasAbleTo(Ensure.that(HHPages.ArticlePage.ArticleInHeroSection.of(article)).isDisplayed());
    }

    @Then("User verify {string} is removed in Hero Section")
    public void userVerifyIsRemovedInHeroSection(String article) {
        Boolean flag=HHPages.ArticlePage.ArticleInHeroSection.of(article).isVisibleFor(user);
        user.wasAbleTo(Ensure.that(flag).isFalse());
    }

    @Then("User verify {string} is displayed in Breaking News Section")
    public void userVerifyIsDisplayedInBreakingNewsSection(String article) {
        user.wasAbleTo(Ensure.that(HHPages.ArticlePage.BreakingNewsSection.of(article)).isEnabled());
    }

    @Then("User verify {string} is removed in Breaking News Section")
    public void userVerifyIsRemovedInBreakingNewsSection(String article) {
        Boolean flag=HHPages.ArticlePage.BreakingNewsSection.of(article).isVisibleFor(user);
        user.wasAbleTo(Ensure.that(flag).isFalse());
    }


}
