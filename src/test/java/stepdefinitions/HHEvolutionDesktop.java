package stepdefinitions;

import Actions.ClickOn;
import Actions.NavigateTo;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static CMSPages.CommonObjects.CheckoutPage;
import static CMSPages.CommonObjects.getTargetOfText;
import static Actions.EnterValueInto.clearSearchInputField;
import static Actions.EnterValueInto.searchInputField;
import static Actions.EnterValueInto.searchInputFieldAndHitEnter;
import static HHPages.HHEvolutionPage.*;
import static HHPages.HHLandingPage.EditorsPicksSection;
import static HHPages.ProfilePage.ProfileSection;
import static Utils.CommonUtils.*;
import static stepdefinitions.BasePage.*;

public class HHEvolutionDesktop {

    Actor user = MyCast.user();

    String MyStoryImgSrc = "";
    String MyStoryTitleText = "";
    String MyStoryDescriptionText = "";
    String webStoryHref = "";
    String webStoryTitle = "";
    String editorsPickTitle = "";
    String magazineName = "";
    String magazineImage = "";
    List<WebElement> webStoriesSvgList;
    String UpcomingSummitName = "";

    @Given("User has launched HHEvolution URL in Desktop view")
    public void userHasLaunchedHHEvolutionURLInDesktopView() throws InterruptedException {
        new CommonUtils().maximizeTheWindow();
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
        userAcceptsCoookiesPopUpBoxInEvolution();
        Thread.sleep(10000);
    }


    @Then("User validate primary navigation bar items is displayed with items in Desktop view")
    public void userValidatePrimaryNavigationBarItemsIsDisplayedWithItemsInDesktopView(DataTable dt) {
        List<List<String>> rows = dt.asLists(String.class);
        List<WebElement> PrimaryNavBarItems = Serenity.getDriver().findElements(By.xpath(primaryNavBarItemsXpath));
        for (int i=0;i<PrimaryNavBarItems.size();i++){
            user.wasAbleTo(Ensure.that(PrimaryNavBarItems.get(i).isDisplayed()).isTrue());
            user.wasAbleTo(Ensure.that(PrimaryNavBarItems.get(i).getText()).isEqualTo(rows.get(0).get(i)));
        }
    }


    @Then("User validate secondary nav bar items is displayed with items in Desktop view")
    public void userValidateSecondaryNavBarItemsIsDisplayedWithItemsInDesktopView(DataTable dt) {
        List<List<String>> rows = dt.asLists(String.class);
        List<WebElement> SecondaryNavBarItems = Serenity.getDriver().findElements(By.xpath(secondaryNavBarItemsXpath));
        for (int i=0;i<SecondaryNavBarItems.size();i++){
            user.wasAbleTo(Ensure.that(SecondaryNavBarItems.get(i).isDisplayed()).isTrue());
            user.wasAbleTo(Ensure.that(SecondaryNavBarItems.get(i).getText()).isEqualTo(rows.get(0).get(i)));
        }
    }

    @Then("User verify {string} displayed to the {string} direction of {string} title")
    public void userVerifyDisplayedToTheDirectionOfTitle(String content, String direction, String title) {
        WebElement element = Serenity.getDriver().findElement(By.xpath("//h6[text()=\"" + title + "\"]"));
        if (content.equalsIgnoreCase("Carousal")){
//            String carousalClass = "MuiBox-root mui-ttfowy";
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).near(element)).isDisplayed()).isTrue());
            }
        } else if (content.equalsIgnoreCase("editor's pick") || content.equalsIgnoreCase("web stories") || content.equalsIgnoreCase("wellness programmes")) {
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//h6[text()=\"" + content + "\"]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//h6[text()=\"" + content + "\"]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//h6[text()=\"" + content + "\"]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//h6[text()=\"" + content + "\"]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//h6[text()=\"" + content + "\"]")).near(element)).isDisplayed()).isTrue());
            }
        }

    }

    @Then("User verify {string} displayed to the {string} direction of {string} text")
    public void userVerifyDisplayedToTheDirectionOfText(String content, String direction, String text) {
        WebElement element = Serenity.getDriver().findElement(By.xpath("//*[text()=\"" + text + "\"]"));
        if (content.equalsIgnoreCase("Carousal")){
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).near(element)).isDisplayed()).isTrue());
            }
        }else if (content.equalsIgnoreCase("editor's pick") || content.equalsIgnoreCase("web stories") || content.equalsIgnoreCase("wellness programmes")) {
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).near(element)).isDisplayed()).isTrue());
            }
        }

    }

    @Then("User verify {string} displayed to the {string} direction of webelement with xpath {string}")
    public void userVerifyDisplayedToTheDirectionOfWebelementWithXpath(String content, String direction, String xpathName) {
        WebElement element = Serenity.getDriver().findElement(By.xpath(xpathName));
        if (content.equalsIgnoreCase("Carousal")){
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//article)[1]")).near(element)).isDisplayed()).isTrue());
            }
        }else if (content.equalsIgnoreCase("editor's pick") || content.equalsIgnoreCase("web stories") || content.equalsIgnoreCase("wellness programmes")) {
            if (direction.equalsIgnoreCase("left")){
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).toLeftOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("right")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).toRightOf(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("above")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).above(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("below")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).below(element)).isDisplayed()).isTrue());
            } else if (direction.equalsIgnoreCase("near")) {
                user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("//div[@class='MuiBox-root mui-r245rn']/h6[text()=\"" + content + "\"]")).near(element)).isDisplayed()).isTrue());
            }
        }

    }

    @Then("User verify search icon is displayed")
    public void userVerifySearchIconIsDisplayed() {
        user.wasAbleTo(Ensure.that(searchIcon).isDisplayed());
    }

    @When("User click on search icon")
    public void userClickOnSearchIcon() {
        user.wasAbleTo(ClickOn.searchIcon());
    }

    @Then("User validate search input box is displayed")
    public void userValidateSearchInputBoxIsDisplayed() {
        user.wasAbleTo(Ensure.that(searchInputField).isDisplayed());
    }

    @When("User enters {string} keyword in the search bar and press enter")
    public void userEntersKeywordInTheSearchBarAndPressEnter(String text) {
        user.wasAbleTo(searchInputFieldAndHitEnter(text));
    }
    @When("User enters {string} keyword in the search bar")
    public void userEntersKeywordInTheSearchBar(String text) {
        user.wasAbleTo(searchInputField(text));
    }

