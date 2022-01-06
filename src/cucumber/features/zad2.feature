#Z wykorzystaniem Cucumber przygotuj test,
# który będzie zakładał konto na stronie https://hotel-testlab.coderslab.pl/.
# Wykonana powinna być następująca sekwencja kroków:
#strona główna
#przycisk 'Sign in'
#przycisk Create an account
#wypełnienie formularza
#przycisk Register

Feature: Create an account

  Scenario: Create an account in https://hotel-testlab.coderslab.pl/
    Given Web page https://hotel-testlab.coderslab.pl/ opened in browser
    When button 'Sign in' pressed
    And unregistered email typed
#    And button 'Create an account' pressed
#    And personal information typed
#    And button 'Register' pressed
#    Then 'Your account has been created' on page https://hotel-testlab.coderslab.pl/en/my-account opened