Feature: Shopping Cart pada aplikasi Swag Lab

  @Cart
  Scenario: Success Add Shopping Cart
    Given User di halaman product page
    When User add items to the cart
    And User navigate to the cart
    Then User should see the added items in the cart