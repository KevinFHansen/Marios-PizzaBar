package Menukort_Pizza;
import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menukort{
    private String dato;
    public static ArrayList<Pizza> pizzaListe = new ArrayList<>();


    public void instans()throws FileNotFoundException {
        File pizzaer = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv.txt");
        Scanner filScanner = new Scanner(pizzaer);

        filScanner.nextLine();

        while(filScanner.hasNext()){
            String denneLinje = filScanner.nextLine();

            String[] linjeSomArray = denneLinje.split(";");

            int pris = Integer.parseInt(linjeSomArray[0].trim());
            String pizzaNavne = linjeSomArray[1].trim();
            int nummer = Integer.parseInt(linjeSomArray[2].trim());
            String fyld = linjeSomArray[3].trim();

            Pizza tmpPizza = new Pizza(pris,pizzaNavne,nummer,fyld);
            pizzaListe.add(tmpPizza);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Menukort psv = new Menukort();
        psv.instans();
        psv.visPizzaListe();
        psv.skiftPizza();
    }

    public ArrayList<Pizza> getPizzaListe(){
        return this.pizzaListe;
    }


    public void visPizzaListe(){
        System.out.println(pizzaListe);
    }

    public void fjernPizza(){
    Scanner scn = new Scanner(System.in);
        System.out.print("Indtast nummer på pizza der skal fjernes: ");
        int fjern = scn.nextInt();
        pizzaListe.remove(fjern);
        System.out.println(pizzaListe);
    }


    public static void opretNyPizza(){
        Scanner scanNewPizza = new Scanner(System.in);
        System.out.println("Tast hvor på menu kortet den nye pizza skal placeres");
        int hvor = scanNewPizza.nextInt()-1;

        System.out.println("Tast pris, navn, nummer, og fyld på din nye Pizza");

        Pizza nyPizza = new Pizza(scanNewPizza.nextInt(), scanNewPizza.next(), hvor+1, scanNewPizza.next());
        pizzaListe.add(hvor, nyPizza);
        System.out.println("Dette er ny pizza: " + nyPizza);
    }

    public static void skiftPizza(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Indtast nr på pizza der skal ændres");
        int pizzaNr = scn.nextInt()-1;

        pizzaListe.remove(pizzaListe.get(pizzaNr));

        System.out.println("Tast pris, navn og fyld på den ændret Pizza");
        Pizza pizzaÆndring = new Pizza(scn.nextInt(), scn.next(), pizzaNr+1,scn.next());

        pizzaListe.add(pizzaNr,pizzaÆndring);

        System.out.println(pizzaListe);
    }

}
