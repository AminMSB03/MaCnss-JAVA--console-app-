package metier.employee;

import cookies.Dossier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Agent {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Agent() throws ParseException {
    }
    public static void addRefundRequest(Scanner scanner) throws ParseException {
        Dossier dossier = new Dossier();
        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Patient's matricule : "+ANSI_RESET);
        String matricule = scanner.nextLine();

        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Number of ordonnance : "+ANSI_RESET);
        int Nordonnance = Integer.parseInt(scanner.nextLine());
        int ordCounter = 0;

        while(ordCounter<Nordonnance){
            System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+" Enter the date of the ordonnance : "+ANSI_RESET);
            String date = scanner.nextLine();

            //Entered date
            LocalDate localDate = LocalDate.parse(date);
            LocalDate now = LocalDate.now();

            Period period = Period.between(localDate,now);
            if(period.getMonths()<2 || (period.getMonths()==2 && period.getDays()==0)){
                System.out.println(" Counted One😀");
                dossier.amount+=120;
            }
            System.out.println("None Counted😢");
            ordCounter++;
        }





    }

}