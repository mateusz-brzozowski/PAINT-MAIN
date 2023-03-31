# Programowanie Aplikacji Internetowych

Studenci:
```
Aleksandra Sypuła
Bartłomiej Krawczyk
Daniel Kobiałka
Jakub Marcowski
Łukasz Jaremek
Mateusz Brzozowski
Mateusz Krakowski
```

# Temat

Wordle - gra polegająca na odgadnięciu pięcioliterowego słowa. Użytkownik ma do dyspozycji sześć prób, a po każdej próbie gra informuje go, czy użyte litery znajdują się w słowie-odpowiedzi i w jakim dokładnie miejscu, czy też znajdują się w słowie-odpowiedzi, ale w innym miejscu, albo też nie znajdują się w słowie-odpowiedzi w ogóle.

# Wymagania funkcjonalne

- słowa dostępne w wielu językach
- możliwość zakładania konta
- pozwalamy grać anonimowym użytkownikom
- udostępniamy statystyki

# Podziała na moduły

## Front End

**Umożliwia:**
- wpisywanie słów
- działająca klawiatura graficzna
- logowanie
- rejestracja
- inicjowanie sesji oraz ustawień
- przesyłanie słowa w ramach sesji
- wyświetlanie statystyk
    - ranking - czas / ile gier rozegranych / ile gier wygranych / w jakiej ilości słów wygrana

**Technologie:**
- HTML
- ECMAScript - bez wykorzystania frameworków
- CSS
- komunikacja REST-owa
- https://www.dicebear.com/introduction - generacja ikon

## Back End

### Potencjalne mikroserwisy:

#### Logowanie

**Umożliwia:**
- logowanie
- rejestracje

#### Zarządzanie sesją

**Umożliwia:**
- logowanie
- rejestracje
- w ramach sesji
    - walidacja, czy słowo istnieje, czy ma odpowiednią długość
    - odesłanie informacji zwrotnej, czy litera poprawna w poprawnym miejscu
- zapisywanie danych do bazy danych

**Technologie:**
- Spring
- Spring Security
- Spring Webflux
- Mapstruct
- komunikacja REST-owa

#### Statystyki

**Umożliwia:**
- agregacje danych użytkownika
- generację wykresu do pobrania - gry użytkownika w czasie

**Technologie:**
- python
- fast api

## Data Base

**Tabele:**
- użytkownicy
    - login
    - hasło

- słowa
    - słowo
    - język
    - ilość liter - *denormalizacja*

- sesja
    - id użytkownika
    - id sesji
    - słowo
    - tryb

- historia prób
    - id użytkownika
    - id sesji
    - podane słowo
    - czas


**Technologie:**
- PostgreSQL


# Podział odpowiedzialności w zespole

**Kierownik Projektu**
- Aleksandra Sypuła

**Programista Front-End**
- Mateusz Brzozowski
- Jakub Marcowski

**Analityk Danych**
- Łukasz Jaremek

**Ekspert ds. Bezpieczeństwa**
- Daniel Kobiałka

**Programista Back-End**
- Bartłomiej Krawczyk

**Programista Bazy Danych**
- Mateusz Krakowski
