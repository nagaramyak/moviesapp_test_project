package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    By websitelogoLocator = By.className("login-website-logo");
    By headingLocator = By.className("sign-in-heading");
    By labelLocators  = By.className("input-label");
    By loginbuttonLocator = By.className("login-button");
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By errormessageLocator = By.className("error-message");


    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findLoginImageElement(){
        return  driver.findElement(websitelogoLocator);
    }

    public String getHeadingText(){
        return driver.findElement(headingLocator).getText();
    }

    public String getlabelnametextat(int index){
        return driver.findElements(labelLocators).get(index).getText();
    }

    public void clickOnLogininbutton(){
        driver.findElement(loginbuttonLocator).click();
    }

    public void enterusername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterpassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void logintoApplication( String username,String password){
        enterusername(username);
        enterpassword(password);
        clickOnLogininbutton();
    }

    public String getErrormessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return driver.findElement(errormessageLocator).getText();
    }

}
