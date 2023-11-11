package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitModalComponent;



public class RegistrationTest extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    SubmitModalComponent submitModalComponent = new SubmitModalComponent();

    @Test
    void fullFormSubmit() {

        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setGender("Male")
                .setEmail("bohdan@gmail.com")
                .setPhoneNumber("1234567890")
                .setRegistrationDate("1994", "January", "15")
                .setHobbies("Reading")
                .setSubject("Hindi")
                .imageUpload("images/img.png")
                .setState("NCR")
                .setCity("Delhi")
                .setCurrentAddress("baker street 221b")
                .clickSubmitButton();

        submitModalComponent.modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedData("Student Name", "Bohdan Peliutkevich")
                .verifySubmittedData("Student Email", "bohdan@gmail.com")
                .verifySubmittedData("Gender", "Male")
                .verifySubmittedData("Date of Birth", "15 January,1994")
                .verifySubmittedData("Mobile", "1234567890")
                .verifySubmittedData("Subjects", "Hindi")
                .verifySubmittedData("Hobbies", "Reading")
                .verifySubmittedData("Address", "baker street 221b")
                .verifySubmittedData("State and City", "NCR Delhi");


    }

    @Test
    void minDataSubmit() {
        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .clickSubmitButton();

        submitModalComponent.modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedData("Student Name", "Bohdan Peliutkevich")
                .verifySubmittedData("Gender", "Male")
                .verifySubmittedData("Mobile", "1234567890");
    }

    @Test
    void submitWithNotSelectedGender(){
        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setPhoneNumber("1234567890")
                .clickSubmitButton();

        registrationPage.checkGenderFieldValidation("Male");
        submitModalComponent.modalWindowIsNotVisible();
    }

}
