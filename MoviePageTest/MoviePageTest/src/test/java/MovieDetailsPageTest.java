import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class MovieDetailsPageTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    PopularPage popularpage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        popularpage = new PopularPage(driver);
        loginpage.logintoApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void testHomePageMovieUiElements(){
        homepage.clickOnMovieelement(1);

        Assert.assertTrue(homepage.movieTitleisDisplayed(),"Movie Title is Not Displayed");

        Assert.assertTrue(homepage.movieWatchTimeisDisplayed(),"Movie WatchTime is Not Displayed");

        Assert.assertTrue(homepage.movieRatingisDisplayed(),"Movie Rating is Not Displayed");

        Assert.assertTrue(homepage.movieoverViewisDisplayed(),"Movie OverView is Not Displayed");

        Assert.assertTrue(homepage.movieplayButtonisDisplayed(),"Movie Play Button is Not Displayed");

    }
    @Test
    public void testPopularPageMovieUiElements(){
        homepage.clickOnNavBarelement(1);

        homepage.clickOnPopularPageMovieelement(1);

        Assert.assertTrue(homepage.movieTitleisDisplayed(),"Movie Title is Not Displayed");

        Assert.assertTrue(homepage.movieWatchTimeisDisplayed(),"Movie WatchTime is Not Displayed");

        Assert.assertTrue(homepage.movieRatingisDisplayed(),"Movie Rating is Not Displayed");

        Assert.assertTrue(homepage.movieoverViewisDisplayed(),"Movie OverView is Not Displayed");

        Assert.assertTrue(homepage.movieplayButtonisDisplayed(),"Movie Play Button is Not Displayed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
