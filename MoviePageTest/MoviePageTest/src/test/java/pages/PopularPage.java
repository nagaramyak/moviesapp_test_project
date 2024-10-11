package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PopularPage {
    @FindBy(className = "movie-image")
    List<WebElement> movieElement;

    public WebDriver driver;

    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int movieCount(){
        return movieElement.size();
    }
}
