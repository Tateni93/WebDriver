package RunnerFiles

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("stepDefs"),
  plugin = Array("pretty", "html:target/cucumber",
    "json:target/cucumber.json",
    "junit:target/test-reports/TEST-cucumber-junit-report.xml"),
  tags = Array("@wip")
)
class RunWip
