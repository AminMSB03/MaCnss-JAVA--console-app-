package metier.login;

import cookies.Cookie;
import dao.Users;
import metier.email.SendingEmail;

import java.sql.*;
import java.time.*;
import java.util.Calendar;
import java.util.Scanner;

public class Login {
    public Connection conn;




    public boolean LoginOfEmployee(String email, String password) throws Exception {
        Users user = new Users();
        Cookie auth = user.login(email, "email");
        if (auth != null) {
            if (auth.getPassword().equals(password)) {
                Cookie.setAuthId(auth.getId());
                Cookie.setAuthEmail(auth.getEmail());
                Cookie.setAuthRole(auth.getRole());


                return true;
            } else {
                return false;
            }


        }
        return false;


    }


}