import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import java.sql.Connection;
import java.sql.DriverManager;
import org.example.tables.Users;

public class Main {
    public static void main(String args[])
    {
        System.out.println("Hello there");


        //db information
        String user = "postgres";
        String password = "";
        String url = "jdbc:postgresql://localhost:5432/demo";

        try{
            Connection conn = DriverManager.getConnection(url,user,password);
            DSLContext dsl = DSL.using(conn, SQLDialect.POSTGRES);

            //Lets perform a select
            Users u = new Users();
            Result<Record> result = dsl.select().from(u.USERS).fetch();
            for(Record record: result)
                 System.out.println(record.get("name"));



            System.out.print("Connection established");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

}

}
