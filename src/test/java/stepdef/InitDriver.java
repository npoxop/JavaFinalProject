package stepdef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public abstract class InitDriver {
    private static boolean initialized = false;

    @BeforeAll
    static void setUpDriver() {
        if (initialized) return;
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver89.exe");
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        initialized = true;
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

}
