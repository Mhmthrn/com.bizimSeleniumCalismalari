package day03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_FirtsTest{
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

   /* @AfterClass
    public static void teaardown() {

        driver.close();
    }*/

    @Test
    public  void test01() {
        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test02(){
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Fidan Parlak");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fidanparlak@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    @Test
    public void test03(){
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount=driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccount.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//div[@class='clearfix']")).click(); //Title
        //driver.findElement(By.xpath("(//div[@class='radio-inline'][1])")).click();
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zero12345");
        driver.findElement(By.id("days")).sendKeys("20");
        driver.findElement(By.id("months")).sendKeys("November");
        driver.findElement(By.id("years")).sendKeys("1990");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();




        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

    }
    @Test

    public void test04(){
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button


    }
    @Test

    public void test05(){
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
    }

    @Test

    public void test06(){
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }



    }
    /*
    //Test Case 1: Register User
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.id("header"));
        Assert.assertTrue("Home Page sayfasi gorunur durumda",homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();


        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUserSignup.isDisplayed()){
            System.out.println("New User Signup! goruntulendi");
        }

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Fidan Parlak");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("pafrlakidan@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount= driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if (enterAccount.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION goruntulendi");
        }

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//div[@class='clearfix']")).click(); //Title
        //driver.findElement(By.xpath("(//div[@class='radio-inline'][1])")).click();
        driver.findElement(By.xpath("// label[@for='id_gender2']")).click();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zero12345");
        driver.findElement(By.id("days")).sendKeys("20");
        driver.findElement(By.id("months")).sendKeys("November");
        driver.findElement(By.id("years")).sendKeys("1990");

        //10. Select checkbox 'Sign up for our newsletter!'
       // driver.findElement(By.xpath("(//input[@type='checkbox'][1]")).click();
        // driver.findElement(By.xpath("(//input[@type='checkbox'][2]")).click();


        //11. Select checkbox 'Receive special offers from our partners!'

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Fidan");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Parlak");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Wisequarter");
        driver.findElement(By.id("address1")).sendKeys("Deutchland mah.");
        driver.findElement(By.id("address2")).sendKeys("tripstadt");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("New York");
        driver.findElement(By.id("city")).sendKeys("Florida");
        driver.findElement(By.id("zipcode")).sendKeys("15203");
        driver.findElement(By.id("mobile_number")).sendKeys("0492365890");


        //13. Click 'Create Account button'

        WebElement create=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        create.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        driver.close();
    }

     */

