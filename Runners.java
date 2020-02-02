package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/realizar_compra.feature",
        glue = "Steps",
        tags = {},
        plugin = {"pretty", "html: target/report-html", "json: target/report.jason"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false, //Somente valida se os cenarios estao ok, nao executa
        strict = false  //Se possuir um passo sem definição ele aponta erro e nao o coloca como undefined

)

public class Runners {

    @BeforeClass

    public static void reset() {
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");

    }
}

