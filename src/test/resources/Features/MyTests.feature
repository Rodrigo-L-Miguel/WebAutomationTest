Feature: Create a Flight from Lisboa to Paris


  Scenario: Create a flight changing the date and proceeding to the payment
    Given Acess Ryanair page
    And Search a flight if the filters
      | Field               | Value          |
      | Departure           | Lisbon         |
      | Destination         | Paris Beauvais |
      | Departure Date      | 15/09/2021     |
      | Return Date         | 30/01/2022     |
      | Adults  16+ years   | 2              |
      | Children 2-11 years | 1              |


