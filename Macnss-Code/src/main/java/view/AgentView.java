package view;

import metier.employee.Agent;

import java.text.ParseException;
import java.util.Scanner;

public class AgentView {

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";



    public Scanner scanner = new Scanner(System.in);
    public AgentView() throws Exception {
        showInterface();
    }
    public void showInterface() throws Exception {

        int repeat = 0;
        do {
            System.out.println();
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 1-refund request "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 2- Log out "+ANSI_RESET);
            System.out.println();

            System.out.printf("\nEnter your choice :  ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    Agent.addRefundRequest(scanner);
                    break;
                case 2:
                    repeat =99;
                    break;
            }

        }while(repeat==0);
        System.out.printf("\n\n\n");
    }
}