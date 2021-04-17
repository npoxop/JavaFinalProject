package stepdef;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import stepdef.pages.DemoqaHomePage;
import stepdef.pages.DemoqaLoginPage;


public class StepsDefs extends InitDriver {

    public  DemoqaLoginPage demoqaLoginPage = new DemoqaLoginPage();
    public  DemoqaHomePage demoqaHomePage = new DemoqaHomePage();

    @Дано("^открывается страница Авторизации")
    public void checkElementGoogle() {
        demoqaLoginPage.getUrl();
        demoqaLoginPage.checkElementVisiblePage();
    }

    @И("^пользователь заполняет поле Login значением \"([^\"]*)\"$")
    public void fillInputLogin(String login) {
        demoqaLoginPage.fillInputLogin(login);
    }

    @И("^пользователь заполняет поле Password значением \"([^\"]*)\"$")
    public void fillInputPassword(String password) {
        demoqaLoginPage.fillInputPassword(password);
    }


    @И("^пользователь нажимает кнопку Войти")
    public void clickLoginButton() {
        demoqaLoginPage.clickLoginButton();
    }

    @Тогда("^открывается профиль пользователя")
    public void checkElementProfileUser() {
        demoqaHomePage.checkElementProfileUser();
    }
}
