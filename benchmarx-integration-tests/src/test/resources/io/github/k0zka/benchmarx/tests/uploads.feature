Feature: all kind of test input uploads

  Scenario Template: upload <report>
    Given a running benchmarx app
    And a new project
    And a test token in the project
    When we upload the <report> test results
    Then we will see the <report> report in the app

    Examples:
    | report |
    | junit |
    | cucumber |
    | jmh |
