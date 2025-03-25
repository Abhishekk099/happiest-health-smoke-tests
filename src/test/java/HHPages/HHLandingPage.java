package HHPages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("page:HappiestHealth")
public class HHLandingPage extends PageObject {
    public static Target HHLogo = Target.the("HHLogo").locatedBy
            ("//div[contains(@class,'header-section')]/header/*/*/*/a");
    public static Target TabsInMenu = Target.the("{0} In Menu").locatedBy
            ("//span[text()='{0}']");
    public static Target TabsInMenuOP = Target.the("{0} In Menu").locatedBy
            ("//nav[@class=\"less-than-six MuiBox-root mui-1tl12ar\"]");
    //    //a[text()='{0}']/../../../../../../../../../..
    public static Target EditorsPicksSection = Target.the("Editor's Pick section").locatedBy("//h6[text()=\"Editor's Pick\"]/following::div[2]");

    public static Target LoginBtn = Target.the(" item list").locatedBy("#aae_login_btn");
    public static Target LinkInsecondaryMenuBar=  Target.the("{0} Link").
            locatedBy("//p[@id='title' and text()=\"{0}\"]");
    public static Target LinkPrimaryMenuBar=  Target.the("{0} Link").
            locatedBy("(//span[contains(text(),'{0}')])[1]");

    public static Target LinkInPrimaryMenuBar = Target.the("{0} link ").locatedBy("//nav[@class='MuiBox-root mui-16d9tbi']//span[text()='{0}']");
    public static Target MagazineSlide = Target.the("MagazineSlide ").locatedBy("//div[@class='slider-wrapper axis-horizontal']");
    public static Target CarouselSlide = Target.the("Carousel Slide ").locatedBy("//div[@class=\"slick-slider slick-initialized\"]");
    //    (//div[contains(@class,'elementor-widget-loop-carousel')])[1]
    public static Target HealthSummitBreadcrumb = Target.the("HealthSummitBreadcrumb ").locatedBy("(//span[text()='Health Summits'])[2]");
    @FindBy(css = "a[href='/discussions']")
    private static WebElementFacade docTalesViewAll;

    public static WebElementFacade getDocTalesViewAll(){
        return docTalesViewAll;
    }
	 public static Target LinkWithTextInMenuBar = Target.the("{0} Link").
            locatedBy("(//a[text()='{0}'])[1]");

    public static Target LinkWithLinkName = Target.the("{0} Link").locatedBy("//a[normalize-space(text())='{0}']");

    public static Target LanguageDropDown = Target.the("LanguageDropDown").locatedBy
            ("//li[@id='language-switch']");
    public static Target HindiInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[2]");
    public static Target BanglaInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[3]");
    public static Target KanadaInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[4]");
    public static Target TeluguInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[5]");
    public static Target MalayalamInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[6]");
    public static Target GujratiInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[7]");
    public static Target MarathiInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[8]");
    public static Target TamilInLanguageDropDown = Target.the("HindiInLanguageDropDown").locatedBy
            ("//h2[@id='language-switch-modal-title']/following::div/div[9]");
    public static Target PodcastList = Target.the("PodcastList").locatedBy
            ("//div[contains(@class,'list-card')]");
}