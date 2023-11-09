package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitModalComponent {

    private final SelenideElement
            modalWindow = $(".modal-content"),
            modalHeader = $(".modal-header"),
            modalBody = $(".modal-body");

    public SubmitModalComponent modalWindowIsVisible(){
        modalWindow.shouldBe(visible);
        return this;
    }

    public void modalWindowIsNotVisible(){
        modalWindow.shouldNot(visible);
    }

    public SubmitModalComponent verifyHeaderText(String value) {
        modalHeader.shouldHave(text(value));
        return this;
    }

    public SubmitModalComponent verifySubmittedData(String field, String value){
        modalBody.$(byText(field)).sibling(0).shouldHave(text(value));
        return this;
    }

}
