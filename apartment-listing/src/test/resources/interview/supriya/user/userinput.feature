Feature: As a user, I am able to enter details for the apartment listings on the webpage

Scenario: As a user, I enter the details on the webpage
Given I am on the apartment listing home page
When I enter all the required details
And click 'Create Listing'
Then I see the message 'Listing created successfully'

Scenario: As a user, I enter the details on the webpage, but forget to put email.
Given I am on the apartment listing home page
When I enter all the details except email 
And click 'Create Listing'
Then I see an error message for email Please enter a valid email

Scenario: As a user, I enter email but forget to select suburb
Given I am on the apartment listing home page
When I enter all the details except selecting a suburb 
And click 'Create Listing'
Then I see an error message for suburb Please select a suburb

Scenario: As a user, I forget to enter price
Given I am on the apartment listing home page
When I enter all the details except the price 
And click 'Create Listing'
Then I see an error message for price Please enter a valid price
