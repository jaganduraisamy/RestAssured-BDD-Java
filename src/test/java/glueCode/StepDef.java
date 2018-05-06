package glueCode;


import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertEquals;

import utilities.Utils;
import java.util.List;

public class StepDef extends Utils {


    private Response response;


    @Given("^To initiate Rest service to get country details with code as \"([^\"]*)\"$")
    public void to_initiate_Rest_service_to_get_country_details_with_code_as(String arg1) throws Throwable {
        // Set Request parameters

        // Set Base URI
        setBaseURI();

        // Set Base path as country ISO code
        //		setBasePath(arg1);
        Utils.path = arg1;

        //Get response
        response = getResponse();
        System.out.println("************The Response value as --" + response.prettyPrint());
    }


    @Then("^Respose status code should be \"([^\"]*)\"$")
    public void respose_status_code_should_be(Integer arg1) throws Throwable {
        // To verify the response status code
        assertEquals("Status Check Failed!", 200, response.getStatusCode());

    }

    @Then("^response should includes the following$")
    public void response_includes_the_following(DataTable arg1) throws Throwable {

        // This method to verify response body
        List < List < String >> data = arg1.raw();
        System.out.println("*************** Actua Data Table - data value as-- " + data);

        response.then().body("RestResponse.result.name", equalTo(data.get(1).get(0)));
        response.then().body("RestResponse.result.alpha2_code", equalTo(data.get(1).get(1)));
        response.then().body("RestResponse.result.alpha3_code", equalTo(data.get(1).get(2)));


    }

}