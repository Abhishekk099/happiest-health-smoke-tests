package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MyCast extends OnlineCast {

    @Managed
    static WebDriver driver;

    public static Actor user() {
        Actor actor = Actor.named("User");
        actor.can(BrowseTheWeb.with(driver));
        return actor;
    }

    public static Actor runInMobileView(){
        Actor actor = Actor.named("User");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        actor.can(BrowseTheWeb.with(driver));
        return actor;
    }
}
