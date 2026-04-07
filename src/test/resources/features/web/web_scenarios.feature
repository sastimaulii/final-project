Feature: Saucedemo Web Automation Tests

  @web
  Scenario: Valid login
    Given user open login page
    When user login valid
    Then login success

  @web
  Scenario: Invalid login
    Given user open login page
    When user login invalid
    Then error appears

  @web
  Scenario: Add product to cart
    Given user login successfully
    When user add product to cart
    Then cart badge should show 1

  @web
  Scenario: Checkout product
    Given user login successfully
    When user add product to cart
    And user proceed checkout
    And user fill checkout data
    Then order success