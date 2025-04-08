Feature: Accessing Swag Labs Application

  Scenario Outline: Adding products to cart in swag application
    And enter "<username>" and "<password>"
    And click on login
    And select the "<product>" and click on add to cart button
    Then check whether cart is updated in swag application

    @stage @quit
    Examples: 
      | username                | password     | product    |
      | standard_user           | secret_sauce | backpack   |
      | performance_glitch_user | secret_sauce | bike-light |
      | problem_user            | secret_sauce | onesie     |

    @prod @quit @screenshot
    Examples: 
      | username                | password     | product    |
      | performance_glitch_user | secret_sauce | bike-light |
