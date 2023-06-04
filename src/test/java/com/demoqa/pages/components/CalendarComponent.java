package com.demoqa.pages.components;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate(String day, String month, String year){

        $x("//select[contains(@class,'month-select')]").selectOption(month);
        $x("//select[contains(@class,'year-select')]").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }
}
