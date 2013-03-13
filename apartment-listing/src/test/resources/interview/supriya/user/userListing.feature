
Feature: As a user, I should be able to create 
		the apartment listing.

Scenario: As a user with account,
 I should be able to create a new listing		
Given I am an existing user looking for accomodation
When I give details for apartment listing
Then the listing is created.

Scenario: As a user without account,
I should be able to create an account along with listing.
Given I am not an existing user
And I am looking for an accomodation
When I give details for an apartment listing
Then my account is created
And the listing is also created.