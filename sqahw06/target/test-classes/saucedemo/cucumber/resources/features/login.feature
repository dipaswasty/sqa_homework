Feature: Login Halaman

  Scenario: Success Login
    Given Halaman Login saucedemo
    When input username
    And input password
    And click login button
    Then success login

  Scenario: Failed Login
    Given Halaman Login saucedemo
    When input username
    And input invalid password
    And click login button
    Then failed login