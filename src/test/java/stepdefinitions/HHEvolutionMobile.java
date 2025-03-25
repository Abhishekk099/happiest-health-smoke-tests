package stepdefinitions;


import Actions.NavigateTo;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

import static HHPages.HHEvolutionPage.*;
import static stepdefinitions.BasePage.userAcceptsCoookiesPopUpBoxInEvolution;

public class HHEvolutionMobile {

    Actor user = MyCast.user();


    @Given("User has launched HHEvolution URL in mobile view")
    public void userHasLaunchedHHEvolutionURLInMobileView() {
        new CommonUtils().maximizeTheWindow();
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
        userAcceptsCoookiesPopUpBoxInEvolution();
    }

    @Then("User validate primary navigation bar items is displayed with items in mobile view")
    public void userValidatePrimaryNavigationBarItemsIsDisplayedWithItemsInMobileView(DataTable dt) {
        List<List<String>> rows = dt.asLists(String.class);
        List<WebElement> PrimaryNavBarItems = Serenity.getDriver().findElements(By.xpath(primaryNavBarItemsXpath));
        System.out.println(PrimaryNavBarItems);
        for (int i=0;i<PrimaryNavBarItems.size();i++){
            user.wasAbleTo(Ensure.that(PrimaryNavBarItems.get(i).isDisplayed()).isTrue());
            user.wasAbleTo(Ensure.that(PrimaryNavBarItems.get(i).getText()).isEqualTo(rows.get(0).get(i)));
        }
    }

    @Then("User validate secondary nav bar items by scrolling in secondary nav bar")
    public void userValidateSecondaryNavBarItemsByScrollingInSecondaryNavBar(DataTable dt)  {
        List<List<String>> rows = dt.asLists(String.class);
        List<String> SecondaryNavBarItems = Serenity.getDriver().findElements(By.xpath(secondaryNavBarItemsXpath)).stream().filter(WebElement::isDisplayed).map(WebElement::getText).collect(Collectors.toList());
        System.out.println("Secondary nav bar items : " + SecondaryNavBarItems);
        for (int i=0;i<SecondaryNavBarItems.size()/2;i++){
            WebElement element = Serenity.getDriver().findElement(By.xpath(secondaryNavBarItemsXpath + "[text()=\"" + rows.get(0).get(i) + "\"]"));
            user.wasAbleTo(Ensure.that(element.isDisplayed()).isTrue());
        }
        Actions actions = new Actions(Serenity.getDriver());
        actions.clickAndHold(secondaryNavBarItems.get(secondaryNavBarItems.size()/2))
                .moveToElement(secondaryNavBarItems.get(0))
                .release()
                .perform();
        for (int i=secondaryNavBarItems.size()/2;i<SecondaryNavBarItems.size();i++){
            WebElement element = Serenity.getDriver().findElement(By.xpath(secondaryNavBarItemsXpath + "[text()=\"" + rows.get(0).get(i) + "\"]"));
            user.wasAbleTo(Ensure.that(element.isDisplayed()).isTrue());
        }
    }

    @Then("User verify primary nav bar is sticky in bottom of screen")
    public void userVerifyPrimaryNavBarIsStickyInBottomOfScreen() {
        WebElement primaryNavBar = Serenity.getDriver().findElement(By.xpath("(//nav)[1]"));
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollBy(0, 1000);");
        int primaryNavBarYPositionAfterScroll = primaryNavBar.getLocation().getY();
        int windowHeight = Serenity.getDriver().manage().window().getSize().getHeight();
//        user.wasAbleTo(Ensure.that(primaryNavBarYPositionBeforeScroll).isEqualTo(primaryNavBarYPositionAfterScroll));
        user.wasAbleTo(Ensure.that(primaryNavBarYPositionAfterScroll >= windowHeight - primaryNavBar.getSize().getHeight()).isTrue());
    }

    @Then("User verify Knowledge section highlighted by default")
    public void userVerifyKnowledgeSectionHighlightedByDefault() {
        user.wasAbleTo(Ensure.that(Knowledge).attribute("class").contains("selected"));
    }

    @Then("User validate Web Stories by scrolling in Web Stories section")
    public void userValidateWebStoriesByScrollingInWebStoriesSection() {
        List<WebElement> webStories = Serenity.getDriver().findElements(By.xpath(webStoryListXpath));
        for (int i=0;i<webStories.size()/2;i++){
            user.wasAbleTo(Ensure.that(webStories.get(i).isDisplayed()).isTrue());
        }
        Actions actions = new Actions(Serenity.getDriver());
        actions.clickAndHold(webStories.get(webStories.size()/2))
                .moveToElement(webStories.get(0))
                .release()
                .perform();
        for (int i=webStories.size()/2;i<webStories.size();i++){
            user.wasAbleTo(Ensure.that(webStories.get(i).isDisplayed()).isTrue());
        }
    }




    @Then("User verify max {int} contents under the editor's pick section.")
    public void userVerifyMaxContentsUnderTheEditorSPickSection(int count) {
        List<WebElement> editorPickList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath));
        user.wasAbleTo(Ensure.that(editorPickList.size()).isEqualTo(count));
    }

    @Then("User verify Title for each content in the editors pick section in mobile view.")
    public void userVerifyTitleForEachContentInTheEditorsPickSectionInMobileView() {
        List<WebElement> editorPicksTitleList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath+"//div[contains(@class,'title')]"));
        user.wasAbleTo(Ensure.that(editorPicksTitleList.size()).isEqualTo(3));
        for (WebElement element : editorPicksTitleList) {
            user.wasAbleTo(Ensure.that(element.isDisplayed()).isTrue());
        }
    }

    @Then("User verify Title for each content in the editors pick section is displayed in max {int} lines")
    public void userVerifyTitleForEachContentInTheEditorsPickSectionIsDisplayedInMaxLines(int count) {
        List<WebElement> editorPicksTitleList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath+"//div[contains(@class,'title')]"));
        for (WebElement element : editorPicksTitleList) {
            int elementHeight = element.getSize().getHeight();

            // Get the line height of the text
            String lineHeightStr = element.getCssValue("line-height");
            int lineHeight = Integer.parseInt(lineHeightStr.replace("px", ""));

            // Verify if the text is displayed in not more than 2 lines
            if (elementHeight <= count * lineHeight) {
                System.out.println("The text is displayed in not more than 2 lines.");
                user.wasAbleTo(Ensure.that(true).isTrue());
            } else {
                System.out.println("The text is displayed in more than 2 lines.");
                user.wasAbleTo(Ensure.that(true).isFalse());
            }
        }
    }
}
