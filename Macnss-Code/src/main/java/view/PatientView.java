package view;

import metier.patient.Patient;

import java.text.ParseException;
import java.util.Scanner;

public class PatientView {

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String matricule;

    public Scanner scanner = new Scanner(System.in);
    public PatientView(String matricule) throws Exception {
        this.matricule=matricule;
        showInterface();
    }
    public void showInterface() throws Exception {

        int repeat = 0;
        do {
            System.out.println();
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 1 - Display folders "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 2 - Display info "+ANSI_RESET);
            System.out.printf(ANSI_BLACK+"\t\t"+ANSI_WHITE_BACKGROUND+" 3 - log out "+ANSI_RESET);
            System.out.println();

            System.out.printf("\nEnter your choice :  ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    Patient.displayFolders(this.matricule);
                    break;
                case 2:
                    Patient.displayInfo(this.matricule);
                    break;

                case 3:
                    repeat=99;
                    break;
            }

        }while(repeat==0);
        System.out.printf("\n\n\n");
    }
}