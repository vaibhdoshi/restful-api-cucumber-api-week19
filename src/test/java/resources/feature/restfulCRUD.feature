Feature: Testing CRUD request on the restful booker app

  Scenario Outline: Crud Test
    Given restful booker application is running
    When When I create a new booking by providing the information firstName "<firstName>" lastName "<lastName>" totalPrice "<totalPrice>" depositPaid "<depositPaid>"checkIn"<checkIn>"checkOut"<checkOut>"additionalNeeds"<additionalNeeds>"
    Then I verify that the booking is created
    And I update the booking with information firstName "<firstName>" lastName "<lastName>" totalPrice "<totalPrice>" depositPaid "<depositPaid>"checkIn"<checkIn>"checkOut"<checkOut>"additionalNeeds"<additionalNeeds>"
    And The user is updated successfully
    And I delete the booking with userId
    Then The user deleted successfully from the application
    Examples:
      | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds |
      | Dhyan     | Kumar    | 100        | true        | 2022-01-07 | 2022-01-20 | Breakfast       |






