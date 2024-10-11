package Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomeFunctionalitySteps {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }
    @Given("I am on Home page")
    public void given_i_am_on_home_page(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I should see the headings of each section")
    public void i_should_See_the_headings_of_each_section(){
        List<WebElement> headingtexts = driver.findElements(By.xpath("//h1[@class='movies-list-heading']"));
        Assert.assertEquals(headingtexts.get(0).getText(),"Trending Now");
        Assert.assertEquals(headingtexts.get(1).getText(),"Originals");
    }
    @And("I should see the play button")
    public void i_should_see_the_play_button(){
       WebElement playbutton = driver.findElement(By.className("home-movie-play-button"));
       Assert.assertTrue(playbutton.isDisplayed(),"play button is not displayed");
    }

    @And("I should see the movies in movies section")
    public void i_should_see_the_movies_in_movies_sections(){
        List<WebElement> movies = driver.findElements(By.xpath("//img[@class ='poster']"));
        int count = 0;
        for (WebElement movie:movies){
            if(movie.isDisplayed()){
                count++;
            }
        }
       if(count > 0) System.out.println("Movies are displayed");
       else System.out.println("Movies are not displayed");
    }

    @And("I should see the contact us section")
    public void i_should_See_contact_us_section(){
        WebElement contactus = driver.findElement(By.className("footer-container"));
        Assert.assertTrue(contactus.isDisplayed(),"play button is not displayed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
