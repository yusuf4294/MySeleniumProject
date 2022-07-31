package My_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Match_Cities_List {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");


        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        Actions act= new Actions(driver);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        List<WebElement> cities = driver.findElements(By.cssSelector("ul[id='allItems']>li"));
        List<WebElement> boxes = driver.findElements(By.cssSelector("div[id='dhtmlgoodies_mainContainer']>div>ul"));


        for (WebElement boxNumber:boxes) {
            String boxId= boxNumber.getAttribute("id");

            for (WebElement cityGroupId: cities) {
                String cityId= cityGroupId.getAttribute("groupid");
                if(boxId.equals(cityId)){
                    act.clickAndHold(cityGroupId).moveToElement(boxNumber).release(boxNumber).build().perform();

                }

            }



        }
    }
}
