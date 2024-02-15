package cw.tests.Day16.Tasks;

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

public class HW_02_DataProviderHomework {
    /*
Go to URL: https://opensource-demo.orangehrmlive.com/
Login with negative credentilas by Data Provider.
Then assert that ‘’Invalid credentials’’ is displayed.


URL'ye gidin: https:opensource-demo.orangehrmlive.com
 Veri Sağlayıcı tarafından negatif kimlik bilgileriyle oturum açın.
  Ardından "Geçersiz kimlik bilgileri"nin görüntülendiğini onaylayın.
     */
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "getData")
    public void test(String username, String password) {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement usernameElement = driver.findElement(By.xpath("//input[@name='username']"));
        usernameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@type='password']"));
        passwordElement.sendKeys(password);

        WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
        login.click();

        WebElement message = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        Assert.assertTrue(message.isDisplayed(),"Hata mesajı görüntülenmedi...");

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{

                {"admin","123"},
                {"qwe","11"},
                {"klj","8709"},
                {"jkh","98"}

        };
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}

