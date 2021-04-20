package stepdef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;


public class Hooks {

    public static WebDriver driver;

    @Before
    public static void setUp(Scenario scenario) {
        //System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.timeout=10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @After
    public static void tearDown(Scenario scenario) {
        Selenide.closeWebDriver();
    }

}
