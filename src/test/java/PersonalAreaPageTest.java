import POM.PersonalAreaPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;

public class PersonalAreaPageTest {

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
    @DisplayName("Checking the transition to your personal account")
    public void goToPersonalAccountTest() {

        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site");

        personalAreaPage.goToPersonalAccount();

        boolean expected = true;
        boolean actual = personalAreaPage.isThereALink();

        assertEquals(expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();

    }
}