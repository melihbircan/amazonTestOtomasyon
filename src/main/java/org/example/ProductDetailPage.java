package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(By.id("productTitle")).getText();
    }

    public String getProductPrice() {
        return driver.findElement(By.id("priceblock_ourprice")).getText();
    }

    public String getProductCpuModel() {
        return driver.findElement(By.xpath("//th[text()='İşlemci']/following-sibling::td")).getText();
    }

    public void addToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}

