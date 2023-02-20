package day06_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {

    @Test
    public void test01(){
        // amazon adresine git
        driver.get("https://amazon.com");
        // tum kategoriler dropdowni locate et clik yap

        WebElement ddm =driver.findElement(By.xpath("//select[@data-nav-digest='k+fyIAyB82R9jVEmroQ0OWwSW3A=']"));
        ddm.click();
        Select select=new Select(ddm);
        // bulunan iceriklein listesini ve sayisini yazdirin
        System.out.println("DDM bulunan basliklar :"+select.getOptions().size());

        List<WebElement> icerikList=select.getOptions();
        int sirano=1;

        for (WebElement eachElement:icerikList){

            System.out.println(sirano+"=-=-=-"+eachElement.getText());
            sirano++;

        }
        // listesde "Software" bolumunun bulundugunu test edin
        String expected="Software";
        select.selectByVisibleText("Software");
        String actual=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);

        // index no 10 olan urunun ismini getirin
        System.out.println("Index no 10:"+select.getOptions().get(10).getText());


        wait(2);
    }

    @Test
    public void test02(){
        driver.get("https://amazon.com");
        // elekteronik bolumunu secip arama boumue Macbook yazip sonuclari pahalidan ucuza seklind esiralip

        WebElement ddm =driver.findElement(By.xpath("//select[@data-nav-digest='k+fyIAyB82R9jVEmroQ0OWwSW3A=']"));
        ddm.click();
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");
        select.getFirstSelectedOption().click();

        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("Macbook"+ Keys.ENTER);

        WebElement siralma=driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
        Select select1=new Select(siralma);
        select1.selectByVisibleText("Price: High to Low"+Keys.ENTER);

        //en pahali urunun 40000 tlden daha yuksek oldunu test edin
        WebElement enpahaliUrun=driver.findElement(By.xpath("(//div[@class='sg-col-20-of-24 s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16'])[1]"));

        System.out.println(enpahaliUrun.getText());

        String expectedFiyat="4,794";
        String actualfiyat=enpahaliUrun.getText();
        Assert.assertEquals(expectedFiyat,actualfiyat);
    }
}
