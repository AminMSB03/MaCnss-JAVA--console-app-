package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dossier extends Dao{
    public Dossier() throws Exception {

    }

    public void CreatFolder(String status,String amount,String description) throws Exception{
        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO dossier (status, amount, description)VALUES (?,?,?);");
        ps.setString(1,status);
        ps.setString(2,amount);
        ps.setString(3,description);


        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println("");

        }
    }

    public void UpdateFolder(String id,String status) throws Exception{

        PreparedStatement ps = this.conn.prepareStatement("UPDATE dossier set status= ? where id=?;");

        ps.setString(1,status);
        ps.setString(2,id);



        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println("");
        }
    }

    public void DisplayFolderToAgent() throws Exception{

        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM dossier");
        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println("");
        }
    }
    public void DisplayFolderToPatient(String id) throws Exception{

        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM dossier");
        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()) {
            System.out.println("");
        }
    }






}
