import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    System.out.println("welcoome");
                    break;
                case 2:
                    System.out.println("welcome");
                    break;
            }
        }

    }
}
