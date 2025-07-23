package country_RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static common.CountryBasePath.*;

public class RestCountryRequestBuilder {

    public static Response getAllCountries() {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .basePath(all_countries)
                .when()
                .log().all()
                .get()
                .then()
                .extract()
                .response();
    }
}
