package Menukort_Pizza;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menukort{
    private String dato;
    private ArrayList<Pizza> pizzaListe = new ArrayList<>();
    private ArrayList<Drikkevarer> drikkevarerListe = new ArrayList<>();
    Scanner scn = new Scanner(System.in);


    //indlæsning af menukort og drikkevarer
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

    public ArrayList<Drikkevarer> indlæsDrikkevare()throws FileNotFoundException{

        File drikkevare = new File("MarioPizzaBar/Ressourcer/Drikkevarer.csv");
        Scanner filScanner = new Scanner(drikkevare);

        filScanner.nextLine();

        while(filScanner.hasNext()){
            String denneLinje = filScanner.nextLine();

            String[] linjeSomArray = denneLinje.split(";");

            int nummerPåDrikkevare = Integer.parseInt(linjeSomArray[0]);
            String typeDrikkevare = linjeSomArray[1].trim();
            int prisPåDrikkevare = Integer.parseInt(linjeSomArray[2].trim());


            Drikkevarer tmpDrikkevare = new Drikkevarer(nummerPåDrikkevare, typeDrikkevare,prisPåDrikkevare);
            drikkevarerListe.add(tmpDrikkevare);
        }

        return drikkevarerListe;
    }



    //Getters og setters

    public ArrayList<Pizza> getPizzaListe() {
        return this.pizzaListe;
    }

    public void setPizzaListe(ArrayList<Pizza> pizzaListe){
        this.pizzaListe = pizzaListe;
    }

    public void setDrikkevarerListe(ArrayList<Drikkevarer> drikkevarerListe){
        this.drikkevarerListe = drikkevarerListe;
    }

    public ArrayList<Drikkevarer> getDrikkevarerListe() {
        return drikkevarerListe;
    }


    //Pizza metoder:

    public void visPizzaListe(ArrayList<Pizza> pizzaListe) throws FileNotFoundException {
        //Menukort menukort = new Menukort();
        System.out.println("Menukort");
        //menukort.setPizzaListe(menukort.indlæsMenukort());
        //menukort.pizzaListe.forEach(System.out::println);
        //pizzaListe.forEach(System.out::println);
        for(int i = 0; i < pizzaListe.size(); i++){
            System.out.println("Nr " + (i+1) + " " + pizzaListe.get(i).getNavn() + ": " + pizzaListe.get(i).getFyld() + " kr:" + pizzaListe.get(i).getPris());
        }
    }

    public void fjernPizza(ArrayList<Pizza> pizzaListe) throws FileNotFoundException{
        System.out.println("Skriv nummer på pizza der skal fjernes");
        int fjernNummer = scn.nextInt();
        pizzaListe.remove(fjernNummer-1);
        lavNytKort(pizzaListe);

    }

    public void opretNyPizza(ArrayList<Pizza> pizzaListe) throws FileNotFoundException {
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
        lavNytKort(pizzaListe);
    }

    public void lavOmPåPizza(ArrayList<Pizza> pizzaListe) throws IOException {
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

        lavNytKort(pizzaListe);

    }

    public void lavNytKort(ArrayList<Pizza> pizzaListe) throws FileNotFoundException {
        File fout = new File("MarioPizzaBar/Ressourcer/PizzaListe.csv");

        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("pris;navn;nummer;fyld");

        for(int i = 0; i < pizzaListe.size(); i++){
            writer.print(pizzaListe.get(i).getPris() + ";");
            writer.print(pizzaListe.get(i).getNavn() + ";");
            writer.print(i + 1 + ";");
            writer.println(pizzaListe.get(i).getFyld());
        }
        writer.close();
    }



    //Drikkevare metoder

    public void visDrikkevarer() throws FileNotFoundException {
        System.out.println("Dikkevarer");
        for(int i = 0; i < drikkevarerListe.size(); i++){
            System.out.println((drikkevarerListe.get(i).getNummerPåDrikkevare() + ": " + drikkevarerListe.get(i).getTypeDrikkevare() + " kr:" + drikkevarerListe.get(i).getPrisPåDrikkevare()));
        }
    }

    public void fjernDrikkevarer() throws FileNotFoundException {
        System.out.println("Skriv nummer på drikkevare der skal fjernes");
        int fjernNummer = scn.nextInt();
        drikkevarerListe.remove(fjernNummer-1);
        lavNytDrikkevarerKort();
    }

    public void opretDrikkevarer() throws FileNotFoundException{
        System.out.println("Indtast nr på drikkevare der skal laves");
        int drikkevareNr = scn.nextInt()-1;
        scn.nextLine();


        System.out.println("Indtast navn på drikkevare");
        String nyDrikkevare = scn.nextLine();

        System.out.println("Indtast pris");
        int nyDrikPris = scn.nextInt();

        Drikkevarer drikkevarerFix = new Drikkevarer(drikkevareNr+1, nyDrikkevare, nyDrikPris);
        drikkevarerListe.add(drikkevareNr,drikkevarerFix);
        lavNytDrikkevarerKort();
    }

    public void lavOmPåDrikkevare() throws FileNotFoundException {
        System.out.println("Indtast nr på drikkevare der skal ændres");
        int drikkeVareNr = scn.nextInt()-1;
        scn.nextLine();
        drikkevarerListe.remove(drikkeVareNr);

        System.out.println("Indtast navn på drikkevare");
        String nyDrikkevareNavn = scn.nextLine();

        System.out.println("Indtast pris");
        int nyDrikkevarePris = scn.nextInt();

        Drikkevarer drikkevarerFix = new Drikkevarer(drikkeVareNr+1, nyDrikkevareNavn, nyDrikkevarePris);
        drikkevarerListe.add(drikkeVareNr, drikkevarerFix);
        lavNytDrikkevarerKort();
    }

    public void lavNytDrikkevarerKort() throws FileNotFoundException{
        File fout = new File("MarioPizzaBar/Ressourcer/Drikkevarer.csv");

        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("nummerPåDrikkevare;typeDrikkevare;prisPåDrikkevare");

        for(int i = 0; i < drikkevarerListe.size(); i++){
            writer.print(drikkevarerListe.get(i).getNummerPåDrikkevare() + ";");
            writer.print(drikkevarerListe.get(i).getTypeDrikkevare() + ";");
            writer.println(drikkevarerListe.get(i).getPrisPåDrikkevare());
        }
        writer.close();
    }
}
