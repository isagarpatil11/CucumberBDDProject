Feature: Customers

Background: Steps common for all scenarios
Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    
    @regression
    
    Scenario: Add new Customer 
    When User Click on customers Menu 
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can View confirmation message "The new customer has been added successfully."
    And close browser
    
    @regression
    
    Scenario: Search Customer by Email
    When User Click on customers Menu
    And click on customers Menu Item
    And Enter Customer Email
    When Click on Search button
    Then User Should found email in the search table
    And close browser 
   
    @Sanity
     
    Scenario: Search Customer by Name
    When User Click on customers Menu
    And click on customers Menu Item
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click on Search button
    Then User Should found Name in the Search table
    And close browser