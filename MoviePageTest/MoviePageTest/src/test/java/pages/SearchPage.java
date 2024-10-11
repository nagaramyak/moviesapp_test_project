package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    @FindBy(className = "search-empty-button")
    WebElement searchElement;

    @FindBy (className = "search-input-field")
    WebElement searchmovieElement;

    @FindBy(className = "movie-image")
    List<WebElement> movieElement;

    @FindBy(className = "search-button")
    WebElement moviesearchElement;

    @FindBy(className = "not-found-search-image")
    WebElement errorimageElement;

    @FindBy(className = "not-found-search-paragraph")
    WebElement errorMessageElement;

    public WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnSearchButton(){
        searchElement.click();
    }

    public void enterMovieName(String movie){
        searchmovieElement.sendKeys(movie);
    }

    public int movienumberCount(){
        return movieElement.size();
    }
    public void clickOnMovieSearch(){
        moviesearchElement.click();
    }

    public boolean isErrorImageDisplayed(){
        return errorimageElement.isDisplayed();
    }

    public boolean isErrormessageDisplayed(){
        return errorMessageElement.isDisplayed();
    }

}
