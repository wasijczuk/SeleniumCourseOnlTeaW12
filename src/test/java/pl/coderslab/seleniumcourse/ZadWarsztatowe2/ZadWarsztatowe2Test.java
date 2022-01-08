package pl.coderslab.seleniumcourse.ZadWarsztatowe2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/ZadWarsztatowe2.feature",
        plugin = {"pretty", "html:out"})

public class ZadWarsztatowe2Test {
}