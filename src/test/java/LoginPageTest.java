import Base.BaseUserCreatingAndDeletet;
import DTO.UserDTO;
import POM.LoginPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;


public class LoginPageTest extends BaseUserCreatingAndDeletet {


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
    @DisplayName("Checking the login on the login button on the main")
    public void loginHomePageTest() {// Вход по кнопке войти на главной

        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site");

        loginPage.loginHomePage(user.getEmail(), user.getPassword());

        String expected = "В этом разделе вы можете изменить свои персональные данные";
        String actual = loginPage.textCheck();

        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("Checking the login through the personal account button")
    public void loginThroughPersonalAreaTest() {// Вход через кнопку личный кабинет

        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site");

        loginPage.loginThroughPersonalArea(user.getEmail(), user.getPassword());

        String expected = "В этом разделе вы можете изменить свои персональные данные";
        String actual = loginPage.textCheck();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Login verification through the registration page")
    public void LoginViaRegistrationRageTest() {// Вход через страницу регистрации

        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/register");

        loginPage.loginViaPasswordResetButton(user.getEmail(), user.getPassword());

        String expected = "В этом разделе вы можете изменить свои персональные данные";
        String actual = loginPage.textCheck();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Checking login through the password recovery page")
    public void loginViaPasswordResetButtonTest() {// Вход через страницу востановления пароля
        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        loginPage.loginViaPasswordResetButton(user.getEmail(), user.getPassword());

        String expected = "В этом разделе вы можете изменить свои персональные данные";
        String actual = loginPage.textCheck();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the transition from the personal account to the authorized user's constructor")
    public void transitionFromPersonalAccountToDesignerTest() {// Переход из личного кабинета в конструктор авторизованного пользователя
        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/login");

        loginPage.transitionFromPersonalAccountToDesigner(user.getEmail(), user.getPassword());

        String expected = "Соберите бургер";
        String actual = loginPage.textCheckassembleTheBurger();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the transition from your personal account to the main page")
    public void transitionFromPersonalAccountToTheMainPageTest() {// Переход из личного кабинета на главную страницу
        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/login");

        loginPage.transitionFromPersonalAccountToTheMainPage(user.getEmail(), user.getPassword());

        String expected = "Соберите бургер";
        String actual = loginPage.textCheckassembleTheBurger();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking out of your account")
    public void logoutTest() {// Выход из аккаунта
        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site/login");

        loginPage.logout(user.getEmail(), user.getPassword());

        String expected = "Войти";
        String actual = loginPage.outputCheck();

        assertEquals(expected, actual);
    }


    @After
    public void teardown() {
        driver.quit();

    }
}