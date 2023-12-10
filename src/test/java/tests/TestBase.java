package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeFillForm(){
        Configuration.browser = System.getProperty("browser", "");
        Configuration.browserSize =System.getProperty("browserSize","");
        Configuration.browserVersion = System.getProperty(" browserVersion", ".0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= System.getProperty("baseUrl", "");
        Configuration.holdBrowserOpen = false;
        Configuration.remote = System.getProperty("selenoid", "");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;


    }
    @AfterEach
    void addAttachment(){
        Attach.screenshotAs("Screenshot after test");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
