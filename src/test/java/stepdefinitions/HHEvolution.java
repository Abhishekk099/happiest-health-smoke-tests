package stepdefinitions;

import Actions.ClickOn;
import Actions.NavigateTo;
import Utils.CommonUtils;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static HHPages.HHAskanExpertpage.*;
import static HHPages.HHAskanExpertpage.AskanExpertSectionWithReferenceToMagazine;
import static HHPages.HHEvolutionPage.*;
import static HHPages.HHLandingPage.*;
import static Utils.CommonUtils.isValidMonthDate;
import static stepdefinitions.BasePage.userAcceptsCoookiesPopUpBoxInEvolution;


public class HHEvolution {
    Actor user = MyCast.user();

    @Given("User has launched Evolution URL")
    public void userHasLaunchedEvolutionURL() throws InterruptedException {
         new CommonUtils().maximizeTheWindow();
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
        Thread.sleep(500);
        userAcceptsCoookiesPopUpBoxInEvolution();
    }
    @Given("User has launched Evolution URL again")
    public void userHasLaunchedEvolutionURLpostlogin() throws InterruptedException {
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
        Thread.sleep(500);
    }


    @Then("User Verify {string} is present in main menu")
    public void userVerifyIsPresentInMainMenu(String value) {
        user.attemptsTo(Ensure.that(DiagnosticsInMenu).isDisplayed());
    }

    @Then("Verify {string} is present in main menu")
    public void verifyIsPresentInMainMenu(String value) {
        user.attemptsTo(Ensure.that(TabsInMenu.of(value)).isDisplayed());
    }
    @Then("User clicks on {string} in primary menu")
    public void clickOnValueInPrimaryMenu(String value) {
        user.attemptsTo(ClickOn.theLinkInPrimaryMenu(value));
    }
    @Then("Verify {string} is present in main menu in legacy UI")
    public void verifyIsPresentInMainMenulegacyUI(String value) {
        user.attemptsTo(Ensure.that(TabsInMenuOP.of(value)).isDisplayed());
    }
    @Then("I see the {string} logo on the top left corner in the header section.")
    public void iSeeTheLogoOnTheTopLeftCornerInTheHeaderSection(String arg0) {
        user.attemptsTo(Ensure.that(HHLogo).isDisplayed());
    }

    @When("I clicked on {string} from the secondary menu")
    public void iClickedOnCategoriesFromTheSecondaryMenu(String value) throws InterruptedException {
        user.attemptsTo(ClickOn.theLinkInsecondaryMenuBar(value));
    }

    @When("I clicked on {string} from the primary menu")
    public void iClickedOnCategoriesFromThePrimaryMenu(String value) {
        user.attemptsTo(ClickOn.theLinkPrimaryMenuBar(value));
        userAcceptsCoookiesPopUpBoxInEvolution();
    }

    @When("I clicked on “Happiest Health” logo in the header section")
    public void iClickedOnHappiestHealthLogoInTheHeaderSection() throws InterruptedException {
        Thread.sleep(5000);
        user.attemptsTo(ClickOn.HHLogo());
    }

    @Then("I redirected back to the home page")
    public void iRedirectedBackToTheHomePage() throws InterruptedException {
        Thread.sleep(10000);
        String ExpectedPageTitle="Health and Wellness - A Guide to a Healthy Lifestyle | Happiest Health";
        String ActualPageTitle= Serenity.getDriver().getTitle();
        user.attemptsTo(Ensure.that(ActualPageTitle).isEqualTo(ExpectedPageTitle));

    }

    @Then("I see the {int} card displayed in the {string} section")
    public void iSeeTheCardDisplayedInTheSection(Integer DefaultTilesNo, String value) throws InterruptedException {
       user.attemptsTo(Ensure.that(WellnessProgrammesTiles.size()).isEqualTo(DefaultTilesNo));
    }

