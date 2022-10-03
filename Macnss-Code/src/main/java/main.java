import dao.Users;
import metier.login.Login;

import java.util.UUID;

public class main {
    public static void main(String[] args) throws Exception {
        Users login = new Users();
        login.login("admin@admin.com","email");



    }
}
