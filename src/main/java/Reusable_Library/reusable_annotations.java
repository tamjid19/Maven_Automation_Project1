package Reusable_Library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class reusable_annotations {
    /*
    WebDriver variable needs to get inherited to your test class but in order to do that
    it must be public static
     */
    public static WebDriver driver;
    @BeforeSuite
    public void setTheDriver(){
        reusable_actions.ReusableActions Reusable_Actions = null;
        driver = Reusable_Actions.setUpDriver();
    }//end of beforesuite

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of aftersuite

}
