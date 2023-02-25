package day10_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01 extends TestBaseClass {
    //Bir Class olusturun D19_WebtablesHomework
    //1. “https://demoqa.com/webtables” sayfasina gidin
    @Test
    public void test(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerBasliklar=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        int siraNo=1;
        for (WebElement eachHead:headerBasliklar){
            System.out.println(siraNo+" : "+eachHead.getText());
        }

        System.out.println("=-=-=-=-=-=-=-3-=-=-=-=-=-=-=-=-=-=-=-=");
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutunun basli : "+driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]")).getText());
        System.out.println("=-=-=-=-=-=-=-4-=-=-=-=-=-=-=-=-=-=-=-=");

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalar=driver.findElements(By.xpath("//div[@class='rt-td']"));
        siraNo=1;
        for (WebElement eachHead:tumDatalar){
            System.out.println(siraNo+" : "+eachHead.getText());
            siraNo++;
        }
        System.out.println("=-=-=-=-=-=-=-5-=-=-=-=-=-=-=-=-=-=-=-=");
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosolmayanCell=0;

        siraNo=1;

        for (WebElement eachData:tumDatalar){
            if ((!eachData.getText().equals(" ")) ){
                System.out.println(siraNo+" = "+eachData.getText());
                siraNo++;

                bosolmayanCell++;
            }


        }
        System.out.println("Tabloda bos olmayan "+bosolmayanCell+ " tane cell bulunmaktadir.");

        System.out.println("=-=-=-=-=-=-=-6-=-=-=-=-=-=-=-=-=-=-=-=");
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlar=driver.findElements(By.xpath(" //div[@class='rt-tr-group']"));
        int satirSayisi=satirlar.size();

        System.out.println("Tablodaki Satir sayisi: "+satirSayisi);
        System.out.println("=-=-=-=-=-=-=-7-=-=-=-=-=-=-=-=-=-=-=-=");
        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunlar=driver.findElements(By.xpath(" //div[@class='rt-resizable-header-content']"));
        int sutunSayisi=sutunlar.size();

        System.out.println("Tablodaki Sutun sayisi: "+sutunSayisi);

        System.out.println("=-=-=-=-=-=-=-8-=-=-=-=-=-=-=-=-=-=-=-=");
        // 8. Tablodaki 3.kolonu yazdirin

        String header=driver.findElement(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer'][3]")).getText();


        List<WebElement>ucuncusutunListesi=driver.findElements(By.xpath("//div[@class='rt-td'][3]"));

        System.out.println(" Ucuncu Kolon: "+header);
        for (WebElement eachElement:ucuncusutunListesi){
            System.out.println(eachElement.getText());
        }



        System.out.println("=-=-=-=-=-=-=-9-=-=-=-=-=-=-=-=-=-=-=-=");
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        String kierraSalary = driver.findElement(By.xpath("//div[text()='2000']")).getText();
        System.out.println("Kierra salary : " + kierraSalary);


        System.out.println("=-=-=-=-=-=-=-10-=-=-=-=-=-=-=-=-=-=-=-=");
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


    }
}
