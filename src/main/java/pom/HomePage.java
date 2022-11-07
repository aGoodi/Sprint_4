package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс главной страницы
public class HomePage {

    private final WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "Заказать" верхняя
    private final By headerMakeOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[text() = 'Заказать']");
    //Кнопка "Заказать" нижняя
    private final By makeOrderButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text() = 'Заказать']");
    //Кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    //Кнопка "Go!"
    private final By goButton = By.xpath(".//button[text() = 'Go!']");
    //Поле ввода номера заказа
    private final By inputOrderNumber = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    //Кнопка, чтобы принять куки
    private final By acceptCookieButton = By.xpath(".//button[contains(@class, 'App_CookieButton')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть страницу
    public HomePage open() {
        driver.get(url);
        return this;
    }

    //Клик по кнопке, чтобы принять куки
    public HomePage clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
        return this;
    }
    //Клик по кнопке "Статус заказа"
    public HomePage clickOrderStatusButton() {
        this.driver.findElement(orderStatusButton).click();
        return this;
    }
    //Клик по кнопке "Заказать"
    public void clickOrderButton(String buttonPlace) {
        if (buttonPlace.equals("верхняя кнопка")) {
            driver.findElement(headerMakeOrderButton).click();
        } else if (buttonPlace.equals("нижняя кнопка")) {
            driver.findElement(makeOrderButton).click();
        }
    }
    //Клик по кнопке "Далее"
    public HomePage clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }
    //Написать номер заказа
    public HomePage setOrderNumber(String orderNumber) {
        driver.findElement(inputOrderNumber).sendKeys(orderNumber);
        return this;
    }

    public NotFoundPage notFoundPage() {
        return new NotFoundPage(driver);
    }

    public OrderPage orderPage() {
        return new OrderPage(driver);
    }
    public RentPage rentPage() {
        return new RentPage(driver);
    }
    public FAQSection faqSection() {
        return new FAQSection(driver);
    }
}
