#This feature file contains few test scenarios to verify Rest API services
#Author: Jagan Duraisamy
Feature: To verify API automation with Rest Assured
@API_Test
Scenario: To verify Rest service - GET Method
Given To initiate Rest service to get country details with code as "IN"
Then Respose status code should be "200"
And response should includes the following
| name  | alpha2_code | alpha3_code |
| India | IN 		  | IND         |