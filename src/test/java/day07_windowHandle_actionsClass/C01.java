package day07_windowHandle_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.crypto.KeyAgreementSpi;
import java.awt.*;
import java.util.List;

public class C01 extends TestBase {

    @Test
    public void test01(){
        //1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //2- cizgili alan uzerine sag click yapin ve alerti onaylayin
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(cizgiliAlan).perform();
        driver.switchTo().alert().accept();
        //3- ana sayfade "Context Menu" yazdigini test edin
        String expectedYazi="Context Menu";
        String actualyazi=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedYazi,actualyazi);
        wait(2);

        String ilkSayfaWHD=driver.getWindowHandle();



        //4- ikinci bir sayfada youtub a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        String ikinciSayfaWHD=driver.getWindowHandle();


      /*  //5- arambolumunde "Java" aratin cikan videolarin baslik kismind a"String" ifadesi bulundugunu testedin
        //arama bolumunde "Java" aratin, cikan videolarin baslik kisminda "String" ifadesi bulundugunu test edin
       WebElement aramaKutusu= driver.findElement(By.xpath("//ytd-searchbox[@id='search']"));
       aramaKutusu.sendKeys("Java"+Keys.ENTER);


        List<WebElement> basliklarList=driver.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));

        String expectedIcerik="String";

        for (WebElement element:basliklarList){
           Assert.assertTrue(element.getText().contains(expectedIcerik));
        }*/




        //6-https://demoqa.com/droppable adersine gidin ve Accept boumune tiklayin ve
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demoqa.com/droppable");
        driver.findElement(By.linkText("Accept")).click();
        //7- accepttable elementini drop here bolume surukleyin ve cikan yazinin "Dropped!" oldugunu test edin

        WebElement dragObj=driver.findElement(By.id("acceptable"));
        WebElement dropObj=driver.findElement(By.xpath("(//div[@id='droppable'])[2]"));
        action.dragAndDrop(dragObj,dropObj).perform();

        expectedYazi="Dropped!";
        actualyazi= driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedYazi,actualyazi);


        //8 - youtube don ve ana sayfada youtube amnblemi gozuktugunu test et
        driver.switchTo().window(ikinciSayfaWHD);
        WebElement logo=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


        //9- baslangic sayfamiza donup test islemini tamamlayiniz
        driver.switchTo().window(ilkSayfaWHD);


    }
    /*@Test
    public void test02(){
        //4- ikinci bir sayfada youtub a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        String ikinciSayfaWHD=driver.getWindowHandle();
        wait(2);


        //5- arambolumunde "Java" aratin cikan videolarin baslik kismind a"String" ifadesi bulundugunu testedin
        //arama bolumunde "Java" aratin, cikan videolarin baslik kisminda "String" ifadesi bulundugunu test edin
        WebElement aramaKutusu= driver.findElement(By.id("search-container"));
        aramaKutusu.click();
        Assert.assertTrue(aramaKutusu.isEnabled());
        aramaKutusu.sendKeys("Java"+Keys.ENTER);


       /* List<WebElement> basliklarList=driver.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));

        String expectedIcerik="String";

        for (WebElement element:basliklarList){
            Assert.assertTrue(element.getText().contains(expectedIcerik));
        }*/
    }



