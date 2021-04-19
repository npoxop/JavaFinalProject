package stepdef;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.DemoqaHomePage;
import pages.DemoqaLoginPage;
import pages.DemoqaBooksPage;

public class StepsDefs {

    private DemoqaLoginPage demoqaLoginPage = new DemoqaLoginPage();
    private DemoqaHomePage demoqaHomePage = new DemoqaHomePage();
    private DemoqaBooksPage demoqaBooksPage = new DemoqaBooksPage();

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

    @И("^пользователь нажимает кнопку Перейти в магазин книг")
    public void gotoStoreButton() { demoqaHomePage.clickGoToStoreButton();}

    @И("^пользователь добавляет книгу Git Pocket Guide в свою библиотеку")
    public void addGitPocketGuideBook() {demoqaBooksPage.addGitPocketGuideBook();}

    @И("^пользователь удаляет книгу Git Pocket Guide из своей библиотеки")
    public void removeGitPocketGuideBook() {demoqaHomePage.removeGitPocketGuideBook();}

    @И("^пользователь переходит в свой профиль")
    public void goToProfilePage() {demoqaHomePage.goToProfilePage();}

    @И("^пользователь переходит во вкладку магазин книг")
    public void goToBooksPage() {demoqaBooksPage.goToBooksPage();}

    @Тогда("^открывается профиль пользователя")
    public void checkElementProfileUser() { demoqaHomePage.checkElementProfileUser(); }

    @Тогда("^всплывает сообщение об ошибке")
    public void checkErrorMessage() { demoqaHomePage.checkElementErrorMessage(); }

    @Тогда("^книга удалена из списка")
    public void checkBookList() {demoqaHomePage.checkBookList();}

    @Тогда("^открывается список книг")
    public void checkBooksList() {demoqaBooksPage.checkBooksList();}
}
