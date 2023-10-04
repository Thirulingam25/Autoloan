package runnerClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\java\\Feature\\PNB_CCR.feature" }, glue = {
		"stepDefinition" }, tags = "@tag1", dryRun = false, plugin = { "pretty",
				"json:C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\Report\\AutoLoan_Lead.json",
				"html:C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\Report\\AutoLoan_Lead.html" }, monochrome = true)
public class TestRunner_PNB_AutoLoan_Lead {

	public static void main(String[] args) {
		
		
	}

}
