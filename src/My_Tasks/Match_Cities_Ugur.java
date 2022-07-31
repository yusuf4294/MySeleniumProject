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

public class Match_Cities_Ugur {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        Duration duration= Duration.ofSeconds(10);
        driver.manage().timeouts().pageLoadTimeout(duration); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(duration);

        driver.manage().window().maximize();


        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // Scroll all the way  down.


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        Actions actions = new Actions(driver);

        List<WebElement> countryMatch = driver.findElements(By.xpath("//div[@id='questionDiv']//div[@class='dragDropSmallBox']"));

        List<WebElement> cityMatch = driver.findElements(By.xpath("//div[@id='answerDiv']//div[@class='dragDropSmallBox']"));

        WebElement destinationBox;


        //1. for--> ülke id bul, 2. for--> şehir id bul döngü içinde id eşleşince
        //ülkenin yanındaki destinationboxa at

        for (WebElement countryElement : countryMatch){
            String idCountry = countryElement.getAttribute("id");
            wait.until(ExpectedConditions.visibilityOf(countryElement));

            for (WebElement cityElement : cityMatch){
                String idCity = cityElement.getAttribute("id");
                destinationBox = driver.findElement(By.xpath("//div[@id='questionDiv']//div[@class='destinationBox']" +
                        "[" + idCity.substring(1).trim() +"]"));
                // we need to input line 53 in different quotes since substring methos is not working inside xpath.


                if (idCity.substring(1).equals(idCountry.substring(1))){
                    wait.until(ExpectedConditions.visibilityOf(cityElement));
                    System.out.println(idCity.substring(1).trim());
                    actions.clickAndHold(cityElement).moveToElement(destinationBox).release(countryElement).build().perform();

                }
            }

        }
    }
}
