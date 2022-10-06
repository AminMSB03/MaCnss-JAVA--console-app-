package metier.login;
import cookies.Cookie;
import dao.Users;

import java.sql.*;

public class Login {
    public Connection conn;



    public boolean LoginOfEmployee(String email, String password,String column) throws Exception {

        Users user = new Users();
        Cookie auth = user.login(email,column);



        if((auth.getEmail())!=null){
            if(auth.getPassword().equals(password)){
                Cookie.setAuthId(auth.getId());
                Cookie.setAuthEmail(auth.getEmail());
                Cookie.setAuthRole(auth.getRole());
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }


    }

}
