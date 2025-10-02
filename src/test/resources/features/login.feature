Feature: Login functionality

  @smoke @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "correctpass"
    And clicks the login button
    Then the user should be redirected to the dashboard

  @negative
  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "wrongpass"
    And clicks the login button
    Then an error message "Invalid username or password" should be displayed

  @negative
  Scenario: Failed login with empty credentials
    Given the user is on the login page
    When the user enters username "" and password ""
    And clicks the login button
    Then an error message "Please enter username and password" should be displayed

  @negative
  Scenario: Failed login with empty username
    Given the user is on the login page
    When the user enters username "" and password "correctpass"
    And clicks the login button
    Then an error message "Please enter username" should be displayed

  @negative
  Scenario: Failed login with empty password
    Given the user is on the login page
    When the user enters username "testuser" and password ""
    And clicks the login button
    Then an error message "Please enter password" should be displayed

  @negative
  Scenario: Failed login with special characters
    Given the user is on the login page
    When the user enters username "test@user" and password "pass@word123"
    And clicks the login button
    Then an error message "Invalid characters in username or password" should be displayed
