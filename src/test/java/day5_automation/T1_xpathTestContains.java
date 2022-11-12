package day5_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_xpathTestContains {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //maximize the driver
        driver.manage().window().maximize();

        //click on sign-in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

        //wait two seconds
        Thread.sleep(2000);

        //quit chrome
        driver.quit();

    }//end of main
}//end of java
