package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FAQSection {

    private final WebDriver driver;

    public FAQSection(WebDriver driver) {
        this.driver = driver;
    }

    private final By questions = By.xpath(".//div[@class = 'accordion__button']");
    private final By responses = By.xpath(".//div[contains(@id, 'accordion__panel')]");

    public String getTextFromResponses(int number) {
        List<WebElement> elements = driver.findElements(questions);
        List<WebElement> textElements = driver.findElements(responses);
        elements.get(number).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.visibilityOfElementLocated(questions));
        return textElements.get(number).getText();
    }

    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector('.accordion').scrollIntoView()");
    }
}
