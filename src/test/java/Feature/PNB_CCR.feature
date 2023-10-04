Feature: PNB Autoloan Credit Control Review
   @tag1
  Scenario: User review and move the workitem from Initial Credit Review to Credit Control Review
    Given User launches the URL and login using Credentials
    When User searches the existing workitem and open in Credit Control Review 
    And enters details in Outward Doc tab
    Then User chooses decision from action tab and submits the workitem