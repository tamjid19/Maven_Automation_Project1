package day9_10292022;

import Reusable_Library.reusable_actions;
import org.openqa.selenium.WebDriver;

import static Reusable_Library.reusable_actions.ReusableActions.setUpDriver;

public class T4_MetLife_Reusable {
    public static void main(String[] args) throws InterruptedException {
        //call webdriver method from reusable library
        WebDriver driver = setUpDriver();
        //navigate to MetLife
        driver.navigate().to("https://www.metLife.com");
        //hover over the solutions dropdown
        //ReusableActions.mouseHover(driver, "//*[contains(text(), 'SOLUTIONS')]", "Solutions Dropdown");
        //or click on solutions dropdown
        reusable_actions.ReusableActions.clickActionByIndex(driver, "//*[contains(text(), 'SOLUTIONS')]", 0, "Solutions Link");
        //click on dental link
        reusable_actions.ReusableActions.clickAction(driver, "//*[text() = 'Dental']", "Dental Link");
        //capture the headline title
        String headlineTitle = reusable_actions.ReusableActions.getTextAction(driver, "//*[@class = 'headline__title']", "Headline Title");
        //print out the title
        System.out.println("The headline title is " + headlineTitle);
        //quit driver
        driver.quit();
    }//end of main
}
