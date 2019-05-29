package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        glue     = {"stepDefinitions"},
        format   = {
                        "pretty",
                        "html:target/site/cucumber-pretty2",
                        "json:target/cucumber.json",
        },
        tags     = {"@trivial_empty"},
        monochrome = true
)
public class MyExecutorFirefox {

}