package Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PopularFunctionalitySteps {
    WebDriver driver ;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("I am on Home page for account")
    public void given_i_am_on_home_page_for_account(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on Popular Navbar Element")
    public void i_click_on_popular_navbar_element(){
        driver.findElement(By.xpath("//a[text() ='Popular']")).click();
    }

    @Then("I should navigate to Popular page")
    public void i_should_navigate_to_popular_page(){

        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/popular","Navigation to Home Page Failed");
    }

    @And("I Should see the movies")
    public void i_should_See_the_movies(){
        List<WebElement> movies = driver.findElements(By.className("movie-image"));
        if(movies.size() >0) System.out.println("Movies are displayed");
        else System.out.println("Movies are d not isplayed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
