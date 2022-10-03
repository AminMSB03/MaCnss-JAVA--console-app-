package metier.login;
import java.sql.*;

public class Login {
    public Connection conn;

    public Login() throws Exception {
        Class.forName("org.postgresql.Driver");
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cnss","postgres","vendredi1120deux!");
    }

    public void emplyeeLogin(String email, String password) throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM users WHERE email LIKE ?");
        ps.setString(1,email);
        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println(resultSet.getString("role"));
        }

    }
    public void patientLogin(){
        System.out.println("Patient");
    }
}
