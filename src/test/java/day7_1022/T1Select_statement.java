package day7_1022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1Select_statement {
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
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropDown = new Select(strtMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("11");

        //use select command for year dropdown
   //     WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
     //   Select startYearDropDown = new Select(startYear);
        //select visible text
       // startYearDropDown.selectByVisibleText("2023");

        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();



    }
}
