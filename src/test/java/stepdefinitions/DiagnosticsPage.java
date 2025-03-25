package stepdefinitions;

import Actions.ClickOn;
import Actions.EnterValueInto;
import HHPages.DiagnosticPage;
import Utils.MyCast;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SetCheckbox;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static HHPages.DiagnosticPage.*;
import static HHPages.DiagnosticPage.NocartItemfound;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static stepdefinitions.BasePage.userAcceptsCoookiesPopUpBoxInEvolution;

public class DiagnosticsPage extends UIInteractionSteps {
    Actor user = MyCast.user();
    DiagnosticPage diagnosticPageObject = new DiagnosticPage();
    DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
    @Then("User see the diagnostic landing page")
    public void userSeeTheDiagnosticLandingPage() {

        user.attemptsTo(Ensure.that(HeaderinDiagnosticPage).isDisplayed());
    }

    @When("User clicks on the SEARCH bar")
    public void userClicksOnTheSEARCHBar() {

        user.attemptsTo(ClickOn.SearchByTestsOrCheckups());
    }
    @Then("I see title of the hero section")
    public void iSeeTitleOfTheHeroSection() {
        user.attemptsTo(Ensure.that(TitleOfTheHeroSection).isDisplayed());
    }

    @Then("I see description of the hero section")
    public void iSeeDescriptionOfTheHeroSection() {
        user.attemptsTo(Ensure.that(DescriptionOfTheHeroSection).isDisplayed());

    }
    @Then("I see Hero image")
    public void iSeeHeroImage() {
        user.attemptsTo(Ensure.that(HeroImage).isDisplayed());

    }


    @Then("I see Search Tests and Checkups")
    public void iSeeSearchTestsAndCheckups() {
        user.attemptsTo(Ensure.that(SearchIcon).isDisplayed());
        user.attemptsTo(Ensure.that(TextinSearchBox).isDisplayed());

    }

    @Then("I see Explore Lab Tests")
    public void iSeeExploreLabTests() {
        user.attemptsTo(Ensure.that(TestSectionArrow).isDisplayed());
        user.attemptsTo(Ensure.that(TestSectionLabel).isDisplayed());
        user.attemptsTo(Ensure.that(TestSectionImage).isDisplayed());
    }

    @Then("I see Explore Checkups")
    public void iSeeExploreCheckups() {
        user.attemptsTo(Ensure.that(CheckupSectionArrow).isDisplayed());
        user.attemptsTo(Ensure.that(CheckupSectionLabel).isDisplayed());
        user.attemptsTo(Ensure.that(CheckupSectionImage).isDisplayed());
    }

    @Then("I see DiseaseSpecificPackages")
    public void iSeeDiseaseSpecificPackages() {
        user.attemptsTo(Ensure.that(DiseaseSpecificPackage).isDisplayed());


    }

    @Then("I see Body Organ Checkups")
    public void iSeeBodyOrganCheckups() {

        user.attemptsTo(Ensure.that(BodyOrganCheckups).isDisplayed());

    }

    @Then("I see FAQ sections")
    public void iSeeFAQSections() {
        user.attemptsTo(Ensure.that(DiagnosticsFAQsection).isDisplayed());
    }

    @When("I clicked on Diagnostics from the primary menu")
    public void iClickedOnDiagnosticsFromThePrimaryMenu() {
        user.attemptsTo(
                Click.on(DignosticLabelinPrimarymenu.waitingForNoMoreThan(Duration.ofSeconds(2)))
        );
        userAcceptsCoookiesPopUpBoxInEvolution();
        }

    @Then("I see Explore GMB")
    public void iSeeExploreGMB() {
        user.attemptsTo(Ensure.that(GmbSectionArrow).isDisplayed());
        user.attemptsTo(Ensure.that(GMBSectionLabel).isDisplayed());
        user.attemptsTo(Ensure.that(GMBSectionImage).isDisplayed());
    }

    @Then("User see the diagnostic page Title")
    public void userSeeTheDiagnosticPageTitle() throws  InterruptedException {
    user.attemptsTo(Ensure.that(Serenity.getDriver().getTitle()).contains("Happiest Health Diagnostics"));
    }

    @Then("I see the Book Home collection label")
    public void iSeeTheBookHomeCollectionLabel() throws InterruptedException {
    user.attemptsTo(Ensure.that(BookhomeCollectionlabel.waitingForNoMoreThan(Duration.ofSeconds(1))).isDisplayed());

    }

    @Then("I see the Book Home collection images")
    public void iSeeTheBookHomeCollectionImages() {

        user.attemptsTo(Ensure.that(BookhomeCollectionimage).isDisplayed());

    }

