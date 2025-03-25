package Utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class CommonUtils extends PageObject {
    public void maximizeTheWindow(){
        getDriver().manage().window().maximize();
    }
    public void switshToNewWindow(){
        getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

    public static Target ButtonWithButtonName(String buttonName) {
        return Target.the("Button name with text " + buttonName).locatedBy("//button[normalize-space(text())='" + buttonName + "']");
    }

    public void clickOnElementThatWillEventuallyAppear(String attributeType, String attributeValue) {
        String xPathValue = "//*[@" + attributeType + "=\"" + attributeType + "\"]";
        withTimeoutOf(Duration.ofSeconds(30))
                .find(By.xpath(xPathValue))
                .click();
    }

    public void waitForVisibleTextToAppear(WebElement element) {
        waitForCondition().until(
                ExpectedConditions.textToBePresentInElement(element, "Processing done")
        );
    }

    public static void swipeRightOnAnElement(WebElement element){
        // Get the size of the swipe element
        int width = element.getSize().getWidth();
        // Create an instance of Actions class
        Actions actions = new Actions(Serenity.getDriver());
        // Perform the swipe action: click and hold, move to the right, and release
        actions.clickAndHold(element)
                .moveByOffset(width/2, 0)  // Move right by the width of the element
                .release()
                .perform();
    }

    public static void switchTab(){
        Set<String> allWindowHandles = Serenity.getDriver().getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allWindowHandles);

        // Switch to the second tab
        Serenity.getDriver().switchTo().window(tabs.get(1));
    }

    public static boolean isValidMonthDate(String date) {
        boolean flag;
        Set<String> months = new HashSet<>(Arrays.asList(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December",
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"
        ));
        String[] parts = date.split(" ");
        String month = parts[0];
        if (months.contains(month)) {
            flag= true;
        } else {flag= false;}
        return flag;
    }


    public void waitForAjaxToComplete(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) wd ->
        {
            assert wd != null;
            return ((JavascriptExecutor) wd).executeScript("return jQuery.active").equals(0);
        });
    }

    public static void scrollToLeft(){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollBy(-500, 0);");
    }

    public static void scrollToRight(){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollBy(500, 0);");
    }

    public static void scrollLeftOnAnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollLeft -= 500;", element);  // Scroll left by 250 pixels
    }

    public static void scrollRightOnAnElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollLeft += 500;", element);  // Scroll left by 250 pixels
    }

    public static String capitalizeFirstLetterAndRestSmall(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

}
