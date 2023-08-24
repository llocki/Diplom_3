import POM.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import static org.junit.Assert.assertEquals;


public class RegistrationPageTest {

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
    @DisplayName("User registration")
    public void regisration() {


        RegistrationPage registrationPage = new RegistrationPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.regisration();

        assertEquals(true, registrationPage.CheckingTheRansition());

    }


    @Test
    @DisplayName("Checking for an error during registration")
    public void regisrationError() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.regisrationFailed();

        assertEquals(true, registrationPage.CheckingIfThePasswordIsTooShort());

    }

    @After
    public void teardown() {
        driver.quit();

    }
}