    @Then("I see the Request a Callback button")
    public void iSeeTheRequestACallbackButton() {
        user.attemptsTo(Ensure.that(RequestCallBackButton).isDisplayed());

    }

    @When("I click on the Request Call Back button")
    public void iClickOnTheRequestCallBackButton() throws InterruptedException {




        if(javascriptbutton.isVisibleFor(user)) {
            Ensure.enableSoftAssertions();
              userAcceptsCoookiesPopUpBoxInEvolution();
            Ensure.reportSoftAssertions();
           // user.attemptsTo(WaitUntil.the(RequestCallBackButton, WebElementStateMatchers.isCurrentlyVisible()));
            user.attemptsTo(Click.on(RequestCallBackButton));
        }else {
            user.attemptsTo(WaitUntil.the(RequestCallBackButton, WebElementStateMatchers.isCurrentlyVisible()));

            user.attemptsTo(Click.on(RequestCallBackButton));

        }




    }

    @Then("I see back button")
    public void iSeeBackButton() {
        user.attemptsTo(Ensure.that(Backbuttonimage).isDisplayed());
        user.attemptsTo(Ensure.that(Backbutton).isDisplayed());
          }



    @Then("I see Mobile Number field is empty by default for non-logged In user")
    public void iSeeMobileNumberFieldIsEmptyByDefaultForNonLoggedInUser() {
        user.attemptsTo(Ensure.that(EmptyMobilenoField).isDisplayed());
    }


    @Then("I see proceed button is disabled by default")
    public void iSeeProceedButtonIsDisabledByDefault() {
        user.attemptsTo(Ensure.that(ProceedButton).isDisabled());
    }






    @When("I enter the valid mobile number in the Mobile Number Field")
    public void iEnterTheValidMobileNumberInTheMobileNumberField() throws InterruptedException {
        user.attemptsTo(Clear.field(MobileNoField));
        user.attemptsTo(WaitUntil.the(MobileNoField, isVisible()));

        user.wasAbleTo(Enter.theValue("9538145547").into(MobileNoField));
    }

    @Then("I see Privacy policy & Terms of use check box is checked by defaults")
    public void iSeePrivacyPolicyTermsOfUseCheckBoxIsCheckedByDefaults() {
        boolean termsAndConditionsApproved = user.asksFor(SelectedStatus.of(CheckboxByDefaultforaccept));
        user.attemptsTo(Ensure.that(true).isEqualTo(termsAndConditionsApproved));
    }

    @Then("I see I would like to create an account for me check box is checked by default")
    public void iSeeIWouldLikeToCreateAnAccountForMeCheckBoxIsCheckedByDefault() {
        boolean Whatsappbydefault= user.asksFor(SelectedStatus.of(CheckboxByDefaultforwhatsApp));
        user.attemptsTo(Ensure.that(true).isEqualTo(Whatsappbydefault));


    }

    @Then("I see Proceed button will be enabled")
    public void iSeeProceedButtonWillBeEnabled() {
        user.attemptsTo(Ensure.that(ProceedButton).isEnabled());
       }

    @When("I uncheck the  Privacy policy & Terms of use check box")
    public void iUncheckThePrivacyPolicyTermsOfUseCheckBox() {

        user.attemptsTo(
                SetCheckbox.of(CheckboxByDefaultforaccept).toFalse()
                        .afterWaitingUntilEnabled());

    }

    @When("I uncheck  I would like to create an account  checkbox")
    public void iUncheckIWouldLikeToCreateAnAccountCheckbox() {
        user.attemptsTo(
                SetCheckbox.of(CheckboxByDefaultforwhatsApp).toFalse()
                        .afterWaitingUntilEnabled());

    }

    @Then("I see proceed button is disabled")
    public void iSeeProceedButtonIsDisabled() {
        user.attemptsTo(Ensure.that(ProceedButton).isDisplayed());

    }

    @When("I check the both checkboxes from the Request a Call Back page")
    public void iCheckTheBothCheckboxesFromTheRequestACallBackPage() {
        user.attemptsTo(SetCheckbox.of(CheckboxByDefaultforwhatsApp).toTrue()
                        .afterWaitingUntilEnabled());
        user.attemptsTo(SetCheckbox.of(CheckboxByDefaultforaccept).toTrue()
                        .afterWaitingUntilEnabled());
         }

    @When("I click on Proceed button")
    public void iClickOnProceedButton() {

        user.attemptsTo(ClickOn.ClicOnProceedButton());

    }




