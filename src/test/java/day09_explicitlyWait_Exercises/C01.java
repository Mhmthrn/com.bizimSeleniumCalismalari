package day09_explicitlyWait_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C01 {

    @Test
    public void Test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Wise quarter adseine gidin
        driver.get("https://www.wisequarter.com");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        // id si "zsiq_agtpic" olan chat objesi yuklenenne kadar bekleyin
        WebElement mesajIconu= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zsiq_agtpic")));
        mesajIconu.click();

        driver.switchTo().frame("siqiframe");

        // chat objesinin basarili bir sekilde yuklandigini ve ulasilabilir oldugunu test edin
        WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emptybg\"]/div[2]/em[2]")));

        Assert.assertTrue(logo.isDisplayed());
        driver.switchTo().parentFrame();

        Thread.sleep(2000);

        driver.close();

    }
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // youtube sayfasina gidin
        driver.get("https://youtube.com");
        // butun cookies leri yazdirin
       Set<Cookie> ytCookie= driver.manage().getCookies();

       int siraNo=1;
       for (Cookie eachCookie:ytCookie){
           System.out.println(siraNo+" : "+eachCookie.toString());
           siraNo++;
       }
        // tum cookies sayisinin 10 dan dusuk oldugunu test edin

        Assert.assertTrue(ytCookie.size()<10);

        // sayfanin tum cookielerinin siliniz
        driver.manage().deleteAllCookies();
        driver.manage().getCookies();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-");
         siraNo=1;
        for (Cookie eachCookie:ytCookie){
            System.out.println(siraNo+" : "+eachCookie.toString());
            siraNo++;
        }
        Assert.assertTrue(ytCookie.size()!=0);

        driver.close();

    }

    @Test
    public  void test03(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://ultimateqa.com/simple-html-elements-for-automation/ sayfasina gidin
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Actions actions=new Actions(driver);
        WebElement baslik= driver.findElement(By.xpath("//*[text()='HTML Table with no id']"));
        actions.scrollToElement(baslik).perform();

        //"HTML Table with unique id" baslikli WebTable da bulunan butun datalari yazdirin ve data

        List<WebElement> dataList = driver.findElements(By.xpath("//tbody/tr"));
        int siraNo=1;
        for (WebElement eachElement: dataList){
            System.out.println(siraNo+" : "+eachElement.getText());
            siraNo++;
        }

        // data sayisinin 10 dan az oldugunu test edin
        Assert.assertTrue(dataList.size()<10);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // Automation Testing Architect mesleginin salary bilgisini yazdirin
        WebElement maas=driver.findElement(By.xpath("(//tbody/tr/td)[6]"));
        String maasstr=maas.getText();
        System.out.println("Automation Testing Architect maas/Yilik : "+maasstr);

        // salary in 110,000 daha yuksek oldugunu test edin
       maasstr= maasstr.replaceAll("\\D","").replaceAll(",","");
        System.out.println(maasstr);

        int actualmaas=Integer.parseInt(maasstr);
        int expectedMiktar=110000;

        Assert.assertTrue(actualmaas>expectedMiktar);
        driver.close();

    }

}
