package metier.employee;

import dao.Users;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Scanner;

public class Admin {

    public Admin() throws ParseException{

    }

    public static void displayAgent() throws Exception {
        Scanner input = new Scanner(System.in);
        Users user = new Users();
        ResultSet displayAgent = user.DisplayAgent();
        while (displayAgent.next()) {
            System.out.print(displayAgent.getInt(1));
            System.out.print(": ");
            System.out.println(displayAgent.getString(2));
        }
    }

    public static void deleteAgent() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.printf("\nEnter the number of agent you want to delete : ");
        int id = input.nextInt();

        Users user = new Users();
        user.DeleteAgent(id);


        System.out.println(" ! agent deleted successfully ! ");

    }

    public static void updateAgent() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.printf("\nEnter the number of agent you want to update : ");
        int id = input.nextInt();
        System.out.printf("\nEnter new email : ");
        String email = input.next();
        System.out.printf("\nenter new password : ");
        String password = input.next();

        Users user = new Users();
        user.UpdateAgent(id, email, password);
        System.out.println(" ! agent's info updated successfully ! ");

    }

    public static void createAgent() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.printf("\nEnter email : ");
        String email = input.next();
        System.out.printf("\nenter password : ");
        String password = input.next();

        Users user = new Users();

        user.CreateAgent(email, password);

        System.out.println("agent added successfully ");
    }


}