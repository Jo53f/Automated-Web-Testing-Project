package com.sparta.accounts;

public class Accounts {
    private static final String VALID_EMAIL = "testUser@exampleEmail.co.uk";
    private static final String VALID_PASSWORD = "password456123";

    private static final Account account1 = new Account(
            "theLegend@example.com",
            "passwordLegends1999",
            "3-5-1989",
            "Tom",
            "Legend",
            "15 example road",
            "united testers",
            "nw1 1xx",
            "07429583981"
    );

    private static final Account account2 = new Account(
            "theSecond@example.com",
            "imaginePass123",
            "3-5-1989",
            "Rowan",
            "Sparky",
            "45 the other road",
            "Republic of Automations",
            "S45 4xx",
            "07837584381"
    );

    private static final Account account3 = new Account(
            "third@example.com",
            "Expasswordple8921",
            "13-11-2001",
            "Spockle",
            "Vonny",
            "55 Back Alley",
            "Great Britain",
            "N18 3x0",
            "07845829012"
    );

    public record Account(String email, String password, String DOB, String firstName, String lastName, String address,
                          String country, String cityZipCode, String mobileNumber) {

        public String getName() {
                return firstName + " " + lastName;
            }

        }
}
