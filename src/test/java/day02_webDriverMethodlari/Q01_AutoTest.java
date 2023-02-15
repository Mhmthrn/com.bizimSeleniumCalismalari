package day02_webDriverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Q01_AutoTest {
    public static void main(String[] args) {

        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.mercedes-benz.com adresine gidin

        driver.get("https://www.mercedes-benz.com");

        driver.findElement(By.cssSelector("button.wb-button:nth-child(3)")).click();


        // sayfnin en alt bolumunde olan instagram linkine tiklayin

        WebElement instagramLink=driver.findElement(By.xpath("/html/body/div[3]/footer/div[1]/brandhub-social-media-box//div/div/nav/div/div/div[1]/brandhub-social-media-box-item//span/a/svg"));
        instagramLink.click();



        // instagram linki acildiktan sonra kac tane takipcisi oldugunu bilgisini yazdirin


        // 5 saniye sonra driveri kapatin



    }
}
