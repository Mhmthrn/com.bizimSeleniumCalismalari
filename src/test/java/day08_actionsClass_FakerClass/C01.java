package day08_actionsClass_FakerClass;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseClass;

import javax.swing.text.TabableView;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public  class C01 extends TestBaseClass {
    @Test
    public  void test01(){
        //https://the-internet.herokuapp.com/download
        //LambdaTest elementini indirin indirdiginizi test edin
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("LambdaTest.txt")).click();

        wait(2);

        String dosyayolu="C:\\Users\\USER\\Downloads\\LambdaTest.txt\\";

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }

    @Test
    public void test02(){
        driver.switchTo().newWindow(WindowType.TAB);
        //https://the-internet.herokuapp.com/upload baska bir tabda acin
        driver.get("https://the-internet.herokuapp.com/upload");
        //download da bulunan LambdaTest.txt dosyasini   basarili bir sekilde  yuklendigini test edin.
        WebElement dosyaEklemebutonu=driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\LambdaTest.txt";
        dosyaEklemebutonu.sendKeys(dinamikDosyaYolu);
        driver.findElement(By.id("file-submit")).click();

        String expectedYazi="File Uploaded!";
        String actualYazi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);
    }

    @Test
    public void Test03(){
        //https://ultimateqa.com/
        driver.get("https://ultimateqa.com/");
        // adresine gidin Learning blolumunun uzerine gelip Automation bolumunu secin
        WebElement lerningBolumu=driver.findElement(By.linkText("Learning"));
        Actions actions=new Actions(driver);

        actions.moveToElement(lerningBolumu).perform();
        driver.findElement(By.linkText("Automation Exercises")).click();

        // acilan sayfada fill out forms bolumune tiiklayin
        driver.findElement(By.linkText("Fill out forms")).click();


        // name ve message bolumleirne fake bilgilera isleyin ve submit yapin yapilan islemin
        WebElement ilkbilgiKutusu=driver.findElement(By.id("et_pb_contact_name_0"));

        Faker faker=new Faker();

       /* String islem=driver.findElement(By.xpath("//span [@class=\"et_pb_contact_captcha_question\"]")).getText();

        islem.replaceAll(",","+");


        String [] arr= islem.split(",");

        int intIslem=0;
        for (String s : arr) {
            intIslem = intIslem + Integer.parseInt(s);
        }*/


        actions.contextClick(ilkbilgiKutusu)
                .sendKeys(faker.name().firstName().toUpperCase())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().paragraph())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName().toLowerCase())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .sendKeys(Keys.TAB)
                .sendKeys("12")//degisken deger
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // Thanks for contacting us//Thanks for contacting us "" oldugunu test edin
        String expectedCikti="Thanks for contacting us";

        WebElement yazi1= driver.findElement(By.xpath("(//*[text()='Thanks for contacting us'])[1]"));
        String syazi1=yazi1.getText();
        WebElement yazi2= driver.findElement(By.xpath("(//*[text()='Thanks for contacting us'])[2]"));
        String syazi2=yazi2.getText();

        Assert.assertTrue(syazi1.contains(expectedCikti) &syazi2.contains(expectedCikti));




    }
}
