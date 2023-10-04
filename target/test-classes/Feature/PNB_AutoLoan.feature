Feature: Verify User able to apply AutoLoan in PNB

  Background: Verify User able to Login omniapp
    Given User Launch Omniapp application url
    When Enter Valid username and password
    Then Click Login button
    
  #@tag1
  #Scenario: User Create Lead Workstep
    #Given User create new work item by clicking New button
    #And User enter details in Deal Info tab
    #When User enter details in Collateral tab
    #And User Upload documents in Document tab
    #And User enter details in Risk tab
    #Then User choose decision in Action tab
    #
  #@tag2
  #Scenario: User enter additional details in DataEncoding for exiting workitem
    #Given User search exiting work item to enter additional details in data encoding stage
    #And User add additional details in Applcation Info tab
    #When User add additional details in Collateral and loan details tab
    #And User check bureau details in bureau check tab
    #Then User chooses decision in Action tab
    
  @tag3
  Scenario: User select the workitem in PreEvaluation stage and move to CreditInvestigation for exiting workitem
    Given User search exiting work item to enter additional details in PreEvaluation stage
    And User choose decision in Action tab for PreEvaluation stage
    
  @tag4
  Scenario: User select the workitem in CreditInvestigation stage and move to CreditEvaluation for exiting workitem
    Given User search exiting work item to enter additional details in Credit Investigation stage
    And User enters Details in Application Info tab
    And User enters Details in Teli and Email CI tab
    And User enters Details in Field CI tab
    And User enters Details in Document tab
    When User enters Details in Risk tab
    Then User select the Decision in Action Tab
    
  @tag5
  Scenario: User select the workitem in Credit Evaluation stage and move to Approval stage for exiting workitem
    Given User search exiting work item to enter additional details in CreditEvaluation stage
    And User enter details in CAM tab
    When User enter details in IncomeDerivation tab
    And User choose decision in Action tab for CreditEvaluation stage
    