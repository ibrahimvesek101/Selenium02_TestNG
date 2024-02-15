package cw.tests.Day16.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW_04_ParametersHomework {

    /*

Go to URL: https://www.amazon.com
Search words: Java, Selenium
Assert get text result est that the result text contains the searched Word.
Run tests from XML file.


URL'ye gidin: https:www.amazon.com
Arama sözcükleri: Java, Selenium
Aldığınız metin sonucunu, sonuç metninin aranan Word'ü içerdiğini iddia edin.
Testleri XML dosyasından çalıştırın.

     */
    WebDriver driver;

    @Test(dataProvider = "getData")
    public void test01(String data) throws InterruptedException {
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys(data + Keys.ENTER);

        WebElement message=driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]"));
        Assert.assertTrue(message.getText().contains(data));

        Thread.sleep(1000);
        driver.quit();

    }


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{

                {"Java"},
                {"Selenium"}

        };

    }
}
