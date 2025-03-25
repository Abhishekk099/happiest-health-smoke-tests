package CMSPages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:HappiestHealthCMS")
public class CMSLoginPage extends PageObject {
    public static Target USERNAME = Target.the("Username Field").locatedBy("#user_login");
    public static Target PASSWORD = Target.the("Password Field").locatedBy("#user_pass");


}
