package com.sparta.accounts;

public class Accounts {
    private static final String VALID_EMAIL = "@exampleEmail.co.uk";
    private static final String VALID_PASSWORD = "password456123";

    public static final Account account1 = new Account(
            "theLegend@example.com",
            "passwordLegends1999",
            "3",
            "May",
            "1989",
            "Tom",
            "Legend",
            "15 example road",
            "United States",
            "California",
            "Malibu",
            "nw1 1xx",
            "07429583981"
    );

    public static final Account account2 = new Account(
            "theSecond@example.com",
            "imaginePass123",
            "3",
            "May",
            "1989",
            "Rowan",
            "Sparky",
            "45 the other road",
            "India",
            "Maharashtra",
            "Mumbai",
            "S45 4xx",
            "07837584381"
    );

    public static final Account account3 = new Account(
            "third@example.com",
            "Expasswordple8921",
            "13",
            "November",
            "2001",
            "Spockle",
            "Vonny",
            "55 Back Alley",
            "Canada",
            "Ontario",
            "Toronto",
            "N18 3x0",
            "07845829012"
    );

    public static String GenerateNewValidEmail() {
        return "test" + System.currentTimeMillis() + VALID_EMAIL;
    }

    public static String getValidPassword() {
        return VALID_PASSWORD;
    }

    public record Account(String email, String password, String DOB_day, String DOB_month, String DOB_year, String firstName, String lastName, String address,
                          String country, String state, String city, String cityZipCode, String mobileNumber) {

        public String getName() {
                return firstName + " " + lastName;
            }

        }
}
