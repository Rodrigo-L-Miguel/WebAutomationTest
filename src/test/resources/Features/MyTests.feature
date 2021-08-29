Feature: Create a Flight from Lisboa to Paris


  Scenario: Create a flight changing the date and proceeding to the payment
    Given Acess Ryanair page
    And Search a flight if the filters
      | Field          | Value          |
      | Departure      | Lisbon         |
      | Destination    | Paris Beauvais |
      | Departure Date | 15 Sep 2021    |
      | Return Date    | 28 Jan 2022    |
      | Adults         | 2              |
      | Children       | 1              |
    When I change the dates to
      | Field          | Value          |
      | Departure Date | 03 Jan 2022    |
      | Return Date    | 01 Feb 2022    |



