package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotFoundPage {

    private WebDriver driver;

    private final By notFoundImage = By.xpath(".//img[@alt = 'Not found']");

    public NotFoundPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNotFoundImage() {
        return driver.findElements(notFoundImage).size() > 0;
    }
}
