package com.demoqa.pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyResults {

    SelenideElement studentName = $(".table-responsive").$(byText("Student Name")),
            greeting = $("#example-modal-sizes-title-lg"),
            studentEmail = $(".table-responsive").$(byText("Student Email")),
            gender = $(".table-responsive").$(byText("Gender")),
            number = $(".table-responsive").$(byText("Mobile")),
            dateBirth = $(".table-responsive").$(byText("Date of Birth")),
            subjects = $(".table-responsive").$(byText("Subjects")),
            hobbies = $(".table-responsive").$(byText("Hobbies")),
            picture = $(".table-responsive").$(byText("Picture")),
            address = $(".table-responsive").$(byText("Address")),
            stateCity = $(".table-responsive").$(byText("State and City"));

    public void verifyGreeting() {
        greeting.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyStudentName(String firsAndLastName) {
        studentName.sibling(0).shouldHave(text(firsAndLastName));
    }

    public void verifyEmail(String email) {
        studentEmail.sibling(0).shouldHave(text(email));
    }

    public void verifyGender(String genderValue) {
        gender.sibling(0).shouldHave(text(genderValue));
    }

    public void verifyMobile(String mobile) {
        number.sibling(0).shouldHave(text(mobile));
    }

    public void verifyDateOfBirth(String date) {
        dateBirth.sibling(0).shouldHave(text(date));
    }

    public void verifySubjects(String subject) {
        subjects.sibling(0).shouldHave(text(subject));
    }

    public void verifyHobbies(String hobby) {
        hobbies.sibling(0).shouldHave(text(hobby));
    }

    public void verifyPicture(String filename) {
        picture.sibling(0).shouldHave(text(filename));
    }

    public void verifyAddress(String addressValue) {
        address.sibling(0).shouldHave(text(addressValue));
    }

    public void verifyStateAndCity(String stateAndCity) {
        stateCity.sibling(0).shouldHave(text(stateAndCity));
    }
}
