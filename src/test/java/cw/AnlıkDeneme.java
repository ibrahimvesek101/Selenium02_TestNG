package cw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class AnlıkDeneme {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() {

        driver.get("https://qa-gm3.quaspareparts.com/mlm/#/stock");

        WebElement redBox = driver.findElement(By.id("//*[text()='Request failed with status code 500']"));


        Assert.assertTrue(redBox.isDisplayed());


    }

    @AfterMethod
    public void son() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();

    }
}
