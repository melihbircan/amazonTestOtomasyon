package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver driver;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart() {return cartCount.getText().equals("1");}
}
