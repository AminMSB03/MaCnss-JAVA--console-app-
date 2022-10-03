package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users extends Dao {


    public Users() throws Exception {

    }

    public void login(String email, String column) throws Exception{
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users WHERE "+column+" LIKE ?");
        ps.setString(1,email);
        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println(resultSet.getString("role"));
        }
    }


}
