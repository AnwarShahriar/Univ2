Feature: Login

  Scenario: Clerk login success
    Given the university is initialized
    And the user inputs clerk
    When the clerk logs in with admin
    Then the clerk is logged in
  
  Scenario Outline: Clerk login fail
    Given the university is initialized
    And the user inputs clerk
    When the clerk logs in with <password>
    Then the clerk is not logged in
    
    Examples:
    | password |
    | 123456   |
    | asdfgh   |
    
  Scenario Outline: Student login success
   	Given the university is initialized
    And the user inputs student
    When the student logs in with <email> <password>
    Then the student is logged in
    
    Examples:
    |email|password|
    |jim@gotham|12345|
    |lee@gotham|12345|
