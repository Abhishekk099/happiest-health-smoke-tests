package HHPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class HHEvolutionPage extends PageObject {
    public static Target DiagnosticsInMenu = Target.the("Diagnostics In Menu").locatedBy
            ("#main-menu-item-Diagnostics");

    public static Target HomePageTiles = Target.the("{0} In Home Page Tiles").locatedBy
            ("//h6[text()='{0}']");


    //public static Target WellnessProgrammesTiles = Target.the("HHLogo").locatedBy ("//h6[text()='Wellness Programmes']/../following-sibling::*//div[contains(@id,'home-wellness-programmes')]");


    public static Target WellnessProgrammesViewAll = Target.the("WellnessProgrammesViewAll").locatedBy
            ("//a[@id='home-wellness-programmes-view-all']/p");
    public static Target HealthChampionsViewAll = Target.the("HealthChampionsViewAll").locatedBy
            ("//a[@id='home-health-champions-view-all']/p");

    public static Target VideosViewAll = Target.the("WellnessProgrammesViewAll").locatedBy
            ("//a[@id='home-videos-view-all']/p");
    public static Target WellnessProgrammesThumbnailImage = Target.the("WellnessProgrammesThumbnailImage").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[1]/div/img");
    public static Target PodcastThumbnailImage = Target.the("PodcastThumbnailImage").locatedBy
            ("(//div[contains(@id,'home-podcasts')])[1]/div/img");
    public static Target HealthChampionsThumbnailImage = Target.the("HealthChampionsThumbnailImage").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[4]/div/img");
    public static Target VideosThumbnailImage = Target.the("VideosThumbnailImage").locatedBy
            ("(//div[contains(@id,'home-videos')])[1]/div/img");

    public static Target SearchIconWithReferenceToProfileIcon = Target.the("SearchIconWithReferenceToProfileIcon").locatedBy
            ("//li[@id='profile-happiest-health']/preceding::li[@id='search-happiest-health']");

    public static Target SummitSectionWithReferenceToWebStories = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//h6[text()='Web Stories']/../../following-sibling::*//h6[text()='Health Summits']");

    public static Target MagazineSectionWithReferenceToBanner = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("(//div[contains(@class,'carousal-slide')])[2]/following::*//h6[text()='Magazine']");

    public static Target HealthChampionsSectionWithReferenceToQuiz = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//h6[text()='Quiz']/..//../../following::*//h6[text()='Health Champion']");

    public static Target AskanExpertSectionWithReferenceToMagazine = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//h6[text()='Magazine']/../../following-sibling::*//h6[text()='Ask an Expert']");
    public static Target ShareYourStoryWithReferenceToHealthChampion = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//h6[text()='Are you a Health Champion?']/../../following-sibling::*//a[text()='Share Your Story']");


    public static Target ProfileIcon = Target.the("Profile Icon").locatedBy
            ("//li[@id='profile-happiest-health']");

    public static Target LanguageIconWithReferenceToSearchIcon = Target.the("SearchIconWithReferenceToNotificationIcon").locatedBy
            ("//li[@id='search-happiest-health']/preceding::li[@id='language-switch']");
    public static Target NotificationIconIconWithReferenceProfileIcon = Target.the("Notification Icon With Reference Profile Icon").locatedBy
            ("//li[@id='profile-happiest-health']/preceding::li[@id='notification-happiest-health']");

    public static Target NotificationIcon = Target.the("SearchIconWithReferenceToNotificationIcon").locatedBy
            ("//li[@id='notification-happiest-health']");
    public static Target WellnessProgrammesThumbnailButton = Target.the("WellnessProgrammesThumbnailImage").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[1]/div/button");
    public static Target HealthChampionsThumbnailButton = Target.the("HealthChampionsThumbnailButton").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[4]/div/button");
    public static Target HealthChampionsCardTitle = Target.the("HealthChampionsCardTitle").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[4]/div/div/div/div[2]");
    public static Target HealthChampionsCategoryTitle = Target.the("HealthChampionsCatagoryTitle").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[4]/div/div/div/div[1]");
    public static Target PodcastThumbnailButton = Target.the("PodcastThumbnailButton").locatedBy
            ("(//div[contains(@id,'home-podcasts')])[1]/div/button");
    public static Target VideosThumbnailButton = Target.the("VideosThumbnailButton").locatedBy
            ("(//div[contains(@id,'home-videos')])[1]/div/button");
    public static Target WellnessProgrammesCardTitle = Target.the("WellnessProgrammesCardTitle").locatedBy
            ("(//div[contains(@id,'home-wellness-programmes')])[1]/div/div/div/div");
    public static Target PodcastCardTitle = Target.the("PodcastCardTitle").locatedBy
            ("(//div[contains(@id,'home-podcasts')])[1]/div/div/div/div");
    public static Target VideosCardTitle = Target.the("VideosCardTitle").locatedBy
            ("(//div[contains(@id,'home-videos')])[1]/div/div/div/div");



    public static Target SummitTabs = Target.the("{0} Summit Tab").locatedBy
            ("//button[text()='{0}']");
    public static Target SummitThumbnailImage = Target.the("Summit Thumbnail Image").locatedBy
            ("(//div[contains(@id,'home-summits')])[1]/div/img");
    public static Target SummitShortDescription = Target.the("Summit Short Description").locatedBy
            ("//div[contains(@id,'home-summits')]//div[contains(@class,'description-class')]");

    public static Target SummitDateField = Target.the("Summit Date Field").locatedBy
            ("//div[contains(@id,'home-summits')]/.././following-sibling::*//div[contains(text(),'Date')]");

    public static Target SummitTimeField = Target.the("Summit Time Field").locatedBy
            ("//div[contains(@id,'home-summits')]/.././following-sibling::*//div[contains(text(),'Time (IST)')]");

    public static Target SummitLocationField = Target.the("Summit Location Field").locatedBy
            ("//div[contains(@id,'home-summits')]/.././following-sibling::*//div[contains(text(),'Location')]");

    public static Target AskAnExpertQueryCard = Target.the("Ask An Expert Query Card").locatedBy
            ("(//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[1]");

    public static Target DoctornameInAskAnExpertQueryCard = Target.the("Ask An Expert Query Card Doctors name").locatedBy
            ("((//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[1]/div//div)[10]");

    public static Target SpecialtyInAskAnExpertQueryCard = Target.the("Ask An Expert Query Card Doctors Specialty").locatedBy
            ("((//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[1]/div//div)[11]");

    public static Target DoctorProfilePicInAskAnExpertQueryCard = Target.the("Ask An Expert Query Card Profile pic").locatedBy
            ("(//h6[text()='Ask an Expert']/../following-sibling::div/a/div)[1]/div//img");

    public static Target FirstWebStory = Target.the("First Web Story").locatedBy
            ("(//h6[text()='Web Stories']/../following-sibling::*//a[contains(@href,'web-stories')])[1]");

    public static Target SummitTitle = Target.the("Summit Title").locatedBy
            ("(//div[contains(@id,'home-summits')])[1]//div[contains(@class,'title-class')]");

    public static Target ViewPhotoGallery = Target.the("View Photo Gallery").locatedBy
            ("(//div[contains(@id,'home-summits')])[1]//div[contains(@class,'title-class')]/following-sibling::a/div");

    public static List<WebElement> WellnessProgrammesTiles = Serenity.getDriver().findElements(By.xpath("//h6[text()='Corporate Wellness']/../following-sibling::*//div[contains(@id,'home-wellness-programmes')]"));

    public static List<WebElement> PodcastTiles = Serenity.getDriver().findElements(By.xpath("//h6[text()='Podcasts']/../following-sibling::*//div[contains(@id,'home-podcasts')]"));

    public static List<WebElement> VideosTiles = Serenity.getDriver().findElements(By.xpath("//h6[text()='Videos']/../following-sibling::*//div[contains(@id,'home-videos')]"));

    public static List<WebElement> HealthChampionTiles = Serenity.getDriver().findElements(By.xpath("//h6[text()='Health Champion']/../following-sibling::*//div[contains(@id,'home-wellness-programmes')]"));

    public static List<WebElement> primaryNavBarItems = Serenity.getDriver().findElements(By.xpath("(//nav)[1]//span"));
    public static String primaryNavBarItemsXpath = "(//nav)[1]//span";

    public static String secondaryNavBarItemsXpath = "(//nav)[2]//p";

    public static List<WebElement> secondaryNavBarItems = Serenity.getDriver().findElements(By.xpath("(//nav)[2]//p"));

    public static Target secondaryNavBar = Target.the("Secondary nav bar").locatedBy("//div[contains(@class,'sec-bar-active')]");

    public static Target searchIcon = Target.the("Search icon").located(By.id("search-happiest-health"));

    public static Target searchInputField = Target.the("Search input field").located(By.id("search-input-field"));

//    public static List<WebElement> articleLinks = Serenity.getDriver().findElements(By.xpath("//div[contains(@class,'type-articles')]//h1[@class='elementor-heading-title elementor-size-default']/a"));

    public static List<WebElement> searchResultsContentExcerpt = Serenity.getDriver().findElements(By.xpath("//div[@id='search_results']//div[contains(@class,'elementor-widget-theme-post-excerpt')]/div"));
    public static List<WebElement> searchResultsContentTitles = Serenity.getDriver().findElements(By.xpath("//div[@id='search_results']//div[contains(@class,'elementor-widget-theme-post-title')]//h1/a"));
    public static List<WebElement> searchResultsContentImages = Serenity.getDriver().findElements(By.xpath("//div[@id='search_results']//div[contains(@class,'elementor-widget-theme-post-featured-image')]//a/img"));

    public static List<WebElement> getSearchResultsContentLinks = Serenity.getDriver().findElements(By.xpath("//div[@id='search_results']//div[contains(@class,'elementor-widget-theme-post-title')]//h1/a"));
    public static List<WebElement> MyStoryList = Serenity.getDriver().findElements(By.xpath("//*[text()='My Story']/following::div[@class='slick-list']//div[@class='slick-slide' or @class='slick-slide slick-active slick-center slick-current']"));
    public static String MyStoryListXpath = "//*[text()='My Story']/following::div[@class='slick-list']//div[@class='slick-slide' or @class='slick-slide slick-active slick-center slick-current']";
    public static List<WebElement> FooterLinks = Serenity.getDriver().findElements(By.xpath("//ul[@class='MuiList-root MuiList-padding mui-1hgkieg']/li/*"));
    public static Target footerLink = Target.the("{0} footer link").locatedBy("//ul/li[contains(@id,'footer-quick-link')]/*[text()='{0}']");
    public static String footerLinksXpath = "//ul[@class='MuiList-root MuiList-padding mui-1hgkieg']/li/*";

    public static String breadcrumbSignXpath = "//*[contains(@id,'arrow-back-ios-new-rounded') or contains(@class,'fas fa-angle-right') or contains(@class,'fas fa-chevron-right') or contains(@class,'MuiBreadcrumbs-separator')]";
    public static Target contentViewAll = Target.the("{0} view all").locatedBy("//h6[text()=\"{0}\"]/following::p[normalize-space(text())='View All'][1]");
    public static Target primaryNavBarTitle = Target.the("{0} icon").locatedBy("//nav//li[contains(@id,'{0}')]");

    public static Target MyStoryDescription = Target.the("My Story description").locatedBy("//h6[text()='My Story']/following::p[contains(@class,'carousal-description')]");
    public static Target MyStoryReadMore = Target.the("My Story read more").located(By.id("home-my-story-more"));
    public static WebElement MyStoryDesc = Serenity.getDriver().findElement(By.xpath("//h6[text()='My Story']/following::p[contains(@class,'carousal-description')]"));
    public static WebElement MyStoryTitle = Serenity.getDriver().findElement(By.xpath("//h6[text()='My Story']/following::h6[contains(@class,'carousal-title')]"));
    public static WebElement MyStoryActiveImage = Serenity.getDriver().findElement(By.xpath("//div[@class='slick-slide slick-active slick-center slick-current']//a//img"));
    public static String MyStoryDescXpath = "//h6[text()='My Story']/following::p[contains(@class,'carousal-description')]";
    public static String MyStoryTitleXpath = "//h6[text()='My Story']/following::h6[contains(@class,'carousal-title')]";
    public static String MyStoryActiveImageXpath = "//div[@class='slick-slide slick-active slick-center slick-current']//a//img";
    public static List<WebElement> WebStoryList = Serenity.getDriver().findElements(By.xpath("//h6[text()='Web Stories']/following::div[@class='MuiGrid-root mui-rfnosa']"));
    public static String webStoryListXpath = "//h6[text()='Web Stories']/following::div[@class='MuiGrid-root mui-rfnosa']";
    public static Target ReadTodayHealthzine = Target.the("Read today's healthzine").locatedBy("//span[@id='todays-newsletter']/following-sibling::span");
    public static List<WebElement> socialMediaFooterLinks = Serenity.getDriver().findElements(By.xpath("//ul[@class='MuiList-root MuiList-padding mui-aeicvb']/li/a"));
    public static String socialMediaFooterLinksXpath = "//ul/li[contains(@id,'footer-social-link')]/a";
    public static Target languageSwitch = Target.the("Language Switch").locatedBy("//li[@id='language-switch']/div");
    public static List<WebElement> languages = Serenity.getDriver().findElements(By.xpath("//*[@id='language-switch-modal-title']/following::button"));
    public static String languagesXpath = "//*[@id='language-switch-modal-title']/following::button";
    public static Target chatbot = Target.the("Chatbot icon").located(By.xpath("(//img[@id='Boticon'])[2]"));
    public static Target firstMyStoryImage = Target.the("My Story first image").locatedBy("//div[@class='slick-slide slick-active slick-center slick-current']//a[@id='home-my-story-image']//img");
    public static WebElement firstMyStoryImageElement = Serenity.getDriver().findElement(By.xpath("//div[@class='slick-slide slick-active slick-center slick-current']//a[@id='home-my-story-image']//img"));
    public static String firstMyStoryImageElementXpath = "//div[@class='slick-slide slick-active slick-center slick-current']//a[@id='home-my-story-image']//img";

    public static Target PollSection = Target.the("Poll section").locatedBy("//h6[text()='Polls']/following::div[@id='survey-response-card']");
    public static Target QuizSection = Target.the("Quiz section").locatedBy("//h6[text()='Quiz']/following::div[@id='survey-response-card'][1]");

    public static Target WebStoriesSection = Target.the("Web Stories section").locatedBy("//h6[text()='Web Stories']/following::div[2]");

    public static String EditorsPicksListXpath = "//h6[text()=\"Editor's Pick\"]/following::div[2]/a";
    public static Target MagazineImage = Target.the("Magazine image").locatedBy("//div[@id='home-magazine']//img");
    public static Target MagazineTitle = Target.the("Magazine Title").locatedBy("//div[@id='home-magazine']//h3");
    public static Target MagazineDot = Target.the("Magazine dot beside the title").locatedBy("(//div[@id='home-magazine']//p)[1]");
    public static Target MagazineDate = Target.the("Magazine date").locatedBy("(//div[@id='home-magazine']//p)[2]");
    public static Target MagazineCheckoutMessage = Target.the("Magazine checkout Message").locatedBy("(//div[@class='woocommerce-message'])[1]");
    public static Target MagazineCheckoutViewCart = Target.the("View Cart").locatedBy("(//div[@class='woocommerce-message']/a)[1]");
    public static Target PollQuestion = Target.the("Poll Question").located(By.id("question"));
    public static List<WebElement> PollRadioButtons = Serenity.getDriver().findElements(By.xpath("//input[contains(@id,'poll-option-radio')]"));
    public static String PollRadioButtonsXpath = "//input[contains(@id,'poll-option-radio')]";
    public static List<WebElement> PollOptions = Serenity.getDriver().findElements(By.xpath("//div[contains(@id,'option-text')]"));
    public static String PollOptionsXpath = "//div[contains(@id,'option-text')]";
    public static Target PollVoteButton = Target.the("Poll vote button").locatedBy("//button[text()='Vote']");
    public static String PoleProgressBarsXpath = "//span[contains(@class,'Progress-bar')]";
    public static String PoleOptionsVotePercentXpath = "//span[contains(@class,'Progress-bar')]/following::p[1]";
    public static Target PollImage = Target.the("Poll image").locatedBy("//h6[text()='Polls']/following::img[@id='survey-response-card-image']");
    public static String WebStorySvgListXpath = "//h6[text()='Web Stories']/following::div[@class='MuiGrid-root mui-rfnosa']//*[name()='svg']";
    public static Target SummitUnderUpcomingSummits = Target.the("Summit under upcoming summits").locatedBy("//button[text()='Upcoming Summits']/following::div[contains(@id,'home-summits')]");
    public static Target TitleOfSummitUnderUpcomingSummits = Target.the(" Title of Summit under upcoming summits").locatedBy("//button[text()='Upcoming Summits']/following::div[contains(@id,'home-summits')]//div[contains(@class,'title-class')]");
    public static Target Knowledge = Target.the("Knowledge").located(By.id("main-menu-item-Knowledge"));

    public static Target Podcast = Target.the("Podcast in sub menu").locatedBy
            ("//p[text()='Podcasts']");


}
