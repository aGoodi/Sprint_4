package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Класс для страницы про аренду
public class RentPage {

    private WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Когда привезти скутер"
    private final By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле "Срок аренды"
    private final By rentalPeriodField = By.xpath(".//div[contains(@class, 'Dropdown-control')]");
    //Поле комментария
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //Кнопка "Да" в попапе
    private final By okButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");
    //Текст об успешном оформлении заказа
    private final By orderIsPlaced = By.xpath(".//div[text() = 'Заказ оформлен']");
    //Выбор цвета самоката
    public void selectColorOfScooter(String color) {
        if (color.equals("чёрный жемчуг")) {
            driver.findElement(By.xpath(".//div[@class ='Order_Checkboxes__3lWSI']/label[@for = 'black']")).click();
        } else if (color.equals("серая безысходность")) {
            driver.findElement(By.xpath(".//div[@class ='Order_Checkboxes__3lWSI']/label[@for = 'gray']")).click();
        }
    }
    //Выбор срока аренды
    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodField).click();
        WebElement element = driver.findElement(By.xpath(".//div[text() = 'двое суток']"));
        element.click();
    }
    //Заполнение информации об аренде
    public RentPage setRentInfo(String date, String period, String color, String comment) {
        driver.findElement(dateField).sendKeys(date);
        selectColorOfScooter(color);
        driver.findElement(commentField).sendKeys(comment);
        selectRentalPeriod(period);
        return this;
    }
    //Клик по кнопке "Заказать"
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
    //Клик по кнопке "Да" в попапе
    public RentPage clickOkButton() {
        driver.findElement(okButton).click();
        return this;
    }

    public boolean isOrderIsPlaced() {
        return driver.findElements(orderIsPlaced).size() > 0;
    }


}
