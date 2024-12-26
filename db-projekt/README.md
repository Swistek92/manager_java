# Student Management Database

Ten projekt umożliwia skonfigurowanie bazy danych MySQL dla systemu zarządzania studentami.

## Wymagania wstępne

- Zainstalowany Docker na Twoim komputerze.

## Usługi

### Usługa bazy danych

- **Obraz**: `mysql:8.0`
- **Nazwa kontenera**: `mysql-container`
- **Zmienne środowiskowe**:
  - `MYSQL_ROOT_PASSWORD`: rootpassword
  - `MYSQL_DATABASE`: student_management
  - `MYSQL_USER`: customuser
  - `MYSQL_PASSWORD`: custompassword
- **Wolumeny**:
  - `./init.sql:/docker-entrypoint-initdb.d/init.sql`
- **Porty**:
  - `3306:3306`

## Uruchomienie projektu

1. Upewnij się, że Docker jest zainstalowany i uruchomiony na Twoim komputerze.
2. Utwórz plik o nazwie `init.sql` w tym samym katalogu co niniejszy plik README, zawierający inicjalne instrukcje SQL.
3. Utwórz plik `.env` w katalogu projektu i wprowadź w nim następujące zmienne środowiskowe:

   ```env
   MYSQL_ROOT_PASSWORD=rootpassword
   MYSQL_DATABASE=student_management
   MYSQL_USER=customuser
   MYSQL_PASSWORD=custompassword
   ```

4. Otwórz terminal i przejdź do katalogu projektu.
5. Uruchom poniższe polecenie, aby wystartować kontener MySQL:

   ```sh
   docker-compose up
   ```

Baza danych MySQL będzie dostępna na porcie 3306.

## Zatrzymywanie projektu

Aby zatrzymać działające kontenery, użyj polecenia:

```sh
docker-compose down
```

## Uwagi

Upewnij się, że plik `init.sql` zawiera poprawne instrukcje SQL do inicjalizacji bazy danych. W razie potrzeby zmodyfikuj zmienne środowiskowe, aby dopasować je do swoich ustawień.
