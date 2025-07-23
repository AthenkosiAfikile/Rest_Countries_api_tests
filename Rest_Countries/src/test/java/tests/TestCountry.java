package tests;

import country_PayloadBuilder.RestCountrySchemaPayloadBuilder;
import country_RequestBuilder.RestCountryRequestBuilder;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class TestCountry {

    @Test
    @Description("Test to validate the schema of the response from the API")
    public void testSchemaValidation() {
        try {
            RestCountryRequestBuilder.getAllCountries()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchema(RestCountrySchemaPayloadBuilder.getSchemaPayload()));

            System.out.println("Schema validation passed successfully.");
        } catch (Exception e) {
            System.out.println("Schema validation failed: " + e.getMessage());
            throw e;
        }
    }
}
