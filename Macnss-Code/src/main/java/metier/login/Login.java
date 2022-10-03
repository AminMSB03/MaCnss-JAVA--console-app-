package metier.login;
import java.sql.*;

public class Login {
    public Connection conn;

    public Login() throws Exception {
        Class.forName("org.postgresql.Driver");
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cnss","postgres","vendredi1120deux!");
    }

    public void LoginOfEmployee(String column ,String email, String password) throws Exception {


    }

}
