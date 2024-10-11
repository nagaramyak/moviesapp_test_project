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

public class PopularPageTest {
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
    public void testMoviesDisplayed(){
        homepage.clickOnNavBarelement(1);

        String expected ="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(driver.getCurrentUrl(),expected,"Movies are displayed");

        int moviecount = 0;

        if(popularpage.movieCount() == 0) System.out.println("Movies are not displayed");
        else System.out.println("Movies are  displayed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
