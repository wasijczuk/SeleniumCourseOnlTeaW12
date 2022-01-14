#będzie logować się na tego stworzonego użytkownika,
#wejdzie klikając w kafelek Addresses po zalogowaniu (adres,
# na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
#kliknie w + Create new address,
#wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie
# (alias, address, city, zip/postal code, country, phone),
#sprawdzi czy dane w dodanym adresie są poprawne.

#  Dodatkowe kroki dla chętnych:
#usunie powyższy adres klikając w "delete",
#sprawdzi czy adres został usunięty.

Feature: Log in and create new address

  Scenario Outline: Log in and create a new address in https://mystore-testlab.coderslab.pl/index.php
    Given Web page https://mystore-testlab.coderslab.pl/index.php opened in browser
    When button 'Sign in' pressed
    And logged in to account
    And link 'addresses' pressed
    And link 'Create new address' pressed
    Then Form filled with data: <alias>, <address>, <city>, <postCode>, <country>, <phone>
    And button 'save' clicked
  And confirmed new address
    And deleted new address
    And confirmed address deleted

    Examples:
      | alias | address      | city         | postCode | country       | phone         |
      | annad | 62 Walwyn Rd | CHARINGWORTH | GL55 0WT | UnitedKingdom | 077 0455 4726 |