package com.roomraccoon.stepDefinitions;

import com.roomraccoon.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HomePageSteps {
    private HomePage homePage;
    private Scenario scenario;
    private RemoteWebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        this.scenario = scenario;
        String hubUrl = System.getenv("SELENIUM_HUB_URL");
        if (hubUrl == null || hubUrl.isEmpty()) {
            hubUrl = "http://host.docker.internal:4444/wd/hub";// Used the one on docker-compose
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.merge(options);
        capabilities.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + "_failure");
                String pageSource = driver.getPageSource();
                scenario.attach(pageSource, "text/html", "Page Source on Failure");
                scenario.log("Current URL: " + driver.getCurrentUrl());
            } catch (Exception e) {
                scenario.log("Failed to capture screenshot: " + e.getMessage());
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }




    @Given("I am on the DemoBlaze Homepage")
    public void navToHomePage(){
    homePage.openHomePage();  



}

}
