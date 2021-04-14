package UI_Menu;

import Menukort_Pizza.Menukort;
import bestillingssystem.Ordre;

import java.util.Scanner;

public class UImenu {
    public int scanUserInput;
    Scanner scn = new Scanner(System.in);
    boolean exitProgram = false;
    Menukort menukort = new Menukort();
    Ordre ordre = new Ordre();


    public void presentMenuOptions(){

        System.out.println("Du har følgende muligheder :");
        System.out.println("Tast 1 for at se Menu Kort");
        System.out.println("Tast 2 for at oprette ny ordre");
        System.out.println("Tast 3 for at tilføje ny pizza til menukort");
        System.out.println("Tast 4 for at fjerne pizza fra menukort");
        System.out.println("Tast 5 for ændre pizza på menukort");
        System.out.println("Tast 6 for at afslutte");
        }


    public void startUI (){
        while (exitProgram == false){
        presentMenuOptions();
        int userInput = scn.nextInt();

        switch (userInput) {

        //Valg 1
            case 1:
                System.out.println("Her er menukortet");
                break;

        //Valg 2
            case 2:
                System.out.println("Opret ny ordre");
                ordre.opretOrdre();
                break;

        //Valg 3
            case 3:
                System.out.println("Tilføj Pizza til menukortet");
                Menukort.opretNyPizza();
                break;

        //Valg 4
            case 4:
                System.out.println("Fjern Pizza fra menukort");
                menukort.fjernPizza();
                break;

        //Valg 5
            case 5:
                System.out.println("Ændre Pizza");
                Menukort.skiftPizza();
                break;

        //Valg 6
            case 6:
                System.out.println("Du har valgt at afslutte");
                exitProgram = true;

        }

        }
    }

    public static void main(String[] args) {
        UImenu uImenu = new UImenu();
        uImenu.startUI();
    }
}
