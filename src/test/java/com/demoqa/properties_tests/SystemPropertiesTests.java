package com.demoqa.properties_tests;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser", "chrome");

    }


}
