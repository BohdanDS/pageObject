package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitModalComponent;
import testdata.RegistrationData;


public class RegistrationTest extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    SubmitModalComponent submitModalComponent = new SubmitModalComponent();

    RegistrationData registrationData = new RegistrationData();


    @Test
    void fullFormSubmitTest() {

        registrationPage.openPage()
                .setFirstName(registrationData.firstName)
                .setLastName(registrationData.lastName)
                .setGender(registrationData.fakeGender)
                .setEmail(registrationData.userEmail)
                .setPhoneNumber(registrationData.phoneNumber)
                .setRegistrationDate(registrationData.fakeYear, registrationData.fakeMonth, registrationData.fakeDay)
                .setHobbies(registrationData.fakeHobby)
                .setSubject(registrationData.fakeSubject)
                .fileUpload(registrationData.fakeImage)
                .setState(registrationData.fakeState)
                .setCity(registrationData.fakeCity)
                .setCurrentAddress(registrationData.streetAddress)
                .clickSubmitButton();

        submitModalComponent.modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedData("Student Name", String.format("%s %s",registrationData.firstName,registrationData.lastName))
                .verifySubmittedData("Student Email", registrationData.userEmail)
                .verifySubmittedData("Gender", registrationData.fakeGender)
                .verifySubmittedData("Date of Birth", String.format("%s %s,%s",registrationData.fakeDay,registrationData.fakeMonth,registrationData.fakeYear))
                .verifySubmittedData("Mobile", registrationData.phoneNumber)
                .verifySubmittedData("Subjects", registrationData.fakeSubject)
                .verifySubmittedData("Hobbies", registrationData.fakeHobby)
                .verifySubmittedData("Picture", registrationData.fakeImage)
                .verifySubmittedData("Address", registrationData.streetAddress)
                .verifySubmittedData("State and City", String.format("%s %s",registrationData.fakeState,registrationData.fakeCity));


    }

    @Test
    void minDataSubmitTest() {
        registrationPage
                .openPage()
                .setFirstName(registrationData.firstName)
                .setLastName(registrationData.lastName)
                .setGender(registrationData.fakeGender)
                .setPhoneNumber(registrationData.phoneNumber)
                .clickSubmitButton();

        submitModalComponent
                .modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedData("Student Name", String.format("%s %s",registrationData.firstName,registrationData.lastName))
                .verifySubmittedData("Gender", registrationData.fakeGender)
                .verifySubmittedData("Mobile", registrationData.phoneNumber);
    }

    @Test
    void submitWithNotSelectedGenderTest(){
        registrationPage
                .openPage()
                .setFirstName(registrationData.firstName)
                .setLastName(registrationData.lastName)
                .setPhoneNumber(registrationData.phoneNumber)
                .clickSubmitButton();

        registrationPage.checkGenderFieldValidation(registrationData.fakeGender);
        submitModalComponent.modalWindowIsNotVisible();
    }

}
