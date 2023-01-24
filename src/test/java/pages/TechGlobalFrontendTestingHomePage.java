package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TechGlobalFrontendTestingHomePage extends TechGlobalBasePage {
    public TechGlobalFrontendTestingHomePage() {
        super();
    }

    @FindBy(css="div[id^='card']")
    public List<WebElement> cards;

    public void clickOnCard(int cardIndex) {
        cards.get(cardIndex).click();

    }
}