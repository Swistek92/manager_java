## Użyte biblioteki w projekcie

### 1. [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)

- **Wersja:** `8.0.33`
- **Opis:** Oficjalny sterownik JDBC dla MySQL. Umożliwia połączenie aplikacji Java z bazą danych, obsługując standardowe operacje SQL.

### 2. [java-dotenv](https://mvnrepository.com/artifact/io.github.cdimascio/java-dotenv)

- **Wersja:** `5.2.2`
- **Opis:** Biblioteka umożliwiająca zarządzanie zmiennymi środowiskowymi z plików `.env`. Ułatwia odczytanie i bezpieczne przechowywanie konfiguracji aplikacji (np. dane połączenia z bazą).

### 3. [HikariCP](https://mvnrepository.com/artifact/com.zaxxer/HikariCP)

- **Wersja:** `5.0.1`
- **Opis:** Wysokowydajna i lekka pula połączeń do bazy danych. Umożliwia lepsze zarządzanie połączeniami w aplikacjach, co poprawia wydajność oraz stabilność przy intensywnym użytkowaniu.

### 4. [JUnit Jupiter](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter)

- **Wersja:** `5.9.3`
- **Opis:** Nowoczesna wersja JUnit (platforma do testów jednostkowych). Umożliwia pisanie i uruchamianie testów z użyciem adnotacji takich jak `@Test`, `@BeforeEach`, czy `@AfterEach`.

### 5. [Mockito Core](https://mvnrepository.com/artifact/org.mockito/mockito-core)

- **Wersja:** `4.11.0`
- **Opis:** Biblioteka do mockowania, która pozwala tworzyć symulacje obiektów podczas testów jednostkowych. Ułatwia testowanie izolowanych komponentów poprzez eliminację rzeczywistych zależności.

### 6. [Mockito Inline](https://mvnrepository.com/artifact/org.mockito/mockito-inline)

- **Wersja:** `4.11.0`
- **Opis:** Rozszerzenie Mockito umożliwiające mockowanie statycznych metod i finalnych klas/metod. Wymagane w przypadku bardziej złożonych scenariuszy testowych.

## Jak działają te biblioteki w projekcie?

- **Sterownik MySQL**: używany w klasie `DatabaseConnection` do nawiązywania połączenia z bazą danych.
- **Java Dotenv**: umożliwia łatwe wczytywanie konfiguracji (np. URL bazy, użytkownik, hasło) z pliku `.env`, co zwiększa bezpieczeństwo i elastyczność.
- **HikariCP**: zarządza pulą połączeń do bazy danych, co zwiększa wydajność i stabilność w obsłudze wielu zapytań.
- **JUnit Jupiter**: platforma do pisania i uruchamiania testów jednostkowych, zapewniając wysoką jakość kodu.
- **Mockito Core i Inline**: umożliwiają mockowanie zależności, np. `StudentManagerImpl`, w testach jednostkowych, pozwalając na izolację logiki testowanej klasy.
