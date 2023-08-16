package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage {
    private WebDriver driver;

    @FindBy(id = "productTitle")
    WebElement productTitle;
    @FindBy(id = "priceblock_ourprice")
    WebElement productPrice;
    @FindBy(xpath = "//th[text()='İşlemci']/following-sibling::td")
    WebElement cpuModel;
    @FindBy(id = "add-to-cart-button")
    WebElement addCartButton;


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductCpuModel() {
        return cpuModel.getText();
    }

    public void addToCart() {
        addCartButton.click();
    }
}

