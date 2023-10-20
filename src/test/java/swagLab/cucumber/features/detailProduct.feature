Feature: Melihat detail produk di aplikasi Swag Lab

  @Detail
  Scenario: Success go to detail  product
    Given User on product page
    When User click product
    Then User can redirect to detail product