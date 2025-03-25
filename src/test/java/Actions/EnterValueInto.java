package Actions;

import CMSPages.CMSArticlePage;
import CMSPages.CMSHomePage;
import CMSPages.CMSLoginPage;
import CMSPages.CommonObjects;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static HHPages.AskAnExpert.*;
import static HHPages.DiagnosticPage.DiagnosticsSearchBox;
import static HHPages.HHEvolutionPage.searchInputField;
import static HHPages.HHVideoPage.*;
import static HHPages.UserAuthenticationPage.EmailField;

public class EnterValueInto {

    public static Performable searchInputFieldAndHitEnter(String text){
        return Task.where("{0} enters "+ text + " in search field",
                Enter.theValue(text)
                        .into(searchInputField).thenHit(Keys.ENTER));
    }


    public static Performable searchInputField(String text){
        return Task.where("{0} enters "+ text + " in search field",
                Enter.theValue(text)
                        .into(searchInputField));
    }

    public static void clearSearchInputField(){
        Serenity.getDriver().findElement(By.id("search-input-field")).clear();
    }

    public static Performable enterresponse (String text){
        return  Task.where("{0} enters "+ text + " in response field",
                Enter.theValue(text)
                        .into(EnterResponse));
    }

    public static Performable entername (String text){
        return  Task.where("{0} enters "+ text + " in response field",
                Enter.theValue(text)
                        .into(EnterName));
    }


    public static Performable enterhemail (String text){
        return  Task.where("{0} enters "+ text + " in response field",
                Enter.theValue(text)
                        .into(EnetrEmail));
    }

    public static Performable SpecialtyAndHitEnter(String text){
        return Task.where("{0} enters ",
                Enter.theValue(text)
                        .into(Specialty).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }


    public static Performable QueryTextArea(String Query){
        return Task.where("{0} enters title "+Query,
                Enter.theValue(Query)
                        .into(QueryTextArea).thenHit(Keys.ENTER));
    }
    public static Performable AssigneeAndHitEnter(String moderator, String query){
        return Task.where("{0} enters ",
                Enter.theValue(moderator)
                        .into(SelectAssigneeDropdownForGivenQuery.of(query)).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }
    public static Performable ModeratorNameInput(String moderator){
        return Task.where("{0} enters ",
                Enter.theValue(moderator)
                        .into(ModeratorNameInput).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }
    public static Performable ReasonInput(String input){
        return Task.where("{0} enters ",
                Enter.theValue(input)
                        .into(ReasonInput).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }

    public static Performable responseTextbox(String text){
        return Task.where("{0} enters "+ text + " in search field",
                Enter.theValue(text)
                        .into(ResponseTextbox));
    }

    public static Performable SelectExpertAndHitEnter(String text){
        return Task.where("{0} enters ",
                Enter.theValue(text)
                        .into(SelectExpert).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }
    public static Performable SelectExpertSecondAndHitEnter(String text){
        return Task.where("{0} enters ",
                Enter.theValue(text)
                        .into(SelectExpert2nd).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }
    public static Performable DeleteResponseReasonSelector(String text){
        return Task.where("{0} enters ",
                Enter.theValue(text)
                        .into(DeleteResponseReasonSelector).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }

    public static Performable FirstMameTextbox(String text){
        return Task.where("{0} enters "+ text + " in search field",
                Enter.theValue(text)
                        .into(ResponseTextbox));
    }
    public static Performable InputFieldWithLabel(String text,String Label){
        return Task.where("{0} enters "+ text + " in search field",
                Enter.theValue(text)
                        .into(InputFieldWithLabel.of(Label)).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER));
    }

    public static Performable givenField (Target field, String text){
        return  Task.where("{0} enters "+ text + " in response field",
                Enter.theValue(text)
                        .into(field));
    }
    public static Performable MobileNoField(String text){
        return Task.where("{0} enters "+ text + " in mobile no field",
                Enter.theValue(text)
                        .into(EmailField).thenHit(Keys.ENTER));
    }
    public static Performable theUsernameField(String username){
        return Task.where("{0} enters username "+username,
                Enter.theValue(username)
                        .into(CMSLoginPage.USERNAME));
    }

    public static Performable thePasswordField(String password){
        return Task.where("{0} enters password "+password,
                Enter.theValue(password)
                        .into(CMSLoginPage.PASSWORD)
                        .thenHit(Keys.ENTER)
        );
    }

    public static Performable theAddTitleField(String title){
        return Task.where("{0} enters title "+title,
                Enter.theValue(title)
                        .into(CMSArticlePage.Addtitle));
    }

    public static Performable theAddBodyField(String title){
        return Task.where("{0} enters title "+title,
                Enter.theValue(title)
                        .into(CMSArticlePage.Body));
    }

    public static Performable switchToFrame(String CSS){

        return Task.where("{0} switch to inner frame",
                Switch.toFrame(new CMSHomePage().getIFrameelement(CSS)));
    }

    public static Performable switchToDefaultFrame(){

        return Task.where("{0} switch to default frame",
                Switch.toDefaultContext());
    }

    public static Performable theGivenInputField(String value, String label) {
        return Task.where("{0} enters title "+value,
                Enter.theValue(value)
                        .into(CMSArticlePage.InputboxWithLabel.of(label)));
    }

    public static Performable theGivenTextAreaField(String value,String label){
        return Task.where("{0} enters title "+value,
                Enter.theValue(value)
                        .into(CMSArticlePage.TextAreaBoxWithLabel.of(label)));
    }

    public static Performable theExpertField(String value){
        return Task.where("{0} enters title "+value,
                Enter.theValue(value)
                        .into(CMSArticlePage.ExpertTextBox));
    }

    public static Performable StringInputBox(String value,String inputField){
        return Task.where("{0} enters title "+value,
                Enter.theValue(value)
                        .into(CommonObjects.StringInputField.of(inputField)));
    }

    public static Performable diagnosticsSearchBox(String title){
        return Task.where("{0} enters title "+title,
                Enter.theValue(title)
                        .into(DiagnosticsSearchBox));
    }
}