//    @Then("User verify {string} list is displayed")
//    public void userVerifyListIsDisplayed(String content) {
////        List<String> contentLinksList = getContentLinks(content).stream().filter(WebElement::isDisplayed).map(webElement -> webElement.getAttribute("href")).distinct().collect(Collectors.toList());
//        List<String> Links =
//        for (String hrefValue: contentLinksList){
//            user.wasAbleTo(Ensure.that(hrefValue).contains("articles"));
//        }
//    }

    @Then("User validate {string} is displayed in title")
    public void userValidateIsDisplayedInTitle(String text) throws InterruptedException {
        Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(15000);
        String title = Serenity.getDriver().getTitle();
        user.wasAbleTo(Ensure.that(title).contains(text));
    }

    @Then("User verify content titles is displayed")
    public void userVerifyTitleIsDisplayed() {
        List<WebElement> contentTitle = searchResultsContentTitles.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement title: contentTitle){
            user.wasAbleTo(Ensure.that(title.isDisplayed()).isTrue());
        }
    }

    @Then("User verify content short descriptions is displayed")
    public void userVerifyShortDescriptionIsDisplayed() {
        List<WebElement> contentShortDescription = searchResultsContentExcerpt.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement excerpt: contentShortDescription){
            user.wasAbleTo(Ensure.that(excerpt.isDisplayed()).isTrue());
        }
    }

    @Then("User verify content thumbnail images is displayed")
    public void userVerifyThumbnailImagesIsDisplayed() {
        List<WebElement> contentThumbnailImages = searchResultsContentImages.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement image: contentThumbnailImages){
            user.wasAbleTo(Ensure.that(image.isDisplayed()).isTrue());
        }
    }

    @Then("User verify search results for {string} is displayed and are valid")
    public void userVerifySearchResultsForIsDisplayedAndAreValid(String content) {
        List<WebElement> searchResultLinkElements = getSearchResultsContentLinks.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        List<String> searchResultLinks = getSearchResultsContentLinks.stream().filter(WebElement::isDisplayed).map(webElement -> webElement.getAttribute("href")).distinct().collect(Collectors.toList());
        for (WebElement searchResultLinkElement : searchResultLinkElements) {
            user.wasAbleTo(Ensure.that(searchResultLinkElement.isDisplayed()).isTrue());
        }
        for (String hrefValue: searchResultLinks){
            user.wasAbleTo(Ensure.that(hrefValue).containsIgnoringCase(content));
        }
    }

    @Then("User verify search input box text matches {string}")
    public void userVerifySearchInputBoxTextMatches(String text) {
        user.wasAbleTo(Ensure.that(searchInputField).hasValue(text));
    }

    @And("User clear text from searchBox")
    public void userClearTextFromSearchBox() {
        clearSearchInputField();
    }

    @Then("User validate MyStory section has {int} cards")
    public void userValidateMyStorySectionHasCards(int num) {
        Actions actions = new Actions(Serenity.getDriver());
        List<WebElement> myStoryList = MyStoryList;
        actions.scrollToElement(myStoryList.get(0));
        user.wasAbleTo(Ensure.that(myStoryList.size()).isEqualTo(num));
    }

    @Then("User verify swipe functionality in MyStories")
    public void userVerifySwipeFunctionalityInMyStories() {
        Actions actions = new Actions(Serenity.getDriver());
        List<WebElement> MyStoryImages = Serenity.getDriver().findElements(By.xpath("//*[text()='My Story']/following::div[@class='slick-list']//div[@class='slick-slide' or @class='slick-slide slick-active slick-center slick-current']//img"));
        String firstMyStoryImage = MyStoryImages.get(0).getAttribute("src");
        for (int i=0;i<MyStoryList.size()-1;i++){
            user.wasAbleTo(Ensure.that(MyStoryImages.get(i).isDisplayed()).isTrue());
            actions.clickAndHold(MyStoryList.get(i)).moveToElement(MyStoryList.get(i+1)).release();
            MyStoryImages = Serenity.getDriver().findElements(By.xpath("//*[text()='My Story']/following::div[@class='slick-list']//div[@class='slick-slide' or @class='slick-slide slick-active slick-center slick-current']//img"));
        }
        for (WebElement image: MyStoryImages){
            if (image.isDisplayed()){
                user.wasAbleTo(Ensure.that(image.getAttribute("src").equals(firstMyStoryImage)).isTrue());
                break;
            }
        }
    }

    @When("User scroll to bottom of page")
    public void userScrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Then("User validate following footer links are displayed")
    public void userValidateFollowingFooterLinksAreDisplayed(DataTable dt) {
        List<List<String>> rows = dt.asLists(String.class);
        List<WebElement> footerLinks = Serenity.getDriver().findElements(By.xpath("//ul/li[contains(@id,'footer-quick')]/*"));
        List<String> footerLinkText = new ArrayList<>();
        for (WebElement link : footerLinks) {
            footerLinkText.add(link.getText());
        }
//        List<String> footerLinkText = footerLinks.stream().filter(WebElement::isDisplayed).map(webElement-> webElement.getText()).collect(Collectors.toList());
        System.out.println("Footer links size : " + footerLinkText.size());
        System.out.println("Footer links list : " + footerLinkText);
        for (int i=0;i<rows.get(0).size();i++){
//            user.wasAbleTo(Ensure.that(footerLinks.get(i).isDisplayed()).isTrue());
//            user.wasAbleTo(Ensure.that(footerLinks.get(i).getText()).isEqualTo(rows.get(0).get(i)));
            System.out.println("Looking for Footer link : " + rows.get(0).get(i));
            user.wasAbleTo(Ensure.that(footerLinkText.contains(rows.get(0).get(i))).isTrue());
        }
    }


    @Then("User verify {string} landing page with {string} breadcrumb")
    public void userVerifyLandingPageWithBreadcrumb(String content, String expectedBreadcrumb) {
        String breadcrumbText="";
        try{
            breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li']//span)[2]")).getText();
        } catch (NoSuchElementException e) {
            try {
                breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//a[contains(@class,'breadcrumbs-title')])[2]")).getText();
            } catch (NoSuchElementException f) {
                Serenity.getDriver().findElement(By.xpath("(//div[@class='custom-breadcrumb-section']//a)[2]")).getText();
            }
        }
        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }

    @Then("User verify editor peak landing page with {string} breadcrumb")
    public void userVerifyEditorPeakLandingPageWithBreadcrumb(String expectedBreadcrumb) {
        String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li']//span)[2]")).getText();

        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(breadcrumbText).contains(expectedBreadcrumb));
    }

    @Then("User verify Magazine landing page with {string} breadcrumb")
    public void userVerifyMagazineLandingPageWithBreadcrumb(String expectedBreadcrumb) {
        String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li']//a)[2]")).getText();

        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }

    @Then("User verify quiz landing page with {string} breadcrumb")
    public void userVerifyQuizLandingPageWithBreadcrumb(String expectedBreadcrumb) {
        String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//div[@class='custom-breadcrumb-section']//a)[2]")).getText();

        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }

    @Then("User verify Categories landing page with {string} breadcrumb")
    public void userVerifyCategoriesLandingPageWithBreadcrumb(String expectedBreadcrumb) {
        String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li']//span)[2]")).getText();

        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }
    @Then("User verify {string} landing page")
    public void userVerifyLandingPage(String content) throws InterruptedException {
//        WebElement contentTitle = Serenity.getDriver().findElement(By.xpath("//ul[@class='nav']/li/a[contains(text()='" + content + "')]"));
//
//        user.wasAbleTo(Ensure.that(contentTitle.getAttribute("class").contains("active")).isTrue());
        Thread.sleep(3000);
        String title = Serenity.getDriver().getTitle();
        user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
//        String link = Serenity.getDriver().getCurrentUrl();
//        user.wasAbleTo(Ensure.that(link).containsIgnoringCase(content));
    }

    public void userVerifyLandingPageForFooterLinks(String content) {
        Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = Serenity.getDriver().getTitle();
        user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
    }

    @When("User clicks on {string} view all")
    public void userClicksOnViewAll(String content) {
        user.wasAbleTo(ClickOn.contentViewAll(content));
    }

    @When("User clicks on {string} title from primaryNavBar")
    public void userClicksOnTitleFromPrimaryNavBar(String title) {
        user.wasAbleTo(ClickOn.theLinkInPrimaryNavBar(title));
    }

    @Then("User should be redirected to home page")
    public void userShouldBeRedirectedToHomePage() throws InterruptedException {
        Thread.sleep(10000);
        user.wasAbleTo(Ensure.that(secondaryNavBar).isDisplayed());
    }

    @Then("User verify {string} section is highlighted by default")
    public void userVerifySectionIsHighlightedByDefault(String title) {
        user.wasAbleTo(Ensure.that(primaryNavBarTitle.of(title)).attribute("class").containsIgnoringCase("Mui-selected"));
    }

    @Then("User verify MyStory description does not have more than {long} lines")
    public void userVerifyMyStoryDescriptionDoesNotHaveMoreThanLines(long num) {
        WebElement MyStoryDesc = Serenity.getDriver().findElement(By.xpath("//h6[text()='My Story']/following::p[contains(@class,'carousal-description')]"));
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        Long visibleLineCount = (Long) js.executeScript(
                "var element = arguments[0];" +
                        "var style = window.getComputedStyle(element);" +
                        "var lineHeight = parseFloat(style.lineHeight);" +
                        "var height = element.offsetHeight;" +
                        "return Math.round(height / lineHeight);",
                MyStoryDesc
        );
        System.out.println("Line count = " + visibleLineCount);
        user.wasAbleTo(Ensure.that(visibleLineCount<=num).isTrue());
    }

    @Then("User verify MyStory description shows Read More option when it has more than {int} lines")
    public void userVerifyMyStoryDescriptionShowsReadMoreOptionWhenItHasMoreThanLines(int num) {
        List<WebElement> myStoryList = MyStoryList;
        Actions actions = new Actions(Serenity.getDriver());
        actions.scrollToElement(myStoryList.get(0));
        for (int i=0;i<myStoryList.size();i++){
            JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
            Long visibleLineCount = (Long) js.executeScript(
                    "var element = arguments[0];" +
                            "var style = window.getComputedStyle(element);" +
                            "var lineHeight = parseFloat(style.lineHeight);" +
                            "var height = element.offsetHeight;" +
                            "return Math.round(height / lineHeight);",
                    MyStoryDesc
            );
            System.out.println("Line count = " + visibleLineCount);
            if (visibleLineCount>7)
                user.wasAbleTo(Ensure.that(MyStoryReadMore).isDisplayed());
            else
                user.wasAbleTo(Ensure.that(MyStoryReadMore).isNotDisplayed());
            swipeRightOnAnElement(MyStoryList.get(i));
        }

    }


    @Then("Verify MyStory title, image and Description")
    public void verifyMyStoryTitleImageAndDescription() {
        List<WebElement> myStoryList = Serenity.getDriver().findElements(By.xpath(MyStoryListXpath));
        Actions actions = new Actions(Serenity.getDriver());
        actions.scrollToElement(myStoryList.get(0));
        for (WebElement element : myStoryList) {
            WebElement myStoryTitle = Serenity.getDriver().findElement(By.xpath(MyStoryTitleXpath));
            WebElement myStoryDesc = Serenity.getDriver().findElement(By.xpath(MyStoryDescXpath));
            WebElement myStoryImage = Serenity.getDriver().findElement(By.xpath(MyStoryActiveImageXpath));
            user.wasAbleTo(Ensure.that(myStoryTitle.isDisplayed()).isTrue());
            user.wasAbleTo(Ensure.that(myStoryDesc.isDisplayed()).isTrue());
            user.wasAbleTo(Ensure.that(myStoryImage.isDisplayed()).isTrue());
            swipeRightOnAnElement(element);
        }
    }

    @When("User clicks on {string} title from secondaryNavBar")
    public void userClicksOnTitleFromSecondaryNavBar(String title) {
        user.wasAbleTo(ClickOn.theLinkInsecondaryMenuBar(title));
    }

    @Then("User validate all the web stories are listed below the “Web Stories” section.")
    public void userValidateAllTheWebStoriesAreListedBelowTheWebStoriesSection() {
        List<WebElement> webStories = Serenity.getDriver().findElements(By.xpath(webStoryListXpath));
        for (int i=1;i<=webStories.size();i++){
            user.wasAbleTo(Ensure.that(RelativeLocator.with(By.xpath("//h6[text()='Web Stories']/following::div[@class='MuiGrid-root mui-rfnosa']["+i+"]")).below(By.xpath("//h6[text()='Web Stories']"))).isDisplayed());
        }
    }

    @When("User clicks on profile section")
    public void userClicksOnProfileSection() {
        user.wasAbleTo(Ensure.that(ProfileSection).isDisplayed());
        user.wasAbleTo(ClickOn.profileSection());
    }

    @Then("User validate {string} displayed in secondary nav bar")
    public void userValidateDisplayedInSecondaryNavBar(String title) {
        List<WebElement> secondaryNavBarItems = Serenity.getDriver().findElements(By.xpath("(//nav)[2]//p"));
        System.out.println("SecondaryNavBarItems size = " + secondaryNavBarItems.size());
        List<String> secondaryNavBarItemsText = new ArrayList<>();
        for (WebElement secondaryNavBarItem : secondaryNavBarItems) {
            secondaryNavBarItemsText.add(secondaryNavBarItem.getText());
        }
//        List<String> secondaryNavBarItemsText = secondaryNavBarItems.stream().filter(WebElement::isDisplayed).map(webElement-> webElement.getText()).collect(Collectors.toList());
        System.out.println("SecondaryNavBarItemsText = " + secondaryNavBarItemsText);
        if (secondaryNavBarItemsText.contains(title)){
            user.wasAbleTo(Ensure.that(secondaryNavBarItemsText.contains(title)).isTrue());
        }
    }

    @When("I click on the {string} option in secondary nav bar")
    public void iClickOnTheOptionInSecondaryNavBar(String option) {
        List<WebElement> SecondaryNavBarItems = Serenity.getDriver().findElements(By.xpath("(//nav)[2]//p"));
        for (WebElement item: SecondaryNavBarItems){
            if (item.getText().equalsIgnoreCase(option)){
                Target targetItem = Target.the(option).locatedBy("(//nav)[2]//p[text()='"+ option + "']");
                user.wasAbleTo(Click.on(targetItem));
            }
        }

    }

    @When("User clicks on Read Today’s Healthzine Now")
    public void userClicksOnReadTodaySHealthzineNow() {
        user.wasAbleTo(ClickOn.todayHealthzine());
    }

    @Then("User should be redirected to today’s newsletter screen")
    public void userShouldBeRedirectedToTodaySNewsletterScreen() {
       
        String title = Serenity.getDriver().getTitle();
        String url = Serenity.getDriver().getCurrentUrl();
        user.wasAbleTo(Ensure.that(title).contains("Daily Healthzine"));
        user.wasAbleTo(Ensure.that(url).contains("todays-newsletter"));

    }

    @Then("User validate following social media links")
    public void userValidateFollowingSocialMediaLinks(DataTable dt) throws InterruptedException {
        List<List<String>> rows = dt.asLists(String.class);
        List<WebElement> socialMediaLinks = Serenity.getDriver().findElements(By.xpath(socialMediaFooterLinksXpath));;
        List<String> socialMediaLinkUrls = socialMediaLinks.stream().filter(WebElement::isDisplayed).map(webElement -> webElement.getAttribute("href")).collect(Collectors.toList());
        for (int i=0;i<rows.get(0).size();i++){
            if (rows.get(0).get(i).equalsIgnoreCase("facebook")){
                String content = "facebook";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement facebook = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'" + content + "')]"));
//                facebook.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("happiesthealth"));
            }
            if (rows.get(0).get(i).equalsIgnoreCase("instagram")){
                String content = "instagram";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement instagram = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'" + content + "')]"));
