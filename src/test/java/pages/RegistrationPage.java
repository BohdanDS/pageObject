package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderField = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            datePicker = $("#dateOfBirthInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            subjectInput = $("#subjectsInput"),
            fileUploadField = $("#uploadPicture"),
            stateCityWrapper = $("#stateCity-wrapper"),
            selectState = stateCityWrapper.$("#react-select-3-input"),
            selectCity = stateCityWrapper.$("#react-select-4-input"),
            currentAddressInput = $("#currentAddress"),
            submit = $("#submit");


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

    public RegistrationPage setRegistrationDate(String year, String month, String day){
        datePicker.click();
        calendarComponent.setDate(year,month, day);
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesSelector.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage imageUpload(String value){
        fileUploadField.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setState(String value){
        selectState.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value){
        selectCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage checkGenderFieldValidation(String value){
        genderField.$(byText(value)).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        return this;
    }
    public void clickSubmitButton(){
        submit.click();
    }
}