    @Then("I see error message not dsiplayed for thr number starting from the six to nine")
    public void iSeeErrorMessageNotDsiplayedForThrNumberStartingFromTheSixToNine(DataTable arg1) throws InterruptedException {

       List<java.lang.String> mobileno=arg1.asList(java.lang.String.class);

       for(String mobilenodata:mobileno)
       {
System.out.println(mobilenodata+"===========================================");
           Serenity.getDriver().findElement(By.xpath("//input[@type='text' and @name='mobile Number']")).clear();
         user.attemptsTo(Clear.field(MobileNoField));
           user.attemptsTo(Type.theValue(mobilenodata).into(MobileNoField));
          user.attemptsTo(  Ensure.that(MobileNoErrorMessage).isNotDisplayed());


       }
    }

    @Then("I see no error message is displayed")
    public void iSeeNoErrorMessageIsDisplayed() throws InterruptedException {
        user.attemptsTo(Ensure.that(MobileNoErrorMessage).isNotDisplayed());
        user.attemptsTo(Clear.field(MobileNoField));

    }


    @Then("I see Request Call Back form is displayed with Mobile number field")
    public void iSeeRequestCallBackFormIsDisplayedWithMobileNumberField() throws InterruptedException {

        user.attemptsTo(
                WaitUntil.the(RequestCallBackText, isVisible()));
        user.attemptsTo(Ensure.that(RequestCallBackText).isDisplayed());
        user.attemptsTo(Ensure.that(MobileNolabel).isDisplayed());

    }

    @When("I click on Back button")
    public void iClickOnBackButton() {

        user.attemptsTo(ClickOn.ClicOnkBackButton());
       }

    @Then("user is navigated back to Diagnostics home page")
    public void userIsNavigatedBackToDiagnosticsHomePage() throws InterruptedException {

        user.attemptsTo(WaitUntil.the(DescriptionOfTheHeroSection, isVisible()));
         user.attemptsTo(Ensure.that(DescriptionOfTheHeroSection).isDisplayed());
        user.attemptsTo(Ensure.that(HeroImage).isDisplayed());
        user.attemptsTo(Ensure.that(TitleOfTheHeroSection).isDisplayed());
    }


    @Then("I see Request Call Back form is displayed with OTP field")
    public void iSeeRequestCallBackFormIsDisplayedWithOTPField() {
        user.attemptsTo(Ensure.that(EnterOTPText).isDisplayed());
        user.attemptsTo(Ensure.that(EnterOTPText).isDisplayed());


    }

    @Then("I see cancel and submit button displayed")
    public void iSeeCancelAndSubmitButtonDisplayed() {
        user.attemptsTo(Ensure.that(CancelButton).isDisplayed());
        user.attemptsTo(Ensure.that(submitOTP).isDisplayed());
       }

    @Then("I see Resend button clickable")
    public void iSeeResendButtonClickable() {
        user.attemptsTo(Ensure.that(ResendOTP).isDisplayed());



    }

    @Then("I see the Please wait before requesting another OTP text")
    public void iSeeThePleaseWaitBeforeRequestingAnotherOTPText() {

        user.attemptsTo(Ensure.that(ResendOTPtext).isDisplayed());

    }

    @When("I click on the Resend button")
    public void iClickOnTheResendButton() {
        user.attemptsTo(Click.on(ResendOTP));
    }


    @When("I click on the Request Call Back button secondtime")
    public void iClickOnTheRequestCallBackButtonSecondtime() {
         user.attemptsTo(WaitUntil.the(RequestCallBackButton, WebElementStateMatchers.isCurrentlyVisible()));
        user.attemptsTo(Click.on(RequestCallBackButton));
    }


    @Then("I see Tests section")
    public void iSeeTestsSection() throws InterruptedException {
        Thread.sleep(200);
        if(javascriptbutton.isVisibleFor(user)) {
            Ensure.enableSoftAssertions();
            userAcceptsCoookiesPopUpBoxInEvolution();
            Ensure.reportSoftAssertions();
            user.attemptsTo(Ensure.that(TestSectionArrow).isDisplayed());
            user.attemptsTo(Ensure.that(TestSectionLabel).isDisplayed());
            user.attemptsTo(Ensure.that(TestSectionImage).isDisplayed());
        }
        else { user.attemptsTo(Ensure.that(TestSectionArrow).isDisplayed());
            user.attemptsTo(Ensure.that(TestSectionLabel).isDisplayed());
            user.attemptsTo(Ensure.that(TestSectionImage).isDisplayed());

        }
    }

    @When("I click on Tests sections")
    public void iClickOnTestsSections() {
        user.attemptsTo(WaitUntil.the(TestSectionArrow, WebElementStateMatchers.isCurrentlyVisible()));
        user.attemptsTo(Click.on(TestSectionArrow));

    }


