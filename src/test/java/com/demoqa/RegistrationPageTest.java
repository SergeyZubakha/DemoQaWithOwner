package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
    }

    @Test
    void practiceFormTest() {

        // Заполнение формы
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Kiwi");
        $("#lastName").setValue("Locus");
        $("#userEmail").setValue("kiwi@gmail.com");
        $x("//label[@for='gender-radio-1']").click();
        $("#userNumber").setValue("7111111112");
        $("#dateOfBirthInput").click();
        $x("//select[contains(@class,'month-select')]").selectOption("October");
        $x("//select[contains(@class,'year-select')]").selectOption("1991");
        $x("//div[contains(@class,'day--020')]").click();
        $("#subjectsInput").setValue("M");
        $("#react-select-2-option-0").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $("#currentAddress").setValue("Moscow, Red street 4");
        $("#uploadPicture").uploadFromClasspath("qa.png");
        $("#submit").click();

        //Проверка формы
        $(".table-responsive").shouldHave(text("Kiwi Locus"));
        $(".table-responsive").shouldHave(text("kiwi@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7111111112"));
        $(".table-responsive").shouldHave(text("20 October,1991"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("qa.png"));
        $(".table-responsive").shouldHave(text("Moscow, Red street 4"));
        $(".table-responsive").shouldHave(text("NCR Noida"));

    }
}

