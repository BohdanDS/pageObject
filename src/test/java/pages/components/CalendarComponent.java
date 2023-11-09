package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement
            yearSelect = $(".react-datepicker__year-select"),
            monthSelect = $(".react-datepicker__month-select");

    public void setDate(String year, String month, String day) {
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        $(".react-datepicker__day--0"+day).click();
    }

}