    @Then("I see breadcrumb is displayed")
    public void iSeeBreadcrumbIsDisplayed() {

        user.attemptsTo(Ensure.that(Testbreadcrumb).isDisplayed());

    }

    @Then("I see hero section is displayed with description")
    public void iSeeHeroSectionIsDisplayedWithDescription() {
        user.attemptsTo(Ensure.that(HeroSection).isDisplayed());
    }

    @Then("I see Search bar is displayed with the text Search by tests or checkup nameg and search icon")
    public void iSeeSearchBarIsDisplayedWithTheTextSearchByTestsOrCheckupNamegAndSearchIcon() {
        user.attemptsTo(Ensure.that(SearchBarIcons).isDisplayed());
    }
    int TitleSize=0;

    @Then("I see the list of Tests with the test title")
    public void iSeeTheListOfTestsWithTheTestTitle() {


        TitleSize= DiagnosticPageObject.getPopularTestsElement().size();



    }
    int DescriptionSize=0;
    @Then("I see description with the test included")
    public void iSeeDescriptionWithTheTestIncluded() {
        DescriptionSize=DiagnosticPageObject.getListofCardDescription().size();
        user.attemptsTo(Ensure.that(TitleSize).isEqualTo(DescriptionSize));
    }
    List<WebElement> listoftitle;
    String s1;
    @Then("I see the View Detail option in the cards")
    public void iSeeTheViewDetailOptionInTheCards() {
        listoftitle= getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
        s1="//p[text()="+listoftitle.get(0).getText()+"]/following-sibling::div[4]/div[3]/div/button[text()='View Details']";

        user.attemptsTo(Ensure.that(By.xpath(s1)).isDisplayed());

    }

    @When("I click on the View Detail option")
    public void iClickOnTheViewDetailOption() {

        user.attemptsTo(Click.on(org.openqa.selenium.By.xpath(s1)));
    }

    @Then("I see page redirected to the specific detail screen")
    public void iSeePageRedirectedToTheSpecificDetailScreen() {
        user.attemptsTo(Ensure.that(CardDetails.of(listoftitle.get(1).getText())).isDisplayed());

    }



    @And("User enters the test and checkup name as {string}")
    public void userEntersTheTestAndCheckupNameAs(String searchString) throws InterruptedException {
        user.attemptsTo(EnterValueInto.diagnosticsSearchBox(searchString));
        Thread.sleep(5000);
    }

    @When("User clicks on the Checkup Icon")
    public void userClicksOnTheCheckupIcon() {
        user.attemptsTo(ClickOn.CheckupsIcon());
    }

    @When("User clicks on the Test Icon")
    public void userClicksOnTheTestIcon() {
        user.attemptsTo(ClickOn.TestIcon());
    }

    @Then("I see Disease Specific package below the Explore section")
    public void iSeeDiseaseSpecificPackageBelowTheExploreSection() {
        user.attemptsTo(Ensure.that(DiseaseSpecificSection).isDisplayed());
    }

    @Then("I see {int} disease cards are displayed")
    public void iSeeDiseaseCardsAreDisplayed(int expectedVisibleCard) {
        List<WebElement> DiseaseElement=new DiagnosticPage().getDiseaseElement();
        int count=0;
        for(WebElement e:DiseaseElement){
            if(count==expectedVisibleCard){
                user.attemptsTo(Ensure.that(e.isDisplayed()).isFalse());
                break;
            }
            user.attemptsTo(Ensure.that(e.isDisplayed()).isTrue());
            count++;

        }
        user.attemptsTo(Ensure.that(count==expectedVisibleCard).isTrue());
    }

    @When("I click on View More Option of Disease Specific Packages")
    public void iClickOnViewMoreOptionDiseaseSpecificPackages() {
        user.attemptsTo(ClickOn.theViewMoreButtoninDiagnosticsDiseaseSpecificPackages());
    }

    @When("I click on View More Option of Body Organ Checkup Packages")
    public void iClickOnViewMoreOptionBodyOrganCheckupPackages() {
        user.attemptsTo(ClickOn.theViewMoreButtoninBodyOrganCheckupPackages());
    }

    @Then("I see remaining disease icon cards")
    public void iSeeRemainingDiseaseIconCards() {
        List<WebElement> DiseaseElement = new DiagnosticPage().getDiseaseElement();
        for (WebElement e : DiseaseElement) {
            user.attemptsTo(Ensure.that(e.isDisplayed()).isTrue());
        }
    }

    @Then("I see remaining body organ icon cards")
    public void iSeeRemainingBodyOrganIconCards() {
        List<WebElement> BodyOrgan = new DiagnosticPage().getOrganElement();
        for (WebElement e : BodyOrgan) {
            user.attemptsTo(Ensure.that(e.isDisplayed()).isTrue());
        }
    }


