Feature: Create a Flight from Lisboa to Paris


  Scenario: Create a flight changing the date and proceeding to the payment
    Given Acess Ryanair page
    And Search a flight if the filters
      | Field          | Value          |
      | Departure      | Lisbon         |
      | Destination    | Paris Beauvais |
      | Departure Date | 15 Sep 2021    |
      | Return Date    | 15 Dec 2021    |
      | Adults         | 2              |
      | Children       | 1              |
    When I change the dates to
      | Field          | Value       |
      | Departure Date | 03 Oct 2021 |
      | Return Date    | 30 Dec 2021 |
    And Select the payment method
    And I inform the passagers names
      | Passenger 1 | Mrs Sónia Pereira   |
      | Passenger 2 | Mr Diogo Bettencout |
      | Passenger 3 | Inês Marçal         |





