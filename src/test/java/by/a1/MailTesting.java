package by.a1;

import by.a1.POM.AfterSubscribePage;
import by.a1.POM.FooterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailTesting {
WebDriver driver;
@BeforeEach
public void startUp () {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
}
@Test
    public void mailSubscribeTesting() {
    driver.get(DataForTesting.SITE);
    FooterPage footerPage = FooterPage.getFooterPage(driver);
    footerPage.closeCookie();
    footerPage.scrollSubscribe();
    footerPage.subscribe();
    AfterSubscribePage afterSubscribePage = AfterSubscribePage.getAfterSubscribePage(driver);

    /*Проверка появилось ли сообщение об успешной подписке*/
    assertEquals(DataForTesting.SUCCESS_SUBSCRIBE,afterSubscribePage.getMessageSubscribe(),"Сообщение об успешной подписке не появилось, либо поменялся его текст");

}
@AfterEach
    public void closeBrowser() {
    driver.quit();
}
}
