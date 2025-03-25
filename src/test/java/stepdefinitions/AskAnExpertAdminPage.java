package stepdefinitions;


import Actions.ClickOn;
import Actions.EnterValueInto;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static HHPages.AskAnExpert.*;

public class AskAnExpertAdminPage {
    Actor user = MyCast.user();
    String  phno;
    @Given("User has launched Admin URL")
    public void userHasLaunchedAdminURL(){
        new CommonUtils().maximizeTheWindow();
        user.attemptsTo(NavigateTo.theHHAAEAdminPage());
    }

    @And("User click on Ask an Expert tab")
    public void userClickOnAskAnExpertTab() {
        user.attemptsTo(ClickOn.AskAnExpertTab());
    }

    @And("User click on Expert Profiles tab")
    public void userClickOnExpertProfilesTab() {
        user.attemptsTo(ClickOn.ExpertProfilesTab());
    }

    @And("User clicks on Select Assignee for given {string}")
    public void userClicksOnSelectAssigneeForGiven(String query) {
        user.attemptsTo(ClickOn.selectAssigneeDropdownForGivenQuery(query));
    }


    @And("User selects {string} and click on Assign button for {string}")
    public void userSelectsAndClickOnAssignButtonFor(String moderator, String query) {
        user.attemptsTo(EnterValueInto.AssigneeAndHitEnter(moderator,query));
        user.attemptsTo(ClickOn.AssigneeButtonForGivenQuery(query));
    }

    @And("User Verify Success message is displayed")
    public void userVerifySuccessMessageIsDisplayed() {
        //user.attemptsTo(Ensure.that(SuccessPopUpAdminPortal).isDisplayed());
    }

    @And("User click on add response for the given {string}")
    public void userClickOnAddResponseForTheGiven(String query) {
        user.attemptsTo(ClickOn.AddResponseButtonForGivenQuery(query));
    }

    @And("User click on Reject Query for the given {string}")
    public void userClickOnRejectQueryForTheGiven(String query) {
        user.attemptsTo(ClickOn.RejectQueryButtonForGivenQuery(query));
    }

    @And("waitt")
    public void waitt() throws InterruptedException {
        Thread.sleep(500000);
    }

    @And("User clicks on Response textbox And Add Response")
    public void userClicksOnResponseTextboxAndAddResponse() {
        user.attemptsTo(EnterValueInto.switchToFrame("#responseDetails_0_ifr"));
        user.attemptsTo(EnterValueInto.responseTextbox("This is a test response added by automation script"));
        user.wasAbleTo(EnterValueInto.switchToDefaultFrame());
    }


    @And("User clicks on Select {string} in Expert dropdown")
    public void userClicksOnSelectInExpertDropdown(String expert) {
        user.attemptsTo(EnterValueInto.SelectExpertAndHitEnter(expert));
    }

    @And("User click on {string} tab from Secondary Menu")
    public void userClickOnTabFrom(String tab) {
        user.attemptsTo(ClickOn.tabFromSecondaryMenu(tab));

    }

    @And("User click on review response for the given {string}")
    public void userClickOnReviewResponseForTheGiven(String query) {
        user.attemptsTo(ClickOn.ReviewResponseButtonForGivenQuery(query));
    }

    @And("User Logout of the admin portal")
    public void userLogoutOfTheAdminPortal() {
        user.attemptsTo(ClickOn.ProfileIcon());
        user.attemptsTo(ClickOn.LogoutAdminPortal());
    }

    @And("User clicks on Publish Response button in confirmation popup")
    public void userClicksOnPublishResponseButtonInConfirmationPopup() throws InterruptedException {
        user.attemptsTo(ClickOn.PublishResponseButtonINConfirmationPopUp());
        try{
            Serenity.getDriver().findElement(By.xpath("//button[text()='Yes']")).click();
        } catch (Exception e) {

        }
    }

