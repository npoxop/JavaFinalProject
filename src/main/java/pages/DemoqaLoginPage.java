package pages;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaLoginPage {

    public void getUrl() {
        open("https://demoqa.com/login");
    }

    public void checkElementVisiblePage() {
        $(By.id("userForm")).shouldHave(Condition.visible);
    }

    public void fillInputLogin(String login) {
        $(By.id("userName")).sendKeys(login);
    }

    public void fillInputPassword(String password) {
        $(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        $(By.id("login")).click();
    }
}
