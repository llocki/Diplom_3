package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class RegistrationPage {

    private WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //------------------------------------------------------
    //Локаторы для регистрации

    static final By name = By.xpath(".//label[.='Имя']/../input");
    static final By email = By.xpath(".//label[.='Email']/../input");
    static final By password = By.xpath(".//label[.='Пароль']/../input");
    static final By buttonLogin = By.xpath(".//button[text()='Зарегистрироваться']");

    private final By entrance = By.xpath(".//a[text()='Восстановить пароль']");

    private final By incorrectPassword = By.xpath(".//p[.='Некорректный пароль']");
    //----------------------------------------------------------------------------------------------
    //Тестовые данные


    static final String userName = "Bob" ;

    static int randomCompany = new Random().nextInt();
    static final String userEmail = "ivanov_" + randomCompany + "@gmail.com";

    static final String userPassword = "1234567";
    static final String userPasswordError = "123";

    //-------------------------------------------------------

    @Step("Regisration")
    public void regisration(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(name));

        driver.findElement(name).sendKeys(userName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(buttonLogin).click();
    }

    @Step("Checking if there is an element on the new page")
    public boolean CheckingTheRansition(){//Проверка что есть элемент на новой странице

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(entrance));

        return driver.findElement(entrance).isEnabled();
    }

    @Step("Registration error")
    public void regisrationFailed(){// Ошибка при регистрации

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(name));

        driver.findElement(name).sendKeys(userName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPasswordError);
        driver.findElement(buttonLogin).click();
    }

    @Step("Checking if there is an element on the new page")
    public boolean CheckingIfThePasswordIsTooShort(){//Проверка что есть элемент на новой странице

        return driver.findElement(incorrectPassword).isEnabled();
    }

}