    @Then("I see the {int} card displayed in the podcast section")
    public void iSeeTheCardDisplayedInThePodcastSection(Integer DefaultTilesNo) throws InterruptedException {
        user.attemptsTo(Ensure.that(PodcastTiles.size()).isEqualTo(DefaultTilesNo));
    }

    @Then("I see the {string} section")
    public void iSeeTheSection(String value) {
        user.attemptsTo(Ensure.that(HomePageTiles.of(value)).isDisplayed());
    }

    @When("I click on the {string} card")
    public void iClickOnTheCard(String arg0) {
        Serenity.getDriver().findElement(By.xpath("//h6[text()='Corporate Wellness']/../following-sibling::*//div[contains(@id,'home-wellness-programmes')]")).click();
    }
    @When("I click on the podcast card")
    public void iClickOnThePodcastCard() {
        Serenity.getDriver().findElement(By.xpath("//h6[text()='Podcasts']/../following-sibling::*//div[contains(@id,'home-podcasts')]")).click();
    }

    @Then("I see user should be redirected to the specific programme details screen")
    public void iSeeUserShouldBeRedirectedToTheSpecificProgrammeDetailsScreen() throws InterruptedException {
        Thread.sleep(60000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("wellnessprograms"));
    }

    @Then("I see user should be redirected to the specific podcast details screen")
    public void iSeeUserShouldBeRedirectedToTheSpecificPodcastDetailsScreen() throws InterruptedException {
        Thread.sleep(60000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("podcast"));
    }

    @When("I click on the  view all in in wellness programmes section")
    public void iClickOnTheViewAllInInWellnessProgrammesSection() {
        user.attemptsTo(ClickOn.wellnessProgrammesViewAll());
    }

    @When("I click on the  view all in in podcast section")
    public void iClickOnTheViewAllInInPodcastSection() {
        user.attemptsTo(ClickOn.podcastViewAll());
    }

    @Then("I verify title thumbnail image with podcast name and button")
    public void iVerifyTitleThumbnailImageWithPodcastNameAndButton() {
        user.attemptsTo(Ensure.that(PodcastThumbnailImage).isDisplayed());
        user.attemptsTo(Ensure.that(PodcastThumbnailButton).isDisplayed());
        user.attemptsTo(Ensure.that(PodcastCardTitle).isDisplayed());
    }

    @Then("I verify title thumbnail image with programme name and button")
    public void iVerifyTitleThumbnailImageWithProgrammeNameAndButton() {

        user.attemptsTo(Ensure.that(WellnessProgrammesThumbnailImage).isDisplayed());
        user.attemptsTo(Ensure.that(WellnessProgrammesThumbnailButton).isDisplayed());
        user.attemptsTo(Ensure.that(WellnessProgrammesCardTitle).isDisplayed());
    }

    @And("I verify card title should display with {int} dots at the end of the title")
    public void iVerifyCardTitleShouldDisplayInLinesWithDotsAtTheEndOfTheTitle(int arg1) {
      String  WellnessProgrammesCardTitleActual = Serenity.getDriver().findElement(By.xpath(("(//div[contains(@id,'home-wellness-programmes')])[1]/div/div/div/div"))).getText();
      if(WellnessProgrammesCardTitleActual.length()>70) {
            user.attemptsTo(Ensure.that(WellnessProgrammesCardTitleActual).contains("..."));
        }
    }

    @And("I verify podcast card title should display with {int} dots at the end of the title")
    public void iVerifyPodcastCardTitleShouldDisplayInLinesWithDotsAtTheEndOfTheTitle(int arg1) {
        String  PodcastCardTitleActual = Serenity.getDriver().findElement(By.xpath(("(//div[contains(@id,'home-podcasts')])[1]/div/div/div/div"))).getText();
        if(PodcastCardTitleActual.length()>70) {
            user.attemptsTo(Ensure.that(PodcastCardTitleActual).contains("..."));
        }
    }

