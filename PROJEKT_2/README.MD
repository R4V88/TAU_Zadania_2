<h4><u>Przypadki testowe dla Chrome:</u></h4>
<p>Testy przeprowadzano na stronie <a>http://automationpractice.com/index.php</a>
ktora jest ogolnie dostepna do trenowania testow automatycznych dlatego czesto wystepuja problemy. Nawet dlugie sleepy nie pomagaja :)</p>
<h6>*** 1. Test zalogowania dla uzytkownika, ktory nie istnieje w systemie ***</h6>
Kroki: </br>
1. Otwarcie przegladarki Chrome </br>
2. Skierowanie sie pod adres: http://automationpractice.com/index.php </br>
3. Nacisnieto przycisk Logowania </br>
4. W polu Login wprowadzono nie istniejacy login, w polu haslo wprowadzono losowy ciag znakow. </br>
5. Nacisnieto przycisk Zaloguj. </br>
6. Logowanie nie jest mozliwe, pojawil sie komunikat informujacy o problemie. </br>
7. Zamknieto przegladarki. </br>

<h6>*** 2. Test czy na stronie widoczny jest formularz kontaktowy ***</h6>
Kroki: </br>
1. Otwarcie przegladarki Chrome </br>
2. Skierowanie sie pod adres: http://automationpractice.com/index.php </br>
3. Nacisnieto przycisk Formularz kontaktowy. </br>
4. Formularz kontaktowy pojawil sie na stronie </br>
5. Wykonano zrzut ekranu formularza </br>
6. Zamknieto przegladarke </br>
</br>
</br>

<h4><u>Przypadki testowe dla Firefox:</u></h4>
<p>Testy przeprowadzono na stronie <a>www.zalando.pl</a></p>
<h6>*** 1. Test czy na stronie z przecenionymi rzeczami wywietlanych jest komplet rzeczy ***</h6>
Kroki: </br>
1. Otwarcie przegladarki Firefox</br>
2. Skierowanie sie pod adres: https://zalando.com </br>
3. Kliknieto w przycisk Promocje </br>
4. Odczekano na pelne zaladowanie strony </br>
5. Sprawdzono czy widoczny jest maksymalny mozliwy komplet przecenionych rzeczy.</br>
6. Zamknieto przegladarke </br>

<h6>*** 2. Test czy wyszukiwanie nieistniejacej rzeczy wywola odpowiedni komunikat ***</h6>
Kroki: </br>
1. Otwarcie przegladarki Firefox</br>
2. Skierowanie sie pod adres: https://zalando.com </br>
3. Znaleziono pole input dla wyszukiwarki. </br>
4. W polu wprowadzono losowy ciag znakow </br>
5. Nacisnieto przycisk Enter </br>
6. Odczekano na pelne zaladowanie wynikow wyszukiwania </br>
7. Sprawdzono czy tekst wyswietlany na stronie jest poprawny </br>
8. Zamknieto przegladarke </br>
