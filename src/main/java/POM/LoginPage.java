package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    static final By homePageLogin = By.xpath(".//button[text()='Войти в аккаунт']");//Кнопка вход на главной странице

    static final By personalArea = By.xpath(".//p[text()='Личный Кабинет']");//Кнопка для перехода в личный кабинет

    static final By personalAreaText = By.xpath(".//p[starts-with(text(),'В этом разделе')]");//текст в личном кабинете


    static final By loginButton = By.xpath(".//button[text()='Войти']"); //Кнопка войти на странице логина

    static final By loginButtonRegictration = By.xpath(".//a[@href='/login']") ;//Кнопка войти в поле регистрации

    static final By fieldEmail = By.xpath(".//input[@name='name']");
    static final By fieldPassword = By.xpath(".//input[@name='Пароль']");

    static final By constructorButton = By.xpath(".//p[text()='Конструктор']");// Кнопка конструктора в личном кабинете

    static final By exitButton = By.xpath(".//button[text()='Выход']");// Кнопка выхода в личном кабинете

    static final By assembleTheBurgerText = By.xpath(".//h1[text()='Соберите бургер']");// Текст на главной странице для проверки
    static final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");// Логотип сайта


    @Step("Login using the login button on the main page")
    public void loginHomePage(String email, String password){//Вход по кнопке войти на главной

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(homePageLogin));

        driver.findElement(homePageLogin).click();

        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
    }

    @Step("Login through the personal account button")
    public void loginThroughPersonalArea(String email, String password){// Вход через кнопку личный кабинет

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();

        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
    }

    @Step("Login via register button and stop password")
    public void loginViaPasswordResetButton(String email, String password){// Вход через кнопку регистрации и востановления пароля

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButtonRegictration));

        driver.findElement(loginButtonRegictration).click();


        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
    }

    @Step("Getting text to check")
    public String textCheck() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAreaText));

        return  driver.findElement(personalAreaText).getText();
    }
//-------------------------------------------------------------------------------------------------

@Step("Switching from a personal account to an authorized user's constructor")
    public void transitionFromPersonalAccountToDesigner(String email, String password) {// Переход из личного кабинета в конструктор авторизованного пользователя

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fieldEmail));

        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
        driver.findElement(constructorButton).click();
    }

    @Step("Transition from a personal account to the main page of an authorized user")
    public void transitionFromPersonalAccountToTheMainPage(String email, String password) {// Переход из личного кабинета на главную страницу

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fieldEmail));

        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
        driver.findElement(logo).click();
    }

    @Step("getting text from homepage")
    public String textCheckassembleTheBurger() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(assembleTheBurgerText));

        return  driver.findElement(assembleTheBurgerText).getText();
    }
    //--------------------------------------------------------------------------------------

    @Step("Logout")
    public void logout (String email, String password) {// Выход из аккаунта

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fieldEmail));

        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));

        driver.findElement(exitButton).click();
    }
    @Step("getting the text from the button to validate")
    public String outputCheck() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));

        return  driver.findElement(loginButton).getText();
    }
    }

