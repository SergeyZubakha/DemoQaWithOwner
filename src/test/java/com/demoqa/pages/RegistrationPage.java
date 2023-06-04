package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.Calendar;
import com.demoqa.pages.components.VerifyResults;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    Calendar calendar = new Calendar();
    VerifyResults verify = new VerifyResults();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderValue = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            hobbyCheckBox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            subjectsMathInput = $("#react-select-2-option-0"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            addressInput = $("#currentAddress"),
            selectPicture = $("#uploadPicture"),
            submitButton = $("#submit"),
            closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirsName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderValue.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbyCheckBox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsMathInput.click();
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectPicture() {
        selectPicture.uploadFromClasspath("qa.png");
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyGreeting() {
        verify.verifyGreeting();
        return this;
    }

    public RegistrationPage verifyStudentName(String firsAndLastName) {
        verify.verifyStudentName(firsAndLastName);
        return this;
    }

    public RegistrationPage verifyStudentEmail(String email) {
        verify.verifyEmail(email);
        return this;
    }

    public RegistrationPage verifyGender(String genderValue) {
        verify.verifyGender(genderValue);
        return this;
    }

    public RegistrationPage verifyMobile(String mobile) {
        verify.verifyMobile(mobile);
        return this;
    }

    public RegistrationPage verifyDateOfBirth(String date) {
        verify.verifyDateOfBirth(date);
        return this;
    }

    public RegistrationPage verifySubjects(String subject) {
        verify.verifySubjects(subject);
        return this;
    }

    public RegistrationPage verifyHobbies(String hobby) {
        verify.verifyHobbies(hobby);
        return this;
    }

    public RegistrationPage verifyPicture(String filename) {
        verify.verifyPicture(filename);
        return this;
    }

    public RegistrationPage verifyAddress(String address) {
        verify.verifyAddress(address);
        return this;
    }

    public RegistrationPage verifyStateAndCity(String stateAndCity) {
        verify.verifyStateAndCity(stateAndCity);
        return this;
    }

    public RegistrationPage closeModalForm() {
        closeButton.click();
        return this;

    }
}

