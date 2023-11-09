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
                .imageUpload()
                .setState("NCR")
                .setCity("Delhi")
                .setCurrentAddress("baker street 221b")
                .clickSubmitButton();

//        Assertions
        submitModalComponent.modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedDate("Student Name", "Bohdan Peliutkevich")
                .verifySubmittedDate("Student Email", "bohdan@gmail.com")
                .verifySubmittedDate("Mobile", "1234567890");

    }

    @Test
    void minDataSubmit() {
        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .clickSubmitButton();

        //        Assertions
        submitModalComponent.modalWindowIsVisible()
                .verifyHeaderText("Thanks for submitting the form")
                .verifySubmittedDate("Student Name", "Bohdan Peliutkevich")
                .verifySubmittedDate("Gender", "Male")
                .verifySubmittedDate("Mobile", "1234567890");
    }

    @Test
    void submitWithNotSelectedGender(){
        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setPhoneNumber("1234567890")
                .clickSubmitButton();

        //        Assertions
        registrationPage.checkGenderFieldValidation("Male");
        submitModalComponent.modalWindowIsNotVisible();
    }


}
