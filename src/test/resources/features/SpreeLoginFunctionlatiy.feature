Feature: Spree login functionality

# This is a comment
Scenario: 1.Valid user with valid password
  Given Not a validated user
  When User browse to the site
  Then Spree home page should display
  When User click login link
  Then Browser display Login page
  When User enter user email as "yusufahmedny@gmail.com"
  And User enter password as "99223399"
  And User click login button
  Then Home page should display
  And Login success message display