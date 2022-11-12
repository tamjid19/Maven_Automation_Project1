package action_items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class Actionitem_Two {
    public static void main(String[] args) throws InterruptedException {
        //array list for sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Basketball");
        sports.add("Baseball");
        sports.add("Football");
        sports.add("Soccer");

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        for (int i=0; i< sports.size();i++) {
            //navigate to bing site
            driver.navigate().to("https://www.bing.com");
            //maximize window
            driver.manage().window().maximize();
            //wait few seconds
            Thread.sleep(3000);

            //search keyword on searchfield
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            //hit submit on the bing search button
            driver.findElement(By.xpath("//*[@id='sb_form']")).submit();
            //wait few secs.
            Thread.sleep(3000);

            //capture search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("the search number for " + sports.get(i) + " is " + splitResult[0]);
        }//end of for loop
        //quit driver to end session
        driver.quit();

    }//end of main
}//end of java class