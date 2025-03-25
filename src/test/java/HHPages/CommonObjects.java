package HHPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CommonObjects extends PageObject {

    public static Target RadioButtonWithName = Target.the("Radio button with {0} name").locatedBy("//input[@name='{0}']");
    public static Target ErrorMessage = Target.the("Error message").located(By.id("email-error"));
}
