Feature: Login pada Aplikasi Swag Lab

  @Login @Positive
  Scenario: Success Login
    Given Halaman login swag lab
    When Input Username
    And Input Password
    And Click login button
    Then User in on product page

  @Login @Negative
  Scenario: Failed Login
    Given Halaman login swag lab
    When Input Username
    And Input invalid Password
    And Click login button
    Then User get error message