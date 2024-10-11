package Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MovieDetailsFunctionalitySteps {
    WebDriver driver ;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I am on Home Page of movie website")
    public void i_am_on_home_page_of_movie_website(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @Given("I am on Popular Page of movie website")
    public void i_am_on_popular_page_of_movie_website(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        driver.findElement(By.xpath("//a[text() ='Popular']")).click();
    }

    @When("I click on any movie in Home page")
    public void i_click_on_any_movie_in_home_page(){
        List<WebElement> homepagemovies  = driver.findElements(By.className("poster"));
        homepagemovies.get(1).click();
    }

    @When("I click on any movie in Popular Page")
    public void i_click_on_any_movie_in_popular_page(){
        driver.findElement(By.xpath("//a[text() ='Popular']")).click();
        List<WebElement> popularpagemovies  = driver.findElements(By.className("movie-image"));
        popularpagemovies.get(1).click();
    }
    @Then("I should see the all UI elements present in it")
    public void i_should_see_all_ui_elements_present_in_it(){
        WebElement movietitle = driver.findElement(By.className("movie-title"));
        Assert.assertTrue(movietitle.isDisplayed());
        WebElement moviewatchtime = driver.findElement(By.className("watch-time"));
        Assert.assertTrue(moviewatchtime.isDisplayed());
        WebElement movierating = driver.findElement(By.className("sensor-rating"));
        Assert.assertTrue(movierating.isDisplayed());
        WebElement movieoverview = driver.findElement(By.className("movie-overview"));
        Assert.assertTrue(movieoverview.isDisplayed());
        WebElement movieplaybutton = driver.findElement(By.className("play-button"));
        Assert.assertTrue(movieplaybutton.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
