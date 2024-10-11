import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginpage;
    HomePage homepage;
    AccountsPage accountpage;
    SearchPage searchpage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\OneDrive\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        accountpage = new AccountsPage(driver);

        driver.get("https://qamoviesapp.ccbp.tech");

        loginpage.logintoApplication("rahul","rahul@2021");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testAccountUiElements(){
        accountpage.clickOnAccountButton();
       String expected ="https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(driver.getCurrentUrl(),expected,"Navigation to Account Page Failed");

        Assert.assertEquals(accountpage.isaccountheadingdisplayed(),"Account","Account heading is not displayed");

        Assert.assertEquals(accountpage.memebershipdetails(0),"Member ship","Membership is not displayed");

        Assert.assertEquals(accountpage.memebershipdetails(1),"Plan details","Membership plan  is not displayed");

        Assert.assertTrue(accountpage.isusernameDisplayed(),"Username is not displayed");

        Assert.assertTrue(accountpage.isPasswordDisplayed(),"Password is not displayed");

        Assert.assertTrue(accountpage.ismemebershipplanDisplayed(),"Membership plan is not displayed");

        Assert.assertTrue(accountpage.isusernameDisplayed(),"Membership plan details is not displayed");
    }

    @Test(priority = 1)
    public void testLogoutFunctionality(){
        accountpage.clickOnAccountButton();
        String expected ="https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(driver.getCurrentUrl(),expected,"Navigation to Account Page Failed");

        accountpage.clickOnLogoutButton();
        expected ="https://qamoviesapp.ccbp.tech/login";
        Assert.assertEquals(driver.getCurrentUrl(),expected,"Navigation to Logout Page Failed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
