flywaydb-postgres
=================

Agile database migration framework for Java using postgresql.

Prerequisites:
- Java 5+
- Maven 2+

1) Create a maven project using the Maven Archetype Plugin.

```mvn
> mvn archetype:generate -B -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1 -DgroupId=foo -DartifactId=bar -Dversion=1.0-SNAPSHOT -Dpackage=foobar
```

2) Import the project to eclipse.

3) Change the pom.xml file to add dependence: flyway and postgresql.

```xml
<project ...>
    ...
    <dependencies>
        <dependency>
            <groupId>com.googlecode.flyway</groupId>
            <artifactId>flyway-core</artifactId>
            <version>2.2.1</version>
        </dependency>
        <dependency>
	    <groupId>postgresql</groupId>
	    <artifactId>postgresql</artifactId>
	    <version>9.1-901.jdbc4</version>
        </dependency>
        ...
    </dependencies>
    ...
</project>
```

4) Postgresql database connection (bar/src/main/java/foobar/App.java). 
I used a local database for the tests. Just change the url, username and password for your database.

```java
package foobar;

import com.googlecode.flyway.core.Flyway;

public class App {
	public static void main(String[] args) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:postgresql://127.0.0.1:5432/database", "username", "password");
		flyway.migrate();
	}
}
```

5) Create migrations in the directory: src/main/resources/db/migration.

```sqlfile
-> Default format to create sql file for migration:
	-> V1__filename1.sql (V1 = version 1)
	-> V2__filename2.sql
	...
```

6) Execute the commands in terminal to compile and run the migrations:

```mvn
flywaydb-postgres> mvn compile
flywaydb-postgres> mvn package exec:java -Dexec.mainClass=foobar.App
```



