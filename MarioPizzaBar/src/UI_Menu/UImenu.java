package UI_Menu;

import Menukort_Pizza.Menukort;
import bestillingssystem.Bestillingsliste;
import bestillingssystem.Ordre;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UImenu {
    public int scanUserInput;

    boolean exitProgram = false;
    Menukort menukort = new Menukort();
    Ordre ordre = new Ordre();
    Bestillingsliste bestillinger = new Bestillingsliste();
    BestillingerGUI gui = new BestillingerGUI();
    Scanner scn = new Scanner(System.in);


    public void startUI () throws IOException {
        gui.opretVindue(bestillinger.getBestillinger());

        printLogo();
        while (!exitProgram){
            presentMenuOptions();
        int userInput = scn.nextInt();


        switch (userInput) {


        //Valg 1 - Vis menukort

            case 1:
                System.out.println("Her er menukortet");
                menukort.visPizzaListe();
                break;

        //Valg 2 - Håndter ordrer
            case 2:

                subMenuOrdre();

                int choice = scn.nextInt();

                if (choice == 1) {
                    System.out.println();
                    System.out.println("Her er din nuværende ordre");
                    ordre.visOrdre();
                    continue;
                }

                else if (choice == 2) {
                    System.out.println("Du har valgt at oprette en ny ordre");
                    Ordre nyOrdre = ordre.opretOrdre();
                    bestillinger.tilføjOrdreTilBestillinger(nyOrdre);
                    bestillinger.beregnVentetid();

                    gui.opdaterVindue(bestillinger.getBestillinger(), gui.getTabel());

                }

                else if (choice == 3) {
                    System.out.println();
                    System.out.println("Du har valgt at slette en ordre - Her er din ordre liste");
                    //slet ordre metode();

                }

                else if (choice == 4) {
                    bestillinger.visBestillinger();
                    System.out.println("Indtast nr på den ordre du vil afslutte?");
                    int afslutNr = scn.nextInt()-1;
                    bestillinger.afslutOrdre(bestillinger.getBestillinger().get(afslutNr));
                    gui.opdaterVindue(bestillinger.getBestillinger(), gui.getTabel());
                }

                else if (choice == 5) {
                    System.out.println("Her er hovedmenuen");
                }

                else {
                    System.out.println("Forkert indtastning - Tast 1, 2, 3, 4 eller 5");
                }
                break;

            //Valg 3 - Skift Pizza
            case 3:

               subMenuPizza();
                int choice1 = scn.nextInt();

                if (choice1 == 1) {
                    System.out.println("Du har valgt at tilføje en ny pizza til menukortet");
                    menukort.setPizzaListe(menukort.indlæsMenukort());
                    menukort.opretNyPizza();
                    break;
                }

                else if (choice1 == 2){
                    System.out.println("Du har valgt at fjerne en pizza fra menukortet");
                    menukort.setPizzaListe(menukort.indlæsMenukort());
                    menukort.fjernPizza();
                    }

                else if (choice1 == 3){
                    System.out.println("Du har valgt at ændre en pizza på menukortet");
                    menukort.setPizzaListe(menukort.indlæsMenukort());
                    menukort.lavOmPåPizza();
                }

                else if (choice1 == 4) {
                    break;
                }

                else {
                    System.out.println("Forkert indtastning - Tast 1, 2, 3 eller 4");
                    break;
                }


        //Valg 4 - Afslut ordre
            case 4:
                System.out.println("Du har valgt at afslutte");
                exitProgram = true;
        }

        }
    }


    public void presentMenuOptions(){
        System.out.println();
        System.out.println("Du har følgende valg:");
        System.out.println("Tast 1 - Se Menukort");
        System.out.println("Tast 2 - Håndter ordrer");
        System.out.println("Tast 3 - Håndter Menukortet");
        System.out.println("Tast 4 - Afslut");
    }

    public void subMenuOrdre (){
        System.out.println("Håndter ordre - Du har følgende valg:");
        System.out.println("Tast 1 - Se nuværerende ordre");
        System.out.println("Tast 2 - Opret ordre");
        System.out.println("Tast 3 - Slet ordre");
        System.out.println("Tast 4 - Afslut ordre");
        System.out.println("Tast 5 - Gå til Hovedmenu");
    }
    public void subMenuPizza (){
        System.out.println("Håndter menukortet - Du har følgende valg:");
        System.out.println("Tast 1 - Tilføj ny Pizza til Menukortet");
        System.out.println("Tast 2 - Slet Pizza fra Menukortet");
        System.out.println("Tast 3 - Ændre en Pizza på Menukortet");
        System.out.println("Tast 4 - Gå til Hovedmenu");
    }

    public void printLogo (){

        System.out.println("                        ___");
        System.out.println("                        |%=@%%/");
        System.out.println("                        |o%%%/");
        System.out.println("                     __ |%%o/");
        System.out.println("               _,--~~ | |(_/ ._");
        System.out.println("            ,/'  m%%%%| |o/ /  `\\.");
        System.out.println("           /' m%%o(_)%| |/ /o%%m `\\");
        System.out.println("         /' %%@=%o%%%o|   /(_)o%%% `\\");
        System.out.println("        /  %o%%%%%=@%%|  /%%o%%@=%%  \\");
        System.out.println("       |  (_)%(_)%%o%%| /%%%=@(_)%%%  |");
        System.out.println("       | %%o%%%%o%%%(_|/%o%%o%%%%o%%% |");
        System.out.println("       | M A R I O'S - P I Z Z A B A R|");
        System.out.println("       |  (_)%%=@%(_)%o%o%%(_)%o(_)%  |");
        System.out.println("        \\ ~%%o%%%%%o%o%=@%%o%%@%%o%~ /");
        System.out.println("         \\. ~o%%(_)%%%o%(_)%%(_)o~ ,/");
        System.out.println("           \\_ ~o%=@%(_)%o%%(_)%~ _/");
        System.out.println("             `\\_~~o%%%o%%%%%~~_/'");
        System.out.println("                `--..____,,--'");
    }


    public void drikkevareMenu(){
        System.out.println("Tilføj Drikkevare");
        System.out.println("Tast 1 - Tilføj Sodavand (20 kr.)");
        System.out.println("Tast 2 - Tilføj Vin (25 kr.)");
        System.out.println("Tast 3 - Tilføj Øl (25 kr.)");
        System.out.println("Tast 4 - Tilføj Vand (20 kr.)");
        System.out.println("Tast 5 - Gå tilbage");
    }

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        UImenu uImenu = new UImenu();
        uImenu.startUI();

    }

}
