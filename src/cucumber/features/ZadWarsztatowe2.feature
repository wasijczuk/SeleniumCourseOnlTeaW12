#Napisz skrypt, który:
#zaloguje się na tego samego użytkownika z zadania 1,
#wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
#wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
#wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
#dodaj produkt do koszyka,
#przejdzie do opcji - checkout,
#potwierdzi address (możesz go dodać wcześniej ręcznie),
#wybierze metodę odbioru - PrestaShop "pick up in store",
#wybierze opcję płatności - Pay by Check,
#kliknie na "order with an obligation to pay",
#zrobi screenshot z potwierdzeniem zamówienia i kwotą.

#Dodatkowe kroki dla chętnych:
#Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
#sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment"
#i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

Feature: Buy new Sweaters

  Scenario Outline:Buy Sweaters and pay
    Given Web page https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account opened in browser
    And log in to account
    When search the Hummingbird Printed Sweater and select product
    And select size: <size>
    And selected quantity: <quantity>
    And add to Cart
    And button 'proceed to checkout'
    And confirmed address pressed
    And selected 'shipping method'
    And selected 'payment'
    Then button 'order with an obligation to pay' pressed
    And taken screenshot with order confirmation and payment amount

    Examples:
      | size | quantity |
      | M    | 5        |