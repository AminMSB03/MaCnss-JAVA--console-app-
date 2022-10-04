package dao;

import cookies.Cookie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users extends Dao{

    public Users() throws Exception {

    }

    public Cookie login(String email, String column) throws Exception{

        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users WHERE "+column+" LIKE ?");
        ps.setString(1,email);
        ResultSet resultSet = ps.executeQuery();

        Cookie cookie = new Cookie();

        if(resultSet.next()) {
            cookie.setId(resultSet.getInt("id"));
            cookie.setEmail(resultSet.getString("email"));
            cookie.setPassword(resultSet.getString("password"));
            cookie.setRole(resultSet.getString("role"));
        }
        return cookie;
    }


}
