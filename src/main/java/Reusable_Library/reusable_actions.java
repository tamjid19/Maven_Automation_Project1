package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusable_actions {
    public static class ReusableActions {
        //reusable method to define and launch webdriver
        //reusable method to define and launch webdriver
        public static WebDriver setUpDriver() {
            //define the webdriver manager setup for chromedriver
            WebDriverManager.chromedriver().setup();
            //initialize chrome options
            ChromeOptions options = new ChromeOptions();
            //add argument to chrome options
            options.addArguments("start-maximized");
            //for mac use "start-fullscreen"
            //options.addArguments("start-fullscreen");
            //if above does not work on mac, then try --kiosk
            //options.addArguments("--kiosk");
            //initialize driver with chrome options
            WebDriver driver = new ChromeDriver(options);
            return driver;
        }//end of setup driver method

        public static void clickAction(WebDriver driver, String xpath, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            }
        }

        public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            } catch (Exception e) {
                System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            }
        }

        public static void mouseHover(WebDriver driver, String xpath, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //declare mouse actions
            Actions actions = new Actions(driver);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                actions.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            }
        }

        public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.sendKeys(userInput);
            } catch (Exception e) {
                System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            }
        }

        public static String getTextAction(WebDriver driver, String xpath, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            String textOutput = "";
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                textOutput = element.getText();
            } catch (Exception e) {
                System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            }
            return textOutput;
        }
    }
}
