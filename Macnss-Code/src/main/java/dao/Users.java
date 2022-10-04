package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users extends Dao {


    public Users() throws Exception {

    }

    public void login(String email, String column) throws Exception{
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users WHERE "+column+" LIKE ?;");
        ps.setString(1,email);
        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println(resultSet.getString("role"));
        }
    }
    public ResultSet CreateAgent(String email,String password) throws Exception{
        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO users (email, password, role, matricule)VALUES (?,?,?,?);");
        ps.setString(1,email);
        ps.setString(2,password);
        ps.setString(3,"agent");
        ps.setString(4,null);

        return ps.executeQuery();

    }
    public ResultSet DeleteAgent(int id) throws Exception{
        PreparedStatement ps = this.conn.prepareStatement("DELETE FROM users WHERE id = ? ;");

        ps.setInt(1,id);
        return  ps.executeQuery();
    }
    public ResultSet UpdateAgent(int id,String email,String password) throws Exception{

        PreparedStatement ps = this.conn.prepareStatement("UPDATE users set email= ?,password= ? where id=?;");

        ps.setString(1,email);
        ps.setString(2,password);
        ps.setInt(3,id);
        
        return  ps.executeQuery();


    }

    public ResultSet DisplayAgent() throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users where role = 'agent';");
        ResultSet resultSet = ps.executeQuery();


        return resultSet;
    }




}
