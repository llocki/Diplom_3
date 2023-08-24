package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAreaPage {

    private WebDriver driver;

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }



    static final By personalArea = By.xpath(".//p[text()='Личный Кабинет']");//Кнопка для перехода в личный кабинет

    private final By entrance = By.xpath(".//a[text()='Восстановить пароль']");

    @Step("Go to personal account")
    public void goToPersonalAccount (){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalArea));

        driver.findElement(personalArea).click();
    }

    @Step("Checking for the Existence of an Element")
    public boolean isThereALink (){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(entrance));

        return driver.findElement(entrance).isEnabled();

    }
}
