package orderstatus;

import main.BrowserRule;
import org.junit.*;
import pom.HomePage;

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
