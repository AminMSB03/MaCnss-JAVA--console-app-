package dao;
import cookies.Cookie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends Dao {


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
    public void CreateAgent(String email,String password) throws Exception{

        try{
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO users (email, password, role, matricule)VALUES (?,?,?,?);");
            ps.setString(1,email);
            ps.setString(2,password);
            ps.setString(3,"agent");
            ps.setString(4,null);

            ResultSet res=ps.executeQuery();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }


    }
    public void DeleteAgent(int id) throws Exception{
        try{
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM users WHERE id = ? ;");

            ps.setInt(1,id);

            ps.executeQuery();

        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
    public void UpdateAgent(int id,String email,String password) throws Exception{

        try{
            PreparedStatement ps = this.conn.prepareStatement("update users set email = ? , password = ? where id = ?;");

            ps.setString(1,email);
            ps.setString(2,password);
            ps.setInt(3,id);

            ps.executeQuery();
        }

        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }


    }

    public ResultSet DisplayAgent() throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users where role = 'agent';");
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    public ResultSet DisplayFolders(String matricule) throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM dossier where patientid =? ;");
        ps.setString(1,matricule);
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }
    public ResultSet DisplayInfo(String matricule) throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users where matricule = ?;");
        ps.setString(1,matricule);
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }




}
