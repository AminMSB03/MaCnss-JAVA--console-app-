package Cookie;

public class Cookie {
    private int id;
    private String email;
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    static int authId;
    static String authEmail;
    static String authRole;



    public static int getAuthId() {
        return authId;
    }

    public static void setAuthId(int authId) {
        Cookie.authId = authId;
    }

    public static String getAuthEmail() {
        return authEmail;
    }

    public static void setAuthEmail(String authEmail) {
        Cookie.authEmail = authEmail;
    }

    public static String getAuthRole() {
        return authRole;
    }

    public static void setAuthRole(String authRole) {
        Cookie.authRole = authRole;
    }





}