package day05_exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Q1_TestCase7 {
    //Test Case 7: Verify Test Cases Page
    //    //1. Launch browser
    //    //2. Navigate to url 'http://automationexercise.com'
    //    //3. Verify that home page is visible successfully
    //    //4. Click on 'Test Cases' button
    //    //5. Verify user is navigated to test cases page successfully
    //    //6.  https://www.techlistic.com/p/selenium-practice-form.htm sayfasina gidiniz
    //    //7. navigasyon kisminda bulunan iceriklerin listesini yazdirirn
    //    //8.icerik icerisinde "Contact" basligi icerip icermedigini test edin
    //    // 9. bulunnulan sayfada footer bolumunde  "Powered by Blogger" yazdigini test ediniz
    //    //10.driverimiz sayfa gecislerinde kapatilip tekrar acilsin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }


    @After
    public void gecis() throws InterruptedException {
        Thread.sleep(4000);

    }

    @Test
    public void test01() {
        driver.navigate().to("http://automationexercise.com");
        WebElement homeYazisi = driver.findElement(By.xpath("//a[text()=' Home']"));
        String actualDurum = homeYazisi.getAttribute("style");
        System.out.println(actualDurum);//
        String expectedDurum = "color: orange;";

        Assert.assertEquals(expectedDurum, actualDurum);
    }

    @Test
    public void test02(){
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement testPage=driver.findElement(By.xpath("/html/body/section/div/div[1]/div/h2/b"));

        String expectedYazi="TEST CASES";
        String actualYazi=testPage.getText();
        System.out.println(actualYazi);//

        Assert.assertEquals(expectedYazi,actualYazi);
    }

    @Test
    public void test03(){
        //6.  https://www.techlistic.com sayfasina gidiniz
        driver.navigate().to("https://www.techlistic.com");

        //7. navigasyon kisminda bulunan iceriklerin listesini yazdirirn
        List<WebElement> navigateBar=driver.findElements(By.className("overflowable-item"));
        String [] listBar=new String[navigateBar.size()];

        int siraNo=1;
        int strArrIndexNo=0;

        for (WebElement eachElemenet:navigateBar ) {
            listBar[strArrIndexNo]= String.valueOf(eachElemenet.getText());
            strArrIndexNo++;
            System.out.println(siraNo + " -=-=-=--=-=-=- " +eachElemenet.getText());
            siraNo++;
        }

        System.out.println(Arrays.toString(listBar));

        //8.icerik icerisinde "Contact" basligi icerip icermedigini test edin

        String expectedBaslik=" Contact";

        for (String s : listBar) {

            Assert.assertTrue(expectedBaslik.equalsIgnoreCase(s));


           System.out.println("Contact basligi icerik testi PASSED");

        }


    }
    //8. icerik icerisinde "Contact" basligi icerip icermedigini test edin
}




// 9. bulunnulan sayfada footer bolumunde "Powered by Blogger" yazdigini test ediniz
//10.driverimiz sayfa gecislerinde kapatilip tekrar acilsin



