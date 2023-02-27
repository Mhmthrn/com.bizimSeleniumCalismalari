package day11;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03 extends TestBase {

  @Test
  public void test() throws IOException {
      // youtube gidelim
      driver.get("https://youtube.com");
      wait(5);
      driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[11]")).click();
      wait(2);
      //trending bolumune jsexecutor kullanarak scroll yapin

      WebElement trending = driver.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item"));


      Actions actions = new Actions(driver);

      actions.scrollToElement(trending).perform();

     // JavascriptExecutor jse = (JavascriptExecutor) driver;

     // jse.executeScript("arguments[0].scrollIntoView();",trending);
      wait(2);

      // o sayfanin  ekran gorunturusnu alin

      TakesScreenshot tkSs = (TakesScreenshot) driver;
      File alanGoruntusu = new File("target/ytSs.jpeg");

      File geciciData = tkSs.getScreenshotAs(OutputType.FILE);
      wait(2);

      FileUtils.copyFile(geciciData, alanGoruntusu);
      // kapanmadan once alert seklinde  "islem basari ile tamamlandi" yazdirin.

      wait(2);

     //jse.executeScript("alert('islem basari ile tamamlandi.:::::))))))))')");

  }




 }
