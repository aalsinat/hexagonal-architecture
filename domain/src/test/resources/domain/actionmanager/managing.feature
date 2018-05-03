Feature: Action manager - Managing

  Scenario: User can add action
    When 'Toni' add 'Read Article' action of type 'INSERTED' to repository
    Then 'Toni' can get 'Read Article' action

  Scenario: User can delete action
    Given 'Toni' add 'Ask for approval' action of type 'INSERTED' to repository
    When 'Toni' delete 'Ask for approval' action
    Then 'Toni' cannot get 'Ask for approval' action
    And 'Ask for approval' action doesn't exist