package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {
    @FindBy(className = "avatar-button")
    WebElement accountButtonElement;

    @FindBy(className = "logout-button")
    WebElement logoutbuttonElement;

    @FindBy(className = "account-heading")
    WebElement accountheadingElement;

    @FindBy(className = "membership-heading")
    List<WebElement> membershipElement;

    @FindBy(className = "membership-username")
    WebElement membershipusernameElement;

    @FindBy(className = "membership-password")
    WebElement membershippasswordElement;

    @FindBy(className = "plan-paragraph")
    WebElement membershipplanElement;

    @FindBy(className = "plan-details")
    WebElement membershipplandetailsElement;

    public WebDriver driver;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAccountButton(){ accountButtonElement.click();}

    public void clickOnLogoutButton(){ logoutbuttonElement.click();}

    public String isaccountheadingdisplayed(){ return accountheadingElement.getText();}

    public String memebershipdetails(int index){return membershipElement.get(index).getText();}

    public boolean isusernameDisplayed(){return membershipusernameElement.isDisplayed();}

    public boolean isPasswordDisplayed(){return membershippasswordElement.isDisplayed();}

    public boolean ismemebershipplanDisplayed(){return membershipplanElement.isDisplayed();}

    public boolean ismemebershipplandetailsDisplayed(){return membershipplandetailsElement.isDisplayed();}







}
