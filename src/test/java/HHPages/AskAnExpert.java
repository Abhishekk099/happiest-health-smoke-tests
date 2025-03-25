package HHPages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class AskAnExpert extends PageObject {


    public static Target AAELabelInPrimaryMenu = Target.the("Ask an Expert Label in Primary menu").
            locatedBy("//span[text()='Ask an Expert']");

    public static Target PostAQuery = Target.the("Post a Query Button").
            locatedBy("(//button[text()='Post a Query'])[1]");

    public static Target Specialty = Target.the("Specialty Dropdown").
            locatedBy("//div[@name='specialty']//input");
    public static Target Title = Target.the("Specialty Dropdown").
            locatedBy("//div[text()='Title']/..//div[text()='-- select one --']");
    public static Target InputFieldWithLabel = Target.the("{0} Field").
            locatedBy("//label[contains(text(),'{0}')]/..//input");
    public static Target QueryTextArea = Target.the("Query Text Area").
            locatedBy("//textarea[@name='query']");
    public static Target SubmitQuery = Target.the("Submit Query button").
            locatedBy("//button[text()='Submit Query']");
    public static Target MyQueries = Target.the("My Query Tab").
            locatedBy("#tab-tab-MyQueries");
    public static Target AnswerOfQuestion = Target.the("{0} Answer").
            locatedBy("//p[text()='{0}']/../../..//div[contains(@class,'answercontainer')]");
    public static Target SuccessPopUp = Target.the("Success Pop Up").
            locatedBy("//div[contains(@class,'successPopup_popup')]");
    public static Target SuccessPopUpAdminPortal = Target.the("Success Pop Up").
            locatedBy("//span[contains(text(),'Success')]");

    public static Target SelectAssigneeDropdownForGivenQuery = Target.the("Select Assignee Dropdown For '{0}' Query").
            locatedBy("//p[contains(text(),'{0}')]/../../../..//input");

    public static Target AssigneeButtonForGivenQuery = Target.the("Select Assignee Dropdown For '{0}' Query").
            locatedBy("//p[contains(text(),'{0}')]/../../../..//span[@type='button']");

    public static Target AddResponseButtonForGivenQuery = Target.the("Select Add response For '{0}' Query").
            locatedBy("//p[contains(text(),'{0}')]/../../../../../../..//span[text()='ADD RESPONSE']");

    public static Target RejectQueryButtonForGivenQuery = Target.the("Select Add response For '{0}' Query").
            locatedBy("//p[contains(text(),'{0}')]/../../../../../../..//span[text()='REJECT QUERY']");

    public static Target ReviewResponseButtonForGivenQuery = Target.the("Select Add response For '{0}' Query").
            locatedBy("//p[contains(text(),'{0}')]/../../../../../../..//span[text()='REVIEW RESPONSE']");
    public static Target PublishQueryViewDetails = Target.the("Select View Details For '{0}' Query").
            locatedBy("(//p[contains(text(),'{0}')]/../../../../..//span[text()='VIEW DETAILS'])[1]");
    public static Target ResponseTextbox = Target.the("Select Add response For '{0}' Query").
            locatedBy("//body[@id='tinymce']/p");

    public static Target SelectExpert = Target.the("Select Add response For '{0}' Query").
            locatedBy("//label[text()='Select/Enter Expert Name']/..//input[@placeholder='--select--']");
    public static Target SelectExpert2nd = Target.the("Select Add response For '{0}' Query").
            locatedBy("(//label[text()='Select/Enter Expert Name']/..//input[@placeholder='--select--'])[2]");
    public static Target ResponseSavedToasterMessage = Target.the("Response saved successfully toaster message").
            locatedBy("//div[text()='Response saved successfully']");

    public static Target ReassignToModerator = Target.the("Reassign to Moderator button").
            locatedBy("//button[text()='Reassign to Moderator']");
    public static Target ReassignToModeratorPopup = Target.the("Reassign to Moderator Pupup").
            locatedBy("//div[contains(@class,'responseControlPopup')]/h2");
    public static Target ModeratorNameInput = Target.the("ModeratorNameInput").
            locatedBy("//div[contains(@class,'responseControlPopup')]//input[1]");
    public static Target ReasonInput = Target.the("ReasonInput").
            locatedBy("(//div[contains(@class,'responseControlPopup')]//input)[2]");
    public static Target Proceedbutton = Target.the("Proceed button").
            locatedBy("(//div[contains(@class,'responseControlPopup')]//button)[5]");
    public static Target ReassignToModeratorConfirmationPopup = Target.the("ReassignToModeratorConfirmationPopup").
            locatedBy("//div[contains(@class,'confirmationPopup_popup')]");
    public static Target ReAssignButton = Target.the("Re Assign Button").
            locatedBy("//button[contains(@class,'confirmationPopup_submit')]");
    public static Target DeleteResponse = Target.the("Delete Response button").
            locatedBy("//button[text()='Delete Response']");
    public static Target DeleteResponseConfirmationPopup = Target.the("Delete Response Confirmation popup").
            locatedBy("//h2[contains(text(),'Delete')]/..");
    public static Target DeleteButton = Target.the("Delete button").
            locatedBy("//button[text()='Delete']");
    public static Target ResponseDeletedToasterMessage = Target.the("Response saved successfully toaster message").
            locatedBy("//div[text()='Response deleted successfully']");
    public static Target ResponseReassignedToasterMessage = Target.the("Response reassigned successfully toaster message").
            locatedBy("//div[text()='Response reassigned successfully']");
    public static Target QueryRevertedSuccessfullyToasterMessage = Target.the("Query reverted successfully toaster message").
            locatedBy("//div[text()='Query reverted successfully']");
    public static Target AddAnotherResponse = Target.the("Add Another Response button").
            locatedBy("//span[text()='Add Another Expert Response']");
    public static Target RejectQueryConfirmationPopup = Target.the("RejectQueryConfirmationPopup").
            locatedBy("//div[contains(@class,'quesAndAns_rejectPopup')]");
    public static Target RejectReasonSelector = Target.the("RejectReasonSelector").
            locatedBy("//div[text()='-- select one --']");
    public static Target RejectReasonValue = Target.the("RejectReasonValue").
            locatedBy("//li[text()='Irrelevant Query']");
    public static Target RejectQueryButton = Target.the("RejectQueryButton").
            locatedBy("//button[text()='REJECT QUERY']");
    public static Target QueryRejectedSuccessfullyToasterMessage = Target.the("Query rejected successfully toaster message").
            locatedBy("//div[text()='Query rejected successfully']");
    public static Target ExpertDetailsSavedSuccessfullyToasterMessage = Target.the("Expert details saved successfully toaster message").
            locatedBy("//div[text()='Expert details saved successfully']");
    public static Target ExpertdeactivatedsuccessfullyToasterMessage = Target.the("Expert deactivated successfully toaster message").
            locatedBy("//div[text()='Expert deactivated successfully']");

    public static Target RevertButtonInRejectQueryTabForGivenQuery = Target.the("Revert Button In Reject Query Tab For Given Query").
            locatedBy("(//p[contains(text(),'{0}')]/../../../../../../..//span[text()='REVERT'])[1]");
    public static Target ResponseReassignedWorningMessage = Target.the("Response Reassigned Worning Message").
            locatedBy("//div[text()='This response has already been reassigned to']");
    public static Target DeleteResponseReasonSelector = Target.the("Delete Response Reason Selector").
            locatedBy("//div[contains(@class,'responseControlPopup_popup')]//input");
    public static Target ProceedButtonindeleteresponseconfirmationpopup = Target.the("Proceed Button in delete response confirmation popup").
            locatedBy("(//div[contains(@class,'responseControlPopup_popup')]//button)[4]");
    public static Target BacktoPublishedQueries = Target.the("Back to Published Queries").
            locatedBy("//div[text()='Back to Published Queries']");
    public static Target ADDEXPERTPROFILEButton = Target.the("ADD EXPERT PROFILE Button").
            locatedBy("//span[text()='ADD EXPERT PROFILE']");
    public static Target EditOptionForUserWithMobileNo = Target.the("Edit Option For User With Mobile No {0}").
            locatedBy("//div[text()='{0}']/../.././/div[contains(@class,'actionsCell')]");
    public static Target QueryLogHistory = Target.the("Query Log History").
            locatedBy("//div[contains(@class,'viewPublishedResponse_querylog')]");
    public static Target EditResponseInPublishedQueryTab = Target.the("Edit Response In Published QueryTan").
            locatedBy("(//p[contains(text(),'{0}')]/../../../../..//span[text()='EDIT RESPONSE'])[1]");
    public static Target ExpertProfileHeader = Target.the("Expert Profile Header").
            locatedBy("//h2[text()='Experts Profiles']");
    public static Target AddExpertProfile = Target.the("Add Expert Profile").
            locatedBy("//h2[text()='Add Expert Profile']");
    public static Target EditProfile = Target.the("Edit Profile").
            locatedBy("//li[text()='Edit Profile']");
    public static Target ViewProfile = Target.the("View Profile").
            locatedBy("//li[text()='View Profile']");
    public static Target DeactivateProfile = Target.the("Deactivate Profile").
            locatedBy("//li[text()='Deactivate Profile']");
    public static Target RegistrationCouncilDetailsAddButton = Target.the("Registration Council Details Add Button").
            locatedBy("(//button[text()='ADD'])[1]");
    public static Target StartDateMonthField = Target.the("Start Date Month Field").
            locatedBy("(//label[contains(text(),'Start Date')]/..//button)[1]");
    public static Target StartDateYearField = Target.the("Start Date Year Field").
            locatedBy("(//label[contains(text(),'Start Date')]/..//button)[2]");
    public static Target EndDateMonthField = Target.the("End Date Month Field").
            locatedBy("(//label[contains(text(),'End Date')]/..//button)[1]");
    public static Target EndDateYearField = Target.the("End Date Year Field").
            locatedBy("(//label[contains(text(),'End Date')]/..//button)[2]");
    public static Target Button = Target.the("{0} Button").
            locatedBy("//button[text()='{0}']");
    public static Target ExperienceDetailsAddButton = Target.the("Experience Details Add Button").
            locatedBy("(//button[text()='ADD'])[2]");
    public static Target DocumentType = Target.the("DocumentType").
            locatedBy("(//label[contains(text(),'Document Type')]/..//div)[1]");
    public static Target UploadDetailsAddButton = Target.the("Experience Details Add Button").
            locatedBy("(//button[text()='ADD'])[3]");
    public static Target ExpertProfileDetails = Target.the("Expert Profile").
            locatedBy("//div[contains(@class,'quesAndAns_cardwrapper')]");
    public static Target EditExpertProfile = Target.the("Edit Expert Profile").
            locatedBy("//h2[text()='Edit Expert Profile']");
    public static Target SubmitForReviewButton = Target.the("Submit for review").
            locatedBy("(//button[text()='Submit for review'])[1]");
    public static Target SubmitForReviewButtonInConfirmationPopUp = Target.the("Submit for review").
            locatedBy("(//button[text()='Submit for review'])[2]");
    public static Target AdminProfileIcon = Target.the("Admin Profile Icon").
            locatedBy("(//button[@id='dropdown-basic'])[1]");
    public static Target SwitchApplicationIcon = Target.the("Switch Application Icon").
            locatedBy("(//button[@id='dropdown-basic'])[2]");
    public static Target PatientEngagementSystem = Target.the("Patient Engagement System").
            locatedBy("//a[text()='Patient Engagement System']");
}
