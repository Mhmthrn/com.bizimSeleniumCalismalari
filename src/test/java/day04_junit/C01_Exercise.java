package day04_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Exercise {
    //Test Case 10: Verify Subscription in home page

    static WebDriver driver;


    @BeforeClass
    public static void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public  void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));

        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test02(){
        //4. Scroll down to footer
       //5. Verify text 'SUBSCRIPTION'
        WebElement footer=driver.findElement(By.xpath("//h2[text()='Subscription']"));
       Assert.assertTrue(footer.isDisplayed());
    }

    @Test
    public void test03(){
        //6. Enter email address in input and click arrow button

        driver.findElement(By.id("susbscribe_email")).sendKeys("ahmetmehmethasan@gmail.com");
        driver.findElement(By.id("subscribe")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message=driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));

        String expectedMessage="You have been successfully subscribed!";
        String actulalMessage=message.getText();

        Assert.assertEquals(expectedMessage,actulalMessage);
    }

    @Test
    public void test04() {
            //8. www.yourtube.com a gidin arama bolumunda Ahmet Bululuoz
            // 9. cilan sonuc bilgisini bize getirin
            // driveri kapatin
            driver.get("https://www.youtube.com");
            driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys("Ahmet Bulutluoz"+ Keys.ENTER);

            WebElement aboneSayisi= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-channel-renderer/div/div[2]/a/div[1]/div/span[3]"));
            //aboneSayisi.getText();
            String uyeSayisiStr= aboneSayisi.getText();
            int uyeSayisiIInt=Integer.parseInt(uyeSayisiStr);
            int expecteedInt=8000;

            Assert.assertFalse(uyeSayisiIInt<expecteedInt);

        }

}
