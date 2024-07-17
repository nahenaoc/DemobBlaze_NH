package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;

    private final By priceContainer = By.xpath("//h3[@class='price-container']");
    private final By addToCartButton = By.xpath("//a[@onclick='addToCart(15)']");
    private final By addToCartButtonm = By.xpath("//a[@onclick='addToCart(10)']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        return driver.findElement(priceContainer).getText().trim().split("\\s+")[0];
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
    public void addToCartm() {
        driver.findElement(addToCartButtonm).click();
    }
}
