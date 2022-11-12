package day6_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_webElements {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-fullscreen");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //go to google page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear purchase price
        pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("45000");

        //clear and enter new downpayment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        //clear downpayment
        dPayment.clear();
        dPayment.sendKeys("25");
    }
}
