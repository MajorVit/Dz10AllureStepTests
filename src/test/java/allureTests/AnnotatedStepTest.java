package allureTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    String rep = "autotests-cloud/qa_guru_first_course";
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(rep);
        steps.clickOnRepositoryLink(rep);
        steps.seachIssuesTab();
        steps.takeScreenshot();
    }
}