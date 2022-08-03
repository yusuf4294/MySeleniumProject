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

public class Match_Capitals {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        List<WebElement> cities = driver.findElements(By.cssSelector("div[id='dropContent']>.dragableBox"));
        cities.removeIf(n->(n.getAttribute("id").startsWith("D")));

        List<WebElement> countries = driver.findElements(By.cssSelector("div[id='countries']>.dragableBoxRight"));

        for (WebElement city:cities) {
            String cityId=city.getAttribute("id");
            wait.until(ExpectedConditions.visibilityOf(city));

            for (WebElement country:countries){
                String countryId=country.getAttribute("id");

                if (cityId.substring(3).equals(countryId.substring(5))){
                    wait.until(ExpectedConditions.visibilityOf(country));
                    actions.dragAndDrop(city,country).perform();
                    // -->other method is below
                    //actions.clickAndHold(city).moveToElement(country).release(country).build().perform();
                    break;
                }
            }
        }
    }
}


