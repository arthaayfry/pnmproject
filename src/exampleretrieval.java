import bro.sqltest;
import com.mysql.cj.protocol.Resultset;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class exampleretrieval {
    String passkey;
    String password;
    String decryptedPassword;
    String loginid;

    exampleretrieval() {
        sqltest conn = new sqltest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passkey of the password you want to choose");
        this.passkey = sc.nextLine();
        System.out.println("Enter your password");
        this.password = sc.next();
        try {
            PreparedStatement login = conn.c.prepareStatement("select login_id from login where pass='" + password + "';");
            ResultSet rs = login.executeQuery();
            rs.next();
            loginid = rs.getString(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            PreparedStatement decrypt =conn.c.prepareStatement("select cast(aes_decrypt(enctext,'key123')as char(100))as decrypt from passwords where passkey='"+passkey+"' and login_id ="+loginid+";");
            ResultSet rs1=decrypt.executeQuery();
            rs1.next();
            decryptedPassword= rs1.getString(1);
            System.out.println(decryptedPassword);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new exampleretrieval();
    }
}




