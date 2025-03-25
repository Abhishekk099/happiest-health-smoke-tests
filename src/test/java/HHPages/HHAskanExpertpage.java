package HHPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HHAskanExpertpage extends PageObject {

    public static Target AskanExpertSectionWithReferenceToMagazine = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//h6[text()='Magazine']/../../following-sibling::*//h6[text()='Ask an Expert']");

    public static List<WebElement> askAnExpertCards = Serenity.getDriver().findElements(By.xpath("(//h6[text()='Ask an Expert']/../following-sibling::div/a/div)"));

    public static Target askAnExpertfirstcard = Target.the("Ask an Expert first card").locatedBy
            ("(//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[1]");

    public static Target askAnExpertSecondCardcard  = Target.the("Ask an Expert second card").locatedBy
            ("(//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[2]");


    public static Target AskanExpertViewAll = Target.the("askAnExpertViewAll").locatedBy
            ("//h6[text()='Ask an Expert']/parent::div/div/a/p");



    public static Target GoogleAds = Target.the("Google Ads").locatedBy
            ("//iframe[contains(@id,'google_ads_iframe')]");


    public static Target LinkInsecondaryMenuBar=  Target.the("{0} Link").
            locatedBy("//p[@id='title' and text()=\"{0}\"]");

    public static Target PodcastViewAll = Target.the("WellnessProgrammesViewAll").locatedBy
            ("//a[@id='home-podcasts-view-all']/p");
}
