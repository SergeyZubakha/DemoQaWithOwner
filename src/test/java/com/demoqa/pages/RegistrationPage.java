package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.VerifyResultsСomponent;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    VerifyResultsСomponent verify = new VerifyResultsСomponent();

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
        return this;
    }

    public RegistrationPage closeBanners() {
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

    public RegistrationPage selectPicture(String filename) {
        selectPicture.uploadFromClasspath(filename);
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

    public RegistrationPage verifyResult(String key, String value) {
        verify.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closeModalForm() {
        closeButton.click();
        return this;
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(month);
    }public static String getRandomSubject() {
        String[] subjects = {"Math", "English", "Chemistry", "Civics", "Computer Science", "Arts", "Physics", "Economics"};
        return getRandomItemFromArray(subjects);
    }
      public static String getRandomState() {
    String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    return getRandomItemFromArray(state);
}
    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] city = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Uttar Pradesh")) {
            String[] city = {"Agra", "Lucknow", "Merrut"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Haryana")) {
            String[] city = {"Karnal", "Panipat"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Rajasthan")) {
            String[] city = {"Jaipur", "Jaiselmer"};
            return getRandomItemFromArray(city);
        }
        return null;
    }
    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobby);
    }


    private static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }
}