    @Then("I Validate the search icon is present before the profile icon")
    public void iValidateTheSearchIconIsPresentBeforeTheProfileIcon() {
        user.attemptsTo(Ensure.that(SearchIconWithReferenceToProfileIcon).isDisplayed());
    }


    @And("I select Hindi languages in LanguageDropdown")
    public void iSelectOtherLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.hindiInLanguageDropDown());
    }
    @And("I select Bengali languages in LanguageDropdown")
    public void iSelectBengaliLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.banglaInLanguageDropDown());
    }
    @And("I select Kannada languages in LanguageDropdown")
    public void iSelectKannadaLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.kanadaInLanguageDropDown());
    }

    @And("I select Telugu languages in LanguageDropdown")
    public void iSelectTeluguLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.teluguInLanguageDropDown());
    }
    @And("I select Malayalam languages in LanguageDropdown")
    public void iSelectMalayalamLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.malayalamInLanguageDropDown());
    }
    @And("I select Gujarati languages in LanguageDropdown")
    public void iSelectGujaratiLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.gujratiInLanguageDropDown());
    }
    @And("I select Marathi languages in LanguageDropdown")
    public void iSelectMarathiLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.marathiInLanguageDropDown());
    }
    @And("I select Tamil languages in LanguageDropdown")
    public void iSelectTamilLanguagesExceptInLanguageDropdown() {
        user.wasAbleTo(ClickOn.theLanguageDropDown());
        user.wasAbleTo(ClickOn.tamilInLanguageDropDown());
    }
    @Then("I see user should be redirected to Hindi Language Landing Page")
    public void iSeeUserShouldBeRedirectedToHindiLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/hi"));

    }
    @Then("I see user should be redirected to Bengali Language Landing Page")
    public void iSeeUserShouldBeRedirectedToBengaliLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/bn"));
    }
    @Then("I see user should be redirected to Kannada Language Landing Page")
    public void iSeeUserShouldBeRedirectedToKannadaLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/ka"));

    }
    @Then("I see user should be redirected to Telugu Language Landing Page")
    public void iSeeUserShouldBeRedirectedToTeluguLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/te"));

    }
    @Then("I see user should be redirected to Malayalam Language Landing Page")
    public void iSeeUserShouldBeRedirectedToMalayalamLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/ml"));

    }
    @Then("I see user should be redirected to Gujarati Language Landing Page")
    public void iSeeUserShouldBeRedirectedToGujaratiLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/gu"));

    }
    @Then("I see user should be redirected to Marathi Language Landing Page")
    public void iSeeUserShouldBeRedirectedToMarathiLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/mr"));

    }
    @Then("I see user should be redirected to Tamil Language Landing Page")
    public void iSeeUserShouldBeRedirectedToTamilLanguageLandingPage() throws InterruptedException {
        Thread.sleep(15000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/ta"));

    }

    @Then("I see user should be redirected to diagnostics Landing Page")
    public void iSeeUserShouldBeRedirectedToDiagnosticsLandingPage() throws InterruptedException {
        Thread.sleep(5000);
        userAcceptsCoookiesPopUpBoxInEvolution();
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("diagnostics.happiesthealth.com"));

    }
    @Then("I see user should be redirected to askanexpert Landing Page")
    public void iSeeUserShouldBeRedirectedToaskanexpertLandingPage() throws InterruptedException {
        Thread.sleep(5000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/askanexpert"));

    }

    @Then("I see user should be redirected to Magazine Landing Page")
    public void iSeeUserShouldBeRedirectedToMagazineLandingPage() throws InterruptedException {
        Thread.sleep(5000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/magazine-subscription"));

    }

    @Then("I see user should be redirected to Health Summits Landing Page")
    public void iSeeUserShouldBeRedirectedToHealthSummitsLandingPage() throws InterruptedException {
        Thread.sleep(5000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/wellnessprograms"));

    }

    @Then("I click on notification icon")
    public void iClickOnNotificationIcon()  throws InterruptedException{
        user.attemptsTo(ClickOn.notificationIcon());

    }

    @Then("I Validate profile icon is present")
    public void iValidateProfileIconIsPresent() {
        user.attemptsTo(Ensure.that(ProfileIcon).isDisplayed());
    }


    @And("I Validate the language option is present before the search option")
    public void iValidateTheLanguageOptionIsPresentBeforeTheSearchOption() {
        user.attemptsTo(Ensure.that(LanguageIconWithReferenceToSearchIcon).isDisplayed());
    }

    @Then("I Validate the notification is present icon before the profile option")
    public void iValidateTheNotificationIsPresentIconBeforeTheProfileOption() {
        user.attemptsTo(Ensure.that(NotificationIconIconWithReferenceProfileIcon).isDisplayed());
    }

    @Then("I see the {int} card displayed in the videos section")
    public void iSeeTheCardDisplayedInTheVideosSection(Integer DefaultTilesNo) throws InterruptedException {
        user.attemptsTo(Ensure.that(VideosTiles.size()).isEqualTo(DefaultTilesNo));
    }

    @When("I click on the videos card")
    public void iClickOnTheVideosCard() {
        Serenity.getDriver().findElement(By.xpath("//h6[text()='Videos']/../following-sibling::*//div[contains(@id,'home-videos')]")).click();
    }

    @Then("I see user should be redirected to the specific videos details screen")
    public void iSeeUserShouldBeRedirectedToTheSpecificVideosDetailsScreen() throws InterruptedException {
        Thread.sleep(60000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("videos"));
    }

    @Then("I verify title thumbnail image with videos name and button")
    public void iVerifyTitleThumbnailImageWithVideosNameAndButton() {
        user.attemptsTo(Ensure.that(VideosThumbnailImage).isDisplayed());
        user.attemptsTo(Ensure.that(VideosThumbnailButton).isDisplayed());
        user.attemptsTo(Ensure.that(VideosCardTitle).isDisplayed());
    }

    @And("I verify videos card title should display with {int} dots at the end of the title")
    public void iVerifyVideosCardTitleShouldDisplayInLinesWithDotsAtTheEndOfTheTitle(int arg1) {
        String  VideoTitleActual = Serenity.getDriver().findElement(By.xpath(("(//div[contains(@id,'home-videos')])[1]/div/div/div/div"))).getText();
        if(VideoTitleActual.length()>70) {
            user.attemptsTo(Ensure.that(VideoTitleActual).contains("..."));
        }
    }

    @And("I verify Health Champion card title should display with {int} dots at the end of the title")
    public void iVerifyHealthChampionCardTitleShouldDisplayInLinesWithDotsAtTheEndOfTheTitle(int arg1) {
        String  HealthChampionTitleActual = Serenity.getDriver().findElement(By.xpath(("(//div[contains(@id,'home-wellness-programmes')])[4]/div/div/div/div[2]"))).getText();
        if(HealthChampionTitleActual.length()>70) {
            user.attemptsTo(Ensure.that(HealthChampionTitleActual).contains("..."));
        }
    }

    @When("I click on the  view all in videos section")
    public void iClickOnTheViewAllInVideosSection() {
        user.attemptsTo(ClickOn.videosViewAll());
    }

    @Then("Verify the latest summit section should display below the web stories section")
    public void verifyTheLatestSummitSectionShouldDisplayBelowTheWebStoriesSection() {
        user.attemptsTo(Ensure.that(SummitSectionWithReferenceToWebStories).isDisplayed());
    }

    @Then("Verify the Magazine section should display below the Carousel section")
    public void verifyTheMagazineSectionShouldDisplayBelowTheCarouselSection() {
        user.attemptsTo(Ensure.that(MagazineSectionWithReferenceToBanner).isDisplayed());
    }

    @Then("Verify the Health Champions section should display below the Quiz section")
    public void verifyTheHealthChampionsSectionShouldDisplayBelowTheQuizSection() {
        user.attemptsTo(Ensure.that(HealthChampionsSectionWithReferenceToQuiz).isDisplayed());
    }

    @Then("Verify the Ask an Expert section should be displayed below the editors’ pick section and next to the Magazine section")
    public void verifyTheAskAnExpertSectionShouldBeDisplayedBelowTheEditorsPickSectionAndNextToTheMagazineSection() {
        user.attemptsTo(Ensure.that(AskanExpertSectionWithReferenceToMagazine).isDisplayed());
    }

    @Then("Verify the Share your story button should  display next to the Are You a Health Champion? text")
    public void verifyTheShareYourStoryButtonShouldDisplayNextToTheAreYouAHealthChampionText() {
        user.attemptsTo(Ensure.that(ShareYourStoryWithReferenceToHealthChampion).isDisplayed());
    }

    @When("I click on the  view all in Health Champions section")
    public void iClickOnTheViewAllInHealthChampionsSection() {
        user.attemptsTo(ClickOn.healthChampionsViewAll());
    }

    @Then("I see user should be redirected to the Health Champions listing page")
    public void iSeeUserShouldBeRedirectedToTheHealthChampionsListingPage() throws InterruptedException {
        Thread.sleep(30000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/health-champions"));
    }

    @Then("I see user should be redirected to the Health Champions page")
    public void iSeeUserShouldBeRedirectedToTheHealthChampionsPage() throws InterruptedException {
        Thread.sleep(30000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).isNotEmpty());
    }

    @Then("I see the {int} card displayed in the Health Champions section")
    public void iSeeTheCardDisplayedInTheHealthChampionsSection(Integer DefaultTilesNo) throws InterruptedException {
        user.attemptsTo(Ensure.that(HealthChampionTiles.size()).isEqualTo(DefaultTilesNo));
    }

    @When("I click on the Health Champions card")
    public void iClickOnTheHealthChampionsCard() {
        Serenity.getDriver().findElement(By.xpath("//h6[text()='Health Champion']/../following-sibling::*//div[contains(@id,'home-wellness-programmes')]")).click();
    }

    @Then("I verify title thumbnail image with button for Health Champions present with Category and name")
    public void iVerifyTitleThumbnailImageWithHealthChampionsNameAndButton() {
       // ,category name, content type ,   and "View All" options
        user.attemptsTo(Ensure.that(HealthChampionsThumbnailImage).isDisplayed());
        user.attemptsTo(Ensure.that(HealthChampionsThumbnailButton).isDisplayed());
        user.attemptsTo(Ensure.that(HealthChampionsCardTitle).isDisplayed());
        user.attemptsTo(Ensure.that(HealthChampionsCategoryTitle).isDisplayed());
    }

    @Then("user Clicks on share your story button")
    public void userClicksOnShareYourStoryButton(){
        user.attemptsTo(ClickOn.ShareYourStory());
}

    @Then("Verify share your story form is displayed")
    public void verifyShareYourStoryFormIsDisplayed() throws InterruptedException {
        Thread.sleep(30000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("health-champions/upload"));
    }

    @Then("Verify the summit section has {string} tab")
    public void verifyTheSummitSectionHasUpcomingSummitsTab(String tabValue) {
        user.attemptsTo(Ensure.that(SummitTabs.of(tabValue)).isDisplayed());
    }

    @Then("I see the Past summit displayed with summits thumbnail image")
    public void iSeeThePastSummitDisplayedWithSummitsThumbnailImage() {
        user.attemptsTo(Ensure.that(SummitThumbnailImage).isDisplayed());
    }

    @Then("I see the title of the summit")
    public void iSeeTheTitleOfTheSummit() {
        user.attemptsTo(Ensure.that(SummitTitle).isDisplayed());
    }

    @Then("I see the photo gallery related to specific summit")
    public void iSeeThePhotoGalleryRelatedToSpecificSummit() {
        user.attemptsTo(Ensure.that(ViewPhotoGallery).isDisplayed());
    }

    @When("I click on the photo gallery on a specific summit")
    public void iClickOnThePhotoGalleryOnASpecificSummit() {
        user.attemptsTo(ClickOn.viewPhotoGallery());
    }

    @Then("I see summit card redirected to the summits home page")
    public void iSeeSummitCardRedirectedToTheSummitsHomePage() throws InterruptedException {
        Thread.sleep(60000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("all-summit-gallery"));
    }

    @Then("I see summit card redirected to the upcoming summits home page")
    public void iSeeSummitCardRedirectedToTheUpcomingSummitsHomePage() throws InterruptedException {
        Thread.sleep(60000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("wellness_summit"));
    }

    @Then("I see the Upcoming Summits tab is highlighted by default")
    public void iSeeTheUpcomingSummitsTabIsHighlightedByDefault() {
        String styleActualValue=Serenity.getDriver().findElement(By.xpath("//span[contains(@class,'Tabs-indicator')]")).getAttribute("style");
        String styleExpectedValue = "left: 0px; width:";
        user.attemptsTo(Ensure.that(styleActualValue).contains(styleExpectedValue));
    }

    @Then("I see the short description for the summit")
    public void iSeeTheShortDescriptionForTheSummit()  {
        user.attemptsTo(Ensure.that(SummitShortDescription).isDisplayed());
    }

    @Then("I see the date displayed in the Month date format with Date label")
    public void iSeeTheDateDisplayedInTheMonthDateFormatWithDateLabel() {
        user.attemptsTo(Ensure.that(SummitDateField).isDisplayed());
        String SummitDateFieldValue=Serenity.getDriver().findElement(By.xpath("//div[contains(text(),'Date')]/following-sibling::div")).getText();
        user.attemptsTo(Ensure.that(isValidMonthDate(SummitDateFieldValue)).isTrue());
    }

    @Then("I see the Time in the time {string} with {string} format")
    public void iSeeTheTimeInTheWithFormat(String arg0, String arg1) {
        user.attemptsTo(Ensure.that(SummitTimeField).isDisplayed());
        String SummitTimeFieldValue=Serenity.getDriver().findElement(By.xpath("//div[contains(text(),'Time (IST)')]/following-sibling::div")).getText();
        user.attemptsTo(Ensure.that(SummitTimeFieldValue.contains(arg0)).isTrue());
    }

    @Then("I see the location of the Summit displayed  with {string} label")
    public void iSeeTheLocationOfTheSummitDisplayedWithLabel(String arg0) {
        user.attemptsTo(Ensure.that(SummitLocationField).isDisplayed());
    }

    @Then("I click on {string} tab")
    public void iClickOnPastSummitsTab(String tabValue) {
        user.attemptsTo(ClickOn.summitTabs(tabValue));
    }

    @When("I click on the Summit under Upcoming summits section")
    public void iClickOnTheSummitUnderUpcomingSummitsSection() {
        user.attemptsTo(ClickOn.summitShortDescription());
    }

    @Then("I see the {string} queries card")
    public void iSeeTheQueriesCard(String arg0) {
        user.attemptsTo(Ensure.that(AskAnExpertQueryCard).isDisplayed());
    }

    @Then("I see the response with doctors name")
    public void iSeeTheResponseWithDoctorsName() {
        user.attemptsTo(Ensure.that(DoctornameInAskAnExpertQueryCard).isDisplayed());

    }

    @Then("I see the response with doctors profile pic")
    public void iSeeTheResponseWithDoctorsProfilePic() {
        user.attemptsTo(Ensure.that(DoctorProfilePicInAskAnExpertQueryCard).isDisplayed());
    }

    @When("I clicked on any web story")
    public void iClickedOnAnyWebStory() {
        user.attemptsTo(ClickOn.theFirstWebStory());
    }

    @Then("I redirected to the specific web story details screen in a new tab")
    public void iRedirectedToTheSpecificWebStoryDetailsScreenInANewTab() throws InterruptedException {
        Thread.sleep(10000);
        CommonUtils.switchTab();
        Thread.sleep(10000);
        String ActualPageURL= Serenity.getDriver().getCurrentUrl();
        user.attemptsTo(Ensure.that(ActualPageURL).contains("/web-stories"));
    }

    @Then("Verify  the Ask an Expert section should be displayed with {int} cards")
    public void verifyTheAskAnExpertSectionShouldBeDisplayedWithCards(int DefaultTilesNo) {
        user.attemptsTo(Ensure.that(askAnExpertCards.size()).isEqualTo(DefaultTilesNo));
    }

    @Then("I see user should be redirected to the Ask An Expert response page")
    public void iSeeUserShouldBeRedirectedToTheAskAnExpertResponsePage() throws InterruptedException {
        Thread.sleep(5000);
        String ExpectedPageTitle="Happiest Health - Responses";
        String ActualPageTitle= Serenity.getDriver().getTitle();
        user.attemptsTo(Ensure.that(ActualPageTitle).isEqualTo(ExpectedPageTitle));

    }

    @When("I click on the View All option")
    public void iClickOnTheViewAllOption() {
        user.attemptsTo(ClickOn.askAnExpertViewAll());

    }

    @Then("I see user should be redirected to the health queries answered by doctors")
    public void iSeeUserShouldBeRedirectedToTheHealthQueriesAnsweredByDoctors() {

        String ExpectedPageTitle="Ask an Expert – your health queries answered by doctors";
        String ActualPageTitle= Serenity.getDriver().getTitle();
        user.attemptsTo(Ensure.that(ActualPageTitle).isEqualTo(ExpectedPageTitle));

    }

    @When("I click on the Particular Ask An Expert First Card")
    public void iClickOnTheParticularAskAnExpertFirstCard() {

        user.attemptsTo(ClickOn.clickonaskanexpertFirstcard());

    }

    @When("I click on the Particular Ask An Expert second Card")
    public void iClickOnTheParticularAskAnExpertSecondCard() {

        user.attemptsTo(ClickOn.clickonaskanexpertSecondcard());
    }

    @When("I navigate back to the home page")
    public void iNavigateBackToTheHomePage() {
        user.wasAbleTo(NavigateTo.theHHEvolutionPage());
    }

    @Then("I see the response with specialty")
    public void iSeeTheResponseWithSpecialty() {
        user.attemptsTo(Ensure.that(SpecialtyInAskAnExpertQueryCard).isDisplayed());
    }

    @Then("Verify ads are shown in evolution page")
    public void verifyAdsAreShownInEvolutionPage() {
        user.attemptsTo(Ensure.that(GoogleAds).isDisplayed());
    }

    @And("Verify magazine slides are displayed")
    public void verifyMagazineSlidesAreDisplayed() {
        user.attemptsTo(Ensure.that(MagazineSlide).isDisplayed());
    }

    @And("Verify Health Summit Breadcrumb is displayed")
    public void verifyHealthSummitBreadcrumbIsDisplayed() {
        user.attemptsTo(Ensure.that(HealthSummitBreadcrumb).isDisplayed());
    }

    @Then("Verify carrousel is available")
    public void verifyCarrouselIsAvailable() {
        Ensure.enableSoftAssertions();
        user.attemptsTo(Ensure.that(CarouselSlide).isDisplayed());
        Ensure.reportSoftAssertions();

    }

    @When("I click on the Podcast link in sub menu")
    public void iClickOnThePodcastLinkInSubMenu() {
        user.attemptsTo(ClickOn.PodcastLink());
    }

    @Then("I verify {int} podcast are loaded")
    public void iVerifyPodcastAreLoadedByDefault(int expectedPodcastTiles) {
        List<WebElement> podcastlist=Serenity.getDriver().findElements(By.xpath("//div[contains(@class,'list-card')]"));
        user.attemptsTo(Ensure.that(podcastlist.size()).isEqualTo(expectedPodcastTiles));
    }
}
