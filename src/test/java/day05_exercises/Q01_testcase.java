package day05_exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;
import java.util.List;

public class Q01_testcase {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        System.out.println("Test surecleri tamamlanmistir");
        driver.close();
    }

  /*  @Before
    public  void testStart(){
        driver.manage().window().fullscreen();

    }
    @After
    public  void testEnd(){
        System.out.println("Test parcali adimlari tamamlanmistir");
        driver.get();

    }*/

    //Test Case 7: Verify Test Cases Page

    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homeYazisi=driver.findElement(By.xpath("//a[text()=' Home']"));
       String actualDurum= homeYazisi.getAttribute("style");
       System.out.println(actualDurum);
       String expectedDurum="color: orange;";

       Assert.assertEquals(expectedDurum,actualDurum);
    }

    @Test
    public void test02(){
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//i[@class='fa fa-list'])[1]"+ Keys.ENTER));
        //5. Verify user is navigated to test cases page successfully
        WebElement testSayfaKont=driver.findElement(By.xpath("//h2[@class='title text-center']"));

        String expectedYazi="TEST CASES";

        String actualYazi=testSayfaKont.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }


    @Test@Ignore
    public  void Test03(){
        //6.  https://www.techlistic.com/p/selenium-practice-form.html sayfasina gidiniz
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //7. navigasy0n kisminda bulunan iceriklerin listesini yazdirirn

        List<WebElement> navigateBar=driver.findElements(By.className("overflowable-item"));
        int siraNo=1;
        int arrindex=0;
        String [] strarr=new String[navigateBar.size()];
        for (WebElement eachElement: navigateBar){

            strarr[arrindex]= String.valueOf(eachElement);
            arrindex++;

            System.out.println(siraNo+" =-=-=-= "+eachElement.getText());
            siraNo++;
        }
        String expectedBaslik="Contact";
        for (String s : strarr) {

            Assert.assertTrue(expectedBaslik.contains(s));

        }

        //8. icerik icerisinde "Contact" basligi icerip icermedigini test edin
    }




    // 9. bulunnulan sayfada footer bolumunde "Powered by Blogger" yazdigini test ediniz
    //10.driverimiz sayfa gecislerinde kapatilip tekrar acilsin












}
