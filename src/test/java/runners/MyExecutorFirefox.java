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
                        "html:target/site/cucumber-pretty3",
                        "json:target/cucumber.json",
        },
        tags     = {"@trivial_firefox"},
        monochrome = true
)
public class MyExecutorFirefox {

}
