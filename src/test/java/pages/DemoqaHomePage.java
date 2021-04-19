package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DemoqaHomePage {

    public void checkElementProfileUser() {
        $(By.id("userName-value")).shouldHave(Condition.exactText("TestUser123"));
    }

    public void goToProfilePage() {
        $(By.xpath("//span[contains(text(),'Profile')]")).scrollTo();
        $(By.xpath("//span[contains(text(),'Profile')]")).click();
    }

    public void checkElementErrorMessage() {
        $(By.id("name")).shouldHave(Condition.exactText("Invalid username or password!"));
    }

    public void clickGoToStoreButton() {

        $(By.id("gotoStore")).scrollTo();
        $(By.id("gotoStore")).click();
    }

    public void removeGitPocketGuideBook() {
        $(By.id("delete-record-undefined")).click();
        $(By.id("closeSmallModal-ok")).click();
        switchTo().alert().accept();
    }

    public void checkBookList(){
        $(By.id("see-book-Git Pocket Guide")).shouldNot(Condition.visible);
    }
}


