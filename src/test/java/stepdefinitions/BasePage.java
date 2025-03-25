package stepdefinitions;

import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import Actions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static CMSPages.CommonObjects.*;
import static HHPages.CommonObjects.ErrorMessage;
import static Utils.CommonUtils.ButtonWithButtonName;
import static Utils.GenericLibrary.assertBreadcrumbTextWithExpectedBreadcrumbText;
import static happiestHealth.CreateLocators.createLinkUsingSource;
import static happiestHealth.CreateLocators.createTextField;
import static net.serenitybdd.core.Serenity.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;


public class BasePage {

    Actor user = MyCast.user();
    public static List<String> getBreadCrumbElementNameList(){
        WebDriver driver = getDriver();
        List<WebElement> breadcrumbElementList;
        //a[contains(@class,'breadcrumbs-title')]
        breadcrumbElementList = driver.findElements(By.xpath("//a[contains(@class,'breadcrumbs-title')]"));
//        breadcrumbElementList = driver.findElements(By.xpath("//*[contains(@id,'arrow-back-ios-new-rounded') or contains(@class,'fas fa-angle-right') or contains(@class,'fas fa-chevron-right') or contains(@class,'MuiBreadcrumbs-separator')]/preceding::div[@class='elementor-widget-container'][1]"));
        List<String> stringList = new ArrayList<>();
        for (WebElement element : breadcrumbElementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    @And("User click on {string} link using href attribute")
    public void userClickOnLinkUsingHrefAttribute(String linkName) {
        getLinkUsingHref(linkName).click();
    }

    public static WebElement getLinkUsingHref(String href){
        WebDriver driver = getDriver();
        String xpathValue = createLinkUsingSource(href);
        return driver.findElement(By.xpath(xpathValue));
    }

    @When("User clicks on {string} Link using linkName")
    public void userClicksOnLinkUsingLinkName(String linkName) throws InterruptedException {

        user.wasAbleTo(ClickOn.linkUsingLinkName(linkName));
        Thread.sleep(60000);
    }

    @Then("User validate {string} breadcrumb with {string} category and {string} title")
    public void userValidateBreadcrumbWithCategoryAndTitle(String expectedBreadcrumb, String category, String title) {
        user.wasAbleTo(Ensure.that(assertBreadcrumbTextWithExpectedBreadcrumbText(expectedBreadcrumb + category + ">" + title, title)).isTrue());
    }

    @Then("User validate date")
    public void userValidateDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        WebDriver driver = getDriver();
        WebElement contentDate = driver.findElement(By.xpath("//p[contains(@class,'date')]"));
        String contentDateText = contentDate.getText();
        System.out.println("Actual date " + contentDateText);
        user.wasAbleTo(Ensure.that(contentDateText).isEqualTo(dtf.format(now)));
    }

    public static String getCurrentMonth(String monthFormat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(monthFormat);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }


    public static String getCurrentDate(String dateFormat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    public static String getCurrentYear(String yearFormat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(yearFormat);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    @And("User accepts coookies pop up box")
    public static void userAcceptsCoookiesPopUpBox() {
        WebDriver driver = getDriver();
        try {

            WebElement acceptElement = driver.findElement(By.xpath("//span[text()='Accept']"));
            // click(acceptElement);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", acceptElement);
       /* Alert alert=webDriverInstance.getDriver().switchTo().alert();
        alert.accept();*/
        } catch (Exception e) {
            System.out.println("alert not found");
        }
    }

    public static  void userAcceptsCoookiesPopUpBoxInEvolution() {
        WebDriver driver = getDriver();
        try {
Thread.sleep(1000);
            WebElement acceptElement = driver.findElement(By.xpath("//button[text()='ACCEPT']"));
            // click(acceptElement);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", acceptElement);
       /* Alert alert=webDriverInstance.getDriver().switchTo().alert();
        alert.accept();*/
        } catch (Exception e) {
            System.out.println("alert not found post login");
            try {
                Thread.sleep(10000);
                WebElement acceptElement = driver.findElement(By.xpath("//button[text()='ACCEPT']"));
                // click(acceptElement);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", acceptElement);
            }catch (Exception f) {
                System.out.println("alert not found even after 10 seconds");
            }
        }
    }




    @And("User clicks on {string} button")
    public void userClicksOnButton(String buttonName) throws InterruptedException {
        WebDriver driver = getDriver();
        if (buttonName.equalsIgnoreCase("Media Library")){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[normalize-space(text())='" + buttonName + "']")));
        }else {
            try {
                if (buttonName.equalsIgnoreCase("Opt-in Now")){
                    Serenity.getDriver().findElement(By.xpath("//button[normalize-space(text())='" + buttonName + "']")).click();
                }else {
                    user.wasAbleTo(Click.on(ButtonWithButtonName(buttonName)));
                }
            }catch (ElementClickInterceptedException e){
                System.out.println("Element not clickable");
            }
        }
        Thread.sleep(10000);
    }




    @And("User click on {string} text")
    public void UserClickOnText(String text) {
        WebDriver driver = Serenity.getDriver();
        String xpathValue = createTextField(text);
        driver.findElement(By.xpath(xpathValue)).click();
    }

    @And("User clicks on radio button with {string} text using {string} label")
    public void userClicksOnRadioButtonWithTextUsingLabel(String text, String label) {
        user.wasAbleTo(ClickOn.radioButtonWithTextAndLabel(text,label));
    }

    @And("User click on {string} using {string}")
    public void userClickOnUsing(String elementAttribute, String attributeType) {

        user.wasAbleTo(ClickOn.attributeNameWithAttributeType(elementAttribute,attributeType));
    }

    @And("User enter {string} value in {string} input field")
    public void userEnterValueInInputField(String value, String inputField) throws InterruptedException {
        user.wasAbleTo(EnterValueInto.StringInputBox(value,inputField));
        Thread.sleep(5000);
    }

    @And("User clicks on checkbox with {string} text using {string} label")
    public void userClicksOnCheckboxWithTextUsingLabel(String text, String label) {
        user.wasAbleTo(ClickOn.checkBoxWithTextAndLabel(text,label));
    }

    @Then("^User validate ([^\\”]*) (text|link|inputBox|paragraph|class|button|checkbox|textArea) displayed on webPage$")
    public static void userValidateDisplayedOnWebPage(String elementName, String elementType) throws Exception {

        String xPathValue;
        switch (elementType.toLowerCase()) {

            case "link":
                xPathValue = "//a[contains(@href," + elementName + ") or contains(normalize-space(text())," + elementName + ")]";
                //List<WebElement> list = createListOfWebElement(xPathValue).stream().filter(a -> a.isDisplayed()).collect(Collectors.toList());
                List<WebElement> list = createListOfWebElement(xPathValue);
                assertThat("given " + elementType + " " + elementName + " not found", list.get(0).isDisplayed());
                break;

            case "text":
                xPathValue = "//*[normalize-space(text())=" + elementName + "]";
                list = createListOfWebElement(xPathValue).stream().filter(a -> a.isDisplayed()).collect(Collectors.toList());

                assertThat("given " + elementType + " " + elementName + " not found", list.get(0).isDisplayed());
                break;

            case "inputbox":
                xPathValue = "//input[contains(@placeholder," + elementName + ") or contains(@type," + elementName + ") or contains(@name," + elementName + ")]";
                assertThat("given " + elementType + " " + elementName + " not found", createListOfWebElement(xPathValue).stream().filter(a -> a.isDisplayed()).collect(Collectors.toList()).get(0).isDisplayed());
                break;

            case "textarea":
                xPathValue = "//textArea[contains(@placeholder," + elementName + ") or contains(@type," + elementName + ") or contains(@name," + elementName + ")]";
                assertThat("given " + elementType + " " + elementName + " not found", createListOfWebElement(xPathValue).stream().filter(a -> a.isDisplayed()).collect(Collectors.toList()).get(0).isDisplayed());
                break;

            case "paragraph":
                xPathValue = "//p[contains(normalize-space(text())," + elementName + ")]";
                System.out.println("given xpath is:- " + xPathValue);
                assertThat("given " + elementType + " " + elementName + " not found", createWebElement(xPathValue).isDisplayed());
                break;

            case "class":
                xPathValue = "//*[contains(@class," + elementName + ")]";
                assertThat("given " + elementType + " " + elementName + " not found", createWebElement(xPathValue).isDisplayed());
                break;

            case "button":
                xPathValue = "//button[normalize-space(text())=" + elementName + "]";
                list = createListOfWebElement(xPathValue).stream().filter(a -> a.isDisplayed()).collect(Collectors.toList());
                assertThat("given " + elementType + " " + elementName + " not found", list.get(0).isDisplayed());
                break;

            case "checkbox":
                xPathValue = "//input[@value=" + elementName + " or @id = " + elementName + "]";
                assertThat("given " + elementType + elementName + "not found", createWebElement(xPathValue).isEnabled());
                break;

            default:
                throw new Exception("given case not defined");
        }

    }


    @And("User click on {string} xpath button")
    public void userClickOnXpathButton(String xpathValue) {
        user.wasAbleTo(ClickOn.elementWithXpath(xpathValue));
    }

    @Then("User validate author name {string} with {string} in list screen")
    public void userValidateAuthorNameWithInListScreen(String author,String title) {
        user.wasAbleTo(Ensure.that(AuthorName.of(title)).isDisplayed());
        user.wasAbleTo(Ensure.that(AuthorName.of(title)).hasText(author));
    }

    @Then("User validate author subtitle {string} with {string} in list screen")
    public void userValidateAuthorSubtitleWithInListScreen(String authorSubtitle, String title) {
        user.wasAbleTo(Ensure.that(AuthorSubtitle.of(title)).isDisplayed());
        user.wasAbleTo(Ensure.that(AuthorSubtitle.of(title)).hasText(authorSubtitle));
    }

    @When("User clicks on radio button with {string} name")
    public void userClicksOnRadioButtonWithName(String name) {
        user.wasAbleTo(ClickOn.radioButtonWithName(name));
    }

    @Then("User validate error message is displayed")
    public void userValidateErrorMessageIsDisplayed() {
        user.wasAbleTo(Ensure.that(ErrorMessage).isDisplayed());
    }

    @When("User navigates back to the page")
    public void userNavigatesBackToThePage() {
        Serenity.getDriver().navigate().back();
    }

    @And("User validate {string} web button is enabled")
    public void iValidatewebButtonIsEnabled(String webButtonName) {

        user.wasAbleTo(Ensure.that(ButtonWithButtonName(webButtonName)).isEnabled());

    }

    @And("User clear value of {string} input")
    public void userClearValueOfInput(String value) {
        WebElement inputField = Serenity.getDriver().findElement(By.xpath("//input[@id='" + value + "' or @placeholder='" + value + "']"));
        String attributeValue = inputField.getAttribute("value");
        for (int i=0;i<attributeValue.length();i++){
            inputField.click();
            inputField.sendKeys(Keys.BACK_SPACE);
        }
    }

    @When("User scroll to {string} text")
    public void userScrollToText(String text) {
        Actions actions = new Actions(Serenity.getDriver());
        WebElement element = Serenity.getDriver().findElement(By.xpath("//*[text()='" + text + "']"));
        actions.scrollToElement(element);
    }
}
