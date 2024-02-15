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

public class HW_01_DataProviderHomework {

    /*
        Open the site: https://www.amazon.com/
        Search the following keys with DataProvider:
        Java
        JavaScript
        Phyton

        Siteyi açın: https:www.amazon.com
        DataProvider ile şu anahtarları arayın:
        Java
        JavaScript
        Phyton
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
    public void test(String datas) {

        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(datas + Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(resultText.getText().contains(datas));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Java"},
                {"JavaScript"},
                {"Python"}
        };

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

