@All
Feature: Demo Blaze Sanity Test

  Background: User is to log on to Demo Blaze on google
    Given the user is on the Google web browser
    When the user navigates to the demo_blaze website

  @test1 @Web
  Scenario Outline: To verify the URL for Demo_blaze on Google browser
    Then views the list of "<Menu>" links on the site are valid

    Examples: 
      | Menu     |
      | Home     |
      | Contact  |
      | About us |
      | Cart     |
      | Log in   |
      | Sign up  |

  @test2 @Web
  Scenario: Validate Demo Blaze Home Page
    Then validate the Header on the Home Page

  @test3 @Web
  Scenario: Validate user can Sign up
    And user clicks on Sign up link
    When user enters username and password
    And user clicks on Sign up button
    Then user clicks Close button

  @test4 @Web
  Scenario Outline: Validate Welcome Greeting when you
    And user clicks on Log in link
    When The user enters sheetname "<Sheetname>" and <RowNumber>

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
      | Sheet1    |         2 |
      | Sheet1    |         3 |
