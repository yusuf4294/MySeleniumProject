package Day10.ActionsClassMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _04_ActionsClass_DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://demo.guru99.com/test/drag_drop.html");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe[id='ccpa-consent-notice']"))));

        driver.switchTo().frame("ccpa-consent-notice");

        WebElement popUp= driver.findElement(By.xpath("//*[@id=\"close\"]"));
        popUp.click();

        WebElement fiveThousandButton = driver.findElement(By.xpath("(//li[@id='fourth']//a)[2]"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(fiveThousandButton, debitAmount).perform();

        WebElement bankButton = driver.findElement(By.id("credit2"));
        WebElement debitAccount = driver.findElement(By.id("bank"));

        actions.dragAndDrop(bankButton, debitAccount).perform();

        //driver.quit();

    }

}
