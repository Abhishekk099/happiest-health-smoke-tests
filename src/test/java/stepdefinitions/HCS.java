package stepdefinitions;

import Actions.ClickOn;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SetCheckbox;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;

import static HHPages.HealthCarePage.*;

public class HCS {
    Actor user = MyCast.user();

    @Then("Verify {string} section is available")
    public void verifyFAQSectionIsAvailable(String data) {
        user.attemptsTo(Ensure.that(HealthCarePageTiles.of(data)).isDisplayed());
    }

    @When("user clicked on Healthcare from the primary menu")
    public void userClickedOnHealthcareFromThePrimaryMenu() {
        user.attemptsTo(ClickOn.Healthcare());
    }
    @Then("user verify Doctor section below services")
    public void userVerifyDoctorSectionBelowServices() {
        user.attemptsTo(Ensure.that(DoctorSectionBelowService).isDisplayed());
    }
    @Then("user verify {string} Image")
    public void userVerifyImage(String arg0) {
        String imageSrc=Serenity.getDriver().findElement(By.xpath("(//h6[text()='Doctors']/../..//img)[1]")).getDomAttribute("src");
        user.attemptsTo(Ensure.that(imageSrc).isNotEmpty());
    }
    @Then("user verify {string} Name")
    public void userVerifyName(String arg0) {
        user.attemptsTo(Ensure.that(DoctorName).isDisplayed());
    }

    @Then("user verify {string} Qualification")
    public void userVerifyQualification(String arg0) {
        user.attemptsTo(Ensure.that(DoctorQualification).isDisplayed());
    }

    @Then("user verify {string} Speciality")
    public void userVerifySpeciality(String arg0) {
        user.attemptsTo(Ensure.that(DoctorSpeciality).isDisplayed());
    }

    @Then("user verify {string} Location")
    public void userVerifyLocation(String arg0) {
        user.attemptsTo(Ensure.that(DoctorLocation).isDisplayed());
    }

    @Then("user verify Book an Appointment button")
    public void userVerifyBookAnAppointmentButton() {
        user.attemptsTo(Ensure.that(BookAnAppointmentButton).isDisplayed());
    }
    @When("user clicked on Carousel")
    public void userClickedOnCarousel() {
        user.attemptsTo(ClickOn.Carosel());
    }

    @Then("user verify next three Doctor cards are displayed")
    public void iVerifyNextThreeDoctorCardsAreDisplayed() {
        String CurrentDoctorName=Serenity.getDriver().findElement(By.xpath("//h6[text()='Doctors']/../..//div[@class='slick-slide slick-active slick-current']//h5[contains(@class,'profile-header-title')]")).getText();
        user.attemptsTo(Ensure.that(CurrentDoctorName).isNotEqualTo(user.recall("doctor name")));
    }

    @When("user clicked on view all link for doctors section")
    public void userClickedOnViewAllLinkForDoctorsSection() {
        user.attemptsTo(ClickOn.ViewAllLink());
    }
    @Then("Verify Doctors listing section is available")
    public void verifyDoctorsListingSectionIsAvailable() {
        user.attemptsTo(Ensure.that(DoctorListingSection).isDisplayed());
    }
    @When("user clicked on any one Doctor card in the listing page")
    public void userClickedOnAnyOneDoctorCardInTheListingPage() {
        user.attemptsTo(ClickOn.card());
    }
    @Then("Verify Doctors Details section is available")
    public void verifyDoctorsDetailsSectionIsAvailable() {
        user.attemptsTo(Ensure.that(DoctorDetailSection).isDisplayed());
    }
    @When("user clicked on Book an Appointment button")
    public void userClickedOnBookAnAppointmentButton() {
        user.attemptsTo(ClickOn.Book());
    }


