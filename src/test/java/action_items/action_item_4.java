package action_items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class action_item_4 {
    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //create array list for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("Delaware");
        destinations.add("Minnesota");

        //create an arraylist for adults
        //had to lower number of adults because couldn't find available rooms
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(2);

        //create an arraylist for children age
        ArrayList<String> kAge = new ArrayList<>();
        kAge.add("1");
        kAge.add("2");
        kAge.add("3");

        //create for loop to iterate through destinations
        for (int i=0; i < destinations.size(); i++) {

            //navigate to hotels.com
            try {
                driver.navigate().to("https://www.hotels.com");
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }

            // wait 3 sec
            Thread.sleep(3000);

            // click on search bar "Going to"
            try {
                driver.findElement(By.xpath("//*[@class= 'uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }

            // type in destination
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destinations.get(i));
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to type in destinations.. " + e);
            }
            //added sleep time to adjust dates to get available dates manually
            Thread.sleep(10000);

            // click on travelers
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers.. " + e);
            }

            // wait a sec
            Thread.sleep(1000);

            //create an arraylist
            ArrayList<WebElement> plusMinus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));

            //click to add one child
            try {
                plusMinus.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on + to add a child.. " + e);
            }

            //create for loop for adults age
            for (int j = 1; j < adults.get(i); j++) {
                // add adults age
                try {
                    plusMinus.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to add adults age.. " + e);
                }

            }// end of adults loop

            //click to add one child
            try {
                plusMinus.get(3).click();
            } catch (Exception e) {
                System.out.println("Unable to add one child.. " + e);
            }

            //use select command for children
            WebElement child = driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
            Select childDropDown = new Select(child);

            //select by value
            try {
                childDropDown.selectByValue(kAge.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select value.. " + e);
            }

            //click done
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click done.. " + e);
            }

            //click on the search button
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on the search button.. " + e);
            }

            // wait a couple seconds
            Thread.sleep(3000);

            //create an arraylist for hotels
            ArrayList<WebElement> hotel = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'uitk-spacing uitk-spacing-margin-blockstart-three']")));
            //click on first hotel address
            if (i == 0) {
                try {
                    hotel.get(0).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on first link..." + e);
                }
            }// end of if statement
            else if (i == 1) {
                try {
                    hotel.get(2).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on third link..." + e);
                }
            }
            // end of 2nd if statement
            else if (i == 2) {
                try {
                    hotel.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on second link..." + e);
                }
            }
            //end of 3rd if statement

            // capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // switch to new tabs
            driver.switchTo().window(tabs.get(1));

            //wait 8 seconds
            Thread.sleep(8000);

            // capture name of the hotel
            try {
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                //print out hotel name
                System.out.println(hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print out hotel name...." + e);
            }
            //click on reserve
            try {
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }

            // wait a sec
            Thread.sleep(2000);

            //capture price of hotel
            try {
                String prices = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();

                // print out price of hotel
                System.out.println(prices);
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel.." + e);
            }

            //click on reserve now
            try {
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }
            // wait a sec
            Thread.sleep(4000);
            //capture dates
            try {
                String dates = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                //print out dates
                System.out.println(dates);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out dates.." + e);
            }

            //close tab
            driver.close();

            //switch back to orignal tab
            driver.switchTo().window(tabs.get(0));



        }//end of destinations loop

        driver.quit();


    }// end of main
}// end of class

