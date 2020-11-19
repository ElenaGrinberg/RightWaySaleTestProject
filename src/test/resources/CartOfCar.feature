Feature: Test an info cart of a car
  Background:
    Given User navigates to page of auto

  Scenario Outline: Verify that all info of the car are displayed

    Then On the page all <elements> are displayed
    Examples:
      | elements         |
      | "Odometer"       |
      | "Body Type"      |
      | "Drive Train"    |
      | "Exterior Color" |
      | "Engine Data"    |
      | "Interior Color" |
      | "Transmission"   |
      | "Fuel Economy"   |

    Scenario: Verify that verbal description is on
     Then On the page verbal description is displayed


