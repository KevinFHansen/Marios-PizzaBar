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

            case 4:
                drikkevareMenu();
                int choice2 = scn.nextInt();

                if(choice2 == 1){
                    menukort.visDrikkevarer();

                }

                if(choice2 == 2){
                    System.out.println("Du har valgt at tilføje ny drikkevare");
                    menukort.setDrikkevarerListe(menukort.indlæsDrikkevare());
                    menukort.opretDrikkevarer();

                }

                if(choice2 == 3 ){
                    System.out.println("Du har valgt at fjerne en drik");
                    menukort.setDrikkevarerListe(menukort.indlæsDrikkevare());
                    menukort.fjernDrikkevarer();

                }

                if(choice2 == 4){
                    System.out.println("Du har valgt at ændre i drikkevarer");
                    menukort.setDrikkevarerListe(menukort.indlæsDrikkevare());
                    menukort.lavOmPåDrikkevare();

                }

                if(choice2 == 5){

                }
                break;
        //Valg 5 - Afslut ordre
            case 5:
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
        System.out.println("Tast 4 - Se eller håndter drikkevarer");
        System.out.println("Tast 5 - Afslut");
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

    public void drikkevareMenu(){
        System.out.println("Tast 1 - Vis drikkevarer");
        System.out.println("Tast 2 - Tilføj en drik");
        System.out.println("Tast 3 - Fjern en drik");
        System.out.println("Tast 4 - Ændre i drikkevarer");
        System.out.println("Tast 5 - Gå tilbage");
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




    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        UImenu uImenu = new UImenu();
        uImenu.startUI();

    }

}
