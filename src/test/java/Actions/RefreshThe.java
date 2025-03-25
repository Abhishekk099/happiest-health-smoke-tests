package Actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Browser;

public class RefreshThe {
    public static Performable CurrentPage() {
        return Task.where("{0} login to CMS login page",
                Browser.refreshPage());
    }


}