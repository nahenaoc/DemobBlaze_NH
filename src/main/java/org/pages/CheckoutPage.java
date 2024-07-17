package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//input[@id='name']");
    private final By countryField = By.xpath("//input[@id='country']");
    private final By cityField = By.xpath("//input[@id='city']");
    private final By cardField = By.xpath("//input[@id='card']");
    private final By monthField = By.xpath("//input[@id='month']");
    private final By yearField = By.xpath("//input[@id='year']");
    private final By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    private final By confirmButton = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPaymentForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(nameField).sendKeys(Keys.TAB);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(countryField).sendKeys(Keys.TAB);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cityField).sendKeys(Keys.TAB);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(cardField).sendKeys(Keys.TAB);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(monthField).sendKeys(Keys.TAB);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }
}
