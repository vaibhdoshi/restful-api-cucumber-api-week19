Feature: Testing end point on the restful booker app

  Scenario: verify if booking is created
    When I send a POST request using a valid payload to booking application
    Then I get a valid response code 200

  Scenario: Check if the user can do booking
    When  I send GET request to booking application
    Then I get a valid response code 200

  Scenario: verify if user is updated
    When I send PUT request to booking application
    Then I get a valid response code 200

  Scenario: verify if user is Deleted
    When I send DELETE request to booking application
    Then I get a valid response code for delete 201







