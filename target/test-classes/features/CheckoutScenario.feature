Feature: Checkout Scenario

# Background:
#     Given User is on the login page

Scenario: User can checkout product successfully
    When User logged in with valid credentials
    Then User is navigated to the products page
    When User adds a product to the cart "ADIDAS ORIGINAL"
    And User clicks on the cart icon
    Then User verify the product is added to the cart "ADIDAS ORIGINAL"
    When User click on the checkout button
    Then User is navigated to checkout page
    When User fills in the shipping details
    And User click on the Place Order button
    Then User verify the order is placed successfully

Scenario Outline: User can't login with invalid credentials
    When User logged in with "<username>" and "<password>"
    Then User should see an error message

    Examples:
      | username                          | password   |
      | simanjuntakalbert57@gmail.com     | invalid1   |
      | invalid_user2                     | XBf@rWNvByn!#K8  |
      | invalid_user3                     | invalid3   |

Scenario Outline: User can checkout product with some variant successfully
    When User logged in with "simanjuntakalbert57@gmail.com" and "XBf@rWNvByn!#K8"
    Then User is navigated to the products page
    When User adds a product to the cart "<productName>"
    And User clicks on the cart icon
    Then User verify the product is added to the cart "<productName>"
    When User click on the checkout button
    Then User is navigated to checkout page
    When User fills in the shipping details
    And User click on the Place Order button
    Then User verify the order is placed successfully
    
    Examples:
      | productName        |
      | ZARA COAT 3        |