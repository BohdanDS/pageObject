package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillForm(){

        registrationPage.openPage()
                .setFirstName("Bohdan")
                .setLastName("Peliutkevich")
                .setGender("Male")
                .setEmail("bohdan@gmail.com")
                .setPhoneNumber("1234567890");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--015").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter().setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/image1.png"));
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#currentAddress").setValue("Alabama");
        $("#submit").click();
//        Assertions
        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("tbody").$(byText("Student Name")).sibling(0).shouldHave(text("Bohdan Peliutkevich"));
        $("tbody").$(byText("Student Email")).sibling(0).shouldHave(text("bohdan@gmail.com"));
    }
}
