import metier.login.Login;
import metier.login.SendingEmail;

public class main {
    public static void main(String[] args) throws Exception {
        //Login login = new Login();
        //login.emplyeeLogin("admin@admin.com","admin123");
        SendingEmail.send();
    }
}
