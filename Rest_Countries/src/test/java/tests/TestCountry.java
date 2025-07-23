package tests;

import country_PayloadBuilder.RestCountrySchemaPayloadBuilder;
import country_RequestBuilder.RestCountryRequestBuilder;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

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

    @Test
    @Description("Validating the country count")
    public void testCountryCounts() {
        int expectedCountryCount = 195;
        int actualCountryCount = RestCountryRequestBuilder.getAllCountries()
                .then()
                .log().all()
                .extract()
                .jsonPath()
                .getList("$")
                .size();

        System.out.println("Expected count: " + expectedCountryCount);
        System.out.println("Actual count: " + actualCountryCount);

        Assert.assertEquals(actualCountryCount, expectedCountryCount, "Expected country count does not match actual count.");
    }

    @Test
    @Description("Test to check if South African Sign Language is present in the list of languages")
    public void testSouthAfricanSignLanguage() {
        Response response = RestCountryRequestBuilder.getAllCountries()
                .then()
                .log().all()
                .extract()
                .response();

        // Extract the list of countries
        List<Map<String, Object>> countries = response.jsonPath().getList("$");

        // Check if any country contains "South African Sign Language" in its languages
        boolean isLanguageFound = countries.stream()
                .anyMatch(country -> {
                    Map<String, String> languages = (Map<String, String>) country.get("languages");
                    return languages != null && languages.containsValue("South African Sign Language");
                });

        // Print a message indicating whether the language is found
        if (isLanguageFound) {
            System.out.println("South African Sign Language is present in the list of languages.");
        } else {
            System.out.println("South African Sign Language is NOT present in the list of languages.");
        }

        assertEquals(isLanguageFound, true, "South African Sign Language not found in the list of languages.");
    }
}
