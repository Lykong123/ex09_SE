package ex01;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

    public Connection get_connection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/midterm", "root", "");
            System.out.println("DB is connected");
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public static void main(String[] args){
        DB_Connection db_connection = new DB_Connection();
        System.out.println(db_connection.get_connection());
    }
}
