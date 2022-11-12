package day8_1023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class exception_T1 {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

//initialize chrome options
        ChromeOptions options = new ChromeOptions();

// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("start-maximized");

//define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

//navigate to hotels.com
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(2000);

        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("Texas");
        destinations.add("Nevada");

        for (int i=0; i < destinations.size(); i++) {

            driver.findElement(By.xpath("//*[@aria-label= 'Going to']")).click();
            try {
                WebElement cities = driver.findElement(By.xpath("//*[@id= 'destination_form_field']"));
                cities.click();
                cities.sendKeys(destinations.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter new value on Cities.. " + e);
            }//end of home val exception

            Thread.sleep(1500);

            ArrayList<WebElement> subCities = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-subText truncate']")));

            subCities.get(0).click();

            // wait a sec
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@data-stid= 'open-room-picker']")).click();

            Thread.sleep(1000);



            ArrayList<Integer> adults = new ArrayList<>();
            adults.add(3);
            adults.add(4);
            adults.add(5);

            driver.findElement(By.xpath("//*[@class= 'uitk-layout-flex-item uitk-step-input-touch-target']")).click();

            try {
                WebElement children = driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of children in room 1']"));
                children.click();
            } catch (Exception e) {
                System.out.println("Unable to submit children.. " + e);

                Thread.sleep(1000);


                //use select command for children
                WebElement child =  driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
                Select childDropDown = new Select(child);

                //select by index
                childDropDown.selectByIndex(0);


            }// end of childrens catch

            for(i = 1; i < adults.get(i); i++) {

                try {
                    WebElement travelers = driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of adults in room 1']"));
                    travelers.click();
                } catch (Exception e) {
                    System.out.println("Unable to submit Travelers.. " + e);

                }//end of adults catch


            } // end of for loop for adults


        }// end of for loop for destinations

    }// end of main
}// end of class