Feature: Test Inventory page of 'Right way auto sales' site

  Background:
    Given User navigates to 'https://www.rightwayautosale.com/inventory' page

  Scenario: refine your search label on Inventory Page
    Then Verify refine your search label is Displayed


  Scenario: Verify that filter by years functional
    Then User chooses year on left panel
    When Make sure the car is the same model year as the selected year


  Scenario Outline: Verify that filter by all years functional
    When User open menu year
    And User chooses on <year> on left panel
    When Make sure one car on the page is the same model <year> as the selected year
    Examples:
      | year   |
      | "2008" |
      | "2009" |
      | "2010" |
      | "2011" |
      | "2012" |
      | "2013" |


  Scenario Outline: Verify that filter by body type functional
    When Title of body type is displayed
    And User chooses <type> of car
    Then make sure that type of displayed care is <type>
    Examples:
      | type            |
      | "Sedan"         |
      | "SUV-Crossover" |
      | "Minivan-Van"   |
      | "Hatchback"     |

  Scenario Outline: Verify that filter Make functional
    Then  User open full menu make
    And User chooses on <make> on left menu bar
    When Make sure one car on the searched page is the same <make> make as the selected
    Examples:
      | make        |
      | "Honda"     |
      | "Ford"      |
      | "Dodge"     |
      | "Kia"       |
      | "Jeep"      |
      | "Chevrolet" |
      | "Chrysler"  |
      | "Toyota"    |


  Scenario Outline: Verify that filter by Engine functional
    Then User selects <engine> on left menu bar
    When Make sure one found car has the same <engine> as the selected
    Examples:
      | engine              |
      | "4 Cylinder Engine" |
      | "6 Cylinder Engine" |



