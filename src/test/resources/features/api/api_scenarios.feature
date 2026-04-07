Feature: Dummy API Tests

  @api
  Scenario: Get user by ID
    Given user call get user by id "60d0fe4f5311236168a109ca"
    Then response status code should be 200
    And response body should contain "firstName"

  @api
  Scenario: Create new user
    Given user create user
    Then response status code should be 200
    And response body should contain "Test"

  @api
  Scenario: Get tags
    Given user call get tags
    Then response status code should be 200
    And response body should contain "tag"

  @api
  Scenario: Negative test - invalid user ID
    Given user call get user with invalid id "invalidID"
    Then response status code should be 404