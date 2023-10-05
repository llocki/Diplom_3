import POM.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class HomePageTest {
    WebDriver getWebDriver (String browserName){

        ChromeOptions options = new ChromeOptions();
        switch (browserName){
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "A:\\zzz\\YandexDriver\\bin\\yandexdriver.exe");
                return new ChromeDriver(options.setBinary("C:\\Users\\maxpl\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    public WebDriver driver = getWebDriver("chrome");// yandex или chrome в зависимости от того какой браузер нужен

    @Test
    @DisplayName("Checking the position of the buns")
    public void rollsSearchTest() {// проверка расоложения булок

        HomePage homePage  = new HomePage(driver);

        driver.get("https://stellarburgers.nomoreparties.site");

        Point expected = new Point(0,187);
        Point actual = homePage.rollsSearch();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the position of the sauce")
    public void saucesSearchTest() {// проверка расположения соусов
        HomePage homePage  = new HomePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");

        Point expected = new Point(200,187);
        Point actual = homePage.saucesSearch();

         assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Checking the position of the filling")
    public void fillingSearchTest() {// проверка расположения начинки
        HomePage homePage  = new HomePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");

        Point expected = new Point(400,187);
        Point actual = homePage.fillingSearch();

        assertEquals(expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();

    }
}



