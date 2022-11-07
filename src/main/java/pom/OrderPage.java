package pom;

import org.openqa.selenium.*;

//Класс для страницы заказа
public class OrderPage{

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Имя"
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле "Фамилия"
    private final By secondNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By metroStationField = By.xpath(".//input[@class = 'select-search__input']");
    //Поле "Телефон"
    private final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");

    // Выбор станции метро
    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(metroStationField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroStationField).sendKeys(Keys.ENTER);
    }
    //Заполнение персональной информации
    public OrderPage setUserInfo(String name, String secondName, String address, String metroStation, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        selectMetroStation(metroStation);
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }
    //Клик кнопки "Далее"
    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

}
