package stepdefinitions;

import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static stepdefinitions.CMSCommonSteps.imgSrcForVideoThumbnail;

public class HowToGuides {

    Actor user = MyCast.user();



//    @FindBy(xpath = "//div[@class='elementor-custom-embed-play']")
//    WebElementFacade playButton;

    Target playButton1 = Target.the("play button").locatedBy("//div[@class='elementor-custom-embed-play']/i");

    Target videoDiv = Target.the("Video div").locatedBy("//div[@class='e-con-inner']/div[contains(@class,'elementor-widget-video')]");

    @FindBy(xpath = "//div/video")
    WebElementFacade videoSrc;

    Target videoSrc1 = Target.the("Video src").locatedBy("//div/video");

    @Then("User validate img src of first image")
    public void userValidateImgSrcOfFirstImage() {
//        WebElementFacade firstImage = InfographicImages.get(0);
        WebElement firstImage = new  HHPages.HowToGuides().InfographicImages().get(0);
        user.wasAbleTo(Ensure.that(firstImage.getAttribute("src")).isEqualTo(imgSrcForVideoThumbnail));
    }

    @And("User click on first image")
    public void userClickOnFirstImage() {
        WebElement firstImage = new  HHPages.HowToGuides().InfographicImages().get(0);
        firstImage.click();
    }

    @Then("User validate play button is enabled")
    public void userValidatePlayButtonIsEnabled() throws InterruptedException {

        user.wasAbleTo(Ensure.that(playButton1).isEnabled());
    }


    @Then("User validate video src with {string}")
    public void userValidateVideoSrcWith(String expectedVideoSrc) throws InterruptedException {
        Thread.sleep(2000);
        user.wasAbleTo(Ensure.that(videoSrc1).attribute("src").contains(expectedVideoSrc));
    }

    @And("User click on play button")
    public void userClickOnPlayButton() {
        user.wasAbleTo(Click.on(playButton1));
    }

    @Then("User validate video is YoutubeShorts video")
    public void userValidateVideoIsYoutubeShortsVideo() {
        user.wasAbleTo(Ensure.that(videoDiv).attribute("data-settings").containsIgnoringCase("Youtube"));
        user.wasAbleTo(Ensure.that(videoDiv).attribute("data-settings").containsIgnoringCase("Shorts"));
    }

    @Then("User validate video is Youtube video")
    public void userValidateVideoIsYoutubeVideo() {
        user.wasAbleTo(Ensure.that(videoDiv).attribute("data-settings").containsIgnoringCase("Youtube"));
    }


}
