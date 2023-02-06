import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.model.MainPage;
import ru.praktikum.yandex.model.OrderPage;

import static junit.framework.TestCase.assertTrue;


public class OrderSamokatTest {
    private WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    UserData userData;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void createOrderWithFirstButtonTrue() {
        userData = new UserData("Иван", "Иванов", "79523999737", "Сокольники", "01.03.2023", "трое суток");
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
        userData = new UserData("Тест", "Тестов", "79999999999", "Черкизовская", "30.09.2023", "сутки");
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