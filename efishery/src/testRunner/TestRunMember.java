package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Feature/member.feature",
		glue="stepDefinition",
		dryRun=true,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		)

public class TestRunMember {

}
