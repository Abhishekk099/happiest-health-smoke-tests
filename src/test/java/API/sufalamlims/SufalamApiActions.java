package API.sufalamlims;

import HHPages.DiagnosticPage;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static Utils.GetResponseData.*;
import static io.restassured.RestAssured.given;


public class SufalamApiActions extends UIInteractions {
   private List<String> ServiceName;
    private List<String> DiseaseName;
    private List<String> OrganName;

    Actor user = MyCast.user();

    @Given("Sufalam Api Post call is triggered")
    public void sufalamApiPostCallIsTriggered() {
        RestAssured.baseURI = "https://sufalamlims.com/happiesthealth.api/api/public/public/GetThirdPartyServiceListWithRate";

        // Create a JSON request body
        String requestBody = "{\n" +
                "  \"BranchId\": \"2\",\n" +
                "  \"IsPopularPackage\": \"true\",\n" +
                "  \"IsRemoveServiceLimit\": \"true\"\n" +

                "}";
        System.out.println(requestBody);
        // Send the POST request with username and password in the headers
        Response response = given()
                .header("Content-Type", "application/json")
                .header("User-Agent","PostmanRuntime/7.37.3")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("UserID", "1")
                .header("Password", "Slims$2024")
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // Check that the status code is 201
                //.body("IsSuccess", equalTo("true")) // Validate response body
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Given("Popular Tests And Checkups Sufalam Api Post call is triggered")
    public void popularTestsAndCheckupsSufalamApiPostCallIsTriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPopularPackage\": true,\n" +
                "  \"IsRemoveServiceLimit\": true\n" +
                "}";

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("Password", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }
    public boolean verifyTestsAreSameWithGivenListFromUI(List<String> testListFromUI){
        Collections.sort(ServiceName);
        System.out.println(ServiceName);
        return testListFromUI.equals(ServiceName);
    }

    public boolean verifyDiseaseAreSameWithGivenListFromUI(List<String> diseaseListFromUI){
        Collections.sort(DiseaseName);
        System.out.println(DiseaseName);
        return diseaseListFromUI.equals(DiseaseName);
    }

    public boolean verifyOrgansAreSameWithGivenListFromUI(List<String> OrganListFromUI){
        Collections.sort(OrganName);
        System.out.println(OrganName);
        return OrganListFromUI.equals(OrganName);
    }

    @Then("User validate the popular tests and checkups")
    public void userValidateThePopularTestsAndCheckups() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> popularTestsElement= DiagnosticPageObject.getPopularTestsElement();
        List<String> popularTests = DiagnosticPageObject.getTextFromElement(popularTestsElement);
        System.out.println(popularTests);
        Collections.sort(popularTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(popularTests)).isTrue());
    }

    @Given("Popular Tests and checkups List Response by searching {string} of the test and checkup Sufalam Api Post call is triggered")
    public void popularTestsAndCheckupsListResponseBySearchingOfTheTestAndCheckupSufalamApiPostCallIsTriggered(String searchText) {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"ServiceName\": \""+searchText+"\"\n" +
                "}";

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Then("user validate the searched test and checkup result")
    public void userValidateTheSearchedTestAndCheckupResult() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> searchedResultTestsElement= DiagnosticPageObject.getSearchResultTestsElement();
        List<String> searchedResultTests = DiagnosticPageObject.getTextFromElement(searchedResultTestsElement);
        System.out.println("From UI :-"+searchedResultTests);
        Collections.sort(searchedResultTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(searchedResultTests)).isTrue());
    }

    @Given("Tests  List  Sufalam Api Post call is triggered")
    public void testsListSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"false\"\n" +
                "}";

      System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Then("User validate all tests are available in UI")
    public void userValidateAllTestsAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> popularTestsElement= DiagnosticPageObject.getPopularTestsElement();
        List<String> popularTests = DiagnosticPageObject.getTextFromElement(popularTestsElement);
        System.out.println(popularTests);
        Collections.sort(popularTests);
        System.out.println(popularTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(popularTests)).isTrue());
    }

    @Given("Tests  List  search Sufalam Api Post call is triggered")
    public void testsListSearchSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"false\",\n" +
                "  \"IsPopularPackage\": \"true\"\n" +
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Then("User validate all popular tests are available in UI")
    public void userValidateAllPopularTestsAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> popularTestsElement= DiagnosticPageObject.getPopularTestsElement();
        List<String> popularTests = DiagnosticPageObject.getTextFromElement(popularTestsElement);
        System.out.println(popularTests);
        Collections.sort(popularTests);
        System.out.println(popularTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(popularTests)).isTrue());
    }


    @Given("Search criteria api on tests landing page Sufalam Api Post call is triggered with serach text as {string}")
    public void searchCriteriaApiOnTestsLandingPageSufalamApiPostCallIsTriggeredWithSerachTextAs(String SearchText) {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"false\",\n" +
                "  \"ServiceName\": \""+SearchText+"\"\n" +
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Given("Checkups  List  Sufalam Api Post call is triggered")
    public void checkupListSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"true\"\n" +
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }


    @And("User validate all Checkups are available in UI")
    public void userValidateAllCheckupsAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> popularTestsElement= DiagnosticPageObject.getPopularTestsElement();
        List<String> popularTests = DiagnosticPageObject.getTextFromElement(popularTestsElement);
        System.out.println(popularTests);
        Collections.sort(popularTests);
        System.out.println(popularTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(popularTests)).isTrue());
    }
    @Given("Checkups  List  Search Sufalam Api Post call is triggered")
    public void checkupListSearchSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"true\",\n" +
                "  \"IsPopularPackage\": \"true\"\n" +
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }


    @And("User validate  all Popular Checkups are available in UI")
    public void userValidateAllPopularCheckupsAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> popularTestsElement= DiagnosticPageObject.getPopularTestsElement();
        List<String> popularTests = DiagnosticPageObject.getTextFromElement(popularTestsElement);
        System.out.println(popularTests);
        Collections.sort(popularTests);
        System.out.println(popularTests);
        user.attemptsTo(Ensure.that(verifyTestsAreSameWithGivenListFromUI(popularTests)).isTrue());
    }

    @Given("Search criteria api on Checkups landing page Sufalam Api Post call is triggered with serach text as {string}")
    public void searchCriteriaApiOnCheckupsLandingPageSufalamApiPostCallIsTriggeredWithSerachTextAs(String SearchText) {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"IsPackage\": \"true\",\n" +
                "  \"ServiceName\": \""+SearchText+"\"\n" +
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealthuat.api/api/public/public/GetThirdPartyServiceListWithRate")
                .header("UserID", "1")
                .header("PassWord", "HappiestU@t$22Jul2&24")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        ServiceName = getSufalamLimsServiceNameDataValue(jsonResponse);
        System.out.println(ServiceName.size());
    }

    @Given("Disease List Sufalam Api Post call is triggered")
    public void diseaseListSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"DiseaseIdList\": \"[1005]\"\n"+
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealth.api/api/public/public/GetThirdPartyDiseaseList")
                .header("UserID", "1")
                .header("PassWord", "Slims$2024")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        DiseaseName = getSufalamLimsDiseaseNameDataValue(jsonResponse);
        System.out.println(DiseaseName);
    }

    @And("User validate  all Disease from API are available in UI")
    public void userValidateAllDiseaseFromAPIAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> DiseaseElement= DiagnosticPageObject.getDiseaseElement();
        List<String> DiseaseList = DiagnosticPageObject.getTextFromElement(DiseaseElement);
        System.out.println(DiseaseList);
        Collections.sort(DiseaseList);
        System.out.println(DiseaseList);
        user.attemptsTo(Ensure.that(verifyDiseaseAreSameWithGivenListFromUI(DiseaseList)).isTrue());
    }

    @Given("Body Organ List Sufalam Api Post call is triggered")
    public void bodyOrganListSufalamApiPostcallistriggered() {
        String requestBody = "{\n" +
                "  \"BranchId\": 2,\n" +
                "  \"OrganIdList\": \"[1049]\"\n"+
                "}";

        System.out.println(requestBody);

        Response response =given()
                .baseUri("https://sufalamlims.com")
                .basePath("/happiesthealth.api/api/public/public/GetThirdPartyOrganList")
                .header("UserID", "1")
                .header("PassWord", "Slims$2024")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();

        // Print the response
        String jsonResponse=response.asString();
        OrganName = getSufalamLimsOrganNameDataValue(jsonResponse);
        System.out.println(OrganName);
    }

    @And("User validate  all Body Organ from API are available in UI")
    public void userValidateAllBodyOrganFromAPIAreAvailableInUI() {
        DiagnosticPage DiagnosticPageObject=new DiagnosticPage();
        List<WebElement> OrganElement= DiagnosticPageObject.getOrganElement();
        List<String> OrganList = DiagnosticPageObject.getTextFromElement(OrganElement);
        System.out.println(OrganList);
        Collections.sort(OrganList);
        System.out.println(OrganList);
        user.attemptsTo(Ensure.that(verifyOrgansAreSameWithGivenListFromUI(OrganList)).isTrue());
    }
}
