package testdata;

import com.github.javafaker.Faker;


public class RegistrationData {

    Faker faker = new Faker();

    String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] genderList = {"Male", "Female", "Other"};
    String[] hobbiesList = {"Sports", "Reading", "Music"};
    String[] subjectsList = {"Hindi", "English", "Maths", "History"};
    String[] imageList = {"img.png", "img1.png", "img2.png"};
    String[] stateList = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};


    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            streetAddress = faker.address().streetAddress(),
            phoneNumber = faker.number().digits(10),
            fakeYear = String.valueOf(faker.number().numberBetween(1935, 2023)),
            fakeMonth = faker.options().option(monthList),
            fakeDay = String.valueOf(faker.number().numberBetween(1, 28)),
            fakeGender = faker.options().option(genderList),
            fakeHobby = faker.options().option(hobbiesList),
            fakeSubject = faker.options().option(subjectsList),
            fakeImage = faker.options().option(imageList),
            fakeState = faker.options().option(stateList),
            userEmail = faker.internet().emailAddress(),
            fakeCity = setCity(fakeState);

    public String setCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }
}
