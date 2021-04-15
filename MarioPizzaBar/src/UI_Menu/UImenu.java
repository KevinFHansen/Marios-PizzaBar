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
        System.out.println("Tast 2 for at håndtere ordrer");
        System.out.println("Tast 3 for at håndtere menukortet");
        System.out.println("Tast 4 for afslutte");
        }


    public void startUI (){
        while (!exitProgram){
        presentMenuOptions();
        int userInput = scn.nextInt();

        switch (userInput) {

        //Valg 1
            case 1:
                System.out.println("Her er menukortet");
                menukort.visPizzaListe();
                break;

        //Valg 2
            case 2:
                System.out.println("Håndter ordrre");
                System.out.println("Tast 1 for at se nuværende ordre");
                System.out.println("Tast 2 for at oprette ny ordre");
                System.out.println("Tast 3 for at slette ordre");
                System.out.println("Tast 4 for at afslutte ordre");
                System.out.println("Tast 5 for at vende tilbage til hovedmenu");

                if (scn.nextInt() == 1)
                    System.out.println("Her er din nuværende ordre");
                    //se din nuværende ordrer metode();

                else if (scn.nextInt() == 2) {
                    System.out.println("Du har valgt at oprette en ny ordre");
                    ordre.opretOrdre();
                }

                else if (scn.nextInt() == 3)
                    System.out.println("Du har valgt at slette en ordre - Her er din ordre liste");
                    //slet ordre metode();

                else if (scn.nextInt() == 4) {
                    System.out.println("Du har valgt af afslutte ordren");
                    //afslut ordre metode();
                    break;
                }

                else if (scn.nextInt() == 5)
                    break;

                else
                    System.out.println("Forkert indtastning - Tast 1, 2, 3, 4 eller 5");

            case 3:
                System.out.println("Hvilke ændringer vil du lave i menukortet?");
                System.out.println("Tast 1 for at tilføje en pizza til menukortet");
                System.out.println("Tast 2 for at fjerne en pizza fra menukortet");
                System.out.println("Tast 3 for at ændre en pizza på menukortet");
                System.out.println("Tast 4 for at vende tilbage til hovedmenu");

                if (scn.nextInt() == 1) {
                    System.out.println("Du har valgt at tilføje en ny pizza til menukortet");
                    //Menukort.opretNyPizza();
                }

                else if (scn.nextInt() == 2){
                    System.out.println("Du har valgt at fjerne en pizza fra menukortet");
                    menukort.fjernPizza();
                    }

                else if (scn.nextInt() == 3){
                    System.out.println("Du har valgt at ændre en pizza på menukortet");
                    //Menukort.skiftPizza();
                }
                else if (scn.nextInt() == 4)
                    break;

                else
                    System.out.println("Forkert indtastning - Tast 1, 2, 3 eller 4");



/*
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
                //Menukort.skiftPizza();
                break;*/


        //Valg 6
            case 4:
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
