import bro.sqltest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Scanner;

public class userLogin {
    userLogin()
    {
        sqltest conn = new sqltest();
        Scanner sc = new Scanner(System.in);
        String username,pass,sqlpass;
        sqlpass="hehe";
        System.out.println("Enter your username");
        username=sc.next();
        try {
            PreparedStatement login = conn.c.prepareStatement("select pass from login where username='" + username + "';");
            ResultSet rs = login.executeQuery();
            rs.next();
            sqlpass = rs.getString(1);
            System.out.println(sqlpass);
        }
        catch (Exception e) {
            System.out.println(e);

        }
        System.out.println("Enter your password");
        pass=sc.next();
        if(Objects.equals(pass, sqlpass))
        {
            System.out.println("login successful!");
        }
        else {
            System.out.println("Incorrect username or password, try again!");
        }
    }

    public static void main(String[] args) {
        new userLogin();
    }
}

