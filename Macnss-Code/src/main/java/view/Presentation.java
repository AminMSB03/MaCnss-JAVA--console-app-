package view;

import java.util.Scanner;

public class Presentation {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------" +
                "-------------------------------Welcome to MaCnss---------------------------------------" +
                "---------------------------------------");
        System.out.printf("%60s","1-Employee");
        System.out.printf("%60s","2-Patient");

        int personType = 4;
        while(personType>2){
        System.out.print("\nChoose who are you : ");
        personType = Integer.parseInt(input.nextLine());


            switch (personType){
                case 1:
                    loginEmployee();
                    break;
                case 2:
                    loginAdmin();
                    break;
            }
        }
    }

    public static void loginEmployee(){

        System.out.printf("\nEnter your email : ");
        String email = input.nextLine();

        System.out.printf("\nEnter your password : ");
        String password = input.nextLine();



    }
    public static void  loginAdmin(){

        System.out.printf("\nEnter your email : ");
        String email = input.nextLine();

        System.out.printf("\nEnter your password : ");
        String password = input.nextLine();



    }






}
