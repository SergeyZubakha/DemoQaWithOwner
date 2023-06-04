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
                .verifyStudentName("Student Name", "Sergei Zizu")
                .verifyStudentEmail("Student Email", "twst@ya.ru")
                .verifyGender("Gender", "Male")
                .verifyMobile("Mobile", "7111111223")
                .verifyDateOfBirth("Date of Birth", "15 October,1991")
                .verifySubjects("Subjects", "Maths")
                .verifyHobbies("Hobbies", "Sports")
                .verifyPicture("Picture", "qa.png")
                .verifyAddress("Address", "Moscow, Red street 4")
                .verifyStateAndCity("State and City", "NCR Noida");

        //Закрытие модальной формы
        registrationPage.closeModalForm();

    }
}

