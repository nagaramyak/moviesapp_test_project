package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//li//a")
    List<WebElement> headingElement;

    @FindBy(xpath = "//h1[@class ='movies-list-heading']")
    List<WebElement> bottomHeadingElement;

    @FindBy( className= "home-movie-play-button")
    WebElement playButtonElement;

    @FindBy (className = "website-logo")
    WebElement logoElement;


    @FindBy (className = "avatar-button")
    WebElement accountElement;

    @FindBy (className = "footer-container")
    WebElement contactusElement;

    @FindBy (className = "poster")
    List<WebElement> moviePosterElement;

    @FindBy (className = "movie-image")
    List<WebElement> popularPagemovieElement;

    @FindBy (className = "movie-title")
    WebElement movieTitleElement;

    @FindBy (className = "watch-time")
    WebElement movieWatchTimeElement;

    @FindBy (className = "sensor-rating")
    WebElement movieRatingElement;

    @FindBy (className = "movie-overview")
    WebElement movieOverviewElement;

    @FindBy (className = "play-button")
    WebElement movieplayButtonElement;

    public WebDriver driver;
    public  HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkHead(int index){
        return headingElement.get(index).getText();
    }

    public String checkBottomHead(int index){
        return bottomHeadingElement.get(index).getText();
    }

    public Boolean checkPlayButtonDisplayed(){
        return playButtonElement.isDisplayed();
    }

    public WebElement isLogoDisplayed(){
        return logoElement;
    }

    public void clickOnNavBarelement(int index){ headingElement.get(index).click(); }

    public void clickOnaccountelement(){
        accountElement.click();
    }

    public boolean contactUsisDisplayed(){ return contactusElement.isDisplayed(); }

    public void clickOnMovieelement(int index){ moviePosterElement.get(index).click(); }

    public void clickOnPopularPageMovieelement(int index){ popularPagemovieElement.get(index).click(); }

    public boolean movieTitleisDisplayed(){ return movieTitleElement.isDisplayed(); }

    public boolean movieWatchTimeisDisplayed(){ return movieWatchTimeElement.isDisplayed(); }

    public boolean movieRatingisDisplayed(){ return movieRatingElement.isDisplayed(); }

    public boolean movieoverViewisDisplayed(){ return movieOverviewElement.isDisplayed(); }

    public boolean movieplayButtonisDisplayed(){ return movieplayButtonElement.isDisplayed(); }

}
