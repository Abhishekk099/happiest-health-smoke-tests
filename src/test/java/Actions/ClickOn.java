package Actions;


import CMSPages.CMSArticlePage;
import CMSPages.CMSHomePage;
import HHPages.HHLandingPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static CMSPages.CMSArticlePage.InputboxWithLabel;
import static CMSPages.CMSHomePage.*;
import static CMSPages.CommonObjects.*;
import static HHPages.ArticlePage.ArticleWithArticleName;
import static HHPages.AskAnExpert.*;
import static HHPages.CommonObjects.RadioButtonWithName;
import static HHPages.DiagnosticPage.*;
import static HHPages.HHAAEAdminLaunchPage.*;
import static HHPages.HHAskanExpertpage.*;
import static HHPages.HHEvolutionPage.*;
import static HHPages.HHLandingPage.*;
import static HHPages.HHVideoPage.*;
import static HHPages.HealthCarePage.*;
import static HHPages.HealthzineSubPopUp.IAcceptCheckbox;
import static HHPages.ProfilePage.ProfileSection;
import static Utils.CommonUtils.ButtonWithButtonName;


public class ClickOn extends PageObject {

    public static Performable viewPhotoGallery(){
        return Task.where("Clicks on the view Photo Gallery ",
                Click.on(ViewPhotoGallery));

    }
    public static Performable theLinkInPrimaryMenu(String menuValue){
        return Task.where("Clicks on the {0} Link ",
                Click.on(TabsInMenu.of(menuValue)));
    }
    public static Performable theLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(LanguageDropDown));
    }

    public static Performable hindiInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(HindiInLanguageDropDown));
    }
    public static Performable banglaInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(BanglaInLanguageDropDown));
    }
    public static Performable kanadaInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(KanadaInLanguageDropDown));
    }
    public static Performable teluguInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(TeluguInLanguageDropDown));
    }
    public static Performable malayalamInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(MalayalamInLanguageDropDown));
    }
    public static Performable gujratiInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(GujratiInLanguageDropDown));
    }
    public static Performable marathiInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(MarathiInLanguageDropDown));
    }
    public static Performable tamilInLanguageDropDown(){
        return Task.where("Clicks on the Language Drop Down Link ",
                Click.on(TamilInLanguageDropDown));
    }

    public static Performable theLinkInMenuBar(String menuValue){
        return Task.where("Clicks on the {0} Link ",
                Click.on(HHLandingPage.LinkWithTextInMenuBar.of(menuValue)));
    }

    public static Performable firstVideoInListingPage(){
        return Task.where("Clicks on the view Photo Gallery ",
                Click.on(FirstVideo));

    }

    public static Performable theLinkInsecondaryMenuBar(String menuValue){
        return Task.where("{0} clicks on the Article Link ",
                Click.on(HHLandingPage.LinkInsecondaryMenuBar.of(menuValue)));
    }

    public static Performable theLinkPrimaryMenuBar(String menuValue){
        return Task.where("{0} clicks on the Article Link ",
                Click.on(HHLandingPage.LinkPrimaryMenuBar.of(menuValue)));
    }

    public static Performable HHLogo() {
        return Task.where("{0} clicks on the Article Link ",
                Click.on(HHLogo));
    }

    public static Performable IAcceptCheckbox() {
        return Task.where("{0} clicks on the Article Link ",
                Click.on(IAcceptCheckbox));
    }


    public static Performable wellnessProgrammesViewAll() {
        return Task.where("{0} clicks on the Wellness Programmes View All",
                Click.on(WellnessProgrammesViewAll));
    }

    public static Performable healthChampionsViewAll() {
        return Task.where("{0} clicks on the Wellness Programmes View All",
                Click.on(HealthChampionsViewAll));
    }


    public static Performable searchIcon(){
        return Task.where("{0} clicks on the search icon ",
                Click.on(searchIcon));
    }

    public static Performable contentViewAll(String content){
        return Task.where("{0} clicks on the " + content + " view all" ,
                Click.on(contentViewAll.of(content)));
    }

    public static Performable theLinkInPrimaryNavBar(String title) {
        return Task.where("{0} clicks on the " + title + " in primary nav bar",
                Click.on(LinkInPrimaryMenuBar.of(title)));
    }

    public static Performable podcastViewAll() {
        return Task.where("{0} clicks on the podcast view all",
                Click.on(PodcastViewAll));
    }

    public static Performable videosViewAll() {
        return Task.where("{0} clicks on the podcast view all",
                Click.on(VideosViewAll));
    }

    public static Performable notificationIcon() {
        return Task.where("{0} clicks on the NotificationIcon ",
                Click.on(NotificationIcon));

    }

    public static Performable profileSection(){
        return Task.where("{0} clicks on profile section",Click.on(ProfileSection));
    }

    public static Performable radioButtonWithName(String name){
        return Task.where("User clicks on radio button with {0} name",Click.on(RadioButtonWithName.of(name)));
    }

    public static Performable todayHealthzine(){
        return Task.where("User clicks on today healthzine",Click.on(ReadTodayHealthzine));
    }

    public static Performable thisFooterLink(String link){
        return Task.where("User clicks on " + link + " footer link",Click.on(footerLink.of(link)));
    }

    public static Performable ShareYourStory() {
        return Task.where("User clicks on Share Your Story Button",
                Click.on(ShareYourStoryWithReferenceToHealthChampion));
    }

    public static Performable summitTabs(String tabValue){
        return Task.where("User clicks on "+tabValue+" Tab",
                Click.on(SummitTabs.of(tabValue)));
    }

    public static Performable summitShortDescription() {
        return Task.where("User clicks on summit Short Description",
                Click.on(SummitShortDescription));
    }

    public static Performable theFirstWebStory(){
        return Task.where("Clicks on the First WebStory ",
                Click.on(FirstWebStory));
    }

    public static Performable clickonaskanexpertFirstcard() {
        return Task.where("User clicks on Ask An Expert Card",
                Click.on(askAnExpertfirstcard));
    }
    public static Performable clickonaskanexpertSecondcard() {
        return Task.where("User clicks on Ask An Expert Card",
                Click.on(askAnExpertSecondCardcard));
    }

    public static Performable askAnExpertViewAll() {
        return Task.where("{0} clicks on the Ask an Expert View All",
                Click.on(AskanExpertViewAll));
    }

    public static Performable SearchByTestsOrCheckups() {
        return Task.where("{0} clicks on the Search By Tests Or Checkups",
                Click.on(SearchByTestsOrCheckups));
    }

    public static Performable BuyNowButton() {
        return Task.where("{0} clicks on the Search By Tests Or Checkups",
                Click.on(BuyNowButton));
    }

    public static Performable AddToCartButton() {
        return Task.where("{0} clicks on the Search By Tests Or Checkups",
                Click.on(AddToCartButton));
    }

    public static Performable DiagnosticsSearchBoxBackButton() {
        return Task.where("{0} Diagnostics Search Box Back Button",
                Click.on(DiagnosticsSearchBoxBackButton));
    }
    public static Performable ClickOnDiagnostic(){
        return Task.where("{0} clicks on the Diagnostic primary menu button",
                Click.on(DignosticLabelinPrimarymenu));
    }

    public static Performable ClicOnkRequestCallBackButton() {
        return Task.where("{0} clicks on the Request call back Button",
                Click.on(RequestCallBackButton));
    }

    public static Performable ClicOnProceedButton() {
        return Task.where("{0} clicks on the Proceed Button in the ",
                Click.on(ProceedButton));
    }
    public static Performable ClicOnkBackButton() {

        return Task.where("{0} clicks on the Back Button in the Request call back form",
                Click.on(Backbutton));
    }

    public static Performable TestIcon() {
        return Task.where("{0} clicks on the Ask an Expert View All",
                Click.on(TestIcon));
    }

    public static Performable CheckupsIcon() {
        return Task.where("{0} clicks on the Ask an Expert View All",
                Click.on(CheckupsIcon));
    }

    public static Performable DiagnosticBreadCrumbInTestAndPackagesListingPage() {
        return Task.where("{0} clicks on the Ask an Expert View All",
                Click.on(DiagnosticBreadCrumbInTestAndPackagesListingPage));
    }

    public static Performable entername(){
        return Task.where("Clicks on the Name Field ",
                Click.on(EnterName));
    }
    public static Performable response(){
        return Task.where("Click on Response field",
                Click.on(EnterResponse));
    }

    public static Performable Email(){
        return Task.where("Click on email field",
                Click.on(EnetrEmail));
    }
    public static Performable PostCommentbutton(){
        return Task.where("Click on email field",
                Click.on(PostComment));
    }

    public static Performable theViewMoreButtoninDiagnosticsDiseaseSpecificPackages(){
        return Task.where("Clicks on the ViewMore Button in Diagnostics Disease Specific Packages ",
                Click.on(DiseaseSpecificPackagesViewMoreButton));
    }

    public static Performable theViewMoreButtoninBodyOrganCheckupPackages(){
        return Task.where("Clicks on the ViewMore Button in Diagnostics Disease Specific Packages ",
                Click.on(BodyOrganCheckupPackagesViewMoreButton));
    }

    public static Performable theViewMoreButtoninDiagnosticsBodyOrganCheckupPackages(){
        return Task.where("Clicks on the ViewMore Button in Diagnostics Body Organ Checkup Packages ",
                Click.on(BodyOrganCheckupPackagesViewMoreButton));
    }

    public static Performable DiseaseIcon(String tabValue){
        return Task.where("User clicks on "+tabValue+" Disease Icon",
                Click.on(DiseaseIcon.of(tabValue)));
    }

    public static Performable CartIcon(){
        return Task.where("User clicks on cart Icon",
                Click.on(CartIcon));
    }

    public static Performable AAELabelinPrimarymenu(){
        return Task.where("{0} clicks on the AAE Labelin Primary menu ",
                Click.on(AAELabelInPrimaryMenu));
    }

    public static Performable PostAQuery(){
        return Task.where("{0} clicks on the Post A Query button",
                Click.on(PostAQuery));
    }

    public static Performable theGivenField(Target GivenField){
        return Task.where("Clicks on the GivenField",
                Click.on(GivenField));

    }

    public static Performable SubmitQuery(){
        return Task.where("{0} clicks on the Submit Query button",
                Click.on(SubmitQuery));
    }

    public static Performable MyQueries(){
        return Task.where("{0} clicks on the Submit Query button",
                Click.on(MyQueries));
    }

    public static Performable selectAssigneeDropdownForGivenQuery(String query) {
        return Task.where("Clicks on Select Assignee For {0} Query",
                Click.on(SelectAssigneeDropdownForGivenQuery.of(query)));
    }

    public static Performable AssigneeButtonForGivenQuery(String query) {
        return Task.where("Clicks on Assignee Button For {0} Query",
                Click.on(AssigneeButtonForGivenQuery.of(query)));
    }

    public static Performable AddResponseButtonForGivenQuery(String query) {
        return Task.where("Clicks on Add Response Button For {0} Query",
                Click.on(AddResponseButtonForGivenQuery.of(query)));
    }

    public static Performable RejectQueryButtonForGivenQuery(String query) {
        return Task.where("Clicks on Add Response Button For {0} Query",
                Click.on(RejectQueryButtonForGivenQuery.of(query)));
    }

    public static Performable ReviewResponseButtonForGivenQuery(String query) {
        return Task.where("Clicks on Add Response Button For {0} Query",
                Click.on(ReviewResponseButtonForGivenQuery.of(query)));
    }

    public static Performable AskAnExpertTab(){
        return Task.where("{0} clicks on " , Click.on(AskAnExpertTab));
    }

    public static Performable ExpertProfilesTab(){
        return Task.where("{0} clicks on " , Click.on(ExpertProfilesTab));
    }

    public static Performable tabFromSecondaryMenu(String value) {
        return Task.where("Clicks on Add Response Button For {0} Query",
                Click.on(TabFromSecondaryMenu.of(value)));
    }
    public static Performable ProfileIcon(){
        return  Task.where("Clicks on Profile Icon",
                Click.on(ProfileIconAdminPortal));
    }
    public static Performable LogoutAdminPortal(){
        return  Task.where("Clicks on Profile Icon",
                Click.on(LogoutAdminPortal));
    }
    public static Performable PublishResponseButtonINConfirmationPopUp(){
        return  Task.where("Clicks on Profile Icon",
                Click.on(PublishResponseButtonINConfirmationPopUp));
    }
    public static Performable FiltersButton(){
        return  Task.where("Clicks on Filters Button",
                Click.on(FiltersButton));
    }
    public static Performable FiltersButtoninAssignedTab(){
        return  Task.where("Clicks on Filters Button",
                Click.on(FiltersButtonInAssignedTab));
    }

    public static Performable FiltersButtonInPublishedTab(){
        return  Task.where("Clicks on Filters Button",
                Click.on(FiltersButtonInPublishedTab));
    }
    public static Performable Status(){
        return  Task.where("Clicks on Status",
                Click.on(Status));
    }
    public static Performable Drafted(){
        return  Task.where("Clicks on Drafted",
                Click.on(Drafted));
    }
    public static Performable DeleteResponse(){
        return  Task.where("Clicks on Delete Response",
                Click.on(DeleteResponse));
    }
    public static Performable Proceedbutton(){
        return  Task.where("Clicks Procee button",
                Click.on(Proceedbutton));
    }
    public static Performable ReAssignButton(){
        return  Task.where("Clicks on ReAssign Button",
                Click.on(ReAssignButton));
    }

    public static Performable DeleteButton(){
        return  Task.where("Clicks on Delete Response",
                Click.on(DeleteButton));
    }

    public static Performable ReassignToModerator(){
        return  Task.where("Clicks on ReassignToModerator",
                Click.on(ReassignToModerator));
    }

    public static Performable AddAnotherResponse(){
        return  Task.where("Clicks on AddAnotherResponse",
                Click.on(AddAnotherResponse));
    }

    public static Performable RejectReasonSelector(){
        return  Task.where("Clicks on RejectReasonSelector",
                Click.on(RejectReasonSelector));
    }

    public static Performable RejectReasonValue(){
        return  Task.where("Clicks on AddAnotherResponse",
                Click.on(RejectReasonValue));
    }
    public static Performable RejectQueryButton(){
        return  Task.where("Clicks on RejectQueryButton",
                Click.on(RejectQueryButton));
    }

    public static Performable ProceedButtonindeleteresponseconfirmationpopup(){
        return  Task.where("Clicks on ProceedButtonindeleteresponseconfirmationpopup",
                Click.on(ProceedButtonindeleteresponseconfirmationpopup));
    }

    public static Performable PublishQueryViewDetails(String query) {
        return  Task.where("ViewDetails for {0}",
                Click.on(PublishQueryViewDetails.of(query)));
    }

    public static Performable EditResponseInPublishedQueryTab(String query) {
        return  Task.where("ViewDetails for {0}",
                Click.on(EditResponseInPublishedQueryTab.of(query)));
    }

    public static Performable BacktoPublishedQueries(){
        return  Task.where("Clicks on BacktoPublishedQueries",
                Click.on(BacktoPublishedQueries));
    }
    public static Performable ADDEXPERTPROFILEButton(){
        return  Task.where("Clicks on ADDEXPERTPROFILE Button",
                Click.on(ADDEXPERTPROFILEButton));
    }
    public static Performable RevertButtonInRejectQueryTabForGivenQuery(String query) {
        return  Task.where("ViewDetails for {0}",
                Click.on(RevertButtonInRejectQueryTabForGivenQuery.of(query)));
    }
    public static Performable EditOptionForUserWithMobileNo(String MobNo){
        return  Task.where("Clicks on Edit Option For User With Mobile No",
                Click.on(EditOptionForUserWithMobileNo.of(MobNo)));
    }
    public static Performable EditProfile(){
        return  Task.where("Clicks on Edit Profile",
                Click.on(EditProfile));
    }
    public static Performable ViewProfile(){
        return  Task.where("Clicks on View Profile",
                Click.on(ViewProfile));
    }
    public static Performable DeactivateProfile(){
        return  Task.where("Clicks on Deactivate Profile",
                Click.on(DeactivateProfile));
    }
    public static Performable PodcastLink(){
        return Task.where("Podcast Link ",
                Click.on(Podcast));
    }
    public static Performable theArticleLink(){
        return Task.where("{0} clicks on the Article Link ",
                Click.on(CMSHomePage.Articles));
    }

    public static Performable theContentLink(String content){
        return Task.where("{0} clicks on the " + content + " Link ",
                Click.on(CMSHomePage.Content(content)));
    }

    public static Performable theAddNwePostUnderArticle(){
        return Task.where("{0} clicks on the Add New Post button",
                Click.on(CMSArticlePage.AddNewPost));
    }

    public static Performable theDocTalesViewAllLink(){
        return Task.where("{0} clicks on doc tales view all", Click.on(getDocTalesViewAll()));
    }

    public static Performable theGivenInputField(String label){
        return Task.where("{0} clicks on input box with " + label, Click.on(InputboxWithLabel.of(label)));
    }

    public static Performable theCatagoryCheckbox(String category){
        return Task.where("{0} clicks on the Add New Post button",
                Click.on(CMSArticlePage.Catagory.of(category)));
    }
    public static Performable thePublishButton(){
        return Task.where("{0} clicks on the Add New Post button",
                Click.on(CMSArticlePage.PublishButton));
    }
    public static Performable inputField(String attributeType, String elementAttribute){
        return Task.where("{0} clicks on the button", Click.on(CustomInput(elementAttribute,attributeType)));
    }

    public static Performable checkbox(String attributeType, String elementAttribute){
        return Task.where("{0} clicks on the button", Click.on(CustomInput(elementAttribute,attributeType)));
    }

    public static Performable linkUsingLinkName(String linkName){
        return Task.where("{0} clicks on link using " + linkName + " linkname", Click.on(LinkWithLinkName.of(linkName)));
    }

    public static Performable articleUsingLinkName(String linkName){
        return Task.where("{0} clicks on article link using " + linkName + " linkname", Click.on(ArticleWithArticleName.of(linkName)));
    }

    public static Performable buttonUsingButtonText(String buttonText){
        return Task.where("{0} clicks on button using " + buttonText + " text", Click.on(ButtonWithButtonName(buttonText)));
    }

    public static Performable firstImageInMediaLibrary(){
        return Task.where("{0} clicks on first image in media library", Click.on(FirstImageInMediaLibrary));
    }
    public static Performable theSelectRelatedPost() {
        return Task.where("{0} clicks on the Add New Post button",
                Click.on(CMSArticlePage.SelectRelatedPostsInputbox));
    }

    public static Performable theWebminarCheckbox(String checkBoxValue) {
        return Task.where("{0} clicks on Checkbox in Webinar with label "+checkBoxValue,
                Click.on(CMSArticlePage.WebminarCheckbox.of(checkBoxValue)));
    }

    public static Performable viewPostLink() {
        return Task.where("{0} clicks on first image in media library", Click.on(ViewPost));
    }

    public static Performable theAddImageLink(String fieldName) {
        return Task.where("{0} clicks on the add image link of"+fieldName,
                Click.on(CMSArticlePage.AddImagelink.of(fieldName)));
    }

    public static Performable addLinkButtonInContent() {
        return Task.where("{0} add Link Button In Content body",
                Click.on(CMSArticlePage.AddlinkButtonInContent));
    }

    public static Performable radioButtonWithTextAndLabel(String text,String label){
        return Task.where("{0} clicks on radio button with " + text + "and " + label + " label", Click.on(RadioButtonWithTextAndLabel.of(text,label)));
    }

    public static Performable checkBoxWithTextAndLabel(String text,String label){
        return Task.where("{0} clicks on checkbox with " + text + "and " + label + " label", Click.on(CheckBoxWithTextAndLabel.of(text,label)));
    }

    public static Performable linkWithLinkNameAndLabel(String linkName,String label){
        return Task.where("{0} clicks on linkName with " + linkName + "and " + label + " label", Click.on(linkWithLinkNameAndLabel.of(linkName,label)));
    }

    public static Performable attributeNameWithAttributeType(String attributeName,String attributeType){
        return Task.where("{0} clicks on element attribute with " + attributeName + " name using " + attributeType + " attribute", Click.on(attributeNameUsingAttributeType.of(attributeName,attributeType)));
    }

    public static Performable ContentAddNewPost(String contentName){
        return Task.where("{0} clicks on " + contentName + " Add New Post", Click.on(AddNewPost.of(contentName)));
    }

    public static Performable elementWithXpath(String xpathValue){
        return Task.where("{0} clicks on " + xpathValue + " xpath", Click.on(By.xpath(xpathValue)));
    }

    public static Performable Healthcare() {
        return Task.where("Clicks on healthcare",
                Click.on(Healthcare));
    }
    public static Performable ViewAllLink() {
        return Task.where("Clicks on view all link",
                Click.on(ViewAllLink));//
    }
    public static Performable card() {
        return Task.where("Clicks on view all link",
                Click.on(card));
    }
    public static Performable Carosel() {
        return Task.where("Clicks on Carosel",
                Click.on(DoctorsCarouselButton));
    }
    public static Performable Book() {
        return Task.where("Clicks on Carosel",
                Click.on(Book));
    }

    public static Performable viewAllButton()
    {
        return Task.where("Clicks on View All Button",
            Click.on(ViewAllButton));
    }

    public static Performable viewDetails()
    {
        return Task.where("Clicks on View Details Button",
                Click.on(ServicesViewDetails));
    }

//    public static Performable Healthcare() {
//        return Task.where("Clicks on healthcare",
//                Click.on(Healthcare));
//    }
//
//    public static Performable ViewAllLink() {
//        return Task.where("Clicks on view all link",
//                Click.on(ViewAllLink));//
//    }
//
//    public static Performable card() {
//        return Task.where("Clicks on view all link",
//                Click.on(card));
//    }
//
//    public static Performable Carosel() {
//        return Task.where("Clicks on Carosel",
//                Click.on(Carosel));
//    }
//
//    public static Performable Book() {
//        return Task.where("Clicks on Carosel",
//                Click.on(Book));
//    }

    public static Performable bookAnAppointmentButton() {
        return Task.where("Clicks on Book An Appointment Button",
                Click.on(BookAnAppointmentButton));
    }
    public static Performable BackButton() {
        return Task.where("Clicks on Carosel",
                Click.on(BackButton));

    }
    public static Performable proccedButton() {
        return Task.where("Clicks on Carosel",
                Click.on(proccedButton));
    }

}