    @Then("Verify user can see response drafted successfully toast message")
    public void verifyUserCanSeeResponseDraftedSuccessfullyToastMessage() throws InterruptedException {

        if(ResponseSavedToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(ResponseSavedToasterMessage).isDisplayed());
        }else{

        }

    }

    @Then("User click on filter")
    public void userClickOnFilter() {
        user.attemptsTo(ClickOn.FiltersButton());
    }

    @Then("User click on filter in assigned tab")
    public void userClickOnFilterInAssignedTab() {
        user.attemptsTo(ClickOn.FiltersButtoninAssignedTab());
    }

    @And("Select status as drafted")
    public void selectStatusAsDrafted() {
        user.attemptsTo(ClickOn.Status());
        user.attemptsTo(ClickOn.Drafted());


    }

    @Then("Verify user is able to see drafted {string}")
    public void verifyUserIsAbleToSeeDrafted(String query) {
        user.attemptsTo(Ensure.that(AddResponseButtonForGivenQuery.of(query)).isDisplayed());
    }

    @Then("Verify user is able to see drafted {string} in published tab")
    public void verifyUserIsAbleToSeeDraftedInPublishedTab(String query) {
        user.attemptsTo(Ensure.that(EditResponseInPublishedQueryTab.of(query)).isDisplayed());
    }
    @Then("Verify user can view reassign to moderator and delete options in add response page")
    public void verifyUserCanViewReassignToModeratorAndDeleteOptionsInAddResponsePage() {
        user.attemptsTo(Ensure.that(ReassignToModerator).isDisplayed());
        user.attemptsTo(Ensure.that(DeleteResponse).isDisplayed());
    }

    @Then("User click on delete option and able to view delete popup window")
    public void userClickOnDeleteOptionAndAbleToViewDeletePopupWindow() {
        user.attemptsTo(ClickOn.DeleteResponse());
        user.attemptsTo(Ensure.that(DeleteResponseConfirmationPopup).isDisplayed());
    }

    @Then("User click on  delete option in delete popup window")
    public void userClickOnDeleteOptionInDeletePopupWindow() {
        user.attemptsTo(ClickOn.DeleteButton());

    }

    @Then("verify editor able to see response deleted successfully toast message and query remains open query tab")
    public void verifyEditorAbleToSeeResponseDeletedSuccessfullyToastMessageAndQueryRemainsOpenQueryTab() throws InterruptedException {
        Ensure.enableSoftAssertions();
        if(ResponseDeletedToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(ResponseDeletedToasterMessage).isDisplayed());
        }else{
            Thread.sleep(1000);
            user.attemptsTo(Ensure.that(ResponseDeletedToasterMessage).isDisplayed());
        }
        Ensure.reportSoftAssertions();

    }

    @Then("User click on reassign to moderator option")
    public void userClickOnReassignToModeratorOption() {
        user.attemptsTo(ClickOn.ReassignToModerator());
    }

    @And("User is able to view reassign to moderator popup window")
    public void userIsAbleToViewReassignToModeratorPopupWindow(){
        user.attemptsTo(Ensure.that(ReassignToModeratorPopup).isDisplayed());
    }

    @Then("User select  {string} name and reasons  in reassign to modeartor popup window")
    public void userSelectNameAndReasonsInReassignToModeartorPopupWindow(String moderator) throws InterruptedException {
       user.attemptsTo(EnterValueInto.ModeratorNameInput(moderator));
       user.attemptsTo(EnterValueInto.ReasonInput("More information requested"));

    }

    @When("User click on proceed button")
    public void userClickOnProceedButton() throws InterruptedException {
        user.attemptsTo(ClickOn.Proceedbutton());
    }

    @And("Verify user gets reassign to moderator poup window")
    public void verifyUserGetsReassignToModeratorPoupWindow() throws InterruptedException {
        user.attemptsTo(Ensure.that(ReassignToModeratorConfirmationPopup).isDisplayed());
    }

    @When("User click on reassign button")
    public void userClickOnReassignButton() {
        user.attemptsTo(ClickOn.ReAssignButton());
    }

    @Then("Verify editor able to see response reassign to moderator  successfully toast message")
    public void verifyEditorAbleToSeeResponseReassignToModeratorSuccessfullyToastMessageAndQueryWillMoveToAssignedQueriesTab() throws InterruptedException {
        Ensure.enableSoftAssertions();
        if(ResponseReassignedToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(ResponseReassignedToasterMessage).isDisplayed());
        }else{
            Thread.sleep(1000);
            user.attemptsTo(Ensure.that(ResponseReassignedToasterMessage).isDisplayed());
        }
        Ensure.reportSoftAssertions();
    }


    @Then("verify editor able to view {int}nd response list and able add  successfully .")
    public void verifyEditorAbleToViewNdResponseListAndAbleAddSuccessfully(int arg0) throws InterruptedException {
        user.attemptsTo(ClickOn.AddAnotherResponse());
    }

    @Then("User clicks on {int}nd Response textbox And Add Response")
    public void userClicksOnNdResponseTextboxAndAddResponse(int arg0) {
        user.attemptsTo(EnterValueInto.switchToFrame("#responseDetails_1_ifr"));
        user.attemptsTo(EnterValueInto.responseTextbox("This is a test response from automation"));
        user.wasAbleTo(EnterValueInto.switchToDefaultFrame());
    }

    @And("User clicks on Select {string} in second Expert dropdown")
    public void userClicksOnSelectInNdExpertDropdown(String expert) {
        user.attemptsTo(EnterValueInto.SelectExpertSecondAndHitEnter(expert));
    }

    @Then("Verify user can view reject query popup window")
    public void verifyUserCanViewRejectQueryPopupWindow() {
        user.attemptsTo(Ensure.that(RejectQueryConfirmationPopup).isDisplayed());
    }

    @When("User select any one reason form Reason dropdown")
    public void userSelectAnyOneReasonFormReasonDropdown() {
        user.attemptsTo(ClickOn.RejectReasonSelector());
        user.attemptsTo(ClickOn.RejectReasonValue());
    }

    @When("User click on reject query button from reject query popup window")
    public void userClickOnRejectQueryButtonFromRejectQueryPopupWindow() {
        user.attemptsTo(ClickOn.RejectQueryButton());
    }

    @Then("Verify user is able to view query rejected successfully toast message")
    public void verifyUserIsAbleToViewQueryRejectedSuccessfullyToastMessage() throws InterruptedException {
        Ensure.enableSoftAssertions();
        if(QueryRejectedSuccessfullyToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(QueryRejectedSuccessfullyToasterMessage).isDisplayed());
        }else{
            Thread.sleep(1000);
            user.attemptsTo(Ensure.that(QueryRejectedSuccessfullyToasterMessage).isDisplayed());
        }
        Ensure.reportSoftAssertions();
    }

    @And("Verify {string} is present in Rejected Queries tab")
    public void verifyIsPresentInRejectedQueriesTab(String query) {
        user.attemptsTo(Ensure.that(RevertButtonInRejectQueryTabForGivenQuery.of(query)).isDisplayed());
    }

    @When("Verify This response has already been reassigned to one moderator warning message in reassign to moderator poup window")
    public void verifyThisResponseHasAlreadyBeenReassignedToOneModeratorWarningMessageInReassignToModeratorPoupWindow() {
    user.attemptsTo(Ensure.that(ResponseReassignedWorningMessage).isDisplayed());
    }

    @Then("User selects the Reason value as {string}")
    public void userSelectsTheReasonValueAs(String reason) {
        user.attemptsTo(EnterValueInto.DeleteResponseReasonSelector(reason));
    }

    @Then("User Clicks on Proceed Button in delete response confirmation popup")
    public void userClicksOnProceedButtonInDeleteResponseConfirmationPopup() {
        user.attemptsTo(ClickOn.ProceedButtonindeleteresponseconfirmationpopup());
    }

    @And("User click on view details for the given {string} in published query tab")
    public void userClickOnViewDetailsForTheGivenInPublishedQueryTab(String query) {
        user.attemptsTo(ClickOn.PublishQueryViewDetails(query));
    }

    @And("User Verify Query log history is present")
    public void userVerifyQueryLogHistoryIsPresent() {
        user.attemptsTo(Ensure.that(QueryLogHistory).isDisplayed());
    }

    @When("User click on edit repose button in published query tab for the given {string}")
    public void userClickOnEditReposeButtonInPublishedQueryTab(String query) {
        user.attemptsTo(ClickOn.EditResponseInPublishedQueryTab(query));
    }

    @Then("User click on Back to Published Queries")
    public void userClickOnBackToPublishedQueries() {
        user.attemptsTo(ClickOn.BacktoPublishedQueries());
    }

    @Then("User click on filter in published tab")
    public void userClickOnFilterInPublishedTab() {
        user.attemptsTo(ClickOn.FiltersButtonInPublishedTab());
    }

    @When("User click on revert button for rejected {string}")
    public void userClickOnRevertButtonForRejected(String query) {
        user.attemptsTo(ClickOn.RevertButtonInRejectQueryTabForGivenQuery(query));
    }

    @Then("Verify editor can view query reverts successfully toast message and query will move to open queries")
    public void verifyEditorCanViewQueryRevertsSuccessfullyToastMessageAndQueryWillMoveToOpenQueries() throws InterruptedException {
        Ensure.enableSoftAssertions();
        if(QueryRevertedSuccessfullyToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(QueryRevertedSuccessfullyToasterMessage).isDisplayed());
        }else {
            Thread.sleep(1000);
            user.attemptsTo(Ensure.that(QueryRevertedSuccessfullyToasterMessage).isDisplayed());
        }
        Ensure.reportSoftAssertions();
    }

    @Then("verify user is navigating to expert profile list view")
    public void verifyUserIsNavigatingToExpertProfileListView() {
        user.attemptsTo(Ensure.that(ExpertProfileHeader).isDisplayed());
    }

    @Then("User able to see add expert profile page")
    public void userAbleToSeeAddExpertProfilePage() {
        user.attemptsTo(Ensure.that(AddExpertProfile).isDisplayed());
    }

    @When("User clicks on ADD EXPERT PROFILE button")
    public void userClicksOnADDEXPERTPROFILEButton() {
        user.attemptsTo(ClickOn.ADDEXPERTPROFILEButton());
    }

    @And("User select title as Dr.")
    public void userSelectTitleAsDr() {
        user.attemptsTo(ClickOn.theGivenField(Title));
        Actions act=new Actions(Serenity.getDriver());
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
                act.sendKeys(Keys.ENTER).perform();
    }

    @Then("User enter full name and email or mobile number")
    public void userEnterFullNameAndEmailOrMobileNumber() {
        int randomNum = 10000 + (int)(Math.random() * 10000);
        phno = "81471"+Integer.toString(randomNum);
        String eMail = phno+"@gm.com";
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Test","First Name"));
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("User","Last Name"));
        user.attemptsTo(EnterValueInto.InputFieldWithLabel(eMail,"Email ID"));
        user.attemptsTo(EnterValueInto.InputFieldWithLabel(phno,"Mobile Number"));
    }

    @Then("Verify user is able to view expert details saved Successfully toast message")
    public void verifyUserIsAbleToViewExpertDetailsSavedSuccessfullyToastMessage() throws InterruptedException {
        Ensure.enableSoftAssertions();
        if(ExpertDetailsSavedSuccessfullyToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(ExpertDetailsSavedSuccessfullyToasterMessage).isDisplayed());
        }else{}
        Ensure.reportSoftAssertions();
    }


    @When("User click on action button for saved user")
    public void userClickOnActionButtonForSavedUser() {
        user.attemptsTo(ClickOn.EditOptionForUserWithMobileNo(phno));
    }

    @And("User clicks on Edit Profile")
    public void userClicksOnEditProfile() {
        user.attemptsTo(ClickOn.EditProfile());
    }

    @And("User clicks on View Profile")
    public void userClicksOnViewProfile() {
        user.attemptsTo(ClickOn.ViewProfile());
    }

    @And("User clicks on Deactivate Profile")
    public void userClicksOnDeactivateProfile() {
        user.attemptsTo(ClickOn.DeactivateProfile());
    }

    @And("User Upload file supporting Affiliation Details")
    public void userUploadFileSupportingAffiliationDetails() {
        WebElement uploadfile = Serenity.getDriver().findElement(By.xpath("(//input[@type='file'])[2]"));
        File file=new File("./test.png");
        System.out.println(file.getAbsolutePath());
        uploadfile.sendKeys(file.getAbsolutePath());

    }

    @And("User Enters About data")
    public void userEntersAboutData() {
        user.attemptsTo(EnterValueInto.switchToFrame("#tiny_ifr"));
        user.attemptsTo(EnterValueInto.responseTextbox("This is a test account created for testing"));
        user.wasAbleTo(EnterValueInto.switchToDefaultFrame());

    }

    @And("User enters Location data")
    public void userEntersLocationData() {
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Bangalore","Location"));
    }

    @Then("User Adds Registration Number and Council")
    public void userAddsRegistrationNumberAndCouncil() {
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("123123411","Registration Number"));
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Chandigarh Medical Council","Registration Council"));
        user.attemptsTo(ClickOn.theGivenField(RegistrationCouncilDetailsAddButton));
    }

    @Then("User enters Hospital data")
    public void userEntersHospitalData() {
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Andhra Pradesh State Dental Council","Hospital/Organization"));
    }

    @And("User Adds Start Date and End Date value")
    public void userAddsStartDateAndEndDateValue() {
        user.attemptsTo(ClickOn.theGivenField(StartDateMonthField));
        user.attemptsTo(ClickOn.theGivenField(Button.of("Jan")));
        user.attemptsTo(ClickOn.theGivenField(StartDateYearField));
        user.attemptsTo(ClickOn.theGivenField(Button.of("2016")));
        user.attemptsTo(ClickOn.theGivenField(EndDateMonthField));
        user.attemptsTo(ClickOn.theGivenField(Button.of("Jan")));
        user.attemptsTo(ClickOn.theGivenField(EndDateYearField));
        user.attemptsTo(ClickOn.theGivenField(Button.of("2024")));
        user.attemptsTo(ClickOn.theGivenField(ExperienceDetailsAddButton));

    }

    @And("User Adds Document Type and Name")
    public void userAddsDocumentTypeAndName() {
        user.attemptsTo(ClickOn.theGivenField(DocumentType));
        Actions act=new Actions(Serenity.getDriver());
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Test Document Name","Document Name"));

    }

    @And("User adds description and click on add button")
    public void userAddsDescriptionAndClickOnAddButton() {
        user.attemptsTo(EnterValueInto.InputFieldWithLabel("Test Description","Description"));
        user.attemptsTo(ClickOn.theGivenField(UploadDetailsAddButton));
    }

    @And("User verify Profile detail page is displayed")
    public void userVerifyProfileDetailPageIsDisplayed() {
        user.attemptsTo(Ensure.that(ExpertProfileDetails).isDisplayed());
    }

    @And("User verify edit expert profile page is loaded")
    public void userVerifyEditExpertProfilePageIsLoaded() {
        user.attemptsTo(Ensure.that(EditExpertProfile).isDisplayed());
    }

    @And("Verify user is able to view expert profile deactivated Successfully toast message")
    public void verifyUserIsAbleToViewExpertProfileDeactivatedSuccessfullyToastMessage() {
        Ensure.enableSoftAssertions();
        if(ExpertdeactivatedsuccessfullyToasterMessage.isVisibleFor(user)) {
            user.attemptsTo(Ensure.that(ExpertdeactivatedsuccessfullyToasterMessage).isDisplayed());
        }else{

        }
        Ensure.reportSoftAssertions();
    }

    @And("User clicks on Submit for Review button")
    public void userClicksOnSubmitForReviewButton() {
        user.attemptsTo(ClickOn.theGivenField(SubmitForReviewButton));
    }

    @And("User clicks on Submit for review button in confirmation popup")
    public void userClicksOnSubmitForReviewButtonInConfirmationPopup() {
        user.attemptsTo(ClickOn.theGivenField(SubmitForReviewButtonInConfirmationPopUp));
    }

    @And("User clicks on admin profile section")
    public void userClicksOnAdminProfileSection() {
        user.attemptsTo(ClickOn.theGivenField(AdminProfileIcon));
    }

    @And("User Change Application to Patient Engagement System")
    public void userChangeApplicationToPatientEngagementSystem() {
        user.attemptsTo(ClickOn.theGivenField(SwitchApplicationIcon));
        user.attemptsTo(ClickOn.theGivenField(PatientEngagementSystem));
    }


}
