package pl.coderslab.seleniumcourse.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/qwant-search.feature",
        plugin = {"pretty", "html:out"})
public class QwantSearchTest {
}
