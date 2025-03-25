package HHPages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
@DefaultUrl("page:HappiestHealthVideoPage")
public class HHVideoPage extends PageObject {
    public static Target Breadcrumb = Target.the("{0} Breadcrumb").
            locatedBy("//a[contains(@class,'breadcrumbs-title')][text()='{0}']");
    public static Target TILES = Target.the("Article Tiles").
            locatedBy("//div[contains(@class,' list-card ')]");

    public int getAvailableTilesNumber(){
        List<WebElement> tiles=getDriver().findElements(By.xpath("//div[contains(@class,' list-card ')]"));
        return tiles.size();
    }

    public List<WebElement> getAvailableTiles(){
        List<WebElement> tiles=getDriver().findElements(By.xpath("//div[contains(@class,' list-card ')]"));
        return tiles;
    }
    public static Target TIMERICON = Target.the("Timer Icon").
            locatedBy("//div[contains(@class,'timer-icon')]");

    public static Target FirstVideo = Target.the("First Video").
            locatedBy("//div[contains(@class,'title')]");

    public static Target VideoCategoryBreadcrumb = Target.the("Video Category Breadcrumb").
            locatedBy("(//a[contains(@class,'breadcrumbs-title')])[3]");
    public static Target VideoTitleBreadcrumb = Target.the("Video Title Breadcrumb").
            locatedBy("(//a[contains(@class,'breadcrumbs-title')])[4]");

    public static Target PlayButton = Target.the("Play Button").
            located(By.xpath("//div[contains(@class,'video-play-button')]"));

    public static Target LSCStrip = Target.the("LSC Strip").
            locatedBy("//div[contains(@class,'social-media-box')]");

    public static Target Speaker = Target.the("Speaker section").
            locatedBy("//div[contains(@class,'profile-icon')]/..");

    public static Target SpeakerName = Target.the("Speaker Name").
            locatedBy("//h4[contains(@class,'author-name')]");

    public static Target SpeakerImage = Target.the("Speaker Image").
            locatedBy("//div[contains(@class,'profile-icon')]//img");

    public static Target EnterResponse = Target.the("Enter Response").
            locatedBy("//div[contains(@class,'response-input-box')]//textarea");

    public static Target EnterName = Target.the("Enter Name").
            locatedBy("//div[contains(@class,'name-input-box')]//textarea");

    public static Target EnetrEmail = Target.the("Enetr Email").
            locatedBy("//input[@name='email']");

    public static Target PostComment = Target.the("Post Comment").
            locatedBy("//button[contains(@class,'post-comment')]");
    public static Target CommentSection = Target.the("Comment Section").
            locatedBy("//div[contains(@class,'comment-title')]");

    public static Target CommentUserName = Target.the("Comment User Name").
            locatedBy("(//p[contains(@class,'reply-comment-author')])[1]");



}

