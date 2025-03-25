package HHPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserAuthenticationPage extends PageObject {
    public static Target EmailField = Target.the("Email input field").located(By.xpath("//input"));

}
