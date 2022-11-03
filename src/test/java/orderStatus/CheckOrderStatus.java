package orderStatus;

import main.BrowserRule;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;

import java.time.Duration;

import static main.Utils.randomString;

public class CheckOrderStatus {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void notFoundShownWhenNotExistingOrderStatus() {
        HomePage homePage = new HomePage(browserRule.getDriver()) ;

        homePage.open();
        homePage.clickOrderStatusButton()
                .setOrderNumber(randomString())
                .clickGoButton();

        Assert.assertTrue(homePage.notFoundPage().isNotFoundImage());
    }
}
