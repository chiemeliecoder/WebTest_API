Feature: Walmart Website Testing

  @demo
  Scenario: Open Walmart Homepage
    Given I am on the Walmart homepage
    Then the Walmart homepage should be open

  @demo
  Scenario: Check Departments
    Given I am on the Walmart homepage
    When I click on the "Departments" link
    Then I should see a list of all departments
    And each department should have subcategories

  @demo
  Scenario: Check Store Directory
    Given I am on the Walmart homepage
    When I click on the "Store Directory" link
    Then I should see a list of all store locations
    And each store should have address, phone number, and working hours
