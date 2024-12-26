# Użycie oficjalnego obrazu MySQL
FROM mysql:8.0

# Definiowanie zmiennych środowiskowych (mogą być nadpisane przez docker-compose)
ENV MYSQL_ROOT_PASSWORD=rootpassword
ENV MYSQL_DATABASE=student_management
ENV MYSQL_USER=customuser
ENV MYSQL_PASSWORD=custompassword

# Skopiowanie pliku SQL do obrazu
COPY init.sql /docker-entrypoint-initdb.d/

# Port MySQL
EXPOSE 3306
