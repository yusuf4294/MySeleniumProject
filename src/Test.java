import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
    }
}
