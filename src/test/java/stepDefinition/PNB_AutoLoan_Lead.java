package stepDefinition;

import java.awt.AWTException;

import implementation.PNB_AutoLoan_Implementation;
import io.cucumber.java.en.*;

public class PNB_AutoLoan_Lead extends PNB_AutoLoan_Implementation{
	@Given("User Launch Omniapp application url")
	public void user_launch_omniapp_application_url() {
	    userLaunchBrowser();
	}

	@When("Enter Valid username and password")
	public void enter_valid_username_and_password() {
	    userEnterCredentials();
	}

	@Then("Click Login button")
	public void click_login_button() throws InterruptedException {
		clickloginButton();
	}

	@Given("User create new work item by clicking New button")
	public void user_create_new_work_item_by_clicking_new_button() throws Exception {

		searchAndSelectQueue();
	    selectNewButton();
		
	}

	@Given("User enter details in Deal Info tab")
	public void user_enter_details_in_deal_info_tab() throws Exception {
		sourcingInfo();
		loanDetails();
		selectLoanTerm();
		partyDetails();
		partyDetails_AddressDetails();
		PartyDetails_ContactDetails();
		PartyDetails_EmployementDetails();
		employerAddress();
	
	}

	@When("User enter details in Collateral tab")
	public void user_enter_details_in_collateral_tab() throws Exception {
	   collateralDetails();
	}

	@When("User Upload documents in Document tab")
	public void user_upload_documents_in_document_tab() throws Exception {
	    documentUpload();
	    documentUploadDealer();
	    documentUploadACR();
	    documentUploadLatestBiling();
	    
	}

	@When("User enter details in Risk tab")
	public void user_enter_details_in_risk_tab() throws Exception {
	    riskDetails1();
	    riskDetails2();
	}

	@Then("User choose decision in Action tab")
	public void user_choose_decision_in_action_tab() throws Exception {
	   actionDetails();
	}
	
	@Given("User search exiting work item to enter additional details in data encoding stage")
	public void user_search_exiting_work_item_to_enter_additional_details_in_data_encoding_stage() throws Exception {
		searchandselectWorkItem();
	}

	@Given("User add additional details in Applcation Info tab")
	public void user_add_additional_details_in_applcation_info_tab() {
		applicationInfo();
        productDetails();
        dataEncoding_PartyDetails();
        partyDetails_AddressDetails_DataEncoding();
        Id();
        partyDetails_EmployementAddress();
	}

	@When("User add additional details in Collateral and loan details tab")
	public void user_add_additional_details_in_collateral_and_loan_details_tab() throws Exception {
		collateraldetails();
	}

	@When("User check bureau details in bureau check tab")
	public void user_check_bureau_details_in_bureau_check_tab() throws Exception {
		bureauCheck();
	}

	@Then("User chooses decision in Action tab")
	public void user_chooses_decision_in_action_tab() throws Exception {
		action();
	}
	
	@Given("User search exiting work item to enter additional details in PreEvaluation stage")
	public void user_search_exiting_work_item_to_enter_additional_details_in_pre_evaluation_stage() throws Exception {
		searchandselectWorkItem();
	}

	@Given("User choose decision in Action tab for PreEvaluation stage")
	public void user_choose_decision_in_action_tab_for_pre_evaluation_stage() throws Exception {
		actionTab_PreEvaluation();
	}

	@Given("User search exiting work item to enter additional details in Credit Investigation stage")
	public void user_search_exiting_work_item_to_enter_additional_details_in_credit_investigation_stage() throws Exception {
		searchandselectWorkItem();
	}

	@Given("User enters Details in Application Info tab")
	public void user_enters_details_in_application_info_tab() {
	    
	}

	@Given("User enters Details in Teli and Email CI tab")
	public void user_enters_details_in_teli_and_email_ci_tab() {
		TeleInfo();
	}

	@Given("User enters Details in Field CI tab")
	public void user_enters_details_in_field_ci_tab() {
		fieldCI();
	}

	@Given("User enters Details in Document tab")
	public void user_enters_details_in_document_tab() throws Exception {
		documentUploadCreditCheck();
		documentPNBloandDelings();
		documentResidenceVerif();
		documentEmporBusiverify();
		documentPvcid();
		PvcidGis();
		tradeRefer();
	}

	@When("User enters Details in Risk tab")
	public void user_enters_details_in_risk_tab() {
		riskTab();
	}

	@Then("User select the Decision in Action Tab")
	public void user_select_the_decision_in_action_tab() {
		actionTab();
	}

	@Given("User search exiting work item to enter additional details in CreditEvaluation stage")
	public void user_search_exiting_work_item_to_enter_additional_details_in_credit_evaluation_stage() throws Exception {
		searchandselectWorkItem();
	}

	@Given("User enter details in CAM tab")
	public void user_enter_details_in_cam_tab() throws Exception {
		CAM();
	}

	@When("User enter details in IncomeDerivation tab")
	public void user_enter_details_in_income_derivation_tab() {
		incomeDerivation();
	}

	@When("User choose decision in Action tab for CreditEvaluation stage")
	public void user_choose_decision_in_action_tab_for_credit_evaluation_stage() throws Exception {
		action_CreditEvaluation();
	}

}
