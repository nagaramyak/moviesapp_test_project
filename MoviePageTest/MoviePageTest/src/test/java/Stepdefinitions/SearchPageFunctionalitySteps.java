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

public class SearchPageFunctionalitySteps {
    WebDriver driver ;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I am on home page of account")
    public void i_am_on_home_page_of_account(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @Given("I am on Search Page")
    public void i_am_on_search_page(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        driver.findElement(By.className("search-empty-button")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));
    }

    @When("I click on search bar")
    public void i_click_on_search_bar(){
        driver.findElement(By.xpath("//button[@class='search-empty-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));
    }

    @When("I enter valid movie name")
    public void i_enter_valid_movie_name(){
        driver.findElement(By.className("search-input-field")).sendKeys("dune");
    }

    @When("I enter invalid movie name")
    public void i_enter_invalid_movie_name(){
        driver.findElement(By.className("search-input-field")).sendKeys("ram");
    }

    @And("I click on search button")
    public void i_click_on_search_button(){
        driver.findElement(By.xpath("//button[@class ='search-button']")).click();
    }

    @Then("I Should navigate to Search page")
    public void i_should_navigate_to_search_page(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/search";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Navigation to search page unsuccessful");
    }

    @Then("I should see the movies related to movie name")
    public void i_should_See_movies_related_to_movie_name(){
        List<WebElement> movies = driver.findElements(By.className("movie-image"));
        if(movies.size() > 0) System.out.println("Movies are displayed");
        else System.out.println("Movies are not displayed");
    }

    @Then("I should see the error image and text")
    public void i_should_see_the_error_image_and_text(){
        WebElement errorimage = driver.findElement(By.className("not-found-search-image"));
        Assert.assertTrue(errorimage.isDisplayed());
        WebElement errortext= driver.findElement(By.className("not-found-search-paragraph"));
        Assert.assertTrue(errortext.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
