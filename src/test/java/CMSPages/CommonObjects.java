package CMSPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonObjects extends PageObject {

    public static Target getLinkUsingLinkName(String linkName){
        return Target.the(linkName + " linkName").located(By.linkText(linkName));
    }

    public static Target getTargetOfText(String text){
        return Target.the(text + "text").locatedBy("//*[normalize-space(text()) ='" + text + "']");
    }
    public static Target CheckoutPage = Target.the("Radio button with {0} text and {1} label").
            locatedBy("//div[@class='e-checkout__container']");


    public static Target RadioButtonWithTextAndLabel = Target.the("Radio button with {0} text and {1} label").
            locatedBy("//label[normalize-space(text())='{1}']/following::label[normalize-space(text())='{0}']/input[@type='radio']");

    public static Target CheckBoxWithTextAndLabel = Target.the("Radio button with {0} text and {1} label").
            locatedBy("//label[normalize-space(text())='{1}']/following::label[normalize-space(text())='{0}']/input[@type='checkbox']");


    public static Target linkWithLinkNameAndLabel = Target.the("Link with {0} linkName and {1} label").
            locatedBy("//label[normalize-space(text())='{1}']/following::a[normalize-space(text())='{0}']");

    public static Target attributeNameUsingAttributeType = Target.the("Attribute Name as {0} using {1} attributeType").
            locatedBy("//*[@{1}='{0}']");

    public static Target StringInputField = Target.the("String value in {0} input field").
            locatedBy("//input[contains(@placeholder,'{0}') or contains(@type,'{0}')or contains(@name,'{0}') or contains(@id,'{0}')]");

    public static Target AuthorName = Target.the("{0} author name").locatedBy("(//a[text()='{0}']/following::h4)[1]");

    public static Target AuthorSubtitle = Target.the("{0} Author subtitle").locatedBy("(//a[text()='[Automation] Best Practices in Diet Control']/following::h4/following::div[2])[1]");
    public static List<WebElement> createListOfWebElement(String xpath) {
        WebDriver driver = Serenity.getDriver();
        return driver.findElements(By.xpath(xpath));
    }

    public static WebElement createWebElement(String xpath) {
        WebDriver driver = Serenity.getDriver();
        return driver.findElement(By.xpath(xpath));
    }

    public static Target AddNewPost = Target.the("{0} Add new Post button").locatedBy("//h1[normalize-space(text())='{0}']/following::a[normalize-space(text())='Add New Post']");



}
