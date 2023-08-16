package org.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;


public class AmazonTest {
    @Test
    public void amazonTestProduct() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\PAYTR_AMAZON\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            HomePage homePage = new HomePage(driver);
            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
            ProductDetailPage productDetailPage = new ProductDetailPage(driver);
            CartPage cartPage = new CartPage(driver);

            homePage.goToHomePage();

            if (homePage.isAtHomePage()) {
                System.out.println("Amazon sitesine gidildi.");
            } else {
                System.out.println("Amazon sitesine gidilemedi.");
                return;
            }

            homePage.searchProduct("Macbook Pro");
            searchResultsPage.openFirstProductDetails();

            String productName = productDetailPage.getProductName();
            String productPrice = productDetailPage.getProductPrice();
            String productCpuModel = productDetailPage.getProductCpuModel();

            System.out.println("Ürün Adı: " + productName);
            System.out.println("Fiyat: " + productPrice);
            System.out.println("CPU Modeli: " + productCpuModel);

            // Ürün bilgilerini dosyaya yaz
            try (FileWriter writer = new FileWriter("product_info.txt")) {
                writer.write("Ürün Adı: " + productName + "\n");
                writer.write("Fiyat: " + productPrice + "\n");
                writer.write("CPU Modeli: " + productCpuModel + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            productDetailPage.addToCart();

            if (cartPage.isProductInCart()) {
                System.out.println("Ürün sepete eklendi ve sepette.");
            } else {
                System.out.println("Ürün sepete eklenemedi veya sepette değil.");
            }
        } finally {
            driver.quit();
        }
    }
}
