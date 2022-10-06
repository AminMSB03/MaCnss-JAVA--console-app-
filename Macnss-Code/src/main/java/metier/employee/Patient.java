package metier.employee;

import dao.Users;

import java.sql.ResultSet;
import java.util.Scanner;

public class Patient {
    public static void displayFolders(String matricule) throws Exception {
        System.out.println("hello from Patient.java method displayFolders");
        Scanner input = new Scanner(System.in);
        Users user = new Users();
        ResultSet displayFolders = user.DisplayFolders(matricule);
        while (displayFolders.next()) {
            System.out.print("patient matricule: ");
            System.out.println(displayFolders.getString(3));
            System.out.print("amount: ");
            System.out.println(displayFolders.getString(4));
            System.out.print("description: ");
            System.out.println(displayFolders.getString(5));
            System.out.print("status: ");
            System.out.println(displayFolders.getString(2));
            System.out.println("---------------------------------------------------------");
        }
    }
    public static void displayInfo(String matricule) throws Exception {
        Scanner input = new Scanner(System.in);
        Users user = new Users();
        ResultSet displayInfo = user.DisplayInfo(matricule);
        while (displayInfo.next()) {
            System.out.print("email");
            System.out.print(": ");
            System.out.println(displayInfo.getString(2));
            System.out.print("matricule");
            System.out.print(": ");
            System.out.println(displayInfo.getString(5));

        }
    }
}
