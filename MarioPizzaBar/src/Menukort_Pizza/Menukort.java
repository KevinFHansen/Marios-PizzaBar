package Menukort_Pizza;
import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ObjectOutputStream;

public class Menukort{
    private String dato;
    public ArrayList<Pizza> pizzaListe = new ArrayList<>();


    public ArrayList<Pizza> instans()throws FileNotFoundException{

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

        return pizzaListe;
    }

    public static void main(String[] args) throws IOException {
        Menukort psv = new Menukort();
        ArrayList<Pizza> pizzaListe =  psv.instans();
        pizzaListe.toString();
        psv.instans();
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


    public void opretNyPizza(){
        Scanner scanNewPizza = new Scanner(System.in);
        System.out.println("Tast hvor på menu kortet den nye pizza skal placeres");
        int hvor = scanNewPizza.nextInt()-1;

        System.out.println("Tast pris, navn, nummer, og fyld på din nye Pizza");

        Pizza nyPizza = new Pizza(scanNewPizza.nextInt(), scanNewPizza.next(), hvor+1, scanNewPizza.next());
        pizzaListe.add(hvor, nyPizza);
        System.out.println("Dette er ny pizza: " + nyPizza);
    }

    public void skiftPizza () throws IOException {
        Scanner scn = new Scanner(System.in);
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv.txt");

        System.out.println("Indtast nr på pizza der skal ændres");
        int pizzaNr = scn.nextInt()-1;
        pizzaListe.remove(pizzaNr);

        try {
            FileOutputStream filUd = new FileOutputStream(fout);
            ObjectOutputStream objektUd = new ObjectOutputStream(filUd);
            System.out.println("Skriv pris, navn og fyld på den pizza der skal ændres");
            Pizza pizzaFix = new Pizza(scn.nextInt(), scn.next(), pizzaNr, scn.next());
            objektUd.writeObject(pizzaFix);
            pizzaListe.add(pizzaNr, pizzaFix);
            objektUd.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }



        /*
        int pris1;
        String navn2;
        int nummer3;
        String fyld4;
        try {
            Pizza pizza = new Pizza(pris1 = scn.nextInt(), navn2  = scn.nextLine(), nummer3 = scn.nextInt(), fyld4 = scn.next());
            out.write(pris1);
            out.write(navn2);
            out.write(nummer3);
            out.write(fyld4);
            pizzaListe.add(pizzaNr,pizza);
            out.close();
        }catch (Exception e){
            return;
        }
        */

        /*
        System.out.println(pizzaListe);



        System.out.println("Tast pris, navn og fyld på den ændret Pizza");
        Pizza pizzaÆndring = new Pizza(scn.nextInt(), scn.next(), pizzaNr+1,scn.next());
        */

    }

    public void omPizza() throws FileNotFoundException {
        Scanner scn = new Scanner(System.in);
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv.txt");

        PrintWriter writer = new PrintWriter(fout);
        writer.println("");
        writer.close();




    }

}
