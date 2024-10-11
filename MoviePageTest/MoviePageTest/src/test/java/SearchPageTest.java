import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    SearchPage searchpage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        searchpage = new SearchPage(driver);

        loginpage.logintoApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void testSearchFunctionality(){
        searchpage.clickOnSearchButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/search";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Navigation to search page unsuccessful");
    }
    @Test(priority = 1)
    public void testWithValidMovieName(){
        searchpage.clickOnSearchButton();
        searchpage.enterMovieName("dune");
        searchpage.clickOnMovieSearch();
        System.out.println(searchpage.movienumberCount());
    }
    @Test (priority = 2)
    public void testWithInvalidMovieName(){
        searchpage.clickOnSearchButton();
        searchpage.enterMovieName("ram");
        searchpage.clickOnMovieSearch();

        if(searchpage.isErrorImageDisplayed() && searchpage.isErrormessageDisplayed()){
            System.out.println("FailureTest Passed");
        }
        else{
            System.out.println("FailureTest Failed");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
