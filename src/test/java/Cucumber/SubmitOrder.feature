
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

 
  Background:
  Given I landed on Ecommerce page
  
  
  @tag2
  Scenario Outline: Positive test for submitting the order
    Given Login with username<name> and password<password>
    When I add product <productName> in cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER" message is displayed

    Examples: 
      | name                        |     password |    productName|
      | dewashishsahu8888@gmail.com |     Dewa@0000|    ZARA COAT 3|
      