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
    private static final UserData USER_DATA_1 = new UserData("Иван",  "Иванов", "79523999737", "Сокольники", "01.03.2023",  "трое суток");
    private static final UserData USER_DATA_2 = new UserData("Тест",  "Тестов", "79999999999", "Черкизовская", "30.09.2023",  "сутки");

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void createOrderWithFirstButtonTrue() {

        orderPage.open();
        orderPage.acceptCookie();
        mainPage.clickToOrderButtonFirst();
        orderPage.inputTextForm(USER_DATA_1.getUserName(), USER_DATA_1.getUserSurname(), USER_DATA_1.getUserPhone());
        orderPage.metroSelect(USER_DATA_1.getMetroStation());
        orderPage.clickDoneButton();
        orderPage.dateSelect(USER_DATA_1.getDeliverDate());
        orderPage.rentPeriodSelect(USER_DATA_1.getRentPeriodSelect());
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @Test
    public void createOrderWithSecondButtonTrue() {
        orderPage.open();
        orderPage.acceptCookie();
        mainPage.clickToOrderButtonSecond();
        orderPage.inputTextForm(USER_DATA_2.getUserName(), USER_DATA_2.getUserSurname(), USER_DATA_2.getUserPhone());
        orderPage.metroSelect(USER_DATA_2.getMetroStation());
        orderPage.clickDoneButton();
        orderPage.dateSelect(USER_DATA_2.getDeliverDate());
        orderPage.rentPeriodSelect(USER_DATA_2.getRentPeriodSelect());
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}