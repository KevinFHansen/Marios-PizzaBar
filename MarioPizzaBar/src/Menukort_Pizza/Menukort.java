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

        menukort.omPizza();

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
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv");

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

    public void omPizza() throws IOException {
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

}
