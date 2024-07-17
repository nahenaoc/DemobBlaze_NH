package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private final By usernameField = By.xpath("//input[@id='loginusername']");
    private final By passwordField = By.xpath("//input[@id='loginpassword']");
    private final By loginButton = By.xpath("//button[@onclick='logIn()']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(usernameField).sendKeys(Keys.TAB);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}


