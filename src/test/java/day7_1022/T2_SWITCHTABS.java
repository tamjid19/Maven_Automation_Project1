package day7_1022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SWITCHTABS {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with WebDriverManager (case sensitive)
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window & in incognito mode
        options.addArguments("start-fullscreen");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);




        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class= 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);

        //store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);


    }//end of main
}// end of java