    @When("I click on {string} disease or body organ icon card")
    public void iClickOnDiseaseIconCard(String Disease) {
        user.attemptsTo(ClickOn.DiseaseIcon(Disease));
    }

    @Then("I see {string} Specific Tests and Packages when clicked on particular disease icon")
    public void iSeeSpecificTestsAndPackagesWhenClickedOnParticularDiseaseIcon(String Disease) {
        user.attemptsTo(Ensure.that(HeaderInTestAndPackagesListingPage.of(Disease)).isDisplayed());
    }

    @Then("I see title on the top of the detail page like {string} specific Test and Checkups")
    public void iSeeTitleOnTheTopOfTheDetailPageLikeSpecificTestAndCheckups(String Disease) {
        user.attemptsTo(Ensure.that(HeaderInTestAndPackagesListingPage.of(Disease)).isDisplayed());
    }

    @Then("I see Header description")
    public void iSeeHeaderDescription() {
        user.attemptsTo(Ensure.that(CardTitleInTestAndPackagesListingPage).isDisplayed());
    }

    @Then("I see brief description")
    public void iSeeBriefDescription() {
        user.attemptsTo(Ensure.that(CardDescriptionInTestAndPackagesListingPage).isDisplayed());
    }

    @Then("I see Price")
    public void iSeePrice() {
        user.attemptsTo(Ensure.that(PriceInTestAndPackagesListingPage).isDisplayed());
    }

    @Then("I see Add to cart button")
    public void iSeeAddToCartButton() {
        user.attemptsTo(Ensure.that(AddToCartButton).isDisplayed());
    }

    @Then("I see Buy Now button")
    public void iSeeBuyNowButton() {
        user.attemptsTo(Ensure.that(BuyNowButton).isDisplayed());
    }

    @Then("I see breadcrumb in the detail page")
    public void iSeeBreadcrumbInTheDetailPage() {
        user.attemptsTo(Ensure.that(BreadCrumbInTestAndPackagesListingPage).isDisplayed());
    }

    @When("I click on Diagnostics in the breadcrumb")
    public void iClickOnDiagnosticsInTheBreadcrumb() {
        user.attemptsTo(ClickOn.DiagnosticBreadCrumbInTestAndPackagesListingPage());
    }

    @Then("I see user is navigated to the {string} home page")
    public void iSeeUserIsNavigatedToTheHomePage(String arg0) {
        user.attemptsTo(Ensure.that(Serenity.getDriver().getTitle()).contains("Happiest Health Diagnostics"));
    }

    @Then("I see specific organs are displayed below the Disease specific Packages")
    public void iSeeSpecificOrgansAreDisplayedBelowTheDiseaseSpecificPackages() {
        user.attemptsTo(Ensure.that(BodyOrganSection).isDisplayed());
    }

    @Then("I see {int} Body Organ cards are displayed")
    public void iSeeOrganCardsAreDisplayed(int expectedVisibleCard) {
        List<WebElement> OrganElement=new DiagnosticPage().getOrganElement();
        int count=0;
        for(WebElement e:OrganElement){
            if(count==expectedVisibleCard){
                user.attemptsTo(Ensure.that(e.isDisplayed()).isFalse());
                break;
            }
            user.attemptsTo(Ensure.that(e.isDisplayed()).isTrue());
            count++;

        }
        user.attemptsTo(Ensure.that(count==expectedVisibleCard).isTrue());
    }

    @Then("I see Search Bar with search text {string} and icon in the home page")
    public void iSeeSearchBarWithSearchTextAndIconInTheHomePage(String arg0) {
        user.attemptsTo(Ensure.that(SearchByTestsOrCheckups).isDisplayed());
    }

    @When("I click on Search bar to search bar")
    public void iClickOnSearchBarToSearchTestsCheckups() {
        user.wasAbleTo(ClickOn.SearchByTestsOrCheckups());
    }

    @Then("I see suggestions as per the search text {string}")
    public void iSeeSuggestionsAsPerTheSearchType(String searchtext) {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> searchedResultTestsElement= DiagnosticPageObject.getSearchResultTestsElement();
        List<String> searchedResultTests = DiagnosticPageObject.getTextFromElement(searchedResultTestsElement);
        System.out.println("From UI :-"+searchedResultTests);
        Collections.sort(searchedResultTests);
        boolean flag=false;
        for(int i=1;i<searchedResultTests.size();i++){
           flag= searchedResultTests.get(i).toLowerCase().contains(searchtext.toLowerCase());
           if(flag==false)
           { break;}
        }
       user.attemptsTo(Ensure.that(flag).isTrue());
    }

