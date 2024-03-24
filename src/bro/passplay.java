package bro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class passplay {

     static void storePassword()
    {
        try {
            String password,loginPassword,keyword;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Keyword for your password");
            keyword = sc.next();
            System.out.println("Enter password to store");
            password = sc.next();
            System.out.println("Enter your login password");
            loginPassword=sc.next();




        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       passplay p1 = new passplay();
       passplay.storePassword();
    }
}
