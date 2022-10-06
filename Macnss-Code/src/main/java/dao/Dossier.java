package dao;

import cookies.DossierNow;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dossier extends Dao{
    public Dossier() throws Exception {
    }

    public boolean addDocument(DossierNow dossier) throws SQLException {
        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO dossier(status, patientid, amount, description) VALUES (?,?,?,?)");
        ps.setString(1,dossier.getStatus());
        ps.setString(2,dossier.getPatientId());
        ps.setLong(3,dossier.getAmount());
        ps.setString(4,dossier.getDescription());
        boolean result = ps.execute();
        return result;
    }

}
