package ru.praktikum.yandex.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    public final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By DROP_DOWN_QUESTION_0 = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private final By DROP_DOWN_QUESTION_1 = By.xpath("//*[@id=\"accordion__heading-1\"]");
    private final By DROP_DOWN_QUESTION_2 = By.xpath("//*[@id=\"accordion__heading-2\"]");
    private final By DROP_DOWN_QUESTION_3 = By.xpath("//*[@id=\"accordion__heading-3\"]");
    private final By DROP_DOWN_QUESTION_4 = By.xpath("//*[@id=\"accordion__heading-4\"]");
    private final By DROP_DOWN_QUESTION_5 = By.xpath("//*[@id=\"accordion__heading-5\"]");
    private final By DROP_DOWN_QUESTION_6 = By.xpath("//*[@id=\"accordion__heading-6\"]");
    private final By DROP_DOWN_QUESTION_7 = By.xpath("//*[@id=\"accordion__heading-7\"]");
    private final By DROP_DOWN_ANSWER_0 = By.id("accordion__panel-0");
    private final By DROP_DOWN_ANSWER_1 = By.id("accordion__panel-1");
    private final By DROP_DOWN_ANSWER_2 = By.id("accordion__panel-2");
    private final By DROP_DOWN_ANSWER_3 = By.id("accordion__panel-3");
    private final By DROP_DOWN_ANSWER_4 = By.id("accordion__panel-4");
    private final By DROP_DOWN_ANSWER_5 = By.id("accordion__panel-5");
    private final By DROP_DOWN_ANSWER_6 = By.id("accordion__panel-6");
    private final By DROP_DOWN_ANSWER_7 = By.id("accordion__panel-7");


    //верхняя кнопка "Заказать"
    public final By FIRST_BUTTON_ORDERED = By.className("Button_Button__ra12g");
    //нижняя кнопка "Заказать"
    public final By SECOND_BUTTON_ORDERED = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    By questionButtonList[] = {
            DROP_DOWN_QUESTION_0,
            DROP_DOWN_QUESTION_1,
            DROP_DOWN_QUESTION_2,
            DROP_DOWN_QUESTION_3,
            DROP_DOWN_QUESTION_4,
            DROP_DOWN_QUESTION_5,
            DROP_DOWN_QUESTION_6,
            DROP_DOWN_QUESTION_7
    };
    By answerButtonList[] = {
            DROP_DOWN_ANSWER_0,
            DROP_DOWN_ANSWER_1,
            DROP_DOWN_ANSWER_2,
            DROP_DOWN_ANSWER_3,
            DROP_DOWN_ANSWER_4,
            DROP_DOWN_ANSWER_5,
            DROP_DOWN_ANSWER_6,
            DROP_DOWN_ANSWER_7
    };

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickDropDownList(int buttonNumber) {
        WebElement element = driver.findElement(questionButtonList[buttonNumber]);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        element.click();
//        wait.until(ExpectedConditions.visibilityOf(dropDownAnswer));
    }

    public String actualText(int buttonNumber) {
        return driver.findElement(answerButtonList[buttonNumber]).getText();
    }

    public void clickUpperButtonOrder() {
        driver.findElement(FIRST_BUTTON_ORDERED).click();
    }

    public void clickDownButtonOrder() {
        driver.findElement(SECOND_BUTTON_ORDERED).click();
    }

    //Функция нажатия на первую кнопку "Заказать"
    public void clickToOrderButtonFirst() {
        driver.findElement(FIRST_BUTTON_ORDERED).click();
    }

    //Функция прокрутки до второй кнопки "Заказать"
    public void goToOrderButtonSecond() {
        WebElement element = driver.findElement(SECOND_BUTTON_ORDERED);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Функция нажатия на вторую кнопку "Заказать"
    public void clickToOrderButtonSecond() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(SECOND_BUTTON_ORDERED));
        driver.findElement(SECOND_BUTTON_ORDERED).click();
    }

}