package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        //Проверка формы
        registrationPage.openPage()
                .closeBanners()
                .setFirsName("Sergei")
                .setLastName("Zizu")
                .setUserEmail("twst@ya.ru")
                .setGender("Male")
                .setUserNumber("7111111223")
                .setBirthDay("15", "October", "1991")
                .setSubject("Maths")
                .setHobbies("Sports")
                .selectPicture("qa.png")
                .setState("NCR")
                .setCity("Noida")
                .setAddress("Moscow, Red street 4")
                .submitForm();

        //Проверка формы
        registrationPage.verifyGreeting()
                .verifyResult("Student Name", "Sergei Zizu")
                .verifyResult("Student Email", "twst@ya.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "7111111223")
                .verifyResult("Date of Birth", "15 October,1991")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "qa.png")
                .verifyResult("Address", "Moscow, Red street 4")
                .verifyResult("State and City", "NCR Noida");

        //Закрытие модальной формы
        registrationPage.closeModalForm();

    }
}

