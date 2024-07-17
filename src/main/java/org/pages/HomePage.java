package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    private final By loginLink = By.xpath("(//a[@class='nav-link'])[5]");
    private final By laptopsCategory = By.xpath("//a[text()='Laptops']");
    private final By monitorsCategory = By.xpath("//a[@id='itemc' and contains(text(), 'Monitors')]");
    private final By homeLink = By.xpath("//a[@class='nav-link' and contains(text(), 'Home')]");
    private final By cartLink = By.xpath("//a[@id='cartur' and contains(text(), 'Cart')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }

    public void clickMonitorsCategory() {
        driver.findElement(monitorsCategory).click();
    }

    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }
}
