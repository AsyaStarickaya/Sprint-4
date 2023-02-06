package ru.praktikum.yandex.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By dropDownQuestion0 = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private final By dropDownQuestion1 = By.xpath("//*[@id=\"accordion__heading-1\"]");
    private final By dropDownQuestion2 = By.xpath("//*[@id=\"accordion__heading-2\"]");
    private final By dropDownQuestion3 = By.xpath("//*[@id=\"accordion__heading-3\"]");
    private final By dropDownQuestion4 = By.xpath("//*[@id=\"accordion__heading-4\"]");
    private final By dropDownQuestion5 = By.xpath("//*[@id=\"accordion__heading-5\"]");
    private final By dropDownQuestion6 = By.xpath("//*[@id=\"accordion__heading-6\"]");
    private final By dropDownQuestion7 = By.xpath("//*[@id=\"accordion__heading-7\"]");
    private final By DropDownAnswer0 = By.id("accordion__panel-0");
    private final By DropDownAnswer1 = By.id("accordion__panel-1");
    private final By DropDownAnswer2 = By.id("accordion__panel-2");
    private final By DropDownAnswer3 = By.id("accordion__panel-3");
    private final By DropDownAnswer4 = By.id("accordion__panel-4");
    private final By DropDownAnswer5 = By.id("accordion__panel-5");
    private final By DropDownAnswer6 = By.id("accordion__panel-6");
    private final By DropDownAnswer7 = By.id("accordion__panel-7");


    //верхняя кнопка "Заказать"
    public final By FIRST_BUTTON_ORDERED = By.className("Button_Button__ra12g");
    //нижняя кнопка "Заказать"
    public final By SECOND_BUTTON_ORDERED = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    By questionButtonList[] = {
            dropDownQuestion0,
            dropDownQuestion1,
            dropDownQuestion2,
            dropDownQuestion3,
            dropDownQuestion4,
            dropDownQuestion5,
            dropDownQuestion6,
            dropDownQuestion7
    };
    By answerButtonList[] = {
            DropDownAnswer0,
            DropDownAnswer1,
            DropDownAnswer2,
            DropDownAnswer3,
            DropDownAnswer4,
            DropDownAnswer5,
            DropDownAnswer6,
            DropDownAnswer7
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
        element.click();
    }

    public String getDropDownAnswerText(int buttonNumber) {
        return driver.findElement(answerButtonList[buttonNumber]).getText();
    }

    //Функция нажатия на первую кнопку "Заказать"
    public void clickToOrderButtonFirst() {
        driver.findElement(FIRST_BUTTON_ORDERED).click();
    }

    //Функция нажатия на вторую кнопку "Заказать"
    public void clickToOrderButtonSecond() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(SECOND_BUTTON_ORDERED));
        driver.findElement(SECOND_BUTTON_ORDERED).click();
    }

}