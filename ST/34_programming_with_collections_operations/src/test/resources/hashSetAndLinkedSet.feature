Feature: Compare performance between HashSet, LinkedHashSet and TreeSet

  Scenario: Comparing performance adding elements
    Given I have an empty "HashSet" collection
    And I have an empty "TreeSet" collection
    And I have an empty "LinkedHashSet" collection
    When I add 10000000 random numbers to the collections
    Then I should measure and compare the performance of operations for "HashSet" and "TreeSet_vs_LinkedHashSet" collections for "Adding_elements" operation

  Scenario: Comparing performance removing elements
    Given I have the "HashSet" collection with 10000000 random numbers
    And I have the "TreeSet" collection with 10000000 random numbers
    And I have the "LinkedHashSet" collection with 10000000 random numbers
    When I remove first 1000000 elements from the collections
    Then I should measure and compare the performance of operations for "HashSet" and "TreeSet_vs_LinkedHashSet" collections for "Removing_1000000_element" operation
#
  Scenario: Comparing performance randomly removing elements from the first half of the collection
    Given I have the "HashSet" collection with 1000000 random numbers
    And I have the "TreeSet" collection with 10000000 random numbers
    And I have the "LinkedHashSet" collection with 10000000 random numbers
    When I randomly remove 5000 elements from the first half of the collections
    Then I should measure and compare the performance of operations for "HashSet" and "TreeSet_vs_LinkedHashSet" collections for "Random_Removing" operation

