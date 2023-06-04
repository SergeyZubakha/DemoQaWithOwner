package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        //Проверка формы
        registrationPage.openPage()
                .setFirsName("Sergei")
                .setLastName("Zizu")
                .setUserEmail("twst@ya.ru")
                .setGender("Male")
                .setUserNumber("7111111223")
                .setBirthDay("15", "October", "1991")
                .setSubject("Maths")
                .setHobbies("Sports")
                .selectPicture()
                .setState("NCR")
                .setCity("Noida")
                .setAddress("Moscow, Red street 4")
                .submitForm();

        //Проверка формы
        registrationPage.verifyGreeting()
                .verifyStudentName("Sergei Zizu")
                .verifyStudentEmail("twst@ya.ru")
                .verifyGender("Male")
                .verifyMobile("7111111223")
                .verifyDateOfBirth("15 October,1991")
                .verifySubjects("Maths")
                .verifyHobbies("Sports")
                .verifyPicture("qa.png")
                .verifyAddress("Moscow, Red street 4")
                .verifyStateAndCity("NCR Noida");

        //Закрытие модальной формы
        registrationPage.closeModalForm();

    }
}

