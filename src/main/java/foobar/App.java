package foobar;

import com.googlecode.flyway.core.Flyway;

public class App 
{
    public static void main( String[] args ) 
    {
    	Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:postgresql://127.0.0.1:5432/flywaydb", "localuser2",	"123");
        flyway.migrate();
    }
}
