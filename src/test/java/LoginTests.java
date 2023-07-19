import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("invalid@email.com").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //"https://qa.koel.app/"
    //
//      Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //String url = "https://qa.koel.app/";
        //driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }
    @Test
    public void loginValidEmailEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("invalid@email.com").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //"https://qa.koel.app/"
    }
    @Test
    public void loginValidPasswordEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("").providePassword("").clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //"https://qa.koel.app/"
    }
   @Test
    public void LoginValidEmailPassWordTest()   {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("trianasahlin@gmail.com").providePassword("te$t$tudent").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());


    }
}
