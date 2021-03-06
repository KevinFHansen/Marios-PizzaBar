package ui_menu;

import menukort_pizza.Drikkevarer;
import menukort_pizza.Menukort;
import statistik.Statistik;
import menukort_pizza.Pizza;
import bestillingssystem.Bestillingsliste;
import bestillingssystem.Ordre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UImenu {

    Menukort menukort = new Menukort();
    Ordre ordre = new Ordre();
    Bestillingsliste bestillinger = new Bestillingsliste();
    BestillingerGUI gui = new BestillingerGUI();
    Scanner scn = new Scanner(System.in);
    Statistik statistik = new Statistik(0,0);



    public void startUI () throws IOException {
        gui.opretVindue(bestillinger.getBestillinger());
        ArrayList<Pizza> pizzaListe = menukort.indlæsMenukort();
        ArrayList<Drikkevarer> drikkevarerListe = menukort.indlæsDrikkevare();
        boolean afslut = false;

        printLogo();

        while (afslut == false){
            presentMenuOptions();
            int userInput = scn.nextInt();

            switch (userInput) {


            //Valg 1 - Vis menukort

                case 1:
                    System.out.println("Her er menukortet");
                    menukort.visPizzaListe(pizzaListe);
                    break;

            //Valg 2 - Håndter ordrer
                case 2:

                    while(true) {
                        subMenuOrdre();

                        int choice = scn.nextInt();

                        if (choice == 1) {
                            System.out.println("Du har valgt at oprette en ny ordre");
                            Ordre nyOrdre = ordre.opretOrdre();
                            bestillinger.tilføjOrdreTilBestillinger(nyOrdre);
                            bestillinger.beregnVentetid(bestillinger.getBestillinger().indexOf(nyOrdre));

                            System.out.println("Nuværende bestillinger:");
                            bestillinger.visBestillinger();
                            gui.opdaterVindue(bestillinger.getBestillinger(), gui.getTabel());

                        }

                        else if (choice == 2) {
                            bestillinger.visBestillinger();
                            System.out.println("Indtast nr på den ordre du vil afslutte?");
                            int afslutNr = scn.nextInt() - 1;
                            // fjerner ordre fra bestillinger - tilføjes til arraylist i Statistikklassen og skrives til csv-fil
                            statistik.tilføjPizzaTilStatistik(bestillinger.afslutOrdre(bestillinger.getBestillinger().get(afslutNr)));
                            statistik.tilføjPizzaTilFil();
                            gui.opdaterVindue(bestillinger.getBestillinger(), gui.getTabel());

                        } else if (choice == 3) {
                            System.out.println("Her er hovedmenuen");
                            break;

                        } else {
                            System.out.println("Forkert indtastning - Tast 1, 2 eller 3");
                            continue;
                        }

                    }
                    break;

                //Valg 3 - Skift Pizza
                case 3:

                    subMenuPizza();
                    int choice1 = scn.nextInt();

                    if (choice1 == 1) {
                        System.out.println("Du har valgt at tilføje en ny pizza til menukortet");
                        menukort.opretNyPizza(pizzaListe);
                        break;
                    }

                    else if (choice1 == 2){
                        System.out.println("Du har valgt at fjerne en pizza fra menukortet");
                        menukort.fjernPizza(pizzaListe);
                        break;
                        }

                    else if (choice1 == 3){
                        System.out.println("Du har valgt at ændre en pizza på menukortet");
                        menukort.lavOmPåPizza(pizzaListe);
                        break;
                    }

                    else if (choice1 == 4) {
                        break;
                    }

                    else {

                        System.out.println("Forkert indtastning - prøv igen");
                        break;
                    }

                case 4:

                    int option = 0;

                    while (option != 6) {
                        System.out.println("Håndter Drikkevare");
                        drikkevareMenu();
                        int valg2 = scn.nextInt();

                        if (valg2 == 1) {
                            menukort.visDrikkevarer();
                            System.out.println();

                        } else if (valg2 == 2) {
                            menukort.opretDrikkevarer();

                        } else if (valg2 == 3) {
                            menukort.fjernDrikkevarer();

                        } else if (valg2 == 4) {
                            menukort.lavOmPåDrikkevare();

                        } else if (valg2 == 5){
                            ordre.tilføjDrikkevare();
                        }

                        else if (valg2 == 6) {
                        break;

                        }

                        else {
                            System.out.println("Forkert indtastning - prøv igen");
                        continue;

                        }

                    }

                    break;



                case 5:
                    System.out.println("Du har valgt at afslutte");
                    gui.lukVindue();
                    afslut = true;
                    break;

                default:
                    System.out.println("Forkert indtastning - prøv igen");

            }

        }

    }


    public void presentMenuOptions(){
        System.out.println();
        System.out.println("Du har følgende valg:");
        System.out.println("Tast 1 - Se Menukort");
        System.out.println("Tast 2 - Håndter ordrer");
        System.out.println("Tast 3 - Håndter Menukortet");
        System.out.println("Tast 4 - Håndter Drikkevare");
        System.out.println("Tast 5 - Afslut");
    }

    public void subMenuOrdre (){
        System.out.println("Håndter ordre - Du har følgende valg:");
        System.out.println("Tast 1 - Opret ordre");
        System.out.println("Tast 2 - Afslut ordre");
        System.out.println("Tast 3 - Gå til Hovedmenu");
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
        System.out.println("Tast 2 - Tilføj en drik til menukortet");
        System.out.println("Tast 3 - Fjern en drik på menukortet");
        System.out.println("Tast 4 - Ændre i en drik på menukortet");
        System.out.println("Tast 5 - Sælg Drikkevare");
        System.out.println("Tast 6 - Gå tilbage");

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
}
