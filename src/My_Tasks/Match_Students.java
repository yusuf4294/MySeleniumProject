package My_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Match_Students {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");


        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        Actions act= new Actions(driver);
        js.executeScript("window.scrollBy(0,1000)");

        List<WebElement> students = driver.findElements(By.cssSelector("ul[id='allItems']>li"));

        WebElement box1 = driver.findElement(By.id("box1"));
        WebElement box2 = driver.findElement(By.id("box2"));
        WebElement box3 = driver.findElement(By.id("box3"));
        WebElement box4 = driver.findElement(By.id("box4"));
        WebElement box5 = driver.findElement(By.id("box5"));

        wait.until(ExpectedConditions.visibilityOf(box1));

        for (int i = 0; i < 4; i++) {
          act.clickAndHold(students.get(i)).moveToElement(box2).release(box1).build().perform();
        }
        for (int i = 4; i < 8; i++) {
            act.clickAndHold(students.get(i)).moveToElement(box2).release(box2).build().perform();
        }
        for (int i = 8; i < 12; i++) {
            act.clickAndHold(students.get(i)).moveToElement(box3).release(box3).build().perform();
        }
        for (int i = 12; i < 15; i++) {
            act.clickAndHold(students.get(i)).moveToElement(box4).release(box4).build().perform();
        }
        for (int i = 15; i < 22; i++) {
            act.clickAndHold(students.get(i)).moveToElement(box5).release(box5).build().perform();
        }

    }
}
