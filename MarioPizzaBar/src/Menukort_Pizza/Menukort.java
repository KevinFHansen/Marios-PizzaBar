package Menukort_Pizza;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;

public class Menukort{
    private String dato;
    public ArrayList<Pizza> pizzaListe = new ArrayList<>();
    Scanner scn = new Scanner(System.in);



    public ArrayList<Pizza> indlæsMenukort()throws FileNotFoundException{

        File pizzaer = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv");
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
        Menukort menukort = new Menukort();
        menukort.setPizzaListe(menukort.indlæsMenukort());

        System.out.println(menukort.pizzaListe);

        menukort.opretNyPizza();
        System.out.println(menukort.pizzaListe);
    }

    public ArrayList<Pizza> getPizzaListe(){
        return this.pizzaListe;
    }

    public void setPizzaListe(ArrayList<Pizza> pizzaListe){
        this.pizzaListe = pizzaListe;
    }


    public void visPizzaListe(){
        System.out.println(pizzaListe);
    }


    public void fjernPizza() throws FileNotFoundException {
        System.out.println("Skriv nummer på pizza der skal fjernes");
        int fjernNummer = scn.nextInt();
        pizzaListe.remove(fjernNummer-1);
        lavNytKort();

    }

    public void opretNyPizza() throws FileNotFoundException {
        System.out.println("Indtast nr på pizza der skal laves");
        int pizzaNr = scn.nextInt()-1;
        scn.nextLine();

        System.out.println("Indtast navn på pizza");
        String nyPizzaNavn = scn.nextLine();

        System.out.println("Indtast fyld");
        String nyPizzaFyld = scn.nextLine();

        System.out.println("Indtast pris");
        int nyPizzaPris = scn.nextInt();

        Pizza pizzaFix = new Pizza(nyPizzaPris, nyPizzaNavn, pizzaNr+1, nyPizzaFyld);
        pizzaListe.add(pizzaNr, pizzaFix);
        lavNytKort();
    }

    public void lavOmPåPizza() throws IOException {
        //Scanner scn = new Scanner(System.in);
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv");

        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("pris;navn;nummer;fyld");

        System.out.println("Indtast nr på pizza der skal ændres");
        int pizzaNr = scn.nextInt()-1;
        scn.nextLine();
        pizzaListe.remove(pizzaNr);

        System.out.println("Indtast navn på pizza");
        String nyPizzaNavn = scn.nextLine();

        System.out.println("Indtast fyld");
        String nyPizzaFyld = scn.nextLine();

        System.out.println("Indtast pris");
        int nyPizzaPris = scn.nextInt();

        Pizza pizzaFix = new Pizza(nyPizzaPris, nyPizzaNavn, pizzaNr+1, nyPizzaFyld);
        pizzaListe.add(pizzaNr, pizzaFix);

        for(int i = 0; i < pizzaListe.size(); i++){
            writer.print(pizzaListe.get(i).getPris() + ";");
            writer.print(pizzaListe.get(i).getNavn() + ";");
            writer.print(pizzaListe.get(i).getPizzaNummer() + ";");
            writer.println(pizzaListe.get(i).getFyld());
        }
        writer.close();
    }

    public void lavNytKort() throws FileNotFoundException {
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv");

        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("pris;navn;nummer;fyld");

        for(int i = 0; i < pizzaListe.size(); i++){
            writer.print(pizzaListe.get(i).getPris() + ";");
            writer.print(pizzaListe.get(i).getNavn() + ";");
            writer.print(pizzaListe.get(i).getPizzaNummer() + ";");
            writer.println(pizzaListe.get(i).getFyld());
        }
        writer.close();
    }

}
