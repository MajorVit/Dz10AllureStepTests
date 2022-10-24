package allureTests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти в поиске")
    public void searchRepository(String rep) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(rep);
        $(".header-search-input").submit();
    }

    @Step("Кликнуть по ссылке")
    public void clickOnRepositoryLink(String rep) {
        $(linkText(rep)).click();
    }

    @Step("Найти раздел Issues")
    public void seachIssuesTab() {
        $("#issues-tab").shouldHave();
    }


    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}