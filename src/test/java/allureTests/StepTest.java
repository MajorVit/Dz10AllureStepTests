package allureTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {
    public static final String REP = "autotests-cloud/qa_guru_first_course";

    @Test
    public void checkIssueTestWithSteps() {


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("������� ������� ��������", () -> {

            open("https://github.com");
        });
        step("����� � ������" + REP, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REP);
            $(".header-search-input").submit();
        });
        step("�������� �� ������ -" + REP, () -> {
            $(linkText(REP)).click();
        });
        step("����� ������ Issues", () -> {
            $(withText("Issue")).should(Condition.exist);
        });


    }

}