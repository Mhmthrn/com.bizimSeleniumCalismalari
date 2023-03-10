package day10_WebTable;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ extends TestBase {

    @Test
    public void test() throws IOException {
        //https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login adrtesine git
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //bank maneger login butonuna tikla
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        //costumer bolumne tiklayin ve butun bilgileri yaydirin, "	E55555" posta lodlu musterinin oldugunu test edin
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        WebElement tumBilgiler=driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));

        System.out.println(tumBilgiler.getText());

        String expectedPostaK="E55555";

        Assert.assertTrue(tumBilgiler.getText().contains(expectedPostaK));

        //bir geri gelin
        driver.navigate().back();
        // ad costumer bolumene tilayin
        driver.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
        // acilan pencerede ilgili yerlerie fake bilgiler ekleyin

        WebElement isimbolumu=driver.findElement(By.xpath("//input[@ng-model='fName']"));
        Actions actions=new Actions(driver);

        Faker faker=new Faker();

       /* actions.contextClick(isimbolumu)

                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        wait(2);*/
        actions.contextClick(isimbolumu)

                .sendKeys("Tomy")
                .sendKeys(Keys.TAB)
                .sendKeys("Teres")
                .sendKeys(Keys.TAB)
                .sendKeys("895623")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();


        wait(2);



        String sutun=driver.findElement(By.xpath("//td[2]")).getText();

        String satir=driver.findElement(By.xpath("//td[@class='ng-binding'][3]")).getText();

        System.out.println("Istenen data 2 satir 3 sutun "+sutun+"   " +satir);
        



        // musteri bilgi listesini tekrar yazdirin ve eklediginiz yeni musterinin listede oldugunu test edin
         tumBilgiler=driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));

        System.out.println(tumBilgiler.getText());
        String expectedIsim="Tomy";

        Assert.assertTrue(tumBilgiler.getText().contains(expectedIsim));

        TakesScreenshot tss=(TakesScreenshot) driver;
        File tamSayfaSShot=new File("src/test/java/screnShot/tamSayfa.jpeg");

        File geciciRsim=tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciRsim,tamSayfaSShot);

    }

}
