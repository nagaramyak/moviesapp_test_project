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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AccountFunctionalitySteps {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramya\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I am on the Homepage")
    public void iAmOnTheHomePage() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
    }

    @Given("I am on Account page")
    public void i_am_on_Acoount_page() {
        iAmOnTheHomePage();
        driver.findElement(By.className("avatar-button")).click();
    }

    @When("I click on account button")
    public void iClickOnAccountButton() {
        driver.findElement(By.className("avatar-button")).click();
    }

    @When("I click on Logout button")
    public void iClickOnLogoutButton() {
        driver.findElement(By.className("logout-button")).click();
    }

    @Then("I should be redirect to account page")
    public void iShouldBeRedirectToAccountPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "Account Page Navigation Unsuccessful");
    }

    @And("I should see all UI elements present and visible in account page")
    public void iShouldSeeAllUIElementsPresentAndVisisbleInAccountPage() {
        WebElement accountheading = driver.findElement(By.className("account-heading"));
        Assert.assertEquals(accountheading.getText(), "Account", "Account heading is not displayed");

        List<WebElement> membershipheading = driver.findElements(By.className("membership-heading"));
        Assert.assertEquals(membershipheading.get(0).getText(), "Member ship", "Member ship heading is not displayed");
        Assert.assertEquals(membershipheading.get(1).getText(), "Plan details", "Member ship plan  headingis not displayed");

        WebElement username = driver.findElement(By.className("membership-username"));
        Assert.assertTrue(username.isDisplayed(), "Username is not Displayed");

        WebElement password = driver.findElement(By.className("membership-password"));
        Assert.assertTrue(password.isDisplayed(), "password is not Displayed");

        WebElement membershipplan = driver.findElement(By.className("plan-paragraph"));
        Assert.assertTrue(membershipplan.isDisplayed(), "Membership is not Displayed");

        WebElement membershipplandetails = driver.findElement(By.className("plan-details"));
        Assert.assertTrue(membershipplandetails.isDisplayed(), "Member ship plan is not Displayed");
    }

    @Then("I should redirect to Login page")
    public void iShouldRedirectToLoginPage() {
        String expectedtUrl = "https://qamoviesapp.ccbp.tech/login";
        Assert.assertEquals(expectedtUrl, driver.getCurrentUrl(), "Navigation to login page is Failed");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
