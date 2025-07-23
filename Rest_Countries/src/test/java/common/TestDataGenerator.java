package common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    public static String name = Faker.instance().name().firstName();
    public static String cca2 = Faker.instance().country().countryCode2();
    public static String language = Faker.instance().country().name(); // Faker has no direct language method

}
