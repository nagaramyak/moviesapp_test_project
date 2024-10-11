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

public class LoginFunctionalitySteps {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Given("I am on the login page for account")
    public void i_am_on_the_login_page_for_account(){
        driver.get("https://qamoviesapp.ccbp.tech/login");

    }

    @When("I click on the login button")
    public void i_click_on_login_button(){
        driver.findElement(By.className("login-button")).click();

    }

    @When("I enter a valid password")
    public void i_enter_a_valid_password(){
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
    }

    @When("I enter an invalid password")
    public void i_enter_a_invalid_password(){
        driver.findElement(By.id("passwordInput")).sendKeys("rahul1234");
    }


    @Then("I should see the Website logo image")
    public void i_should_see_the_website_logo_image(){
        WebElement websitelogo = driver.findElement(By.className("login-website-logo"));
        Assert.assertTrue(websitelogo.isDisplayed(),"Website logo is not displayed");
    }

    @And("the Heading Text Should be 'Login'")
    public void the_heading_text_should_be_login(){
        WebElement heading = driver.findElement(By.className("sign-in-heading"));
        Assert.assertEquals(heading.getText(),"Login");
    }


    @And("the username label text Should Be 'USERNAME'")
    public void the_username_label_text_should_be_username(){
        WebElement username = driver.findElement(By.xpath("//label[text()='USERNAME']"));
        Assert.assertEquals(username.getText(),"USERNAME");
    }

    @And("the password label text Should Be 'PASSWORD'")
    public void the_username_label_text_should_be_password(){
        WebElement password = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        Assert.assertEquals(password.getText(),"PASSWORD");
    }

    @And("I should see the login button")
    public void i_should_see_the_login_button(){
        WebElement loginbutton = driver.findElement(By.className("login-button"));
        Assert.assertTrue(loginbutton.isDisplayed(),"login button is not displayed");
    }

    @Then("an error message '*Username or password is invalid' should be visible")
    public void verifyUsernameOrPasswordIsInvalidErrorText(){
        String actualText = driver.findElement(By.className("error-message")).getText();
        Assert.assertEquals(actualText, "*Username or password is invalid");
    }

    @Then("an error message '*username and password didn't match' should be visible")
    public void verifyUsernameAndPasswordDidnotMatchErrorText(){
        String actualText = driver.findElement(By.className("error-message")).getText();
        Assert.assertEquals(actualText, "*username and password didn't match");
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage(){
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String currentUrl =  driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedurl);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
