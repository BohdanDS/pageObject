package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderField = $("#genterWrapper"),
            numberInput = $("#userNumber");


    public RegistrationPage openPage(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setPhoneNumber(String value){
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value){
        genderField.$(byText(value)).click();

        return this;
    }
}
