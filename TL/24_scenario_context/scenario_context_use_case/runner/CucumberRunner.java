package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/", //path to feature file, may be in a different location
        glue = {"step_definition", "hooks"})
public class CucumberRunner {
}
