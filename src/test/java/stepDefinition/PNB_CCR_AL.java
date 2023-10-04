package stepDefinition;

import implementation.PNB_AutoLoan_Implementation;
import io.cucumber.java.en.*;

public class PNB_CCR_AL extends PNB_AutoLoan_Implementation {
	
	@Given("User launches the URL and login using Credentials")
	public void user_launches_the_url_and_login_using_credentials() throws Exception {
		userLaunchBrowser();
	    userEnterCredentials();
	    clickloginButton();
	    
	}

	@When("User searches the existing workitem and open in Credit Control Review")
	public void user_searches_the_existing_workitem_and_open_in_credit_control_review() throws Exception {
		searchandselectWorkItem();
	}

	@When("enters details in Outward Doc tab")
	public void enters_details_in_outward_doc_tab() {
		outwarddoc_CreditControlReview();
	}

	@Then("User chooses decision from action tab and submits the workitem")
	public void user_chooses_decision_from_action_tab_and_submits_the_workitem() throws InterruptedException {
		action_CreditControlReview();
	}

}
