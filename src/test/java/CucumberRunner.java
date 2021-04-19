import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepdef"},
        tags = "@allProject",
        plugin = {"pretty", "html:test-output",
                "json:target/cucumber-report/cucumber.json",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class CucumberRunner {
}


