package com.demoqa.tests;

import com.demoqa.config.WebConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {
    static WebConfiguration config = ConfigFactory.create(WebConfiguration.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        baseUrl = config.baseUrl();
        browser = config.browser();
        browserVersion = config.browserVersion();
        pageLoadStrategy = "eager";
        browserSize = config.browserSize();
        if (config.isRemote()) {
            remote = config.remoteUrl();
        }

    }
}