//                instagram.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                switchTab();
                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("happiesthealth"));
            }
            if (rows.get(0).get(i).equalsIgnoreCase("linkedin")){
                String content = "linkedin";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement linkedin = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'" + content + "')]"));
//                linkedin.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                switchTab();
                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("happiesthealth"));
            }
            if (rows.get(0).get(i).equalsIgnoreCase("youtube")){
                String content = "youtube";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement youtube = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'" + content + "')]"));
//                youtube.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                switchTab();
                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("happiesthealth"));
            }
            if (rows.get(0).get(i).equalsIgnoreCase("x")){
                String content = "x";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement x = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'twitter')]"));
//                x.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                switchTab();
                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("happiesthealth"));
            }
            if (rows.get(0).get(i).equalsIgnoreCase("pinterest")){
                String content = "pinterest";
                Serenity.getDriver().get(socialMediaLinkUrls.get(i));
//                WebElement pinterest = Serenity.getDriver().findElement(By.xpath(socialMediaFooterLinksXpath + "[contains(@href,'" + content + "')]"));
//                pinterest.click();
                Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                switchTab();
                Thread.sleep(3000);
                String title = Serenity.getDriver().getTitle();
                user.wasAbleTo(Ensure.that(title).containsIgnoringCase(content));
                String url = Serenity.getDriver().getCurrentUrl();
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase(content));
                user.wasAbleTo(Ensure.that(url).containsIgnoringCase("pinterest"));
            }
        }
    }

    @Then("User validate all footer links landing page")
    public void userValidateAllFooterLinksLandingPage() {
        List<WebElement> footerLinks = Serenity.getDriver().findElements(By.xpath("//ul[@class='MuiList-root MuiList-padding mui-1hgkieg']/li/*"));
        List<String> footerLinkUrls = footerLinks.stream().filter(WebElement::isDisplayed).map(webElement -> webElement.getAttribute("href")).distinct().collect(Collectors.toList());
        List<String> footerLinkText = footerLinks.stream().filter(WebElement::isDisplayed).map(WebElement::getText).distinct().collect(Collectors.toList());
        Serenity.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        for (int i=0;i<footerLinkUrls.size();i++) {
            if (footerLinkText.get(i).equals("Feedback")){
                continue;
            }
            else if (footerLinkText.get(i).equals("Advertising Policy")){
                continue;
            }
            else if (footerLinkText.get(i).equals("Corporate Wellness")){
                Serenity.getDriver().get(footerLinkUrls.get(i));
                String content = "The Fuller Life";
                userVerifyLandingPageForFooterLinks(content);
            } else if (footerLinkText.get(i).equals("FAQ’s")){
                Serenity.getDriver().get(footerLinkUrls.get(i));
                String content = "FAQ's";
                userVerifyLandingPageForFooterLinks(content);
            }
            else {
                String content = footerLinkText.get(i);
                Serenity.getDriver().get(footerLinkUrls.get(i));
                userVerifyLandingPageForFooterLinks(content);
            }
        }
    }

    @And("User click on {string} from footer links")
    public void userClickOnFromFooterLinks(String link) {
        user.wasAbleTo(ClickOn.thisFooterLink(link));
    }

    @Then("User verify language switch icon is displayed")
    public void userVerifyLanguageSwitchIconIsDisplayed() {
        user.wasAbleTo(Ensure.that(languageSwitch).isDisplayed());
    }

    @Then("User click on language switch icon")
    public void userClickOnLanguageSwitchIcon() {
        user.wasAbleTo(Click.on(languageSwitch));
    }

    @Then("User verify following languages is displayed")
    public void userVerifyFollowingLanguagesIsDisplayed(DataTable dt) throws InterruptedException {
        List<List<String>> rows = dt.asLists(String.class);
        Thread.sleep(2000);
        List<WebElement> LanguageList = Serenity.getDriver().findElements(By.xpath("//*[@id='language-switch-modal-title']/following::button"));;
        List<String> languageList = LanguageList.stream().filter(WebElement::isDisplayed).map(WebElement::getText).collect(Collectors.toList());
        System.out.println("language list : " + languageList);
        for (int i=0;i<rows.get(0).size();i++){
            user.wasAbleTo(Ensure.that(languageList.contains(rows.get(0).get(i))).isTrue());
            String text = capitalizeFirstLetterAndRestSmall(rows.get(0).get(i));
            Target Language = Target.the("Language").locatedBy("//*[@id='language-switch-modal-title']/following::button[text()='" + text + "']");
//            WebElement language = Serenity.getDriver().findElement(By.xpath(languages + "[text()='" + rows.get(0).get(i) + "']"));
            user.wasAbleTo(Ensure.that(Language).isDisplayed());
            user.wasAbleTo(Ensure.that(Language).isEnabled());
        }
    }

    @Then("User verify chatbot icon is displayed")
    public void userVerifyChatbotIconIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        user.wasAbleTo(Ensure.that(chatbot).isDisplayed());
    }

    @And("User click on chatbot icon")
    public void userClickOnChatbotIcon() {
        user.wasAbleTo(Click.on(chatbot));
    }

    @Then("User verify profile icon is displayed")
    public void userVerifyProfileIconIsDisplayed() {
        user.wasAbleTo(Ensure.that(ProfileSection).isDisplayed());
    }

    @Then("User verify Login Signup page")
    public void userVerifyLoginSignupPage() {
        Target signIn = getTargetOfText("Sign In");
        user.wasAbleTo(Ensure.that(signIn).isDisplayed());
        String title = Serenity.getDriver().getTitle();
        user.wasAbleTo(Ensure.that(title).containsIgnoringCase("Login"));
        String url = Serenity.getDriver().getCurrentUrl();
        user.wasAbleTo(Ensure.that(url).containsIgnoringCase("login"));
    }

    @Then("User verify checkout page is displayed")
    public void userVerifyCheckoutPageIsDisplayed() {
        user.wasAbleTo(Ensure.that(CheckoutPage).isDisplayed());
    }
    @When("User clicks on the image in My Story card")
    public void userClicksOnTheImageInMyStoryCard() {
        user.wasAbleTo(Click.on(firstMyStoryImage));
    }

    @When("User stores image src, title and  description of My Story card")
    public void userStoresImageSrcTitleAndDescriptionOfMyStoryCard() {
        MyStoryImgSrc = Serenity.getDriver().findElement(By.xpath(firstMyStoryImageElementXpath)).getAttribute("src");
        MyStoryTitleText = Serenity.getDriver().findElement(By.xpath(MyStoryTitleXpath)).getText();
        MyStoryDescriptionText = Serenity.getDriver().findElement(By.xpath(MyStoryDescXpath)).getText();
    }

    @Then("User verify My Story Detail page with {string}")
    public void  userVerifyMyStoryDetailPageWith(String expectedBreadcrumb) {
            String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("(//span[@class='elementor-button-text'])[2]")).getText();

            System.out.println("Actual breadcrumb text : " + breadcrumbText);
            user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }
    

    @Then("User verify Poll title in the header of the Poll section.")
    public void userVerifyPollTitleInTheHeaderOfThePollSection() {
        user.wasAbleTo(Ensure.that(PollSection).isDisplayed());
    }

    @Then("User verify Quiz section is displayed")
    public void userVerifyQuizSectionIsDisplayed() {
        user.wasAbleTo(Ensure.that(QuizSection).isDisplayed());
    }

    @Then("User verify Poll Section is displayed")
    public void userVerifyPollSectionIsDisplayed() {
        user.wasAbleTo(Ensure.that(PollSection).isDisplayed());
    }

    @Then("User verify Quiz title in the header of the Quiz section.")
    public void userVerifyQuizTitleInTheHeaderOfTheQuizSection() {
        user.wasAbleTo(Ensure.that(QuizSection).isDisplayed());
    }

    @Then("User verify View All button in the header of the {string} section.")
    public void userVerifyViewAllButtonInTheHeaderOfTheSection(String content) {
        user.wasAbleTo(Ensure.that(contentViewAll.of(content)).isDisplayed());
    }

    @Then("User verify Web Stories section is displayed")
    public void userVerifyWebStoriesSectionIsDisplayed() {
        user.wasAbleTo(Ensure.that(WebStoriesSection).isDisplayed());
    }

    @Then("User verify “Web Stories” title in the header of the “Web Stories” section.")
    public void userVerifyWebStoriesTitleInTheHeaderOfTheWebStoriesSection() {
        user.wasAbleTo(Ensure.that(WebStoriesSection).isDisplayed());
    }

    @Then("User verify Editor's Picks section is displayed")
    public void userVerifyEditorSPicksSectionIsDisplayed() {
        user.wasAbleTo(Ensure.that(EditorsPicksSection).isDisplayed());
    }

    @Then("User verify Editor’s pick title in the header of the Editor’s pick section.")
    public void userVerifyEditorSPickTitleInTheHeaderOfTheEditorSPickSection() {
        user.wasAbleTo(Ensure.that(EditorsPicksSection).isDisplayed());
    }

    @Then("User verify Web Stories are displayed")
    public void userVerifyWebStoriesAreDisplayed() {
        List<WebElement> webStories = Serenity.getDriver().findElements(By.xpath(webStoryListXpath));
        for (WebElement webStory : webStories) {
            user.wasAbleTo(Ensure.that(webStory.isDisplayed()).isTrue());
        }
    }

    @When("User click on first web story")
    public void userClickOnFirstWebStory() {
        List<WebElement> webStoryLinks = Serenity.getDriver().findElements(By.xpath(webStoryListXpath + "/a"));
        List<WebElement> webStoryTitles = Serenity.getDriver().findElements(By.xpath(webStoryListXpath + "//p"));
        webStoryHref = webStoryLinks.get(0).getAttribute("href");
        webStoryTitle = webStoryTitles.get(0).getText();
        webStoryLinks.get(0).click();
    }

    @Then("User verify Web Story opened in new tab")
    public void userVerifyWebStoryOpenedInNewTab() throws InterruptedException {
        List<String> windowHandles = new ArrayList<>(Serenity.getDriver().getWindowHandles());
        user.wasAbleTo(Ensure.that(windowHandles.size()).isEqualTo(2));
        switchTab();
        Thread.sleep(3000);
        String url = Serenity.getDriver().getCurrentUrl();
        String title = Serenity.getDriver().getTitle();
        user.wasAbleTo(Ensure.that(url).isEqualTo(webStoryHref));
        user.wasAbleTo(Ensure.that(title).contains(webStoryTitle));
    }


    @Then("User verify Web Story with Title is displayed")
    public void userVerifyWebStoryWithTitleIsDisplayed() {
        Ensure.enableSoftAssertions();
        List<WebElement> webStories = Serenity.getDriver().findElements(By.xpath(webStoryListXpath));
        List<WebElement> webStoryTitles = Serenity.getDriver().findElements(By.xpath(webStoryListXpath + "//p"));
        user.wasAbleTo(Ensure.that(webStories.size()).isEqualTo(webStoryTitles.size()));
        for (WebElement storyTitle : webStoryTitles) {
            user.attemptsTo(Ensure.that(storyTitle.isDisplayed()).isTrue());
        }
        Ensure.reportSoftAssertions();
    }


    @Then("User verify {int} editors picks displayed under editors pick section")
    public void userVerifyEditorsPicksDisplayedUnderEditorsPickSection(int count) {
        List<WebElement> editorsPicksList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath));
        user.wasAbleTo(Ensure.that(editorsPicksList.size()).isEqualTo(count));
    }

    @When("User click on first editors pick")
    public void userClickOnFirstEditorsPick() {
        List<WebElement> editorPicksTitleList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath+"//div[contains(@class,'title')]"));
        editorsPickTitle = editorPicksTitleList.get(0).getText();
        editorPicksTitleList.get(0).click();
    }

    @Then("User verify Editors picks detail page")
    public void userVerifyEditorsPicksDetailPage() {
         Target contentTitle = Target.the(editorsPickTitle + " title").locatedBy("//*[text()=\""+editorsPickTitle+"\"]");
        user.wasAbleTo(Ensure.that(contentTitle).isDisplayed());
//        String title = Serenity.getDriver().getTitle();
//        user.wasAbleTo(Ensure.that(title).contains(editorsPickTitle));
    }

    @Then("User verify Title for each content in the editors pick section.")
    public void userVerifyTitleForEachContentInTheEditorsPickSection() {
        List<WebElement> editorPicksTitleList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath+"//div[contains(@class,'title')]"));
        user.wasAbleTo(Ensure.that(editorPicksTitleList.size()).isEqualTo(4));
        for (WebElement element : editorPicksTitleList) {
            user.wasAbleTo(Ensure.that(element.isDisplayed()).isTrue());
        }
    }

    @Then("User verify the tags with symbol of the content type, on the thumbnail images.")
    public void userVerifyTheTagsWithSymbolOfTheContentTypeOnTheThumbnailImages() {
        List<WebElement> editorPicksContentTypeList = Serenity.getDriver().findElements(By.xpath(EditorsPicksListXpath+"//button"));
        user.wasAbleTo(Ensure.that(editorPicksContentTypeList.size()).isEqualTo(4));
        for (WebElement element:editorPicksContentTypeList){
            user.wasAbleTo(Ensure.that(element.isDisplayed()).isTrue());
        }
    }

    @Then("User verify Magazine image is displayed")
    public void userVerifyMagazineImageIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineImage).isDisplayed());
    }

    @Then("User verify Magazine dot which is beside title is displayed")
    public void userVerifyMagazineDotWhichIsBesideTitleIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineDot).isDisplayed());
    }

    @Then("User verify Magazine title is displayed")
    public void userVerifyMagazineTitleIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineTitle).isDisplayed());
    }

    @Then("User verify Magazine date is displayed")
    public void userVerifyMagazineDateIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineDate).isDisplayed());
    }

    @Then("User verify Magazine date displayed right to title")
    public void userVerifyMagazineDateDisplayedRightToTitle() {
        user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath("(//div[@id='home-magazine']//p)[2]")).toRightOf(By.xpath("//div[@id='home-magazine']//h3"))).isDisplayed()).isTrue());

    }

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        Serenity.getDriver().get(url);
    }

    @Then("User verify Magazine added to cart message is displayed")
    public void userVerifyMagazineAddedToCartMessageIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineCheckoutMessage).isDisplayed());
    }

    @Then("User verify View Cart is displayed")
    public void userVerifyViewCartIsDisplayed() {
        user.wasAbleTo(Ensure.that(MagazineCheckoutViewCart).isDisplayed());
    }

    @When("User stores Magazine name")
    public void userStoresMagazineName() {
        magazineName = Text.of(MagazineTitle).answeredBy(user);
    }

    @Then("User verify magazine name in checkout page")
    public void userVerifyMagazineNameInCheckoutPage() {
        user.wasAbleTo(Ensure.that(Text.of(MagazineCheckoutMessage).answeredBy(user)).contains(magazineName));
    }

    @Then("User verify {string} is displayed in checkout page")
    public void userVerifyIsDisplayedInCheckoutPage(String text) {
        user.wasAbleTo(Ensure.that(Text.of(MagazineCheckoutMessage).answeredBy(user)).contains(text));

    }

    @When("User click on Magazine image")
    public void userClickOnMagazineImage() {
        user.wasAbleTo(Click.on(MagazineImage));
    }

    @When("User stores the Magazine image")
    public void userStoresTheMagazineImage() {
        magazineImage = Attribute.of(MagazineImage,"src").answeredBy(user);
    }

    @Then("User verify magazine is opened")
    public void userVerifyMagazineIsOpened() {
        Target Magazine = Target.the("Primary nav bar Magazine").located(By.id("main-menu-item-Magazine"));
        user.wasAbleTo(Ensure.that(Magazine).attribute("class").contains("selected"));
//        Target magazineNameElement = Target.the(magazineName + " magazine name").locatedBy("//*[text()=\"" + magazineName + "\"]");
//        user.wasAbleTo(Ensure.that(magazineNameElement).isDisplayed());
//        Target magazineImageElement = Target.the(magazineImage + " magazine image").locatedBy("//img[@src=\"" + magazineImage + "\"]");
//        user.wasAbleTo(Ensure.that(magazineImageElement).isDisplayed());
    }

    @Then("User verify Poll question is displayed")
    public void userVerifyPollQuestionIsDisplayed() {
        user.wasAbleTo(Ensure.that(PollQuestion).isDisplayed());
    }

    @Then("User verify Poll options are displayed")
    public void userVerifyPollOptionsAreDisplayed() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollOptionsXpath));
        for (WebElement option: PollOptions){
            user.wasAbleTo(Ensure.that(option.isDisplayed()).isTrue());
        }

    }

    @Then("User verify Poll option radioButtons are displayed")
    public void userVerifyPollOptionRadioButtonsAreDisplayed() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollOptionsXpath));
        List<WebElement> PollOptionRadioButtons = Serenity.getDriver().findElements(By.xpath(PollRadioButtonsXpath));
        for (int i=0;i<PollOptions.size();i++){
            user.wasAbleTo(Ensure.that(PollOptionRadioButtons.get(i).isDisplayed()).isTrue());
        }
    }

    @Then("User verify Poll Vote button is disabled by default")
    public void userVerifyPollVoteButtonIsDisabledByDefault() {
        user.wasAbleTo(Ensure.that(PollVoteButton).isDisabled());
    }

    @When("User click on first option in Poll")
    public void userClickOnFirstOptionInPoll() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollRadioButtonsXpath));
        PollOptions.get(0).click();
    }

    @Then("User verify Poll Vote button is enabled")
    public void userVerifyPollVoteButtonIsEnabled() {
        user.wasAbleTo(Ensure.that(PollVoteButton).isEnabled());
    }

    @Then("User verify Poll Options Progress bars is displayed")
    public void userVerifyPollOptionsProgressBarsIsDisplayed() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollOptionsXpath));
        List<WebElement> PollProgressBars = Serenity.getDriver().findElements(By.xpath(PoleProgressBarsXpath));
        for (int i=0;i<PollOptions.size();i++){
            user.wasAbleTo(Ensure.that(PollProgressBars.get(i).isDisplayed()).isTrue());
        }
    }

    @Then("User verify Poll Options Percent is displayed")
    public void userVerifyPollOptionsPercentIsDisplayed() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollOptionsXpath));
        List<WebElement> PollOptionsPercent = Serenity.getDriver().findElements(By.xpath(PoleOptionsVotePercentXpath));
        for (int i=0;i<PollOptions.size();i++){
            user.wasAbleTo(Ensure.that(PollOptionsPercent.get(i).isDisplayed()).isTrue());
        }
    }

    @Then("User verify Poll Vote button is displayed")
    public void userVerifyPollVoteButtonIsDisplayed() {
        user.wasAbleTo(Ensure.that(PollVoteButton).isDisplayed());
    }

    @Then("User verify first option is selected")
    public void userVerifyFirstOptionIsSelected() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollRadioButtonsXpath));
        user.wasAbleTo(Ensure.that(PollOptions.get(0).isSelected()).isTrue());
    }

    @When("User click on second option in Poll")
    public void userClickOnSecondOptionInPoll() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollRadioButtonsXpath));
        PollOptions.get(1).click();
    }

    @Then("User verify second option is selected")
    public void userVerifySecondOptionIsSelected() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollRadioButtonsXpath));
        user.wasAbleTo(Ensure.that(PollOptions.get(1).isSelected()).isTrue());
    }

    @Then("User verify first option is deselected")
    public void userVerifyFirstOptionIsDeselected() {
        List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath(PollOptionsXpath));
        user.wasAbleTo(Ensure.that(PollOptions.get(0).isSelected()).isFalse());
    }


    @Then("User verify Poll Options are displayed below the question")
    public void userVerifyPollOptionsAreDisplayedBelowTheQuestion() {
        user.wasAbleTo(Ensure.that(Serenity.getDriver().findElement(RelativeLocator.with(By.xpath(PollOptionsXpath)).below(Serenity.getDriver().findElement(By.id("question")))).isDisplayed()).isTrue());
    }

    @Then("User verify Poll Question with image is displayed")
    public void userVerifyPollQuestionWithImageIsDisplayed() {
        user.wasAbleTo(Ensure.that(PollImage).isDisplayed());
    }

    @Then("User verify {int} WebStories are displayed at first view")
    public void userVerifyWebStoriesAreDisplayedAtFirstView(int count) {
        webStoriesSvgList = Serenity.getDriver().findElements(By.xpath(WebStorySvgListXpath)).stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        user.wasAbleTo(Ensure.that(webStoriesSvgList.size()).isEqualTo(count));
    }

    @When("User scroll on WebStory from right to left")
    public void userScrollOnWebStoryFromRightToLeft() {
        List<WebElement> webStorySvgList = Serenity.getDriver().findElements(By.ByLinkText.xpath(webStoryListXpath));
        int size = webStorySvgList.size();
        int mid = size/2;
        scrollLeftOnAnElement(webStorySvgList.get(mid));
    }

    @Then("User verify the {int}th webStory")
    public void userVerifyTheThWebStory(int count) {
        List<WebElement> latestWebStoriesSvgList = Serenity.getDriver().findElements(By.xpath(WebStorySvgListXpath)).stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement element : latestWebStoriesSvgList) {
            if (!webStoriesSvgList.contains(element)) {
                webStoriesSvgList.add(element);
            }
        }
        user.wasAbleTo(Ensure.that(webStoriesSvgList.size()).isEqualTo(count));
    }

    @Then("User verify maximum {int} WebStories are there")
    public void userVerifyMaximumWebStoriesAreThere(int count) {
        List<WebElement> WebStories = Serenity.getDriver().findElements(By.xpath(webStoryListXpath));
        user.wasAbleTo(Ensure.that(WebStories.size()).isEqualTo(count));
    }

    @Then("User verify Summit under Upcoming Summits is displayed")
    public void userVerifySummitUnderUpcomingSummitsIsDisplayed() {
        user.wasAbleTo(Ensure.that(SummitUnderUpcomingSummits).isDisplayed());
    }

    @When("User store the Upcoming summit name")
    public void userStoreTheUpcomingSummitName() {
        UpcomingSummitName = Text.of(TitleOfSummitUnderUpcomingSummits).answeredBy(user);
    }

    @Then("User verify the name of summit")
    public void userVerifyTheNameOfSummit() {
        Target SummitName = Target.the("Summit name").locatedBy("//h1");
        String ActualName = Text.of(SummitName).answeredBy(user);
        user.wasAbleTo(Ensure.that(ActualName).contains(UpcomingSummitName));
    }


    @Then("User verify View cart link is displayed")
    public void userVerifyViewCartLinkIsDisplayed() {
        Target element = Target.the("View cart").locatedBy("//a[contains(@href,\"View cart\") or contains(normalize-space(text()),\"View cart\")]");
        user.wasAbleTo(Ensure.that(element).hasTextContent("View cart"));
    }

    @And("User click on I accept checkbox")
    public void userClickOnIAcceptCheckbox() {

        user.wasAbleTo(ClickOn.IAcceptCheckbox());
    }

    @Then("I see user should be redirected to the {int}st link")
    public void iSeeUserShouldBeRedirectedToTheStLink(int arg0)  throws InterruptedException {
            Thread.sleep(30000);
            String ActualPageURL= Serenity.getDriver().getCurrentUrl();
            user.attemptsTo(Ensure.that(ActualPageURL).isNotEmpty());

        }


}
