package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstProductDetails() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> results = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"));
        if (!results.isEmpty()) {
            results.get(0).click();
        }
    }
}

