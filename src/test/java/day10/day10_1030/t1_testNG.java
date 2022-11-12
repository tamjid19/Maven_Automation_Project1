package day10.day10_1030;

import Reusable_Library.reusable_actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class t1_testNG {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        reusable_actions.ReusableActions Reusable_Actions = null;
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void SearchForCar(){
        driver.navigate().to("https://www.google.com");
        //enter a car on search field
        reusable_actions.ReusableActions Reusable_Actions = null;
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']","BMW","Search Field");
        //hit submit on the google search button
        Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }//end of test 1

    @Test(priority = 2)
    public void CaptureSearchNumber(){
        reusable_actions.ReusableActions Reusable_Actions = null;
        String result = Reusable_Actions.getTextAction(driver,"//*[@id='result-stats']","Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
    }//end of test 2

}
