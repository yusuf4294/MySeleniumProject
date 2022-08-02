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


public class Cam11 {
    public static void main(String[] args)  {
        String myPassword="xxxxxx";




        System.setProperty("webdriver.chrome.driver","C:\\Users\\MONSTER\\Desktop\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);

        driver.get("https://campus.techno.study/");

        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("yusuf4294@gmail.com");
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(myPassword);

        driver.findElement(By.className("mat-button-wrapper")).click();                                                     //Clicks Log in button
        driver.findElement(By.cssSelector("svg[class='svg-inline--fa fa-bars']")).click();                                  //Clicks Hamburger icon

        WebElement videoConf=driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-4\"]/div/span[9]/span/button"));
        if(videoConf.isDisplayed())                System.out.println("Video Conferance is displayed");
        else                                       System.out.println("Video Conferance is not displayed");
        videoConf.click();                                                                                                   //Clicks Video Conferance

        WebElement videoMeet=driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-29\"]/div/span[1]/span/button"));
        if(videoMeet.isDisplayed())                System.out.println("Video Meetings is displayed");
        else                                       System.out.println("Video Meetings is not displayed");
        videoMeet.click();                                                                                                    //Clicks Video Meetings

        WebElement topicButton= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(topicButton));
        if(topicButton.isEnabled())                System.out.println("Topic box is enabled");
        else                                       System.out.println("Topic box is not enabled");
        String input= "Selenium";
        topicButton.sendKeys(input);                                                                                //Enters input into topic box


        WebElement datePicker = driver.findElement(By.cssSelector("svg[class='mat-datepicker-toggle-default-icon ng-star-inserted']"));
        if(datePicker.isEnabled())                 System.out.println("Date box is enabled");
        else                                       System.out.println("Date box is not enabled");
        datePicker.click();                                                                                                    //Clicks date box

        WebElement timePeriod = driver.findElement(By.xpath("//*[@id='mat-datepicker-0']/ms-custom-range-header/app-custom-range-panel/mat-card/button[5]/span[1]"));
        actions.moveToElement(timePeriod).perform();
        timePeriod.click();                                                                                                    //Chooses the time period

        WebElement searchButton=driver.findElement(By.cssSelector("button[class='mat-focus-indicator mat-raised-button mat-button-base mat-accent']"));
        searchButton.click();

        List<WebElement> filterList = driver.findElements(By.xpath("//div[contains(text(),'Selenium')]"));       //List of search result
        System.out.println("The search result based on: "+input);

        for (WebElement webElement : filterList) System.out.println(webElement.getText());


        driver.quit();


    }
}
