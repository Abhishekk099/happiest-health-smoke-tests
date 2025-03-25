package HHPages;

import Utils.MyCast;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;

public class HowToGuides {

    static Actor user = MyCast.user();

//    public static List<WebElementFacade> InfographicImages = Target.the("Infographic Images").locatedBy("//div[@class='elementor-widget-container']//div[contains(@class,'type-infographic_cards')]//img").resolveAllFor(user);
    @FindBy(xpath = "//div[@class='elementor-widget-container']//div[contains(@class,'type-infographic_cards')]//img")
    static List<WebElementFacade> images;

    public static List<WebElementFacade> getListOfImages() {
        return images;
    }

    public List<WebElement> InfographicImages(){
        return getDriver().findElements(By.xpath("//div[@class='elementor-widget-container']//div[contains(@class,'type-infographic_cards')]//img"));
    }
}
