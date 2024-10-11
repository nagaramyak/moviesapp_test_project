import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        loginpage.logintoApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void testHeaderSectionUi(){
        Assert.assertTrue(homepage.isLogoDisplayed().isDisplayed(),"Logo didn't displayed");

        Assert.assertEquals(homepage.checkHead(0),"Home","Home text didn't matched");

        Assert.assertEquals(homepage.checkHead(1),"Popular","Popular text didn't matched");
    }
    @Test(priority = 1)
    public void testHeaderSectionNavigation(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        homepage.clickOnNavBarelement(0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Home Page Navigation Failed");

        expectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        homepage.clickOnNavBarelement(1);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Popular Page Navigation Failed");

        expectedUrl ="https://qamoviesapp.ccbp.tech/account";
        homepage.clickOnaccountelement();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Account Page Navigation Failed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
