Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "correctpass"
    And clicks the login button
    Then the user should be redirected to the dashboard

  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "wrongpass"
    And clicks the login button
    Then an error message "Invalid username or password" should be displayed
