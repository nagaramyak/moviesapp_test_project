import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginpage;
    HomePage homepage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\OneDrive\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);

        driver.get("https://qamoviesapp.ccbp.tech");

        loginpage.logintoApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void testCheckHeading(){
        Assert.assertEquals(homepage.checkBottomHead(0),"Trending Now","Trending Now Text didn't match");

        Assert.assertEquals(homepage.checkBottomHead(1),"Originals","Originals Text didn't match");
    }
    @Test
    public void testIsPlayButtonDisplayed(){
        Assert.assertTrue(homepage.checkPlayButtonDisplayed(),"PlayButton didn't displayed");

        Assert.assertTrue(homepage.contactUsisDisplayed(),"ContactUs section is not displayed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