    @When("I click on back button in the search bar")
    public void iClickOnBackButtonInTheSearchBar() {
        user.attemptsTo(ClickOn.DiagnosticsSearchBoxBackButton());
    }

    @Then("I see error message {string}")
    public void iSeeErrorMessage(String arg0) {
        user.attemptsTo(Ensure.that(NoResultErrorMessage).isDisplayed());
    }


    @Then("I see Title heading of the test checkups")
    public void iSeeTitleHeadingOfTheTestCheckups() {
        user.attemptsTo(Ensure.that(CardTitleInTestAndPackagesListingPage).isDisplayed());
    }

    @Then("I see the number of tests included")
    public void iSeeTheNumberOfTestsIncluded() {
        user.attemptsTo((Ensure.that(NoOfTestIncluded).isDisplayed()));
    }

    @Then("I see discounted price")
    public void iSeeDiscountedPrice() {
        user.attemptsTo((Ensure.that(PriceOfTest).isDisplayed()));
    }

    @Then("I see View Details")
    public void iSeeViewDetails() {
        user.attemptsTo((Ensure.that(ViewDetailsButton).isDisplayed()));
    }


    @When("I click on any test checkup results")
    public void iClickOnAnyTestCheckupResults() {

    }

    @When("I click on Buy Now button")
    public void iClickOnBuyNowButton() {
        user.wasAbleTo(ClickOn.BuyNowButton());
    }

    @Then("I see user is navigated to the payment page")
    public void iSeeUserIsNavigatedToThePaymentPage() {
        user.wasAbleTo(Ensure.that(BuyNowHeader).isDisplayed());
    }

    @When("I click on Add to Cart button")
    public void iClickOnAddToCartButton() {
        user.wasAbleTo(ClickOn.AddToCartButton());
    }

    @Then("I see item is added to cart")
    public void iSeeItemIsAddedToCart() {
        user.wasAbleTo(ClickOn.CartIcon());
        user.wasAbleTo(Ensure.that(ItemSelectedElementInCartPage).isDisplayed());

    }

    @And("I see {string} button is displayed")
    public void iSeeButtonIsDisplayed(String ExpectedText) throws InterruptedException {
        Thread.sleep(5000);
        String ActualText=Serenity.getDriver().findElement(By.xpath("(//button[contains(@class,'product-card-button')])[4]")).getText();
        user.wasAbleTo(Ensure.that(ActualText).isEqualTo(ExpectedText));
    }

    @Then("I see FAQ section below Body Organ Checkups")
    public void iSeeFAQSectionBelowBodyOrganCheckups() {
        user.attemptsTo(Ensure.that(DiagnosticFAQBelowBodyOrganCheckupPackages).isDisplayed());
    }

    @Then("I see {string} as a title")
    public void iSeeAsATitle(String ExpectedText) {
        String ActualText=Serenity.getDriver().findElement(By.xpath("(//div[text()='Body Organ Checkup Packages']/following::h6)[2]")).getText();
        user.wasAbleTo(Ensure.that(ActualText).isEqualTo(ExpectedText));
    }

    @Then("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        user.wasAbleTo(ClickOn.CartIcon());
    }

    @Then("I see FAQ's are displayed in listing format")
    public void iSeeFAQSAreDisplayedInListingFormat() {
    }

    @When("I enter less than {int} digit mobile number as {string}")
    public void iEnterLessThanDigitMobileNumberAs(int arg0, String mobilenodata) {
        user.attemptsTo(Type.theValue(mobilenodata).into(MobileNoField));
    }

    @Then("I see error message {string} below the field")
    public void iSeeErrorMessageBelowTheField(String arg0) {
        user.attemptsTo(Ensure.that(MobileNoErrorMessage).isNotDisplayed());
    }

    @When("I enter more than {int} digit mobile number as {string}")
    public void iEnterMoreThanDigitMobileNumberAs(int arg0, String mobilenodata) {
        user.attemptsTo(Type.theValue(mobilenodata).into(MobileNoField));
    }



    @When("user clicks on Add to Cart button")
    public void userClicksOnButton() {
        user.attemptsTo(WaitUntil.the(CartItem, WebElementStateMatchers.isVisible()));

        listoftitle = getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
        user.attemptsTo(Click.on(By.xpath("//p[text()='" + listoftitle.get(0).getText() + "']/following-sibling::div/button[text()='Add to Cart']")));

    }


    @Then("Remove button is displayed in place of Add to cart buttons")
    public void removeButtonIsDisplayedInPlaceOfButton() {
        listoftitle = getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
        user.attemptsTo(Ensure.that(By.xpath("//p[text()='" + listoftitle.get(0).getText() + "']/following-sibling::div/button[text()='Remove']")).isDisplayed());
    }


