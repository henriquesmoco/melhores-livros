package io.github.henriquesmoco.melhoreslivros.selenium;

import io.github.henriquesmoco.melhoreslivros.model.ElectionSummary;
import io.github.henriquesmoco.melhoreslivros.selenium.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;


@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class HomePageIntegrationTests extends AbstractTestNGSpringContextTests {
    private WebDriver driver;
    private HomePage homePage;

    @Parameters({"baseUrl"})
    @BeforeClass
    public void beforeClass(String baseUrl) {
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver, baseUrl);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifyHomePageListElectionsSummary() {
        List<ElectionSummary> expectedSummaries = Arrays.asList(new ElectionSummary[] {
                new ElectionSummary(1, "JQuery"),
                new ElectionSummary(2, "Test"),
                new ElectionSummary(4, "Spring")
        });

        homePage.navigate();
        List<ElectionSummary> summaries = homePage.getAllElectionsSummary();
        assertEquals(summaries, expectedSummaries);
    }
}
