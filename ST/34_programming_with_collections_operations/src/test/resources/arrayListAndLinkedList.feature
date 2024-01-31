Feature: Operations with Collections ArrayList and LinkedList

  Scenario Outline: Comparing performance between ArrayList and LinkedList
    Given I have an empty "<val1>" collection
    And I have an empty "<val2>" collection
    When I add 10000000 random numbers to the collections
    Then I should measure and compare the performance of operations for "<val1>" and "<val2>" collections for "<val3>" operation
    Examples:
      | val1      | val2       | val3            |
      | ArrayList | LinkedList | Adding_elements |

  Scenario Outline: Comparing performance sorting between ArrayList and LinkedList
    Given I have the "<val1>" collection with 10000000 random numbers
    And I have the "<val2>" collection with 10000000 random numbers
    When I sort the collections
    Then I should measure and compare the performance of operations for "<val1>" and "<val2>" collections for "<val3>" operation
    Examples:
      | val1      | val2       | val3             |
      | ArrayList | LinkedList | Sorting_elements |

  Scenario Outline: Comparing performance removing elements between ArrayList and LinkedList
    Given I have the "<val1>" collection with 10000000 random numbers
    And I have the "<val2>" collection with 10000000 random numbers
    When I remove first 10 elements from the collections
    Then I should measure and compare the performance of operations for "<val1>" and "<val2>" collections for "<val3>" operation
    Examples:
      | val1      | val2       | val3                               |
      | ArrayList | LinkedList | Removing_first_elements_from_start |

  Scenario Outline: Comparing performance removing elements between ArrayList and LinkedList
    Given I have the "<val1>" collection with 10000000 random numbers
    And I have the "<val2>" collection with 10000000 random numbers
    When I randomly remove 1000 elements from the first half of the collections
    Then I should measure and compare the performance of operations for "<val1>" and "<val2>" collections for "<val3>" operation
    Examples:
      | val1      | val2       | val3                     |
      | ArrayList | LinkedList | Removing_random_elements |

  Scenario Outline: Comparing performance searching elements between ArrayList and LinkedList
    Given I have the "<val1>" collection with 10000000 random numbers
    And I have the "<val2>" collection with 10000000 random numbers
    When I search for 1000000 random elements in the collections
    Then I should measure and compare the performance of operations for "<val1>" and "<val2>" collections for "<val3>" operation
    Examples:
      | val1      | val2       | val3                      |
      | ArrayList | LinkedList | Searching_random_elements |