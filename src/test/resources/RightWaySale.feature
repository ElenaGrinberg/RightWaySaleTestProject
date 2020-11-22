Feature: Test main page 'right way auto sales' site

  Background:
    Given User navigates to 'https://www.rightwayautosale.com/' page

  Scenario: Navigate to the main page and verify vehicles we offer, more info button, featured vehicles, google reviews, google map, logo
    When Verify that permanent elements are displayed


  Scenario: Verify that carousels is visible on MainPage
    Then Verify vehicles carousel is Displayed
    And Verify google review contents carousel iIs displayed


  Scenario: Check Home link on navigate bar
    Then Verify the Home link is visible


  Scenario: Check About US link on navigate bar
    Then Click to About US menu
    And Verify About US Page is loaded


  Scenario: Check Inventory link on navigate bar
    Then Click to Inventory Link on top menu Main Page
    And Verify Inventory Page is loaded







