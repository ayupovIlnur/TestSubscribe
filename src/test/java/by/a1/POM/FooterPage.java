package by.a1.POM;

import by.a1.DataForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

    private  WebDriver driver;
private static FooterPage footerPage;

    /*Поле емайла*/
    private By fieldSubscribe = By.xpath("//input[@placeholder='Введите свой email']");

    /*Кнопка подписаться*/
    private By buttonSubmit = By.xpath("//button[@type='submit']");

    /*Кнопка cookie*/
   private By buttonCookie = By.xpath("//button[@class='button button--primary cookie-panel-button']");

       /*закрыть куки*/
    public void closeCookie() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCookie));

        driver.findElement(buttonCookie).click();
    }

    /*Скролл до поля подписки*/
    public void scrollSubscribe() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(fieldSubscribe));

        WebElement element = driver.findElement(fieldSubscribe);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /*Ввести емайл, подписаться*/
    public void subscribe() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(fieldSubscribe));
        driver.findElement(fieldSubscribe).sendKeys(DataForTesting.EMAIL);
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        driver.findElement(buttonSubmit).click();
    }

    /*Реализация паттерна Singleton. Экземляр класса FooterPage можно создать только 1 раз через геттер*/
    private FooterPage(WebDriver driver) {

        this.driver = driver;
    }
    public static FooterPage getFooterPage(WebDriver driver) {
        if(footerPage==null) {
            footerPage = new FooterPage(driver);
        } return footerPage;
    }


}

