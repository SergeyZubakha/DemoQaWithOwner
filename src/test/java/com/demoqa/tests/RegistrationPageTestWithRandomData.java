package com.demoqa.tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.demoqa.utils.GetRandoms.*;
import static io.qameta.allure.Allure.step;

@Tag("Basic")
@DisplayName("Successful registration")
public class RegistrationPageTestWithRandomData extends TestBase {

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress(),
            //day = String.valueOf(getRandomInt(10, 28)),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getRandomMonth(),
            year = String.valueOf(getRandomInt(1900, 2100)),
            gender = getRandomGender(),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            state = getRandomState(),
            city = getRandomCity(state),
            fileName = "qa.png";

    @Test
    void successfulRegistrationTest() {

        //Заполнение формы
        step("Verify results", () -> {
                    registrationPage.openPage()
                            .closeBanners()
                            .setFirsName(firstName)
                            .setLastName(lastName)
                            .setUserEmail(email)
                            .setGender(gender)
                            .setUserNumber(phoneNumber)
                            .setBirthDay(day, month, year)
                            .setSubject(subject)
                            .setHobbies(hobbies)
                            .selectPicture(fileName)
                            .setState(state)
                            .setCity(city)
                            .setAddress(address)
                            .submitForm();
                });

        //Проверка формы
        step("Fill form", () -> {
                    registrationPage.verifyGreeting()
                            .verifyResult("Student Name", firstName + " " + lastName)
                            .verifyResult("Student Email", email)
                            .verifyResult("Gender", gender)
                            .verifyResult("Mobile", phoneNumber)
                            .verifyResult("Date of Birth", day + " " + month + "," + year)
                            .verifyResult("Subjects", subject)
                            .verifyResult("Hobbies", hobbies)
                            .verifyResult("Picture", fileName)
                            .verifyResult("Address", address)
                            .verifyResult("State and City", state + " " + city);
                });

        //Закрытие формы
        step("Close form", () -> {
            //Закрытие модальной формы
            registrationPage.closeModalForm();
        });
    }
}

