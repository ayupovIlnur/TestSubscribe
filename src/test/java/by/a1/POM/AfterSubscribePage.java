package by.a1.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AfterSubscribePage {
    private WebDriver driver;
    private static AfterSubscribePage afterSubscribePage;

    /*Локатор сообщения об успешной подписке*/
    private By successSubscribe = By.xpath("//div[not(@class='hidden')]//div[@class='toast-content--success toast-content']/div[text()='Вы успешно подписались на нашу новостную рассылку.']");

    /*Возврат сообщения об успешной подписке*/
    public String getMessageSubscribe() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(successSubscribe));
        return driver.findElement(successSubscribe).getText();
    }

    /*Реализация паттерна Singleton. Экземляр класса AfterSubscribePage можно создать только 1 раз через геттер*/
    private AfterSubscribePage(WebDriver driver) {

        this.driver = driver;
    }
    public static AfterSubscribePage getAfterSubscribePage(WebDriver driver) {
        if(afterSubscribePage==null) {
            afterSubscribePage = new AfterSubscribePage(driver);
        } return afterSubscribePage;
    }
}
