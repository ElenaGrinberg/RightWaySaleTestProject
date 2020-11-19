  Feature: Testing of Sort functional
    Background:
      Given User navigates to 'https://www.rightwayautosale.com/inventory' page

  Scenario: Check that sorting by year function works
    When Click option select by year
    Then Verify that list of car in fact is sorted


    Scenario: Check that sorting by Make function works
      When Click option select by Make
      Then Verify that list of car in fact is sorted by Make

    Scenario: Check that sorting by Price function works
      When Click option select by Price
      Then Verify that list of car in fact is sorted by Price

    Scenario: Check that sorting by Mileage function works
      When Click option select by Mileage
      Then Verify that list of car in fact is sorted by Mileage


