package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaBooksPage {

    public void goToBooksPage() {
        $(By.xpath("//span[(text() = 'Book Store')]")).scrollTo();
        $(By.xpath("//span[(text() = 'Book Store')]")).click();
    }

    public void checkBooksList() {
        ElementsCollection booksList = $$(By.xpath("//span[contains(@id,'see-book')]"));
        List<String> booksNamesList = new ArrayList<String>();
        for (int i = 0; i < booksList.size(); i++)
            booksNamesList.add(booksList.get(i).getText());
        for (int f = 0; f < booksNamesList.size(); f++)
            $(By.xpath("//a[contains(text(),'"+f+"')]")).shouldHave(Condition.visible);
    }

    public void addGitPocketGuideBook() {
        $(By.id("see-book-Git Pocket Guide")).click();
        $(By.xpath("//button[contains(text(),'Add')]")).scrollTo();
        $(By.xpath("//button[contains(text(),'Add')]")).shouldHave(Condition.visible);
        $(By.xpath("//button[contains(text(),'Add')]")).click();
        switchTo().alert().accept();
    }


}


