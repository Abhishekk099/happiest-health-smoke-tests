package stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

import Utils.MyCast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class HCS_API_Steps {
    Actor user = MyCast.user();

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("rest.base.url");

    Response responseBody;
    String response;
    @Given("the API endpoint for testimonials is available")
    public void theApiEndpointForTestimonialsIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/wp-json/wp/v2/testimonials?string=hc");
    }

    @When("I send a GET request with valid authentication")
    public void iSendAGetRequestWithValidAuthentication() {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody=given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint);
        response=responseBody.asString();
    }

    @Then("the response status should be 200")
    public void theResponseStatusShouldBe200() {
        then().statusCode(200);
    }

    @Then("the response should contain the expected data for testimonials")
    public void theResponseShouldContainTheExpectedDataForTestimonials() {
       // System.out.println(response);
        then().body("size()", greaterThan(0));
        String[] words = {"id", "date", "date_gmt", "guid", "rendered","modified","modified_gmt","slug","status","type","link","title","rendered","content","rendered","protected","excerpt","rendered","protected"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }

    }

    @Given("the API endpoint for FAQ is available")
    public void theApiEndpointForFaqIsAvailable() {
        user.remember("APIEndpoint",baseUrl+"/wp-json/wp/v2/faq_item?string=hcs");
    }

    @When("I send a GET request")
    public void iSendAGetRequest() {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody=given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint);
        response=responseBody.asString();
    }

    @Then("the response should contain the expected data for FAQ items")
    public void theResponseShouldContainTheExpectedDataForFaqItems() {
        String[] words = {"id", "date", "date_gmt", "guid", "rendered","modified","modified_gmt","slug","status","type","link","title","rendered","content","rendered","protected","excerpt","rendered","protected"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @Given("the API endpoint for doctors is available")
    public void theAPIEndpointForDoctorsIsAvailable() {
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        if (osName.toLowerCase().contains("linux")) {
            user.remember("APIEndpoint","https://59tp9hm82m.execute-api.ap-south-1.amazonaws.com/qa/doctors");
        } else if (osName.toLowerCase().contains("windows")) {
            user.remember("APIEndpoint","https://wem40frosa.execute-api.ap-south-1.amazonaws.com/dev/doctors");
        }
    }

    @When("I send a GET request for doctors API")
    public void iSendAGETRequestForDoctorsAPI() {
        String APIEndpoint = user.recall("APIEndpoint");
            responseBody = given()
                    .auth()
                    .preemptive()
                    .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                    .when()
                    .get(APIEndpoint);
            response = responseBody.asString();
        }


    @And("the response should contain the expected data for doctors API")
    public void theResponseShouldContainTheExpectedDataForDoctorsAPI() {
        String[] words = {"data","id","name","speciality","qualification","image","location"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @Given("the API endpoint for clinics is available")
    public void theAPIEndpointForClinicsIsAvailable() {
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        if (osName.toLowerCase().contains("linux")) {
            user.remember("APIEndpoint","https://59tp9hm82m.execute-api.ap-south-1.amazonaws.com/qa/clinics");
        } else if (osName.toLowerCase().contains("windows")) {
            user.remember("APIEndpoint","https://wem40frosa.execute-api.ap-south-1.amazonaws.com/dev/clinics");
        }
    }

    @When("I send a GET request for clinics API")
    public void iSendAGETRequestForClinicsAPI() {
        String ClinicsAPI = user.recall("APIEndpoint");
        responseBody = given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(ClinicsAPI);
        response = responseBody.asString();
    }


    @And("the response should contain the expected data for clinics API")
    public void theResponseShouldContainTheExpectedDataForClinicsAPI() {
        String[] words = {"data","id","name","location","area","lat","long","image"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @Given("the API endpoint for service is available")
    public void theAPIEndpointForServiceIsAvailable() {

        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        if (osName.toLowerCase().contains("linux")) {
            user.remember("APIEndpoint","https://59tp9hm82m.execute-api.ap-south-1.amazonaws.com/qa/service");
        } else if (osName.toLowerCase().contains("windows")) {
            user.remember("APIEndpoint","https://wem40frosa.execute-api.ap-south-1.amazonaws.com/dev/service");
        }
    }

    @When("I send a GET request for service API")
    public void iSendAGETRequestForAPIEndpoint() {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody = given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint);
        response = responseBody.asString();
    }


    @And("the response should contain the expected data for service API")
    public void theResponseShouldContainTheExpectedDataForAPIEndpoint() {
        String[] words = {"data","id","name","speciality","clinic","description","isnew"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @Given("the API endpoint for service details by name is available")
    public void theAPIEndpointForServiceDetailsByNameIsAvailable() {
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        if (osName.toLowerCase().contains("linux")) {
            user.remember("APIEndpoint","https://59tp9hm82m.execute-api.ap-south-1.amazonaws.com/qa/service");
        } else if (osName.toLowerCase().contains("windows")) {
            user.remember("APIEndpoint","https://wem40frosa.execute-api.ap-south-1.amazonaws.com/dev/service");
        }
    }

    @When("I send a GET request for service details by name  API with name {string}")
    public void iSendAGETRequestForServiceDetailsByNameAPIWithName(String ServiceName) {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody = given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint+"/"+ServiceName);
        response = responseBody.asString();
    }

    @And("the response should contain the expected data for service details by name API")
    public void theResponseShouldContainTheExpectedDataForServiceDetailsByNameAPI() {
        String[] words = {"data","id","name","speciality","description","rate","isnew"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @When("I send a GET request for service details of clinics by name API with name {string}")
    public void iSendAGETRequestForServiceDetailsOfClinicsByNameAPIWithName(String ServiceName) {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody = given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint+"/"+ServiceName+"/clinics");
        response = responseBody.asString();
    }

    @And("the response should contain the expected data for service details of clinics by name API")
    public void theResponseShouldContainTheExpectedDataForServiceDetailsOfClinicsByNameAPI() {
        String[] words = {"data","name","speciality","image","location","lat","long","area"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

    @When("I send a GET request for service details of doctors by name API with name {string}")
    public void iSendAGETRequestForServiceDetailsOfDoctorsByNameAPIWithName(String ServiceName) {
        String APIEndpoint = user.recall("APIEndpoint");
        responseBody = given()
                .auth()
                .preemptive()
                .basic("api_post_commentuser", "5Gils(0%ubp-CBBjvHHTheadleS5\n")
                .when()
                .get(APIEndpoint+"/"+ServiceName+"/doctors");
        response = responseBody.asString();
    }

    @And("the response should contain the expected data for service details of doctors by name API")
    public void theResponseShouldContainTheExpectedDataForServiceDetailsOfDoctorsByNameAPI() {
        String[] words = {"data","id","name","speciality","qualification","image","location"};
        for(String param:words){
            user.attemptsTo(Ensure.that(response.contains(param)).isTrue());
        }
    }

}
