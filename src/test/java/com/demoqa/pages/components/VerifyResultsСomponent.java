package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyResultsСomponent {

    SelenideElement table = $(".table-responsive"),
            greeting = $("#example-modal-sizes-title-lg");

    public void verifyGreeting() {
        greeting.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        table.$(byText(key)).sibling(0).shouldHave(text(value));
    }

}
