package stepDefinition;

import implementation.PNB_AutoLoan_Implementation;
import io.cucumber.java.en.*;

public class PNB_CA_AL extends PNB_AutoLoan_Implementation {
	@Given("User search exiting work item to enter additional details in CustomerAcceptance stage")
	public void user_search_exiting_work_item_to_enter_additional_details_in_customer_acceptance_stage() throws Exception {
	    userLaunchBrowser();
	    userEnterCredentials();
	    clickloginButton();
	    searchandselectWorkItem();
	}

	@Given("User upload document in Documents tab")
	public void user_upload_document_in_documents_tab() throws Exception {
	    documentUpload_CustomerAcceptance();
	}

	@When("User enter details in Outwarddoc tab")
	public void user_enter_details_in_outwarddoc_tab() {
		outwardDoc_CustomerAcceptance();
	    
	}

	@Then("User choose decision in Action tab for CustomerAcceptance stage")
	public void user_choose_decision_in_action_tab_for_customer_acceptance_stage() throws InterruptedException {
	    action_CustomerAcceptance();
	}


}
