package metier.employee;

import cookies.DossierNow;
import dao.Dossier;
import dao.Medication;
import dao.Users;
import metier.email.SendingEmail;

import java.text.ParseException;
import java.time.*;
import java.util.Scanner;

public class Agent {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Agent() throws ParseException {

    }
    public static void addRefundRequest(Scanner scanner) throws Exception {
        DossierNow dossier = new DossierNow();

        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Patient's matricule : "+ANSI_RESET);
        String matricule = scanner.nextLine();

        //Check if the patient with matricule exists
        Users user = new Users();
        String userCheck = user.getPatient(matricule);

        //Let the aget rewrite the patient matricule
        while (userCheck==null) {
            System.out.printf("\n\n !  USER NOT FOUND  ! ");
            System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Check Patient's matricule : "+ANSI_RESET);
            matricule = scanner.nextLine();
        }

        // add the patient matricule to the document
        dossier.setPatientId(matricule);

        //Enter the number of the ORD
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
            }else{
                System.out.println("None Counted😢");
            }
            ordCounter++;
        }

        // this part for radio and scanner that the document contains
        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Number of radio : "+ANSI_RESET);
        int nRadio = Integer.parseInt(scanner.nextLine());
        int radioCounter = 0;

        while(radioCounter<nRadio){
            System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+" Enter the price paid of radios : "+ANSI_RESET);
            Long price = Long.parseLong(scanner.nextLine());
            dossier.amount+=(price*80)/100;
            radioCounter++;
        }

        // and this for the
        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+"Number of Medicament : "+ANSI_RESET);
        int nMedic = Integer.parseInt(scanner.nextLine());
        int medicamentCounter = 0;

        while(medicamentCounter<nMedic){
            System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+" Enter the ref of medicament : "+ANSI_RESET);
            String ref = scanner.nextLine();
            Medication medication = new Medication();
            int rem = medication.getMedicRem(ref);
            dossier.amount+=rem;
            medicamentCounter++;
        }

        String status;

        if(dossier.amount!=0){
            System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+" status of the request (refused / accepted) :"+ANSI_RESET);
            status = scanner.nextLine();
        }else{
            status = "refused";
        }

        System.out.printf(ANSI_BLACK+"\n "+ANSI_WHITE_BACKGROUND+" Add description :"+ANSI_RESET);
        String description = scanner.nextLine();


        // add the status and description
        dossier.setStatus(status);
        dossier.setDescription(description);


        // save the document
        Dossier dossier1 = new Dossier ();
        boolean result  = dossier1.addDocument(dossier);


        SendingEmail.send(userCheck, "your claim has been "+status, description);


    }

}
