package day03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_TestCase9_SerchProduckt {
    public static void main(String[] args) {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logo=driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        if (logo.isDisplayed()){
            System.out.println("Ana sayfa doru goruntulendi");
        }else{
            System.out.println("Ana sayfa dogru goruntulenemedi.");
        }

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProdukt= driver.findElement(By.xpath("//h2[text()='All Products']"));

      if (allProdukt.isDisplayed()){
          System.out.println("Tum urunler goruntulendi");
      }

        //6. Enter product name in search input and click search button
        WebElement searchBox=driver.findElement(By.id("search_product"));
      searchBox.sendKeys("Polo");

      driver.findElement(By.id("submit_search")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible

        WebElement verifeyText= driver.findElement(By.xpath("//h2[@class='title text-center']"));

        if (verifeyText.isDisplayed()){
            System.out.println("SEARCHED PRODUCTS  gorunur halde");
        }

        //8. Verify all the products related to search are visible
        WebElement aramaSonucu=driver.findElement(By.xpath("(//h2[text()='Rs. 1500'])[1]"));
        if (aramaSonucu.isEnabled()){
            System.out.println("Arama sonuclari gorunur durumdadir.");
        }

        driver.close();
    }
}
