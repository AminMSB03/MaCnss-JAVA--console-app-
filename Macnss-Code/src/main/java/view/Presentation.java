package view;

import cookies.Cookie;

import metier.email.SendingEmail;
import metier.login.Login;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
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
                    loginPatient();
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


        Boolean loginTry = login.loginOfEmployee(email,password,"email");
        if(loginTry){
            String role = Cookie.getAuthRole();
            switch (role){
                case "agent":
                    if(sendMail(email)){
                        AgentView agentView = new AgentView();
                   }
                    else{
                        System.out.println("verification invalid");
                    }
                    break;
                case "admin":
                   AdminView adminView=new AdminView();
                    break;
            }
        }else{
            System.out.println("! FALSE INFOS  !");
        }

    }
    public static boolean sendMail(String email) {
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        int num = (int) ((Math.random() * (9999 - 1111)) + 1111);
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date afterAdding5Mins = new Date(timeInSecs + (5 * 60 * 1000));
        SendingEmail.send(email, "Macnss verification", "This code " + num + " is valid only for 5 min");
        System.out.print("Please check your email and enter the verification code here :");
        int verificationCode = input.nextInt();
        Date current_time = new Date(timeInSecs);
        if (afterAdding5Mins.compareTo(current_time) > 0 && verificationCode == num) {
            System.out.println("verification code is valid");
            flag = true;
        } else {

            flag = false;
        }
        return flag;
    }

    public static void  loginPatient() throws Exception{
        Login login = new Login();
        Scanner input = new Scanner(System.in);

        System.out.printf("\nEnter your matricule : ");
        String matricule = input.nextLine();

        System.out.printf("\nEnter your password : ");
        String password = input.nextLine();
        Boolean loginTry = login.loginOfEmployee(matricule,password,"matricule");
        if(loginTry){
            PatientView PatientView = new PatientView(matricule);


        }

    }







}






