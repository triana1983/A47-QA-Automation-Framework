package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected Actions actions = null;
    protected String url = null;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //By overlayLocator = By.cssSelector(".overlay.loading");
    @FindBy(css = ".overlay.loading")
    private WebElement overlayLocator;

    protected void click (WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    protected WebElement findElement (WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForOverlayToGoAway() {
        wait.until(ExpectedConditions.invisibilityOf(overlayLocator));
    }
    protected void contextClick (WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }

    protected void hoverAction(WebElement webElement) {
        actions.moveToElement(findElement(webElement)).perform();
    }


}
