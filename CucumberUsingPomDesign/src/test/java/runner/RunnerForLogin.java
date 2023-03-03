package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/test1.feature"},
	glue= {}	
		
			)
public class RunnerForLogin extends AbstractTestNGCucumberTests {

}
