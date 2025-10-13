Feature: Login Scenario


Scenario Outline: User can't login with invalid credentials
    When User logged in with "<username>" and "<password>"
    Then User should see an error message

    Examples:
      | username                          | password   |
      | simanjuntakalbert57@gmail.com     | invalid1   |
      | invalid_user2                     | XBf@rWNvByn!#K8  |
      | invalid_user3                     | invalid3   |