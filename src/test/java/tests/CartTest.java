package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest {

    @Test
    public void addProductToCart() {

        WebDriver driver = new ChromeDriver();

        // Open Browser
        driver.manage().window().maximize();

        // Open Website
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // Add Product To Cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        // Open Cart
        driver.findElement(By.className("shopping_cart_link"))
                .click();

        // Verify Product Exists In Cart
        String productName = driver.findElement(By.className("inventory_item_name"))
                .getText();

        Assert.assertEquals(productName, "Sauce Labs Backpack");

        System.out.println("Product added successfully");

        // Close Browser
//        driver.quit();
    }
}
