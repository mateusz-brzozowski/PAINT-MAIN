
## Jak szybko baza w kontener docker (z tego pathu)
```
docker build -t wordledb .
docker run --name wordledb -p 5432:5432 -d wordledb
```

I cieszymy się z bazki działającej w kontenerze dockerowym

Bazka:
```
Name: wordledb
IP: localhost
port: 5432
Login: postgres
Password: admin
URL: jdbc:postgresql://localhost:5432/wordledb
```

Sprawdź czy wszystko śmiga:
```
docker exec -it wordledb psql -U postgres -d wordledb
\conninfo
```

## Stawianie bazy bez dockera(nie rób tego)
Pobierz PostgreSQL 15.2
https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Pamiętaj że trzeba sterowniki dodać w stack builderze ODBC i JDBC 

Jak pobrać: \
https://commandprompt.com/education/how-to-download-and-install-postgresql/

Jak już wszystko jest, odpalamy scripts/DATABASE_CREATE.sql i cieszymy się z bazy
