package ru.praktikum.yandex.model;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By cookie = By.id("rcc-confirm-button");

    //Выпадающее меню метро
    private By metro = By.className("select-search__input");

    //Локатор кнопки Далее
    private By done = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор поля телефон
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор поля дата
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор поля срока аренды
    private By rentPeriod = By.className("Dropdown-placeholder");

    //Локатор кнопки "Заказать" в форме заказа
    private By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор кнопки подтверждения заказа
    private By yesButton = By.xpath("//*[text()='Да']");

    //Локатор окна подтверждения оформления заказа
    private By orderWellDone = By.xpath(".//*[text()='Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get(PAGE_URL);
    }

    //Функция принятия куки
    public void acceptCookie() {
        driver.findElement(cookie).click();
    }

    //Функция локатор станции метро по названию
    public By metroStationLocator(String newStation) {
        By metro = By.xpath(".//*[text()='" + newStation + "']");
        return metro;
    }

    //Функция локатор периода аренды
    public By rentPeriodLokator(String newPeriod) {
        By period = By.xpath(".//div[@class='Dropdown-menu']/div[text()='" + newPeriod + "']");
        return period;
    }

    //Функция нажатия кнопки "Далее" на первой странице формы заказа
    public void clickDoneButton() {
        driver.findElement(done).click();
    }

    //Функция нажатия кнопки "Заказать" на втрой странице формы заказа
    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }

    //Функция нажатия кнопки "Да" в финале подтверждения заказа
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Функция проверки отображения уведомления о завершения заказа
    public boolean orderDoneCheck() {
        boolean check = driver.findElement(orderWellDone).isDisplayed();
        return check;
    }

    //Шаг заполнения рукописных полей заказа самоката
    public void inputTextForm(String newName, String newSurname, String newPhone) {
        driver.findElement(name).sendKeys(newName);
        driver.findElement(surname).sendKeys(newSurname);
        driver.findElement(phone).sendKeys(newPhone);
    }

    //Шаг заполнения поля "метро"
    public void metroSelect(String newStation) {
        driver.findElement(metro).click();
        By metroLokator = metroStationLocator(newStation);
        driver.findElement(metroLokator).click();
    }

    //Шаг заполнения поля "дата"
    public void dateSelect(String newDate) {
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(newDate);
        driver.findElement(date).sendKeys(Keys.RETURN);
    }

    //Шаг заполнения поля "период"
    public void rentPeriodSelect(String newPeriod) {
        driver.findElement(rentPeriod).click();
        By rentLokator = rentPeriodLokator(newPeriod);
        driver.findElement(rentLokator).click();
    }
}