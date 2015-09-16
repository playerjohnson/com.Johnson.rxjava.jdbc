package com.Johnson.app;

import com.github.davidmoten.rx.jdbc.Database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        Connection con = Database.from("jdbc:hsqldb:hsql://localhost/").getConnectionProvider().get();
        Database db = Database.from(con);
        /*db.update(
                "create table person (name varchar(50) primary key, score int not null,dob date, registered timestamp)")
                .count().toBlocking().single();*/
        try {
            db.update("DROP TABLE PERSON").count().toBlocking().single();
        }catch (Exception e){System.out.println( "Hello World!" );
        }finally {
            db.close();


        }
    }
}
