Feature: Mozliwosc mnozenia w kalkulatorze
  Description: Celem testu jest sprawdzenie mnozenia w kalkualtorze

  Background: Uzytkownik ma swiadomosc jak dziala mnozenie w matematyce.

  Scenario:
    Given Uzytkownik wybiera dwie liczby dodatnie
    Given Uzytkownik wybiera pierwsza liczbe dodatnia i druga liczbe ujemna
    Given Uzytkownik wybiera pierwsza liczbe ujemna a druga dodatnia
    Given Uzytkownik wybiera dwie liczby ujemne
    Given Uzytkownik wybiera pierwsza liczbe rozna od zera a druga liczba jest rowna zero
    Given Uzytkownik wybiera pierwsza liczbe rowna zero i druga liczba jest rozna od zera
    Given Uzytkwnik wybiera dwie liczby i obie to zero