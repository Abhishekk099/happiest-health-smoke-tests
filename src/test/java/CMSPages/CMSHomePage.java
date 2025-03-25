package CMSPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CMSHomePage extends PageObject {
    public WebElement getIFrameelement(String css){
        return getDriver().findElement(By.cssSelector(css));
    }
    public static Target Articles = Target.the("Category Field").locatedBy("//div[text() ='Articles']");
    public static Target DocTales = Target.the("Doc tales").locatedBy("//div[text() ='Discussions']");

    public static Target Dashboard = Target.the("Dashboard").locatedBy("//div[text() ='Dashboard']");

    public static Target FirstImageInMediaLibrary = Target.the("FirstImageInMediaLibrary").locatedBy("(//div[@class='thumbnail']//following::img)[1]");
    public static Target ViewPost = Target.the("ViewPost").locatedBy("//a[text()='View post']");
    public static Target Content(String content){
        return Target.the("{0}").locatedBy("//*[text() = '" + content + "']");
    }

    public static Target CustomInput(String elementAttribute, String attributeType){
        return Target.the(elementAttribute+ " input field").locatedBy("//input[@" + attributeType + "='" + elementAttribute +"']");
    }

    public static Target PostConfirmation = Target.the("Dashboard").locatedBy("//p[text()='Post published. ']");



}
