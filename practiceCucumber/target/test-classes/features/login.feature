Feature: Opening maildrop Account

  #before test
  Background: 
    Given user should open the maildrop home url

  Scenario: check whether user able to view the mailbox successfully
    And user should able to enter the "johnman@maildrop.cc"
    When user clicks on view mailbox button
    Then user should able to see the mailbox for the respective mail id

  Scenario: check whether user unable to view the mailbox
    And user should able to enter the "johnman000@maildrop.cc"
    When user clicks on view mailbox button
    But user should able to see the mailbox for the respective mail id
