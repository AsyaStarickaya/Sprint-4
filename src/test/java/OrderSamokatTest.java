import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import ru.praktikum.yandex.model.UserData;

import static junit.framework.TestCase.assertTrue;


public class OrderSamokatTest {
    private WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    UserData userData;
    private static final String USER_NAME_1 = "Иван";
    private static final String USER_NAME_2 = "Тест";
    private static final String USER_SURNAME_1 = "Иванов";
    private static final String USER_SURNAME_2 = "Тестов";
    private static final String USER_PHONE_1 = "79523999737";
    private static final String USER_PHONE_2 = "79999999999";
    private static final String USER_STATION_1 = "Сокольники";
    private static final String USER_STATION_2 = "Черкизовская";
    private static final String USER_DELIVER_DATE_1 = "01.03.2023";
    private static final String USER_DELIVER_DATE_2 = "30.09.2023";
    private static final String USER_RENT_PERIOD_1 = "трое суток";
    private static final String USER_RENT_PERIOD_2 = "сутки";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void createOrderWithFirstButtonTrue() {
        userData = new UserData(USER_NAME_1, USER_SURNAME_1, USER_PHONE_1, USER_STATION_1, USER_DELIVER_DATE_1,  USER_RENT_PERIOD_1);
        orderPage.open();
        orderPage.acceptCookie();
        mainPage.clickToOrderButtonFirst();
        orderPage.inputTextForm(userData.getUserName(), userData.getUserSurname(), userData.getUserPhone());
        orderPage.metroSelect(userData.getMetroStation());
        orderPage.clickDoneButton();
        orderPage.dateSelect(userData.getDeliverDate());
        orderPage.rentPeriodSelect(userData.getRentPeriodSelect());
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @Test
    public void createOrderWithSecondButtonTrue() {
        userData = new UserData(USER_NAME_2, USER_SURNAME_2, USER_PHONE_2, USER_STATION_2, USER_DELIVER_DATE_2, USER_RENT_PERIOD_2);
        orderPage.open();
        orderPage.acceptCookie();
        mainPage.clickToOrderButtonSecond();
        orderPage.inputTextForm(userData.getUserName(), userData.getUserSurname(), userData.getUserPhone());
        orderPage.metroSelect(userData.getMetroStation());
        orderPage.clickDoneButton();
        orderPage.dateSelect(userData.getDeliverDate());
        orderPage.rentPeriodSelect(userData.getRentPeriodSelect());
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}