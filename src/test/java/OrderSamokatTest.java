import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum.yandex.model.MainPage;
import ru.praktikum.yandex.model.OrderPage;

import static junit.framework.TestCase.assertTrue;



public class OrderSamokatTest {
    private WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFirstButtonChrome() {
        orderPage.open();
        orderPage.acceptCookie();
        mainPage.clickToOrderButtonFirst();
        orderPage.inputTextForm("Тест", "Тестович", "79523999737");
        orderPage.metroSelect("Сокольники");
        orderPage.clickDoneButton();
        orderPage.dateSelect("01.02.2023");
        orderPage.rentPeriodSelect("трое суток");
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @Test
    public void testOrderSecondButtonChrome() {
        orderPage.open();
        orderPage.acceptCookie();
        mainPage.goToOrderButtonSecond();
        mainPage.clickToOrderButtonSecond();
        orderPage.inputTextForm("Тест", "Тестович", "79523999737");
        orderPage.metroSelect("Черкизовская");
        orderPage.clickDoneButton();
        orderPage.dateSelect("05.02.2023");
        orderPage.rentPeriodSelect("сутки");
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        assertTrue(orderPage.orderDoneCheck());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}