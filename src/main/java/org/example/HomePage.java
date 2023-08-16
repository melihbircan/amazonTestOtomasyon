package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "searchTextBox")
    WebElement searchTextBox;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
    }

    public boolean isAtHomePage() {
        return driver.getTitle().contains("Amazon");
    }

    public void searchProduct(String keyword) {
        searchTextBox.sendKeys(keyword);
        searchButton.click();
    }
}
