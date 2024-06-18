Feature: Detect Changes in a Web Page

  Scenario: Retrieve a web page and compare it to an older version of same page
    Given a web page has been saved in object storage

    When the same web page is downloaded again

    Then the new version of the web page is saved
    And the new version of the web page is compared against older verisions
    And differences are saved in new marked image file