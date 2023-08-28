import Client.UserClientDeleted;
import Client.UserClientLogin;
import DTO.UserDTO;
import DTO.UserResponse;
import POM.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;


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

        assertTrue(registrationPage.CheckingTheRansition());

        //Удаление пользователя
        //--------------------------------------------------------------------------------------------
        String baseUrl = RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        UserDTO user = new UserDTO("ivanov_307@gmail.com", "1234567", "Bob");

        //Вход в систему
        UserClientLogin userClientLogin = new UserClientLogin();
        Response response = userClientLogin.Login(user);

        //Десериализация
        UserResponse userResponse = response.as(UserResponse.class);
        //удаление начала токена
        String accessToken = userResponse.getAccessToken().substring(7);

        //Удаление пользователя
        UserClientDeleted userClientDeleted = new UserClientDeleted();
        userClientDeleted.Delete(accessToken);

    }

    @Test
    @DisplayName("Checking for an error during registration")
    public void regisrationError() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.regisrationFailed();

        assertTrue(registrationPage.CheckingIfThePasswordIsTooShort());
    }

    @After
    public void teardown() {

        driver.quit();
    }
}