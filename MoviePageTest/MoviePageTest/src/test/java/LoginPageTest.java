import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginpage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginpage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLoginPageUi(){
        Assert.assertTrue(loginpage.findLoginImageElement().isDisplayed(),"WebSite logo is not Displayed");

        Assert.assertEquals(loginpage.getHeadingText(),"Login","Heading text is not displayed");

        Assert.assertEquals(loginpage.getlabelnametextat(0),"USERNAME","username is not displayed");

        Assert.assertEquals(loginpage.getlabelnametextat(1),"PASSWORD","password  is not displayed");

        loginpage.clickOnLogininbutton();
    }

    @Test(priority = 1)
    public void testWithEmptyInputFields(){
        loginpage.clickOnLogininbutton();
        Assert.assertEquals(loginpage.getErrormessage(),"*Username or password is invalid","Error text with empty input fields didn't match ");
    }

    @Test(priority = 2)
    public void testWithEmptyUsername(){
        loginpage.enterpassword("rahul@2021");
        loginpage.clickOnLogininbutton();
        Assert.assertEquals(loginpage.getErrormessage(),"*Username or password is invalid","Error text with empty input fields didn't match ");
    }

    @Test(priority = 3)
    public void testWithEmptyPassword(){
        loginpage.enterusername("rahul");
        loginpage.clickOnLogininbutton();
        Assert.assertEquals(loginpage.getErrormessage(),"*Username or password is invalid","Error text with empty input fields didn't match ");
    }

    @Test(priority = 4)
    public void testWithInvalidCredentials(){
        loginpage.logintoApplication("rahul","rahul");
        Assert.assertEquals(loginpage.getErrormessage(),"*username and password didn't match","Error text with empty input fields didn't match ");
    }
    @Test(priority = 5)
    public void testWithValidCredentials(){
        loginpage.logintoApplication("rahul","rahul@2021");
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/","Error text with empty input fields didn't match ");
    }

}
