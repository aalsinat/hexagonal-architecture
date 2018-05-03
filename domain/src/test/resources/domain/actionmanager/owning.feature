Feature: Action manager - Owning

  Scenario: User cannot retrieve an action that doesn't belong to him
    Given 'Toni' add 'Read Article' action of type 'INSERTED' to repository
    Then 'Jaume' cannot get 'Read Article' action

  Scenario: User cannot delete an action that doesn't belong to him
    Given 'Jaume' add 'Approve' action of type 'INSERTED' to repository
    When 'Toni' delete 'Approve' action
    Then 'Approve' action exist
    And 'Jaume' can get 'Approve' action
