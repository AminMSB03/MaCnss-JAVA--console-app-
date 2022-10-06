package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medication extends Dao {

    public Medication() throws Exception {
    }

    public int getMedicRem(String ref) throws Exception {
        PreparedStatement ps = this.conn.prepareStatement("SELECT remboursement FROM medicament WHERE ref=? ");
        ps.setString(1,ref);
        ResultSet result = ps.executeQuery();
        while (result.next()){
            return result.getInt("remboursement");
        }
        return 0;
    }
}
