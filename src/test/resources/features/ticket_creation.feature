Feature: Ticket creation
  As an admin user
  I want to create tickets from the tickets module
  So that new requests can be tracked in the system

  @e2e @tickets
  Scenario: Admin creates a new ticket with required fields
    Given the admin opens the application
    When the admin logs in with valid credentials
    And the admin opens the ticket creation form
    And the admin completes the required ticket fields
    And the admin saves the ticket
    Then the ticket should be visible in the tickets listing
