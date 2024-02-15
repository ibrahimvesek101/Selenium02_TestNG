package cw.tests.Day18;

import cw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_PageClassTest {


    @Test
    public void withoutPageClass() {

        WebDriver driver = Driver.getDriver();

        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("ibrahim@clarusway.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abc123");

        WebElement signIn = driver.findElement(By.xpath("//*[@class='btn__primary--large from__button--floating']"));
        signIn.click();

        WebElement errorMessage = driver.findElement(By.id("error-for-username"));
        Assert.assertTrue(errorMessage.getText().contains("LinkedIn hesabı bulunamadı."));

        Driver.closeDriver();
        driver.quit();


    }

    @Test
    public void withPageClass2() {

        WebDriver driver = Driver.getDriver();

        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");

        C03_LinkedinLoginPage loginPage = new C03_LinkedinLoginPage();

        loginPage.email.sendKeys("ibrahim@clarusway.com");
        loginPage.password.sendKeys("abc123");
        loginPage.signIn.click();
        String errorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(errorMessage.contains("LinkedIn hesabı bulunamadı."));

        Driver.closeDriver();

        driver.quit();
    }

}