    @Then("user verify Services section")
    public void userVerifyServicesSection() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'healthcare-homepage-services')]/descendant::h6[text()='Services']")).isDisplayed());
    }

    @Then("user verify Services Name")
    public void userVerifyServicesName() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'healthcare-homepage-services')]/descendant::h6[text()='Services']")).isDisplayed());
        user.attemptsTo(Ensure.that(By.xpath("//div[contains(@class,'healthcare-homepage-services')]/descendant::h6[text()='Services']")).hasText("Services"));

    }


    @Then("user verify next three Services cards are displayed")
    public void userVerifyNextThreeServicesCardsAreDisplayed() {
        user.wasAbleTo(Ensure.that(By.xpath("(//following::div[contains(@class,'healthcare-slider')])[1]")).isDisplayed());
    }

    @When("user clicked on view all link for services section")
    public void userClickedOnViewAllLinkForServicesSection() {
        user.attemptsTo(ClickOn.viewAllButton());

    }

    @Then("Verify List Of Services listing section is available")
    public void verifyListOfServicesListingSectionIsAvailable() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'healthcare-specility')]/descendant::h6[text()='List of Services']")).isDisplayed());

        String ExpectedPageTitle="SEO Title";
        String ActualPageTitle= Serenity.getDriver().getTitle();
        user.attemptsTo(Ensure.that(ActualPageTitle).isEqualTo(ExpectedPageTitle));
        System.out.println(ActualPageTitle);

    }

    @When("user clicks on view details of any one Services card in the listing page")
    public void userClicksOnViewDetailsOfAnyOneServicesCardInTheListingPage() {

        user.attemptsTo(ClickOn.viewDetails());
    }


    @Then("user verify details landing page with {string} breadcrumb")
    public void userVerifyDetailsLandingPageWithBreadcrumb(String expectedBreadcrumb) {

        String  breadcrumbText = Serenity.getDriver().findElement(By.xpath("//nav[@aria-label='breadcrumb']/descendant::li[contains(@class,'MuiBreadcrumbs-li')]")).getText();

        System.out.println("Actual breadcrumb text : " + breadcrumbText);
        user.wasAbleTo(Ensure.that(expectedBreadcrumb).contains(breadcrumbText));
    }


    @Then("user clicked on Book an Appointment button for the selected doctor card")
    public void userClickedOnBookAnAppointmentButtonForTheSelectedDoctorCard() {
        user.attemptsTo(Click.on(BookAnAppointmentButton));
    }

    @Then("I see Book an Appointment form is displayed with patient first name")
    public void iSeeBookAnAppointmentFormIsDisplayedWithPatientFirstName() {
        user.attemptsTo(Ensure.that(FirstName).isDisplayed());
    }

    @Then("I see patient first name field is empty by default for non-logged In user")
    public void iSeePatientFirstNameFieldIsEmptyByDefaultForNonLoggedInUser() {
        user.attemptsTo(Ensure.that(EmptyFirstNameField).isDisplayed());
    }

    @Then("I see Book an Appointment form is displayed with patient last name")
    public void iSeeBookAnAppointmentFormIsDisplayedWithPatientLastName() {
        user.attemptsTo(Ensure.that(LastName).isDisplayed());
    }

    @Then("I see patient last name  is empty by default for non-logged In user")
    public void iSeePatientLastNameIsEmptyByDefaultForNonLoggedInUser() {
        user.attemptsTo(Ensure.that(EmptyLastNameField).isDisplayed());

    }

    @Then("I see Book an Appointment form is displayed with Mobile number field")
    public void iSeeBookAnAppointmentFormIsDisplayedWithMobileNumberField() {
        user.attemptsTo(Ensure.that(MobileNumber).isDisplayed());
    }

    @Then("I see Mobile Number field is empty by default for non-logged In user in BAA")
    public void iSeeMobileNumberFieldIsEmptyByDefaultForNonLoggedInUserInBAA() {
        user.attemptsTo(Ensure.that(EmptyMobileNumber).isDisplayed());
    }

    @Then("I see back button in BAP")
    public void iSeeBackButtonInBAP() {
        user.attemptsTo(Ensure.that(Backarrow).isDisplayed());
        user.attemptsTo(Ensure.that(Back).isDisplayed());
    }

    @Then("I see Privacy policy & Terms of use check box")
    public void iSeePrivacyPolicyTermsOfUseCheckBox() {
        user.attemptsTo(Ensure.that(Term).isDisplayed());

    }
    @Then("I see I want to receive the updates through WhatsApp checkbox")
    public void iSeeIWantToReceiveTheUpdatesThroughWhatsAppCheckbox() {
        user.attemptsTo(Ensure.that(WhatsAPP).isDisplayed());

    }

    @Then("I see proceed button is disabled by default in BAA")
    public void iSeeProceedButtonIsDisabledByDefaultInBAA() {
        user.attemptsTo(Ensure.that(ProccedDisabled).isDisplayed());
    }

    @When("I click on Back button in BAP form")
    public void iClickOnBackButtonInBAPForm() {
        user.attemptsTo(Ensure.that(Backarrow).isDisplayed());
        user.attemptsTo(Ensure.that(Back).isDisplayed());
        user.attemptsTo(ClickOn.BackButton());

    }

    @Then("user is navigated back to healthcare service page")
    public void userIsNavigatedBackToHealthcareServicePage() {
        user.attemptsTo(Ensure.that(Healthcare).isDisplayed());
//        user.attemptsTo(Ensure.that(DoctorSectionBelowService).isDisplayed());

    }
    @When("I click on the Book an Appointment button second time")
    public void iClickOnTheBookAnAppointmentButtonSecondTime() {
        user.attemptsTo(Click.on(BookAnAppointmentButton));
    }
    @When("I enter the valid first name in the patient first name Field")
    public void iEnterTheValidFirstNameInThePatientFirstNameField() {
        user.wasAbleTo(Enter.theValue("Surekha").into(FirstName));

    }

    @When("I enter the valid last name  in the patient last name Field")
    public void iEnterTheValidLastNameInThePatientLastNameField() {
        user.wasAbleTo(Enter.theValue("VS").into(LastName));

    }

    @When("I enter the valid mobile number in the Mobile Number Field in BAA")
    public void iEnterTheValidMobileNumberInTheMobileNumberFieldInBAA() {
        user.attemptsTo(Clear.field(MobileNumber));
        user.wasAbleTo(Enter.theValue("9019430542").into(MobileNumber));

    }

    @Then("I see no error message is displayed in BAA")
    public void iSeeNoErrorMessageIsDisplayedInBAA() {
        user.attemptsTo(Ensure.that(NoErrorMessage).isNotDisplayed());

    }

    @Then("I see Proceed button will be enabled in BAA")
    public void iSeeProceedButtonWillBeEnabledInBAA() {
        user.attemptsTo(Ensure.that(ProceedButtonis).isEnabled());

    }
    @When("I uncheck the  Privacy policy & Terms of use check box in BAA")
    public void iUncheckThePrivacyPolicyTermsOfUseCheckBoxInBAA() {
        user.attemptsTo(SetCheckbox.of(Checkboxforaccept).toFalse().afterWaitingUntilEnabled());

    }
    @When("I uncheck the  whatsapp check box in BAA")
    public void iUncheckTheWhatsappCheckBoxInBAA() {
        user.attemptsTo(SetCheckbox.of(CheckboxforWhatsApp).toFalse().afterWaitingUntilEnabled());

    }

    @Then("I see proceed button is disabled in BAA")
    public void iSeeProceedButtonIsDisabledInBAA() {
        user.attemptsTo(Ensure.that(ProceedButtonis).isDisplayed());


    }
    @When("I check the both checkboxes from the Book an Appointment page")
    public void iCheckTheBothCheckboxesFromTheBookAnAppointmentPage() {
        user.attemptsTo(SetCheckbox.of(Checkboxforaccept).toTrue()
                .afterWaitingUntilEnabled());
        user.attemptsTo(SetCheckbox.of(CheckboxforWhatsApp).toTrue()
                .afterWaitingUntilEnabled());
    }

    @When("I click on Proceed button in BAA")
    public void iClickOnProceedButtonInBAA() {
        user.attemptsTo(ClickOn.proccedButton());
    }

    @Then("I see back button in BAA")
    public void iSeeBackButtonInBAA() {
        user.attemptsTo(Ensure.that(BackButton).isDisplayed());

    }

    @Then("I see  Book an Appointment form is displayed with OTP field")
    public void iSeeBookAnAppointmentFormIsDisplayedWithOTPField() {
        user.attemptsTo(Ensure.that(OTPText).isDisplayed());
    }

    @Then("I see cancel and submit button displayed in BAA")
    public void iSeeCancelAndSubmitButtonDisplayedInBAA() {
        user.attemptsTo(Ensure.that(Cancel).isDisplayed());
        user.attemptsTo(Ensure.that(Submit).isDisplayed());
    }
    @Then("I see previous Book an Appointment form is displayed")
    public void iSeePreviousBookAnAppointmentFormIsDisplayed() {
        user.attemptsTo(Ensure.that(BackForm).isDisplayed());
    }

    @Then("I see breadcrumbs")
    public void iSeeBreadcrumbs() {
        user.attemptsTo(Ensure.that(Breadcrumbs).isDisplayed());
    }

    @Then("I see hero banner section")
    public void iSeeHeroBannerSection() {
        user.attemptsTo(Ensure.that(BannerSection).isDisplayed());

    }

    @Then("I see Tittle for hero banner section")
    public void iSeeTittleForHeroBannerSection() {
        user.attemptsTo(Ensure.that(BannerTitle).isDisplayed());

    }

    @Then("I see Description for the hero banner section")
    public void iSeeDescriptionForTheHeroBannerSection() {
        user.attemptsTo(Ensure.that(BannerTitle).isDisplayed());

    }

    @Then("I see {int} cards displayed for the hero banner section")
    public void iSeeCardsDisplayedForTheHeroBannerSection(int arg0) {

    }

    @Then("I see FAQ section")
    public void iSeeFAQSection() {
        user.attemptsTo(Ensure.that( FAQSection).isDisplayed());

    }

    @Then("Verify Why Choose Us section is available")
    public void verifyWhyChooseUsSectionIsAvailable() {
        user.attemptsTo(Ensure.that(HCSWhyChooseUS).isDisplayed());
    }

    @And("user remembers the current doctors name")
    public void userRemembersTheCurrentDoctorsName() {
        String CurrentDoctorName=Serenity.getDriver().findElement(By.xpath("//h6[text()='Doctors']/../..//div[@class='slick-slide slick-active slick-current']//h5[contains(@class,'profile-header-title')]")).getText();
        user.remember("doctor name",CurrentDoctorName);
    }


    @Then("user verify Symptoms section")
    public void userVerifySymptomsSection() {

        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'wp-block-group hh-section')]/following::h2[text()='Symptoms']")).isDisplayed());
    }

    @Then("user verify Treatment section")
    public void userVerifyTreatmentSection() {

        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'wp-block-group hh-section')]/following::h2[text()='Treatment']")).isDisplayed());
    }

    @Then("user verify Doctors section")
    public void userVerifyDoctorsSection() {

        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'wp-block-group hh-section')]/following::h6[contains(text(),'Doctor to')]")).isDisplayed());
    }

    @Then("I see successful message pop up is displayed")
    public void iSeeSuccessfulMessagePopUpIsDisplayed() {
        user.attemptsTo(Ensure.that(Popup).isDisplayed());
    }
    @Then("user verify Testimonials section")
    public void userVerifyTestimonialsSection() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'healthcare-testimonial')]/descendant::h6[text()='Testimonials']")).isDisplayed());
    }
    @Then("user verify Testimonials cards are displayed")
    public void userVerifyTestimonialsCardsAreDisplayed() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'MuiBox-root')]/ancestor::div[contains(@class,'healthcare-testimonial')]")).isDisplayed());
    }

    @Then("user verify the first card in Testimonial section")
    public void userVerifyTheFirstCardInTestimonialSection() {
        user.wasAbleTo(Ensure.that(By.xpath("(//div[contains(@class,'MuiTypography-root')])[1]")).isDisplayed());
    }

    @Then("user clicks on forward button")
    public void userClicksOnForwardButton() {
        user.attemptsTo(Click.on(By.xpath("/html/body/main/div/div[1]/div/div/div[7]/div/div[2]/div/div[2]")));
    }

    @Then("user clicks on backward button")
    public void userClicksOnBackwardButton() {
        user.attemptsTo(Click.on(By.xpath("/html/body/main/div/div[1]/div/div/div[7]/div/div[2]/div/div[1]")));
    }

    @Then("user verify Why Choose Us section")
    public void userVerifyWhyChooseUsSection() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'wp-block-group hh-section')]/descendant::h2[contains(text(),'Why Choose Us')]")).isDisplayed());
    }

    @Then("user verify Why Choose Us cards are displayed")
    public void userVerifyWhyChooseUsCardsAreDisplayed() {
        user.wasAbleTo(Ensure.that(By.xpath("//div[contains(@class,'wp-block-group hh-section-why-choose-group')]")).isDisplayed());
    }

    @Then("user verify the each card in Why Choose Us section")
    public void userVerifyTheEachCardInWhyChooseUsSection() {
        user.wasAbleTo(Ensure.that(WCUFirstText).isDisplayed());
        user.wasAbleTo(Ensure.that(WCUFirstText).hasTextContent("1000+ Trusted Customer"));
        user.wasAbleTo(Ensure.that(WCUSecondText).isDisplayed());
        user.wasAbleTo(Ensure.that(WCUSecondText).hasTextContent("24/7 Access to Support"));
        user.wasAbleTo(Ensure.that(WCUThirdText).isDisplayed());
        user.wasAbleTo(Ensure.that(WCUThirdText).hasTextContent("200+ Experts"));
    }

    @Then("user verify Disclaimer section")
    public void userVerifyDisclaimerSection() {
        user.wasAbleTo(Ensure.that(By.xpath("//strong[contains(text(),'Disclaimer')]/ancestor::div[contains(@class,'MuiGrid-root MuiGrid-item')]")).isDisplayed());

    }

    @Then("user click on Back button again")
    public void userClickOnBackButtonAgain() {
        user.attemptsTo(ClickOn.BackButton());
    }
}

