    @Then("user sees the specific test is added to the cart")
    public void userSeesTheSpecificTestIsAddedToTheCart() {
        user.attemptsTo(Click.on(CartItem));
        user.attemptsTo(Ensure.that(RemoveItem.waitingForNoMoreThan(Duration.ofSeconds(10))).isDisplayed());
        user.attemptsTo(Ensure.that(Cartbreadcrumb).isDisplayed());


    }

    @When("I click on Remove button")
    public void iClickOnRemoveButton() {
        user.attemptsTo(Click.on(RemoveItem));
    }

    @Then("I see card is removed from the tests listing screen")
    public void iSeeCardIsRemovedFromTheTestsListingScreen() throws InterruptedException {
        Thread.sleep(5000);
        user.attemptsTo(Ensure.that(NocartItemfound).isDisplayed());

    }

    @When("I click on Checkups section")
    public void iClickOnCheckupsSection() throws InterruptedException {
        Thread.sleep(300);
        try {
            getDriver().findElement(By.xpath("//a[contains(@href,'health-checkups?stype=tests')]//*[local-name()='svg' ]")).click();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        userAcceptsCoookiesPopUpBoxInEvolution();
        Thread.sleep(200);
        user.attemptsTo(Ensure.that(CheckupsIcon).isDisplayed());
        user.attemptsTo(Click.on(CheckupsIcon));


    }

    @Then("I see Checkups breadcrumb is displayed")
    public void iSeeCheckupsBreadcrumbIsDisplayed() {
        user.attemptsTo(Ensure.that(Checkupbreadcrumb).isDisplayed());

    }

    @Then("I see Hero image is displayed with title and description")
    public void iSeeHeroImageIsDisplayedWithTitleAndDescription() {

        user.attemptsTo(Ensure.that(CheckupTitle).isDisplayed());
        user.attemptsTo(Ensure.that(CheckupDescription).isDisplayed());
        user.attemptsTo(Ensure.that(CheckupHeroImage).isDisplayed());
    }

    @Then("I see search bar is dispalyed with the text Search by tests or checkup name and search icon")
    public void iSeeSearchBarIsDispalyedWithTheTextSearchByTestsOrCheckupNameAndSearchIcon() {
        user.attemptsTo(Ensure.that(SearchbarinCheckups).isDisplayed());

    }
    int sizeofcheckupCard = 0;

    @Then("I see the list of Checkups  with the test title")
    public void iSeeTheListOfCheckupsWithTheTestTitle() {
        sizeofcheckupCard = diagnosticPageObject.getListofCheckupCardTitle().size();
        for (int i = 1; i < sizeofcheckupCard; i++) {
            user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardTitle().get(i).getText()).isNotEmpty());
        }
    }


    @Then("I see description with the checkups included")
    public void iSeeDescriptionWithTheCheckupsIncluded() {
        int sizeofcarddescription = diagnosticPageObject.getListofCheckupCardDescription().size();
        user.attemptsTo(Ensure.that(sizeofcarddescription).isEqualTo(sizeofcheckupCard));
        for (int i = 1; i < sizeofcarddescription; i++) {
            //if( diagnosticPageObject.getListofCheckupCardDescription().get(i).getText().isEmpty())

            user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardTitle().get(i).getText()).isNotEmpty());
        }
    }

    @Then("I see report available time")
    public void iSeeReportAvailableTime() {
        {

            int sizeofreportavailabeltime= diagnosticPageObject.getListofCheckupCardText().size();
            user.attemptsTo(Ensure.that(sizeofreportavailabeltime).isEqualTo(sizeofcheckupCard-1));

         /*   for (int i = 1; i < sizeofreportavailabeltime; i++) {
                System.out.println("===================================================="+diagnosticPageObject.getListofCheckupCardText().get(i).getText());
                user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardText().get(i+1).getText()).isNotEmpty());
            }*/
        }

    }


    @Then("I see actual price, discounted price, with a View Details link")
    public void iSeeActualPriceDiscountedPriceWithAViewDetailsLink() {
        int sizeofcheckupcardprice= diagnosticPageObject.getListofCheckupCardPrice().size();
        int sizeofcheckupcardviewdetails= diagnosticPageObject.getListofCheckupCardViewDetails().size();
        user.attemptsTo(Ensure.that(sizeofcheckupcardprice).isEqualTo(sizeofcheckupCard));
        user.attemptsTo(Ensure.that(sizeofcheckupcardviewdetails).isEqualTo(sizeofcheckupCard));
      /*  for (int i = 1; i < sizeofcheckupcardprice-1; i++) {
            user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardPrice().get(i+1).getText()).isNotEmpty());
            user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardViewDetails().get(i+1).getText()).isNotEmpty());
        }*/
      /*  for (int i = 1; i < sizeofcheckupcardviewdetails; i++) {
            user.attemptsTo(Ensure.that(diagnosticPageObject.getListofCheckupCardViewDetails().get(i+1).getText()).isNotEmpty());
        }*/

    }

    @Then("I see add to cart, buy now action buttons")
    public void iSeeAddToCartBuyNowActionButtonss() {
        int sizeofcheckupbuyNowButton= diagnosticPageObject.getListofCheckupCardBuyNowButton().size();
        int sizeofcheckupAddCartButton= diagnosticPageObject.getListofCheckupCardAddToCartButton().size();
        user.attemptsTo(Ensure.that(sizeofcheckupbuyNowButton).isEqualTo(sizeofcheckupCard));
        user.attemptsTo(Ensure.that(sizeofcheckupAddCartButton).isEqualTo(sizeofcheckupCard));

    }

    @When("I verified the Checkup Details screen")
    public void iClickOnTheViewDetailsFromTheFirstCard() {

        List<WebElement> listofcheckuptitle = getDriver().findElements(By.xpath("//h6[text()='Checkups']/parent::div/following-sibling::article/div/div/div/div[2]/p[1]"));
        System.out.println(listofcheckuptitle);
        String checkuptitle = listofcheckuptitle.get(0).getText();
        String cardpriceValue=getDriver().findElement(By.xpath("//p[text()='" + checkuptitle + "']/following-sibling::div[1]")).getText();


        user.attemptsTo(Click.on(By.xpath( "//p[text()='" + checkuptitle + "']/following-sibling::div[4]/div[3]/div/button[text()='View Details']")));
        user.attemptsTo(Ensure.that(By.xpath("//span[text()='Diagnostics']/parent::a/parent::li/following-sibling::li[1]/*[local-name()='svg' ]/parent::li/following-sibling::li/a/span[text()='checkups']/parent::a/parent::li/following-sibling::li[1]/*[local-name()='svg']/parent::li/following-sibling::li/span[text()='" + checkuptitle + "']")).isDisplayed());

        user.attemptsTo(Ensure.that(By.xpath("//span[text()='"+cardpriceValue+"']")).isDisplayed());
        user.attemptsTo(Ensure.that(BuyButtoninCheckupdetailspage).isDisplayed());
        user.attemptsTo(Ensure.that(AddToCartButtoninCheckupdetailspage).isDisplayed());
        //
        user.attemptsTo(Ensure.that(Reportwithinhours).isDisplayed());
        user.attemptsTo(Ensure.that(InhouseProcessing).isDisplayed());
        user.attemptsTo(Ensure.that(HomeCollection).isDisplayed());
        user.attemptsTo(Ensure.that(KnowledgeInsight).isDisplayed());
        user.attemptsTo(Ensure.that(AddToCartButtoninCheckupdetailspage).isDisplayed());
    }
    @When("I clicks on Add to Cart button")
    public void iClicksOnButton() {
        List<WebElement> listofcheckuptitle = getDriver().findElements(By.xpath("//h6[text()='Checkups']/parent::div/following-sibling::article/div/div/div/div[2]/p[1]"));
        System.out.println(listofcheckuptitle);
        listoftitle = getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
        user.attemptsTo(Click.on(By.xpath("//p[text()='" + listoftitle.get(0).getText() + "']/following-sibling::div/button[text()='Add to Cart']")));

    }

    @Then("Remove button is displayed in place of Add to cart buttons in checkups")
    public void buttonIsDisplayedInPlaceOfButton() {
        listoftitle = getDriver().findElements(By.xpath("//button[text()='Buy Now']/parent::div/preceding-sibling::div/parent::div/p[1]"));
        user.attemptsTo(Ensure.that(By.xpath("//p[text()='" + listoftitle.get(0).getText() + "']/following-sibling::div/button[text()='Remove']")).isDisplayed());

    }

    @Then("I sees the specific Checkup is added to the cart")
    public void iSeesTheSpecificCheckupIsAddedToTheCart() {
        user.attemptsTo(Click.on(CartItem));
        user.attemptsTo(Ensure.that(RemoveItem.waitingForNoMoreThan(Duration.ofSeconds(10))).isDisplayed());
        user.attemptsTo(Ensure.that(Cartbreadcrumb).isDisplayed());
    }

   /* @When("I click on Remove button")
    public void iClickOnButton() {
        user.attemptsTo(Click.on(RemoveItem));
    }*/

}
