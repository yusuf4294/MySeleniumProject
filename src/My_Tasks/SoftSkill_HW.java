package My_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SoftSkill_HW {

    //CAM-11 Test Code

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://campus.techno.study/");

        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("yusuf4294@gmail.com");
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("oBzHoY2B");

        driver.findElement(By.className("mat-button-wrapper")).click();

       // Thread.sleep(5000);

        WebElement hamburger = driver.findElement(By.cssSelector("svg[class='svg-inline--fa fa-bars']"));
        hamburger.click();

        WebElement financeDisplay = driver.findElement(By.xpath("//span[text()='Finance']"));

        boolean isFinanceDisplayed= financeDisplay.isDisplayed();
        System.out.println("Is Finance button displayed?: "+isFinanceDisplayed);

        financeDisplay.click();

        WebElement myFinanceDisplay = driver.findElement(By.xpath("//span[text()='My Finance']"));
        boolean isMyFinanceDisplayed=myFinanceDisplay.isDisplayed();
        System.out.println("Is My Finance button displayed?: "+isMyFinanceDisplayed);







        driver.quit();


    }
}
