package HHPages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:AAEAdmin")
public class HHAAEAdminLaunchPage extends PageObject {
    public static Target AskAnExpertTab = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//a[text()='Ask an Expert']");
    public static Target ExpertProfilesTab = Target.the("SummitSectionWithReferenceToWebStories").locatedBy
            ("//a[text()='Expert Profiles']");
    public static Target TabFromSecondaryMenu = Target.the("{0} Tab From Secondary Menu").locatedBy
            ("//button[contains(text(),'{0}')]");

    public static Target ProfileIconAdminPortal = Target.the("Profile Icon").locatedBy
            ("//button[@id='dropdown-basic']");

    public static Target LogoutAdminPortal = Target.the("Logout").locatedBy
            ("//a[text()='Logout']");

    public static Target PublishResponseButtonINConfirmationPopUp = Target.the("Publish Response Button IN Confirmation PopUp").locatedBy
            ("//div[contains(@class,'confirmationPopup_button')]//button[text()='Publish Response']");
    public static Target FiltersButton = Target.the("Filters Button").locatedBy
            ("(//button[contains(@class,'filterbtn')]/span[text()='Filters'])[1]");
    public static Target FiltersButtonInAssignedTab = Target.the("Filters ButtoninAssigned Tab").locatedBy
            ("(//button[contains(@class,'filterbtn')]/span[text()='Filters'])[2]");
    public static Target Status = Target.the("Status").locatedBy
            ("//li[text()='Status']");
    public static Target Drafted = Target.the("Drafted").locatedBy
            ("//span[text()='Drafted']");

    public static Target FiltersButtonInPublishedTab = Target.the("Filters ButtoninAssigned Tab").locatedBy
            ("(//button[contains(@class,'filterbtn')]/span[text()='Filters'])[4]");


}
