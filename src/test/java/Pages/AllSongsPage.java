package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSong;

    @FindBy(css = "li.playback")
    private WebElement playSong;

    @FindBy(css = "div > button:nth-child(2) > div > img")
    private WebElement soundBar;

    //By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");

    //By playSong = By.cssSelector("li.playback");

    //By soundBar = By.cssSelector("div > button:nth-child(2) > div > img");

    // play song functions
    public AllSongsPage contextClickFirstSong() {
        contextClick(firstSong);
        return this;
    }
    public AllSongsPage choosePlayOption() {
        findElement(playSong).click();
        return this;

    }
    public Boolean isSongPlaying() {
        return findElement(soundBar).isDisplayed();

    }
}
