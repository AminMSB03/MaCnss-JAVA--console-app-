package metier.login;
import Cookie.Cookie;
import dao.Users;

import java.sql.*;

public class Login {
    public Connection conn;



    public boolean LoginOfEmployee(String email, String password) throws Exception {
        Users user = new Users();
        Cookie auth = user.login(email,"email");
        if(auth!=null){
            if(auth.getPassword().equals(password)){
                Cookie.setAuthId(auth.getId());
                Cookie.setAuthEmail(auth.getEmail());
                Cookie.setAuthRole(auth.getRole());
                return true;
            }else{
                return false;
            }
        }
        return false;


    }

}
