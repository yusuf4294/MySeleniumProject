package My_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

//http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
// buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.


public class Match_Cities {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");


        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        Actions a= new Actions(driver);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

        //List<WebElement> countries = driver.findElements(By.cssSelector("div[id='questionDiv']>div[class='dragDropSmallBox']"));

        List<WebElement> fillIn = driver.findElements(By.cssSelector("div[class='destinationBox']"));
        List<WebElement> cities = driver.findElements(By.cssSelector("div[id='answerDiv']>div"));

       // WebElement  city= driver.findElement(By.cssSelector("div[id='answerDiv']>div"));
       // WebElement dragTo= driver.findElement(By.cssSelector("div[class='destinationBox']"));



        a.dragAndDrop(cities.get(1),fillIn.get(1)).perform();
       // a.dragAndDrop(cities.get(2),fillIn.get(2)).perform();
       // a.dragAndDrop(cities.get(3),fillIn.get(3)).perform();















    }

}
