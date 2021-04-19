package stepdef;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pages.DemoqaBooksPage;
import pages.DemoqaHomePage;
import pages.DemoqaLoginPage;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

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

    private static Response response;
    private static final String userName = "TestUser69";
    private static final String password = "TestUser69!";
    private static final String fake_password = "qwerty";
    private static final String url = "https://demoqa.com";
    private static final String userId = "88ea6102-ee19-4bea-b396-0f7b9427a26d";
    private static final String isbn = "9781449325862";
    private static String token;
    private static String bookId;

    @И("^пользователь авторизуется с валидным логином")
    public void loginWithRealPassword() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/Authorized");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @И("^пользователь генерирует токен")
    public void generateToken() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\"}")
                .post("/Account/v1/GenerateToken");
        String getResponseText = response.asString();
        token = JsonPath.from(getResponseText).get("token");
    }

    @И("^пользователь авторизуется с невалидным логином")
    public void loginWithFakePassword() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + fake_password + "\"}")
                .post("/Account/v1/Authorized");
        Assert.assertEquals(400, response.getStatusCode());
    }

    @И("получаем список книг без авторизации")
    public void getBooksListWithoutAuthorization() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.get("/BookStore/v1/Books");
        String booksList = response.asString();
        List<Map<String, String>> books = JsonPath.from(booksList).get("books");
        Assert.assertTrue(books.size() > 0);
    }

    @И("^пользователь добавляет книгу себе в коллекцию")
    public void addBookToCollection() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body("{ \"userId\": \"" + userId + "\", \"collectionOfIsbns\": [ { \"isbn\": \"" + isbn + "\" } ]}")
                .post("/BookStore/v1/Books");
        Assert.assertEquals(201, response.getStatusCode());
    }

    @И("^пользователь удаляет книгу из своей коллекции")
    public void removeBookFromCollection() {
        RestAssured.baseURI = url;
        RequestSpecification request = given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}")
                .delete("/BookStore/v1/Books");
        Assert.assertEquals(204, response.getStatusCode());
    }


    @И("добавляем книгу")
    public void добавляемКнигу() {
        given()
                .accept("application/json")
                .contentType("application/json")
                .body("{ \"userId\": \"String\", \"collectionOfIsbns\": [ { \"isbn\": \"9781449325862\" } ]}")
                .when()
                .post("https://demoqa.com/BookStore/v1/Books")
                .then()
                .log().all();
    }
}
