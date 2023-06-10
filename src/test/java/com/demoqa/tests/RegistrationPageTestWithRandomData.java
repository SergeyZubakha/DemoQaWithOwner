package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.*;
import org.junit.jupiter.api.Test;

import javax.security.auth.Subject;

import static com.demoqa.pages.RegistrationPage.*;

public class RegistrationPageTestWithRandomData extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String FirsName = faker.name().firstName(),
            LastName = faker.name().lastName(),
            Email = faker.internet().emailAddress(),
            PhoneNumber = faker.phoneNumber().subscriberNumber(10),
            Address = faker.address().fullAddress(),
            Day = String.valueOf(getRandomInt(10, 28)),
            Month = getRandomMonth(),
            Year = String.valueOf(getRandomInt(1900, 2100)),
            Gender = getRandomGender(),
            Subject = getRandomSubject(),
            Hobbies = getRandomHobbies(),
            State = getRandomState(),
            City = getRandomCity(State),
            FileName = "qa.png";


    @Test
    void successfulRegistrationTest() {

        //Проверка формы
        registrationPage.openPage()
                .closeBanners()
                .setFirsName(FirsName)
                .setLastName(LastName)
                .setUserEmail(Email)
                .setGender(Gender)
                .setUserNumber(PhoneNumber)
                .setBirthDay(Day, Month, Year)
                .setSubject(Subject)
                .setHobbies(Hobbies)
                .selectPicture(FileName)
                .setState(State)
                .setCity(City)
                .setAddress(Address)
                .submitForm();

        //Проверка формы
        registrationPage.verifyGreeting()
                .verifyResult("Student Name", FirsName + " " + LastName)
                .verifyResult("Student Email", Email)
                .verifyResult("Gender", Gender)
                .verifyResult("Mobile", PhoneNumber)
                .verifyResult("Date of Birth", Day + " " + Month + "," + Year)
                .verifyResult("Subjects", Subject)
                .verifyResult("Hobbies", Hobbies)
                .verifyResult("Picture", FileName)
                .verifyResult("Address", Address)
                .verifyResult("State and City", State + " " + City);

        //Закрытие модальной формы
        registrationPage.closeModalForm();

    }
}

