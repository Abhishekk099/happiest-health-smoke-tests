package stepdefinitions;

import Tasks.FetchOTP;
import Tasks.FetchSignUpOTP;
import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.json.JSONObject;

import java.util.Random;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.greaterThan;

public class UM_API {
    Actor user = MyCast.user();

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("rest.base.url");

    Response responseBody;
    String response;
    @Given("API endpoint for send OTP is available")
    public void ApiEndpointForSendOTPIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/pes/api/v1/account/internal/support/aae/code");
    }

    @Given("the user Triggers send OTP for {string}")
    public void theUserTriggersSendOTPFor(String MobileNo) throws InterruptedException {
        String APIEndpoint = user.recall("APIEndpoint");
        String requestBody = "{ \"userName\": \""+MobileNo+"\" }";

        Response responseBody =SerenityRest.given()
                .contentType(JSON)
                .header("Cookie", "NEXT_LOCALE=en")
                .body(requestBody)
                .when()
                .post(APIEndpoint)
                .then()
                .statusCode(200)
                .extract().response();

        response = responseBody.asString();
        JSONObject jsonObject = new JSONObject(response);
        user.remember("Session",jsonObject.getString("session"));

        Thread.sleep(10000);

    }

    @Given("API endpoint for Login with OTP is available")
    public void apiEndpointForLoginWithOTPIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/pes/api/v1/account/internal/support/aae/token");
    }

    @When("the user Triggers Login with OTP for {string}")
    public void theUserTriggersLoginWithOTPFor(String MobileNo) {
        String APIEndpoint = user.recall("APIEndpoint");
        String OTP=user.recall("OTP");
        String requestBody = "{ \"userName\": \""+MobileNo+"\",\"code\": \""+OTP+"\",\"session\":\""+user.recall("Session")+"\" }";

        Response responseBody =SerenityRest.given()
                .contentType(JSON)
                .header("Cookie", "NEXT_LOCALE=en")
                .body(requestBody)
                .when()
                .post(APIEndpoint)
                .then()
                .extract().response();

        response = responseBody.asString();

    }

    @And("the response should contain the expected data for Login with OTP")
    public void theResponseShouldContainTheExpectedDataForLoginWithOTP() {
        then().body("size()", greaterThan(0));
        String[] words = {"accessToken", "refreshToken", "session", "code", "id","message"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }

    }

    @When("User retrieves OTP")
    public void userRetrievesOTP() {
        user.wasAbleTo(FetchOTP.fromCognitoForLogin());
    }

    @Given("API endpoint for signup is available")
    public void ApiEndpointForSignUPIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/pes/api/v1/account/visitor/verify/email");
    }

    @Given("the user Triggers sign up OTP for {string}")
    public void theUserTriggersSignUpOTPFor(String email) throws InterruptedException {
        String APIEndpoint = user.recall("APIEndpoint");
                Random random = new Random();
                int randomNumber = 1000 + random.nextInt(9000);
                String emailid=email+randomNumber+"@gmail.com";
        user.remember("emailid",emailid);
        String requestBody = "{ \"emailId\": \""+emailid+"\" }";

        Response responseBody =SerenityRest.given()
                .contentType(JSON)
                .header("Cookie", "NEXT_LOCALE=en")
                .body(requestBody)
                .when()
                .post(APIEndpoint)
                .then()
                .statusCode(200)
                .extract().response();

        response = responseBody.asString();
        Thread.sleep(10000);
        }
    @When("User retrieves Sign UP OTP")
    public void userRetrievesSignUPOTP() {
        user.wasAbleTo(FetchSignUpOTP.fromCognitoForLogin());
    }

    @Given("API endpoint for Verify OTP is available")
    public void apiEndpointForVerifyOTPIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/pes/api/v1/account/visitor/verify/otp");
    }

    @When("the user Triggers Verify with OTP for {string}")
    public void theUserTriggersVerifyWithOTPFor(String arg0) {
        String APIEndpoint = user.recall("APIEndpoint");
        String emailid=user.recall("emailid");
        String OTP=user.recall("OTP");
        String requestBody = "{ \"otp\": \""+OTP+"\",\"emailId\": \""+emailid+"\" }";

        Response responseBody =SerenityRest.given()
                .contentType(JSON)
                .header("Cookie", "NEXT_LOCALE=en")
                .body(requestBody)
                .when()
                .post(APIEndpoint)
                .then()
                .statusCode(200)
                .extract().response();

        response = responseBody.asString();
    }

    @Given("API endpoint for Register user is available")
    public void apiEndpointForRegisterUserIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/pes/api/v1/account/visitor/register");
    }

    @Then("the User triggers Register user API")
    public void theUserTriggersRegisterUserAPI() {
        String APIEndpoint = user.recall("APIEndpoint");
        String emailid=user.recall("emailid");
        String OTP=user.recall("OTP");
        String requestBody = "{ \"fname\": \"" + "Automation" + "\", "
                + "\"lname\": \"" + "User" + "\", "
                + "\"regemail\": \"" + emailid + "\", "
                + "\"orgId\": \"" + "ad904279-f539-11ed-9a5a-0068eb3e2e47" + "\", "
                + "\"gender\": \"" + "-" + "\", "
                + "\"otp\": \"" + OTP + "\" }";


        Response responseBody =SerenityRest.given()
                .contentType(JSON)
                .header("Cookie", "NEXT_LOCALE=en")
                .body(requestBody)
                .when()
                .put(APIEndpoint)
                .then()
                .statusCode(200)
                .extract().response();

        response = responseBody.asString();
    }
}
