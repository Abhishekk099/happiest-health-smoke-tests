package HHPages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class DiagnosticPage extends PageObject {


    public static Target DignosticLabelinPrimarymenu = Target.the("Header in Diagnostic Page").
            locatedBy("//span[text()='Diagnostics']");

    public static Target HeaderinDiagnosticPage = Target.the("Header in Diagnostic Page").
            locatedBy("//h1[text()='Unlock Health For You And Your happy Family']");

    public static Target DiagnosticsSearchBox = Target.the("Diagnostics Search Box").
            locatedBy("//input[@placeholder='Search']");

    public static Target DiagnosticsSearchBoxBackButton = Target.the("Diagnostics Search Box back button").
            locatedBy("(//input[@placeholder='Search']/../../../../div)[1]");

    public static Target SearchByTestsOrCheckups = Target.the("Search by tests or checkups").
            locatedBy("//p[text()='Search by tests or checkups']");

    public static Target NoResultErrorMessage = Target.the("No Result Error Message").
            locatedBy("//p[text()='0 Results Found']");

    public static Target TestIcon = Target.the("Test Icon").
            locatedBy("//span[text()='Test']");

    public static Target CheckupsIcon = Target.the("Checkups Icon").
            locatedBy("//span[text()='Smart Health Check-up']");

    public static Target TitleOfTheHeroSection = Target.the("Title of the hero section in Diagnostic Page").
            locatedBy("//h6[text()='With Our Smart Diagnostic Services And Personalized Health Insights']/preceding-sibling::h1");


    public static Target DescriptionOfTheHeroSection = Target.the("Description of the hero section in Diagnostic Page").
            locatedBy("//h1[text()='Unlock Health For You And Your happy Family']/following-sibling::h6");


    public static Target HeroImage = Target.the("Description of the hero section in Diagnostic Page").
            locatedBy("//h1[text()='Unlock Health For You And Your happy Family']/parent::div/parent::div/following-sibling::div/img");


    public static Target TextinSearchBox = Target.the("Search by tests or checkups text in search bar").
            locatedBy("//p[text()='Search by tests or checkups']");

    public static Target SearchIcon = Target.the("Search icon in search bar").
            locatedBy("//p[text()='Search by tests or checkups']/parent::div/div/*[local-name()='svg' ]");

    public static Target DiseaseSpecificSection = Target.the("Disease Specific Packages section").
            locatedBy("//div[text()='Disease Specific Packages']");

    public static Target BodyOrganSection = Target.the("Body Organ Checkups section").
            locatedBy("//div[text()='Body Organ Checkup Packages']");
    public static Target DiagnosticFAQBelowBodyOrganCheckupPackages = Target.the("Diagnostics - FAQ section").
            locatedBy("(//div[text()='Body Organ Checkup Packages']/following::h6)[2]");

    public static Target TestSectionArrow = Target.the("Diagnostics - Test section arrow").
            locatedBy("//a[contains(@href,'bangalore/lab-tests-bangalore')]//*[local-name()='svg' ]");
    public static Target TestSectionLabel = Target.the("Diagnostics - Test section label").
            locatedBy("//a[contains(@href,'bangalore/lab-tests-bangalore')]/span[text()='Explore by Test']");
    public static Target TestSectionImage = Target.the("Diagnostics - Test section Image").
            locatedBy("//a[contains(@href,'bangalore/lab-tests-bangalore')]/figure/img[@alt='Explore by Test']");


    public static Target CheckupSectionArrow = Target.the("Diagnostics - Checkup section arrow").
            locatedBy("//a[contains(@href,'health-checkups?stype=checkups')]//*[local-name()='svg' ]");
    public static Target CheckupSectionLabel = Target.the("Diagnostics - Checkup section label").
            locatedBy("//a[contains(@href,'health-checkups?stype=checkups')]/span[text()='Smart Health Check-up']");

    public static Target CheckupSectionImage = Target.the("Diagnostics - Test section Image").
            locatedBy("//a[contains(@href,'health-checkups?stype=checkups')]/figure/img[@alt='Smart Health Check-up']");
    public static Target GmbSectionArrow = Target.the("Diagnostics - GMB section arrow").
            locatedBy("//a[contains(@href,'gmb?')]//*[local-name()='svg' ]");

    public static Target GMBSectionLabel = Target.the("Diagnostics - GMB section label").
            locatedBy("//a[contains(@href,'gmb?')]/span[text()='GMB Test']");
    public static Target GMBSectionImage = Target.the("Diagnostics - GMB section Image").
            locatedBy(" //a[contains(@href,'gmb?')]/figure/img[@alt='GMB Test']");



    public static Target DiseaseSpecificPackage = Target.the("Disease Specific Packages").
            locatedBy("//div[text()='Disease Specific Packages']");

    public static Target BodyOrganCheckups = Target.the("Disease Specific Packages").
            locatedBy("//div[text()='Body Organ Checkups']");
    public static Target DiagnosticsFAQsection = Target.the("Disease Specific Packages").
            locatedBy("//h6[text()='Diagnostics - FAQ']");

    public static Target BookhomeCollectionlabel = Target.the("Book Home Collection label in diagnostic page").
            locatedBy("//h3[text()='Book Home Collection']");

    public static Target BookhomeCollectionimage = Target.the("Book Home Collection label in diagnostic page").
            locatedBy("//img[@alt='Book Home Collection']");

    public static Target RequestCallBackButton = Target.the("Book Home Collection label in diagnostic page").
            locatedBy("//div/a[contains(text(),'Request a call back')]");


    public static Target Backbuttonimage = Target.the("Book Home Collection label in diagnostic page").
            locatedBy("//a[text()='Back']/parent::div//*[local-name()='path' ]");
    public static Target Backbutton = Target.the("Book Home Collection label in Request Call back form").
            locatedBy("//a[text()='Back']");


    public static Target MobileNoField = Target.the("Mobileno field in diagnostic page in Request Call back form").
            locatedBy("//input[@type='text' and @name='mobile Number']");

    public static Target MobileNoErrorMessage = Target.the("Mobileno error message in Request Call back form").
            locatedBy("    //p[text()='Please enter a valid 10 digit mobile number']");


    public static Target ProceedButton = Target.the("Proceed Button disabled in Request Call back form").
            locatedBy("//button[text()='Proceed']");

    public static Target RequestCallBackText = Target.the("Request CallBack Text displayed in Request Call back form").
            locatedBy("//h3[text()='Request a Call Back']");
    public static Target MobileNolabel = Target.the("Mobileno label displayed in Request Call back form").
            locatedBy("//h5[text()='Enter valid mobile number']");

   /* public static Target ProceedButtonenabled = Target.the("Proceed Button disabled in Request Call back form").
            locatedBy(" //button[@tabindex='0']");*/

    public static Target EmptyMobilenoField = Target.the("Mobile no is empty for non logged user").
            locatedBy("//input[@placeholder='Enter valid mobile number']");

    public static Target BackLabel = Target.the("Back Label is displayed in Request Call back form").
            locatedBy("//a[text()='Back']");

    public static Target javascriptbutton = Target.the("Back Label is displayed in Request Call back form").
            locatedBy("//button[text()='ACCEPT']");


    public static String CheckboxByDefaultforaccept = "//span[text()='I accept the ']/following-sibling::span/a[text()='Privacy Policy']/parent::span/following-sibling::span[text()[normalize-space()='&']]/following-sibling::span/a[text()='Terms Of Use']/parent::span/parent::div/preceding-sibling::div/input[@type='checkbox']";

    public static String CheckboxByDefaultforwhatsApp = "//span[text()='I want to receive the updates through WhatsApp.']/parent::div/preceding-sibling::div/input[@type='checkbox']";


    public static Target EnterOTPText = Target.the("Enter OTP text displayed").
            locatedBy("//h5[text()='Enter OTP']");
    public static Target EnterOTPlaceholder = Target.the("Enter OTP placeholder displayed").
            locatedBy("//input[@placeholder='Enter OTP']");

    public static Target CancelButton = Target.the("Cancel button displayed").
            locatedBy("//button[text()='Cancel']");
    public static Target submitOTP = Target.the("submitOTP button displayed").
            locatedBy("//button[text()='Submit OTP']");
    public static Target ResendOTP = Target.the("Resend OTP hyperlink displayed").
            locatedBy("//span[text()='Resend OTP']");

    public static Target ResendOTPtext = Target.the("Please wait before requesting another OTP text displayed").
            locatedBy("//span[text()='Please wait before requesting another OTP']");

    public static Target Testbreadcrumb = Target.the("Tests breadcrumb displayed").
            locatedBy("//span[text()='Diagnostics']/parent::a/parent::li/following-sibling::li[1]/*[local-name()='svg' ]/parent::li/following-sibling::li/span[text()='tests']");

    public static Target HeroSection = Target.the("Title Description").
            locatedBy("//h1[text()='Turn numbers into actionable insights']/parent::div/h6[text()=' Insights that drive better health outcomes']");

    public static Target SearchBarIcons = Target.the("Search bar icon and text").
            locatedBy("//p[text()='Search by tests or checkups']/parent::div/div/*[local-name()='svg' and contains(@xmlns,'svg')]");

    public static Target Testssection = Target.the("Search bar icon and text").
            locatedBy(" //h6[text()='Tests']");
    public static Target CardDetails = Target.the("{0} text for Card Details").
            locatedBy("//p[text()={0}]");


    public static Target ViewDetailsforFirstCard = Target.the("{0} Link for View details").
            locatedBy("//p[text()={0}]/following-sibling::div[4]/div[3]/div/button[text()='View Details']");
    public static Target ViewDetails = Target.the("Search bar icon and text").
            locatedBy("//button[text()='View Details']");


    public List<WebElement> getListofCardtitle() {
        return getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
    }

    public List<WebElement> getListofReportIcon() {
        return getDriver().findElements(By.xpath("//button[text()='View Details']/parent::div/parent::div/parent::div//*[local-name()='svg']/*[local-name()='path' and contains(@fill,'#000')]"));
    }

    public List<WebElement> getListofCardArrowIcon() {
        return getDriver().findElements(By.xpath("//button[text()='View Details']/span/*[local-name()='svg']/*[local-name()='path' and contains(@fill,'#0060A0')]"));
    }

    public List<WebElement> getListofCardvalue() {
        return getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/span"));
    }

    public List<WebElement> getListofCardDescription() {
        return getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[2]"));
    }

    public List<WebElement> getPopularTestsElement() {
        return getDriver().findElements(By.xpath("//p[contains(@class,'body1 title ')]"));
    }

    public List<WebElement> getSearchResultTestsElement() {
        return getDriver().findElements(By.xpath("//p[contains(text(),'Results Found')]/..//p[contains(@class,'body1 title ')]"));
    }

    public List<WebElement> getDiseaseElement() {
        return getDriver().findElements(By.xpath("//div[@title='Disease Specific Packages']//following-sibling::div/div/div/div"));
    }

    public static Target DiseaseSpecificPackagesViewMoreButton = Target.the("Disease Specific Packages ViewMore Button").locatedBy
            ("//div[@title='Disease Specific Packages']//following-sibling::div//div[text()='View More']");


    public List<WebElement> getOrganElement() {
        return getDriver().findElements(By.xpath("//div[@title='Body Organ Checkup Packages']//following-sibling::div/div/div/div"));
    }
    public static Target BodyOrganCheckupPackagesViewMoreButton = Target.the("Disease Specific Packages ViewMore Button").locatedBy
            ("//div[@title='Body Organ Checkup Packages']//following-sibling::div//div[text()='View More']");

    public static Target HeaderInTestAndPackagesListingPage = Target.the("{0} header in Test And Packages Listing page").
            locatedBy("//h6[contains(text(),'{0}  Specific Tests and Packages')]");

    public static Target CardTitleInTestAndPackagesListingPage = Target.the("Card Title In Test And Packages Listing Page").
            locatedBy("(//p[contains(@class,' title ')])[1]");

    public static Target NoOfTestIncluded = Target.the("No Of Test Included").
            locatedBy("(//p[contains(@class,' sub-title ')]/strong)[1]");

    public static Target PriceOfTest = Target.the("Price Of Test").
            locatedBy("(//div[contains(@class,'price')])[1]");
    public static Target ViewDetailsButton = Target.the("View Details Button").
            locatedBy("(//button[contains(text(),'View Details')])[1]");

    public static Target BuyNowHeader = Target.the("Buy Now Header").
            locatedBy("//h3[text()='Buy Now']");

    public static Target CardDescriptionInTestAndPackagesListingPage = Target.the("Card Description In Test And Packages Listing Page").
            locatedBy("(//p[contains(@class,'sub-title ')])[1]");

    public static Target PriceInTestAndPackagesListingPage = Target.the("Price In Test And Packages Listing Page").
            locatedBy("(//span[contains(@class,'price ')])[1]");

    public static Target BuyNowButton = Target.the("Buy Now Button").
            locatedBy("(//button[contains(@class,'product-card-button')])[3]");

    public static Target AddToCartButton = Target.the("Add To Cart Button").
            locatedBy("(//button[contains(@class,'product-card-button')])[4]");

    public static Target BreadCrumbInTestAndPackagesListingPage = Target.the("BreadCrumb In Test And Packages Listing Page").
            locatedBy("(//nav[contains(@class,'Breadcrumbs')]//span)[2]");

    public static Target DiagnosticBreadCrumbInTestAndPackagesListingPage = Target.the("BreadCrumb In Test And Packages Listing Page").
            locatedBy("(//nav[contains(@class,'Breadcrumbs')]//span)[1]");

/*****/
public static Target CartItem = Target.the("CartItem label").
        locatedBy(" //a[@href='/cart-items']");

    public static Target Cartbreadcrumb = Target.the("CartItem page breadcrumb").
            locatedBy("//span[text()='Diagnostics']/parent::a/parent::li/following-sibling::li//*[local-name()='svg' ]/parent::li/following-sibling::li/span[text()='cart items']");

    public static Target RemoveItem = Target.the("Remove button in the cart page").
            locatedBy("//button[text()='Remove']");

    public static Target NocartItemfound = Target.the("Remove button in the cart page").
            locatedBy(" //p[text()='No cart items found!']");

    public static Target Checkupbreadcrumb = Target.the("Tests breadcrumb displayed").
            locatedBy("//span[text()='Diagnostics']/parent::a/parent::li/following-sibling::li[1]/*[local-name()='svg' ]/parent::li/following-sibling::li/span[text()='checkups']");


    public static Target CheckupDescription = Target.the("CheckupDescription displayed").
            locatedBy("//h1[text()='Comprehensive health check-up ']/following-sibling::h6[text()=' Get a Smart Report for Smarter Decisions']");


    public static Target CheckupTitle = Target.the("CheckupTitle displayed").
            locatedBy("//h1[text()='Comprehensive health check-up ']");




    public static Target CheckupHeroImage = Target.the("CheckupHeroImage displayed").
            locatedBy("//h1[text()='Comprehensive health check-up ']/following-sibling::h6[text()=' Get a Smart Report for Smarter Decisions']/parent::div/parent::div/following-sibling::div/img[contains(@src,'.png')]");


    public static Target SearchbarinCheckups = Target.the("Search box with search icon").
            locatedBy("//p[text()='Search by tests or checkups']/following-sibling::div/*[local-name()='svg']/*[local-name()='path' and contains(@fill,'#0060A0')]");


    public static Target AddtoCartImage = Target.the("Add to cart button image").
            locatedBy(" //button/span/*[local-name()='svg']/*[contains(@fill,'#fff')]");

    public static Target BuyButtoninCheckupdetailspage = Target.the("Buy Now button in CheckupDetails page").
            locatedBy("//button[text()='Buy Now']");

    public static Target AddToCartButtoninCheckupdetailspage = Target.the("AddToCart button in CheckupDetails page").
            locatedBy("  //button[text()='Add to Cart']");

    public static Target Reportwithinhours = Target.the("AddToCart button in CheckupDetails page").
            locatedBy("//li[contains(text(),'Reported within 6 Hours after sample received')]");
    public static Target InhouseProcessing = Target.the("AddToCart button in CheckupDetails page").
            locatedBy("//img[@alt='In-House Processing']/parent::div/following-sibling::p[text()='In-House Processing']");

    public static Target HomeCollection = Target.the("AddToCart button in CheckupDetails page").
            locatedBy(" //img[@alt='Home Collection ']/parent::div/following-sibling::p[text()='Home Collection ']");

    public static Target KnowledgeInsight = Target.the("AddToCart button in CheckupDetails page").
            locatedBy("//img[@alt='Knowledge Insights']/parent::div/following-sibling::p[text()='Knowledge Insights']");

    public static Target TIMERICON = Target.the("Timer Icon").
            locatedBy("//div[contains(@class,'timer-icon')]");

    public List<WebElement> getListofCheckupCardTitle() {
        return getDriver().findElements(By.xpath("//p[text()='Checkups']/parent::div/parent::div/following-sibling::div/p[1]"));
    }

    public List<WebElement> getListofCheckupCardDescription() {
        return getDriver().findElements(By.xpath("//p[text()='Checkups']/parent::div/parent::div/following-sibling::div/p[2]"));
    }

    public List<WebElement> getListofCheckupCardPrice() {
        return getDriver().findElements(By.xpath("//p[text()='Checkups']/parent::div/parent::div/following-sibling::div/div[1]"));
    }

    public List<WebElement> getListofCheckupCardBuyNowButton() {
        return getDriver().findElements(By.xpath("//p[text()='Checkups']/parent::div/parent::div/following-sibling::div/div[2]/button[text()='Buy Now']"));
    }
    public List<WebElement> getListofCheckupCardAddToCartButton() {
        return getDriver().findElements(By.xpath("//p[text()='Checkups']/parent::div/parent::div/following-sibling::div/div[2]/button[text()='Add to Cart']"));
    }

    public List<WebElement> getListofCheckupCardText() {
        return getDriver().findElements(By.xpath("//p[contains(text(),'Reported within 6 Hours after sample received')]/parent::div/div/*[local-name()='svg']/*[local-name()='path' and contains(@fill,'#000')]"));
    }

    public List<WebElement> getListofCheckupCardViewDetails() {
        return getDriver().findElements(By.xpath("//button[text()='View Details']/span/*[local-name()='svg']/*[local-name()='path']"));
    }

    public List<String> getPopularTests(List<WebElement> popularTestsElement) {
        List<String> PopularTests = new ArrayList<String>();
        for(WebElement e: popularTestsElement){
            PopularTests.add(e.getText());
        }
        return PopularTests;
    }

    public int getsizeofElements(List<WebElement> listofWebelements) {
        List<String> listofelements = new ArrayList<String>();
        return listofelements.size();
    }

    public List<String> getTextFromElement(List<WebElement> popularTestsElement) {
        List<String> PopularTests = new ArrayList<String>();
        for(WebElement e: popularTestsElement){
            PopularTests.add(e.getText());
        }
        return PopularTests;
    }

    public static Target DiseaseIcon = Target.the("{0} Disease Icon").locatedBy
            ("//div[text()='{0}']");

    public static Target CartIcon = Target.the("Cart Icon").locatedBy
            ("#cart-happiest-health");

    public static Target ItemSelectedElementInCartPage = Target.the("Item Selected Element In Cart Page").locatedBy
            ("//span[text()='1 Item selected ']");
}





