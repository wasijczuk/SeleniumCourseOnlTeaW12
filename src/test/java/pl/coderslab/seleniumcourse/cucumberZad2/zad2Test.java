package pl.coderslab.seleniumcourse.cucumberZad2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/zad2.feature",
        plugin = {"pretty", "html:out"})
public class zad2Test {
}
