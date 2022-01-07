package pl.coderslab.seleniumcourse.ZadWarsztatowe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/ZadWarsztatowe1.feature",
        plugin = {"pretty", "html:out"})
public class ZadWarsztatowe1Test {
}
