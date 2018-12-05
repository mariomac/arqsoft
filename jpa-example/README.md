# Example: Java Persistence API (JPA)

JPA is an Object-Relational Mapping (ORM) tool: it allows you working with relational databases (e.g.
MySQL, PostgreSQL, Oracle, etc...) directly with Java classes, helping you from creating a lot of
boilerplate code to read/write from/to the database, as well as having to deal with the subtle
differences between all the SQL dialects.

This example uses:

* Gradle as build system and dependency management.
* Hibernate as the JPA provider.
* H2 as embedded database.

Using Java embedded databases (H2, HSQLDB...) allows you easily test your SQL applications without
having to install and configure external services, such as MySQL or Postgres.

Thanks to JPA and Hibernate, you can later switch your database for production without having to
change a line of code (but the [persistence.xml](./src/main/resources/META-INF/persistence.xml)
configuration).


## How to run

In Linux or Mac. Open a terminal an run:

```
./gradlew run
```

In Windows. Open a CMD and run:

```
gradlew.bat run
```

## De