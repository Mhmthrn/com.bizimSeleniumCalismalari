package day03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_LoginUser {
    public static void main(String[] args) {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo=driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        if (logo.isDisplayed()){
            System.out.println("Ana sayfa doru goruntulendi");
        }else{
            System.out.println("Ana sayfa dogru goruntulenemedi.");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text ()=' Signup / Login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement accountDrurumu= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (accountDrurumu.isDisplayed()){
            System.out.println("Login to your account gorunur durumda");
        }

        //6. Enter correct email address and password
        WebElement email=driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("testmail108@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Isiklar555");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
