package view;

// import Cookie.Cookie;

import metier.login.Login;

import java.sql.ResultSet;
import java.util.Scanner;

import dao.Users;

public class Presentation {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------" +
                "-------------------------------Welcome to MaCnss---------------------------------------" +
                "---------------------------------------");
        System.out.printf("%60s", "1-Employee");
        System.out.printf("%60s", "2-Patient");

        int personType = 4;
        while (personType != 0) {
            System.out.print("\nChoose who are you : ");
            personType = Integer.parseInt(input.nextLine());


            switch (personType) {
                case 1:
                    loginEmployee();
                    break;
                case 2:
                    System.out.println("welcome");
                    break;
            }

        }
    }

    public static void loginEmployee() throws Exception {
        Login login = new Login();
        Scanner input = new Scanner(System.in);

        System.out.printf("\nEnter your email : ");
        String email = input.nextLine();

        System.out.printf("\nEnter your password : ");
        String password = input.nextLine();


        // login.LoginOfEmployee(email,password);
    }

    public static void loginAdmin() throws Exception {
        Login login = new Login();
        Scanner input = new Scanner(System.in);

        System.out.printf("\nEnter your email : ");
        String email = input.nextLine();

        System.out.printf("\nEnter your password : ");
        String password = input.nextLine();


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
        System.out.println("Enter the number of agent you want to delete : ");
        int id = input.nextInt();

        Users user = new Users();
        user.DeleteAgent(id);


        System.out.println("agent deleted successfully ");

    }

    public static void updateAgent() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of agent you want to update : ");
        int id = input.nextInt();
        System.out.println("enter new email");
        String email = input.next();
        System.out.println("enter new password");
        String password = input.next();

        Users user = new Users();
        user.UpdateAgent(id, email, password);
        System.out.println("agent's info updated successfully ");

    }

    public static void createAgent() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("enter email");
        String email = input.next();
        System.out.println("enter password");
        String password = input.next();

        Users user = new Users();

        user.CreateAgent(email, password);

        System.out.println("agent added successfully ");
    }


}






