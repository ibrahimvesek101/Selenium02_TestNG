package cw.tests.Day16.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_03_DataProviderHomework {
    /*
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: clarusway@gmail.com
Password: 123456789
Using the Search function do it with Data Provider for Mac, iPad and Samsung.


Siteyi açın: http:opencart.abstracta.usindex.php?route=accountlogin
 Bu kimlik bilgileriyle oturum açın
 E-posta: clarusway@gmail.com
 Parola: 123456789
 Arama işlevini Mac, iPad ve Samsung için Veri Sağlayıcı ile yapın.

     */
    WebDriver driver;


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest(){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement input_email = driver.findElement(By.id("input-email"));
        WebElement input_password = driver.findElement(By.id("input-password"));
        WebElement input_submit = driver.findElement(By.xpath("//*[@type='submit']"));

        input_email.sendKeys("clarusway@gmail.com");
        input_password.sendKeys("123456789");
        input_submit.click();
    }

    @Test(dataProvider = "getData")
    public void searchTest(String data) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement search=driver.findElement(By.xpath("//*[@name='search']"));
        search.sendKeys(data);
        WebElement searchButton=driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg']"));
        searchButton.click();

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{

                {"Mac"},{"iPad"},{"Samsung"},

        };
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}