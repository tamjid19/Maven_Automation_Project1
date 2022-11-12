package action_items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI3 {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with WebDriverManager (case sensitive)
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window & in incognito mode
        options.addArguments("start-fullscreen","incognito");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> zipCode;
        //ArrayList for pPrice
        zipCode = new ArrayList<>();
        zipCode.add("10461");
        zipCode.add("10021");
        zipCode.add("10467");

        for(int i=0; i<zipCode.size(); i++) {

            //navigate to the weight watchers page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //sleep statement
            Thread.sleep(3000);

            //click on "in-person"
            driver.findElement(By.xpath("//*[@class='buttonWrapper-QK2gi selected-G8fmp']")).click();


            //clear and enter a new value to search for locations
            WebElement inputZipCode = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
            //clear the default string in the field
            inputZipCode.clear();
            //type new value on the purchase price
            inputZipCode.sendKeys(zipCode.get(i));

            //click on search button
            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();

            //sleep statement
            Thread.sleep(3000);

            //click on the different links depending on index number of zipCodes
            //if stmt for which class to pick for which zipCode

            if(i==0){
                //define the webElement for the searches to get the 2nd option
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(1).click();
                //define the webElement for the searches to get the 3rd option
            } else if(i==1){
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(2).click();
                //define the webElement for the searches to get the 1st option
            } else if(i==2){
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(0).click();
            }//end of if else/conditions

            //sleep statement
            Thread.sleep(3000);

            //capture and print address for the location
            String siteLocation = driver.findElements(By.xpath("//*[@class='locationName-1jro_']")).get(0).getText();
            //define "address" for where to capture address from
            String address = driver.findElements(By.xpath("//*[@class='address-2PZwW']")).get(0).getText();
            //split the address lines by the "return"/next line to capture just the address lines
            String[] addressSplit = address.split("\\R");
            //print the appropriate statement
            System.out.println("For zip code " + zipCode.get(i) + " the location is " + siteLocation + " the address is " + addressSplit[0] + " " + addressSplit[1]);

            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //declare calculate button into webelement variable
            WebElement scheduleButton = driver.findElement(By.xpath("//*[@class='scheduleTitleWrapper-1IUIk']"));
            //scroll into view of calculate button
            jse.executeScript("arguments[0].scrollIntoView(true);", scheduleButton);

            //sleep statement
            Thread.sleep(5000);

            //define "address" for where to capture address from
            String classSchedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();

            System.out.println("The schedule for " + zipCode.get(i) + " is " + classSchedule);

        }//end of for loop
    }//end of main
}//end of java class
