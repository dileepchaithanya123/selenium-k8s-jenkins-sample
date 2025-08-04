package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumK8sTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        // Replace with your Selenium Grid URL (running in Kubernetes)
        String remoteUrl = "http://selenium-hub.default.svc.cluster.local:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
    }

    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
        assert driver.getTitle().contains("Google");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}