@regression
Feature: Top menu headers
  As a user I want to verify the homepage tabs redirection

  @author_Hiren_Italia @smoke @sanity
  Scenario Outline: Verify all the tabs on the homepage
    Given I am on homepage
    When  I click on accept cookies
    Then I should see Virgin Games logo on homepage
    And  I click on "<tabs>"
    Then I verify the redirected pages "<url>"
    Examples:
      | tabs         | url                                          |
      | Online Slots | https://www.virgingames.com/uk/slots         |
      | Live Casino  | https://www.virgingames.com/uk/live-casino   |
      | Casino       | https://www.virgingames.com/uk/online-casino |
      | Slingo       | https://www.virgingames.com/uk/slingo        |
      | Online Bingo | https://www.virgingames.com/uk/online-bingo  |
      | Free Games   | https://www.virgingames.com/uk/free-games    |
      | Poker        | https://www.virgingames.com/uk/online-poker  |
      | All Games    | https://www.virgingames.com/uk/all-games     |
      | Blog         | https://www.virgingames.com/uk/blog          |

  @author_Hiren_Italia @sanity
    Scenario: Verify the registration page
      Given I am on homepage
      When  I click on accept cookies
      When I click on Join Now
      Then I should redirect to register page
      And I should see the text "Your Details"
