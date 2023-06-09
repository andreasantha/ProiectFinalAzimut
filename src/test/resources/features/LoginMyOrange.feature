Feature: Login My Orange Account
  Background:
    Given Open Orange webpage


# Testing My account with correct user and password

  Scenario: Fill in with correct user and password
    Then Click on My account button
    And Enter "santha708@gmail.com" adress
    Then Enter "Andrea@123"
    Then Click the "Login" button
    And Close Opened Tab

#Testing My account with correct user and incorrect password

  Scenario: Fill in with correct user and incorrect password
    Then Click on My account button
    And Enter "santha708@gmail.com" adress
    Then Enter "abracadabra"
    Then Click the "Login" button
    Then Verify message "Utilizator sau parolă greşită"
    And Close Opened Tab

#Testing My account with with user and with missing password

  Scenario: Fill in only with Username
    Then Click on My account button
    And Enter "santha708@gmail.com " adress
    Then Click the "Login" button
    Then Verify the message "Câmp obligatoriu"
    And Close Opened Tab
