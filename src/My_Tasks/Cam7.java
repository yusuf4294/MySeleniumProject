package My_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Cam7 {

    //CAM-11 Test Code

    public static void main(String[] args)  {
        String myPassword="xxxxxx";















        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://campus.techno.study/");

        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("yusuf4294@gmail.com");
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(myPassword);

        driver.findElement(By.className("mat-button-wrapper")).click(); // Clicks hamburger

        driver.findElement(By.cssSelector("svg[class='svg-inline--fa fa-bars']")).click(); //Clicks Finance

        WebElement financeDisplay = driver.findElement(By.xpath("//span[text()='Finance']"));

        boolean isFinanceDisplayed= financeDisplay.isDisplayed();

        if (isFinanceDisplayed)   System.out.println("Finance is displayed");
        else                      System.out.println("Finance is not displayed");

        financeDisplay.click();

        WebElement myFinanceDisplay = driver.findElement(By.xpath("//span[text()='My Finance']"));
        boolean isMyFinanceDisplayed=myFinanceDisplay.isDisplayed();


        if (isMyFinanceDisplayed)  System.out.println("My Finance is displayed");
        else                       System.out.println("My Finance is not displayed");










        driver.quit();


    }
}
