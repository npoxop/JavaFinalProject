package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DemoqaHomePage {

    public void checkElementProfileUser() {
        $(By.id("userName-value")).shouldHave(Condition.exactText("TestUser123"));
    }
}


