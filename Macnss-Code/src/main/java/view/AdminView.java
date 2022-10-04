package view;

import metier.employee.Admin;

import java.text.ParseException;
import java.util.Scanner;

public class AdminView {

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";



    public Scanner scanner = new Scanner(System.in);
    public AdminView() throws Exception {
        showInterface();
    }
    public void showInterface() throws Exception {

        int repeat = 0;
        do {
            System.out.println();
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 1 - Display agents "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 2 - Create agent "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 3 - Update agent's info "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 4 - Delete agent "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 5 - log out "+ANSI_RESET);
            System.out.println();

            System.out.printf("\nEnter your choice :  ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    Admin.displayAgent();
                    break;
                case 2:
                    Admin.createAgent();
                    break;
                case 3:
                   Admin.updateAgent();
                    break;
                case 4:
                    Admin.deleteAgent();
                    break;
                case 5:
                    repeat=99;

                    break;
            }

        }while(repeat==0);
        System.out.printf("\n\n\n");
    }
}