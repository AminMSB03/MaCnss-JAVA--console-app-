package view;

import cookies.Cookie;
import metier.login.Login;

import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);


        int personType = 4;
        while(personType!=0){

            System.out.println("-----------------------------------------------" +
                "-------------------------------Welcome to MaCnss---------------------------------------" +
                "---------------------------------------");
        System.out.printf("%60s","1-Employee");
        System.out.printf("%60s","2-Patient");

        System.out.print("\nChoose who are you : ");
        personType = Integer.parseInt(input.nextLine());


            switch (personType){
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


        Boolean loginTry = login.LoginOfEmployee(email,password);
        if(loginTry){
            String role = Cookie.getAuthRole();
            switch (role){
                case "agent":
                    AgentView agentView = new AgentView();
                    break;
                case "admin":
                    System.out.println("welcome admin");
                    break;
            }
        }else{
            System.out.println("! FALSE INFOS  !");
        }

    }








}
