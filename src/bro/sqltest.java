package bro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class sqltest {
    public Connection c;
    public Statement s;
    public sqltest(){
        String username = "root";
        String password = "Arthaay20@";
        String url = "jdbc:mysql://localhost:3306/passnotesmanager";
        try{
            c = DriverManager.getConnection(url, username,password);
            s = c.createStatement();
            System.out.println("database connected ab 50 marks milenge");

        }catch (Exception e){
            System.out.println("Connection failed");
        }
    }

    public static void main(String[] args) {
        new sqltest();
    }
}

