package io.github.henriquesmoco.melhoreslivros.selenium.pages;


import io.github.henriquesmoco.melhoreslivros.model.ElectionSummary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private final String baseUrl;
    private final WebDriver driver;

    public HomePage(WebDriver driver, String baseURL)
    {
        this.driver = driver;
        this.baseUrl = baseURL;
    }

    public HomePage navigate() {
        driver.get(baseUrl);
        return this;
    }

    public List<ElectionSummary> getAllElectionsSummary() {
        List<ElectionSummary> result = new ArrayList<>();

        WebElement electionSummary = driver.findElement(By.id("election-summary"));
        List<WebElement> summaryBodies = electionSummary.findElements(By.name("summary-body"));
        for (WebElement webElement : summaryBodies) {
            ElectionSummary summary = parseElectionSummary(webElement);
            result.add(summary);
        }
        return result;
    }

    private ElectionSummary parseElectionSummary(WebElement webElement) {
        int electionId = Integer.parseInt(webElement.getAttribute("data-electionId"));
        String subject = webElement.findElement(By.name("subject")).getText();

        ElectionSummary summary = new ElectionSummary(electionId, subject);
        return summary;
    }

}
