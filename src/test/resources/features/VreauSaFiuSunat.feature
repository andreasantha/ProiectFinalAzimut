Feature: Button Vreau sa fiu sunat
  Background:
    Given Open Orange webpage
    Then Click on Vreau sa fiu sunat button

  #Testing Vreau sa fiu sunat with correct phone number

  Scenario: Testing Vreau sa fiu sunat button with correct phone Number
    And Introduce "0745678678"
    And Check GDPR chekbox
    And Click on "Vreau abonament nou"
    Then Display confirmation and close

  #Testing Vreau sa fiu sunat with incorrect phonenumber (out of 10 numbers but doesn't start with 0)

  Scenario: Testing Vreau sa fiu sunat Button with incorrect Phonenumber
    Then Introduce "4745678678"
    And Check GDPR chekbox
    And Click on "Vreau abonament nou"
    Then Display confirmation and close
    
   #Testing Vreau sa fiu sunat Button with incorrect Phonenumber (less than 10 numbers )
  
  Scenario: Testing Vreau sa fiu sunat button with incorrect Phonenumber
    Then Introduce "74565065"
    And Verify message is "Numărul de telefon introdus nu este corect"
    And Check GDPR chekbox


  # Testing Vreau sa fiu sunat Button with incorrect Phonenumber (combination of letters and numbers )

  Scenario: Testin Vreau sa fiu sunat Button with incorrect Phonenumber
    Then Introduce "o745650650"
    And Verify message is "Numărul de telefon introdus nu este corect"
    And Check GDPR chekbox

