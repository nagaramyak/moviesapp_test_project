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
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HeaderFunctionalitySteps {
    WebDriver driver ;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("I am on the login page")
    public void i_am_on_th_login_page(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @Given("I am on Home Page")
    public void given_i_am_on_home_page(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @When("I enter valid username")
    public void i_enter_valid_username(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
    }

    @When("I enter valid password")
    public void i_enter_valid_password(){
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @When("I click on Home navbar Element")
    public void iClickOnHomeNavbarElement(){
        List<WebElement> navbarelements = driver.findElements(By.xpath("//li//a"));
        navbarelements.get(0).click();
    }
    @When("I click on Popular navbar Element")
    public void iClickOnPopularNavbarElement(){
        List<WebElement> navbarelements = driver.findElements(By.xpath("//li//a"));
        navbarelements.get(1).click();

    }

    @When("I click on Account Element")
    public void iClickOnAccountElement(){
        driver.findElement(By.className("avatar-button")).click();

    }

    @And("I click on login button")
    public void iClickOnLoginButton(){
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I should see the website logo")
    public void iShouldSeeTheWebsiteLogo(){
        WebElement websitelogo = driver.findElement(By.xpath("//img[@class ='website-logo']"));
        Assert.assertTrue(websitelogo.isDisplayed(),"Website Logo is not displayed");
    }

    @And("I should see all the navbar elements")
    public void iShouldSeeAllTheNavbarElements(){
        List<WebElement> navbarElements = driver.findElements(By.xpath("//li//a"));
        Assert.assertTrue(navbarElements.get(0).isDisplayed(),"Home Navbar element is not displayed");
        Assert.assertTrue(navbarElements.get(1).isDisplayed(),"Popular Navbar element is not displayed");
        WebElement accountelment = driver.findElement(By.className("avatar-button"));
        Assert.assertTrue(accountelment.isDisplayed(),"Account element is not displayed");
    }

    @Then("I should navigate to Home Page")
    public void iShouldNavigateToHomePageSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/","Navigation to Home Page Failed");
    }

    @Then("I should navigate to Popular Page")
    public void iSHouldNavigateToPopularPageSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/popular","Navigation to Home Page Failed");
    }

    @Then("I should navigate to Account Page")
    public void iShouldNavigateToAccountPageSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account","Navigation to Home Page Failed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
