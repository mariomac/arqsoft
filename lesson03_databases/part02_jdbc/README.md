# Java DataBase Connectivity (JDBC)

Despite everybody uses indirectly databases, almost nobody use them directly by submitting SQL
queries to the DBMS (e.g. you don't query your Instagram followers by SQL).

This is because, most times, the application is using the database on behalf of the user, with
SQL queries, and just present the data in a _human-friendly_ way.

The Java Database Connectivity (JDBC) Application Programming Interface allows any java application
to use SQL commands and read the output from the Database Engine.

You can use this project as a template for your JDBC applications. To run it:

```
./gradlew run
```

(or `gradlew.bat run` if you are using Windows)

This will simulate a very simple application (with only one table) that creates car fines and stores
them into a database:

```
Starting the database....
Connecting to the database...
Creating the database tables, if they don't exist
generating some fines for the Chorrus Jarls with plate 1720-KAB
listing all the fines for car with plate 1720-KAB
id=52, model='Trini Fews', plate='1720-KAB', euros=19, paid=false
id=53, model='Trini Fews', plate='1720-KAB', euros=11, paid=false
id=54, model='Trini Fews', plate='1720-KAB', euros=44, paid=false
id=55, model='Trini Fews', plate='1720-KAB', euros=95, paid=false
id=56, model='Trini Fews', plate='1720-KAB', euros=51, paid=false
id=57, model='Trini Fews', plate='1720-KAB', euros=1, paid=false
id=58, model='Trini Fews', plate='1720-KAB', euros=11, paid=false
id=59, model='Trini Fews', plate='1720-KAB', euros=17, paid=false
id=60, model='Trini Fews', plate='1720-KAB', euros=3, paid=false
id=61, model='Trini Fews', plate='1720-KAB', euros=47, paid=false
paying some random fines
listing the updated list if the fines for car with plate 1720-KAB
id=52, model='Trini Fews', plate='1720-KAB', euros=19, paid=false
id=53, model='Trini Fews', plate='1720-KAB', euros=11, paid=true
id=54, model='Trini Fews', plate='1720-KAB', euros=44, paid=true
id=55, model='Trini Fews', plate='1720-KAB', euros=95, paid=true
id=56, model='Trini Fews', plate='1720-KAB', euros=51, paid=true
id=57, model='Trini Fews', plate='1720-KAB', euros=1, paid=false
id=58, model='Trini Fews', plate='1720-KAB', euros=11, paid=true
id=59, model='Trini Fews', plate='1720-KAB', euros=17, paid=false
id=60, model='Trini Fews', plate='1720-KAB', euros=3, paid=false
id=61, model='Trini Fews', plate='1720-KAB', euros=47, paid=false
```

Please observe the pattern followed here: all the entities persistence logic is hidden behind an
interface named `FineDAO`, which is implemented in a `JDBCFineDAO` class. This would allow replacing
your SQL database by any other type of database, or by fakes/mocks in your tests.