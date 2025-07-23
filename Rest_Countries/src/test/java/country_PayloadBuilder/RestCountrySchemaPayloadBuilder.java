package country_PayloadBuilder;

import org.testng.annotations.Test;

import java.io.InputStream;

public class RestCountrySchemaPayloadBuilder {
    public static InputStream getSchemaPayload() {
        return RestCountrySchemaPayloadBuilder
                .class
                .getResourceAsStream("/RestCountriesSchema.json");
    }

}
