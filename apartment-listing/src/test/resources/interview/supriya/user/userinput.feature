Feature: As a user, I am able to enter details for the apartment listings on the webpage

Scenario: As a user, I enter the details on the webpage
Given I am on the apartment listing home page
When I enter details |Email|IsAccomodationRequired|Suburb|Price|Date|
					|supriya.joshi@socgen.com|yes|Whitefield|100|2-04-2013|
Then I see the message 'Listing created successfully'