import bro.sqltest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class addPassword {

    String password,passkey,pass,loginid;
    addPassword()
    {
        sqltest conn = new sqltest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passkey for your password");
        passkey=sc.nextLine();
        System.out.println("Enter Password");
        password=sc.next();
        System.out.println("Enter your account password");
        pass=sc.next();
        try {
            PreparedStatement login = conn.c.prepareStatement("select login_id from login where pass='" + pass + "';");
            ResultSet rs = login.executeQuery();
            rs.next();
            loginid = rs.getString(1);
        }
        catch (Exception e) {
            System.out.println(e);;
        }

        try {
            Statement s1= conn.c.createStatement();
            s1.execute("  insert into passwords values ('"+passkey+"',aes_encrypt('"+password+"','key123'),"+loginid+
                    ")");
            System.out.println("Password added!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new addPassword();
    }
}

