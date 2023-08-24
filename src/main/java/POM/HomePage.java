package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    static final By blueLine =By.cssSelector(".tab_tab_type_current__2BEPc");


    static final By rolls = By.xpath(".//span[text()= 'Булки']"); // Булки
    static final By sauces = By.xpath(".//span[text()= 'Соусы']"); // Соусы
    static final By filling = By.xpath(".//span[text()= 'Начинки']"); //Начинки

    @Step("Getting the location of the bun")
    public Point rollsSearch(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rolls));

        return driver.findElement(blueLine).getLocation();
    }

    @Step("Getting the Location of the sauce")
    public Point saucesSearch(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauces));

        driver.findElement(sauces).click();

        return driver.findElement(blueLine).getLocation();
    }

    @Step("Getting the Location of the filling")
    public Point fillingSearch(){

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(filling));

        driver.findElement(filling).click();

        return driver.findElement(blueLine).getLocation();

    }




}
