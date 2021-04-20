package stepdef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.Timestamp;

public class Hooks {

    public static WebDriver driver;

    @BeforeStep
    public static void TimeCount() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);
    }

    @Before
    public static void setUp(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.timeout=10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.browserVersion = "89.0";
        Configuration.remote = "http://188.130.155.80:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @After
    public static void tearDown(Scenario scenario) {
        Selenide.closeWebDriver();
    }

}
