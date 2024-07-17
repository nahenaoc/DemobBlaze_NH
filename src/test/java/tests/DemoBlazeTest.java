package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.CheckoutPage;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DemoBlazeTest extends TestBase {

    @Test
    public void loginToDemoBlaze() throws InterruptedException, IOException {
        setUp();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homePage.clickLoginLink();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        // Verify username
        WebElement usernameElement = driver.findElement(By.xpath("//a[@id='nameofuser' and text()='Welcome " + config.getProperty("username") + "']"));
        String actualUsername = usernameElement.getText().trim();
        Assert.assertEquals("Username verification failed", "Welcome " + config.getProperty("username"), actualUsername);

        // Navigate Laptops category
        homePage.clickLaptopsCategory();

        // Select a laptop
        WebElement selLat = driver.findElement(By.xpath("//a[@class='hrefch' and text()='MacBook Pro']"));
        selLat.click();

        // Verify laptop price
        String actualPriceLaptop = productPage.getPrice();
        Assert.assertEquals("Laptop Price verification failed", "$1100", actualPriceLaptop);

        // Add the laptop to the cart
        productPage.addToCart();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Return to the home page
        homePage.clickHomeLink();

        // Navigate Monitors category
        homePage.clickMonitorsCategory();

        // Select a monitor
        WebElement selMon = driver.findElement(By.xpath("//a[@class='hrefch' and contains(text(), 'Apple monitor 24')]"));
        selMon.click();

        // Verify monitor price
        String expectedMonitorPrice = "$400";
        String actualPriceMonitor = productPage.getPrice();
        Assert.assertEquals("Monitor Price verification failed", expectedMonitorPrice, actualPriceMonitor);

        // Add monitor to the cart
        productPage.addToCartm();
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        alert1.accept();

        // Navigate to the cart
        homePage.clickCartLink();

        // Verify the total amount of the cart
        Thread.sleep(2000);
        String expectedTotalPrice = "1500";
        WebElement totalPrice = driver.findElement(By.xpath("//h3[@class='panel-title' and @id='totalp']"));
        String actualTotalPrice = totalPrice.getText().trim();
        Assert.assertEquals("Total Price verification failed", expectedTotalPrice, actualTotalPrice);

        // Go to the checkout - click on the purchase button
        driver.findElement(By.xpath("//button[@data-target='#orderModal']")).click();

        // Fill in the payment form
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        checkoutPage.fillPaymentForm(
                config.getProperty("payment_name"),
                config.getProperty("payment_country"),
                config.getProperty("payment_city"),
                config.getProperty("payment_card"),
                config.getProperty("payment_month"),
                config.getProperty("payment_year")
        );

        // Click on the purchase button
        checkoutPage.clickPurchaseButton();

        // Click on the ok button to finish the purchase
        Thread.sleep(2000);
        checkoutPage.clickConfirmButton();

        // Click on the LogOut Button
        driver.findElement(By.xpath("//a[@onclick='logOut()']")).click();

        tearDown();
    }
}
