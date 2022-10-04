package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public  abstract class  Dao {
    public Connection conn;

    public Dao() throws Exception {
        Class.forName("org.postgresql.Driver");
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cnss","postgres","Ycode@2021");
    }
}
