package HHPages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HealthCarePage extends PageObject {
    public static Target HealthCarePageTiles = Target.the("{0} In Home Page Tiles").locatedBy
            ("//h6[text()='{0}']");
    public static Target Healthcare = Target.the(" In Home Page Tiles").locatedBy("//div[contains(@class,'MuiListItemText-root')]/following::span[text()='Healthcare']");
    public static Target DoctorSectionBelowService = Target.the(" doctor section with reference to service").locatedBy("//h6[text()='Services']/../../../following-sibling::*//h6[text()='Doctors']");
    public static Target DoctorImage = Target.the(" doctor image").locatedBy("(//h6[text()='Doctors']/../..//img)[1]");
    public static Target DoctorName = Target.the(" doctor name").locatedBy("(//h6[text()='Doctors']/../..//h5[contains(@class,'profile-header-title')])[1]");
    public static Target DoctorQualification =Target.the("doctor qualification").locatedBy("(//h6[text()='Doctors']/../..//h6[contains(@class,'profile-sub-header')])[1]");
    public static Target DoctorSpeciality =Target.the("Doctor Speciality").locatedBy("(//h6[text()='Doctors']/../..//p[contains(@class,'splitList-title')]/following-sibling::p)[1]");
    public static Target DoctorLocation =Target.the("Doctors Location").locatedBy("(//h6[text()='Doctors']/../..//p[contains(@class,'list-title')]/following-sibling::ul)[1]");
    public static Target BookAnAppointmentButton =Target.the("Book An Appointment Button").locatedBy("(//span[contains(@class,'MuiTouchRipple-root')]/ancestor::div[contains(@class,'floating-btn-container MuiBox-root')]/descendant::span[contains(@class,'btn-label')])[2]");
    public static Target DoctorsCarouselButton = Target.the("Doctors Carousel Button").locatedBy("(//h6[text()='Doctors']/../../..//following-sibling::*//li/button)[2]");
    public static Target CurrentDoctorCard = Target.the("Current doctor card").locatedBy("slick-slide slick-active slick-current");
    public static Target ViewAllLink = Target.the(" view all").locatedBy("//h6[text()='Doctors']/..//p[text()='View All']");
    public static Target DoctorListingSection = Target.the(" doctor listing").locatedBy("/html/body/main/div/div[1]/div/nav/parent::div");
    public static Target card = Target.the(" doctor card").locatedBy("/html/body/main/div/div[2]/div/div/div[3]/div/div[2]/div[1]/div");
    public static Target DoctorDetailSection = Target.the("doctor detail section").locatedBy("/html/body/main/div/div[1]/div");
    public static Target Book = Target.the("book appointment").locatedBy("/html/body/main/div/div[2]/div/div/div[2]/div/div[2]/button");

    public static Target Services = Target.the("Services Text").locatedBy("//div[contains(@class,'healthcare-homepage-services')]/descendant::h6[text()='Services']");
    public static Target ViewAllButton = Target.the("View All Button").locatedBy("//h6[contains(text(),'Services')]/following::a[@href='/healthcare/services']");
    public static Target ServicesViewDetails = Target.the("View Details button").locatedBy("(//button[text()='View Details'])[1]");


    public static Target BAA = Target.the("ban").locatedBy("(//div[contains(@class,'button MuiBox-roo')]/descendant::button[text()='Book an Appointment'])[1]");
    public static Target FirstName = Target.the("firstname").locatedBy("//input[@type = 'text' and @name='firstName']");
    public static Target EmptyFirstNameField = Target.the("Empty First Name").locatedBy("//input[@placeholder='Patient First Name']");
    public static Target LastName = Target.the("Last name").locatedBy("//input[@type = 'text' and @name='lastName']");
    public static Target EmptyLastNameField = Target.the("Empty Last Name").locatedBy("//input[@placeholder='Patient Last Name']");
    public static Target MobileNumber = Target.the("mobile number").locatedBy("//input[@type = 'text' and @name='mobileNumber']");
    public static Target EmptyMobileNumber = Target.the("Empty Mobile Number").locatedBy("//input[@placeholder= 'Mobile Number']");
    public static Target Backarrow = Target.the("Back Arrow").locatedBy("//a[text()='Back']/parent::div//*[local-name()='path']");
    public static Target Back = Target.the("Back button").locatedBy("//a[text()='Back']");
    public static Target Term = Target.the("privacy term").locatedBy("//span[text()='I accept the ']");
    public static Target WhatsAPP = Target.the("Update by whats app").locatedBy("//span[text()='I want to receive the updates through WhatsApp.']");
    public static Target ProccedDisabled = Target.the("Proceed button is disabled").locatedBy("//button[text()='Proceed']");
    public static Target BackButton = Target.the("Click on Back Button").locatedBy("//a[text()='Back']/ancestor::div[contains(@class,'wp-block-group')]");
    public static Target NoErrorMessage = Target.the("No error message is displayed").locatedBy("//p[text()='Please enter a valid 10 digit mobile number']");
    public static Target ProceedButtonis = Target.the("proceed button is enabled").locatedBy("//button[text()='Proceed']");
    public static String Checkboxforaccept = "//input[@name='termsAccepted']";
    public static String CheckboxforWhatsApp ="//input[@name='whatsAppEnabled']";
    public static Target proccedButton = Target.the("click on proceed button").locatedBy("//button[text()='Proceed']");
    public static Target OTPText = Target.the("enter otp text is displayed ").locatedBy("//label[text()='Enter OTP']");
    public static Target Cancel = Target.the("cancel text").locatedBy("//button[text()='Cancel']");
    public static Target Submit =Target.the("Submit text").locatedBy("//button[text()='Submit OTP']");
    public static Target BackForm = Target.the("back to previous form").locatedBy("/html/body/main/div/div[1]/div/div/div/div");
    public static Target Breadcrumbs =Target.the("breadcrumb is displayed").locatedBy("//nav[@aria-label='breadcrumb']");
    public static Target BannerSection = Target.the("Banner section is displayed").locatedBy("(//div[contains(@class,'slick-slider')])[1]");
    public static Target BannerTitle = Target.the("Banner title is displayed").locatedBy("(//div[contains(@class,'slick-slider')])[1]");
    public static Target FAQSection = Target.the("FAQ section is displayed").locatedBy("//h6[text()='Healthcare Services - FAQ']");
    public static  Target Popup = Target.the("sucessfull popup form").locatedBy("//p[text()='Your request for book an appointment is submitted successfully!!!']");
    public static  Target HCSWhyChooseUS = Target.the("Why choose us").locatedBy("//h2[text()='Why Choose Us?']");

    public static Target WCUFirstText = Target.the("WCU first text").locatedBy("//div[contains(@class,'wp-block-group')]/following::h2[contains(text(),'Trusted Customer')]");
    public static Target WCUSecondText = Target.the("WCU second text").locatedBy("//div[contains(@class,'wp-block-group')]/following::h2[contains(text(),'Access to Support')]");
    public static Target WCUThirdText = Target.the("WCU third text").locatedBy("//div[contains(@class,'wp-block-group')]/following::h2[contains(text(),'Experts')]");

}
