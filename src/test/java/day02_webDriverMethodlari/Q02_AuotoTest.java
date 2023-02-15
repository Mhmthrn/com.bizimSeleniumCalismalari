package day02_webDriverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TransferQueue;

public class Q02_AuotoTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // www.trendyol.com adresine gidin

        driver.navigate().to("https://www.trendyol.com");

        // sayfanin title ni getirin
        System.out.println(driver.getTitle());

        // search bolumunde
        WebElement searchbox= driver.findElement(By.xpath("//div[@class='country-select']"));
        searchbox.click();

        WebElement bolgesec=driver.findElement(By.xpath("//option[@value='TR']"));
        bolgesec.click();

        WebElement select=driver.findElement(By.xpath("//*[@id=\"country-selection\"]/div/div/div[2]/div[4]/button"));
        select.click();

        //Apple Watch Ultra aratin
        WebElement aramaBolumu=driver.findElement(By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input"));
        aramaBolumu.sendKeys("Apple Watch Ultra"+ Keys.ENTER);

        // fiyat bilgisini getirin
        WebElement onerilenKismi= driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[2]/select"));
        onerilenKismi.click();

        WebElement enUcuz=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[2]/select/option[2]"));
        enUcuz.click();



       String fiyat=driver.findElement(By.xpath("(//div[@class='prc-box-dscntd'])[4]")).getText();


        System.out.println("Trendyol saat fiyati : "+fiyat);


        // butce 26.000 tl eger bu fiyattan dusukse sepete ekle.

        driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[4]")).click();

        driver.findElement(By.xpath("///button[@class='add-to-basket']")).click();




        Thread.sleep(5000);


        // driveri kapatin
        driver.quit();

    }
}
