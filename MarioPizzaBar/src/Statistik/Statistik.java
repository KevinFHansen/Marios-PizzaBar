package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Bestillingsliste;
import bestillingssystem.Ordre;


import java.io.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistik {

    private int pizzaNr;
    private int omsætning;
    private LocalDate dato = LocalDate.now();
    private ArrayList<Pizza> pizzaStatistik = new ArrayList<>();

    public Statistik(int pizzaNr, int omsætning) {
        this.omsætning = omsætning;
        this.pizzaNr = pizzaNr;

    }


    public void setOmsætning(int omsætning) {
        this.omsætning = omsætning;
    }

    public int getOmsætning(){
        return this.omsætning;
    }



    public static void main(String[] args) throws IOException {

        Statistik sta = new Statistik(0,0);

        Ordre ordre = new Ordre();
        ordre.tilføjPizza();
        Bestillingsliste b = new Bestillingsliste();
        b.tilføjOrdreTilBestillinger(ordre);
        System.out.println(b);


        System.out.println();


        sta.tilføjPizzaTilStatistik(b.afslutOrdre(ordre));

        System.out.println(sta.pizzaStatistik);

        sta.tilføjPizzaTilFil();

        System.out.println(sta.læsStatistikFraFil());

        System.out.println();

        System.out.println(sta.beregnOmsætningFraFil(sta.læsStatistikFraFil()));

        System.out.println();

        System.out.println(sta.mestSolgtePizza(sta.læsStatistikFraFil()));
    }

   public void tilføjPizzaTilStatistik(ArrayList<Pizza> pizzaTilStat) {

        for (int i = 0; i < pizzaTilStat.size(); i ++){
            pizzaStatistik.add(pizzaTilStat.get(i));
        }
   }


    public void tilføjPizzaTilFil() throws IOException {

        File fout = new File("MarioPizzaBar/Ressourcer/Statistik.csv");


        FileWriter writer = new FileWriter(fout, true);


        for(int i = 0; i < pizzaStatistik.size(); i++){
            writer.append(pizzaStatistik.get(i).getPizzaNummer() + ";");
            writer.append(pizzaStatistik.get(i).getPris() + ";");
            writer.append(dato.toString() + "\n");
        }
        writer.close();
    }

    public ArrayList<Statistik> læsStatistikFraFil() throws FileNotFoundException{

        File pizzaFil = new File("MarioPizzaBar/Ressourcer/Statistik.csv");

        Scanner filScanner = new Scanner(pizzaFil);

        ArrayList<Statistik> nummerOgPris = new ArrayList<Statistik>();

        filScanner.nextLine();

        while(filScanner.hasNext()){
            String denneLinje = filScanner.nextLine();

            String[] linjeSomArray = denneLinje.split(";");

            int nummer = Integer.parseInt(linjeSomArray[0].trim());
            int pris = Integer.parseInt(linjeSomArray[1].trim());


            Statistik tmpStat = new Statistik(nummer, pris);
            nummerOgPris.add(tmpStat);


        }
        return nummerOgPris;

    }


    // indtast dato for omsætning
    public String beregnOmsætningFraFil(ArrayList<Statistik> priserFraFil){
        int omsætningFraFil = 0;
        for (int i = 0; i < priserFraFil.size(); i ++){
            omsætningFraFil = omsætningFraFil + priserFraFil.get(i).getOmsætning();
        }
        return "Omsætning: " + omsætningFraFil + " kr.";
    }


    public String mestSolgtePizza(ArrayList<Statistik> numreFraFil){
        int element = 0;
        int count = 0;

        for( int i = 0 ; i < numreFraFil.size(); i ++){

            int tempEl = numreFraFil.get(i).pizzaNr;
            int tempCount = 0;

            for (int j = 0; j < numreFraFil.size(); j++)
                if (numreFraFil.get(i).pizzaNr == tempEl)
                    tempCount++;
            if (tempCount>count){
                element = tempEl;
                count = tempCount;
            }

        }
    return "Den mest solgte pizza er nr: " + element + " Antal: " + count;
    }

    @Override
    public String toString() {
        return "Statistik { " +
                " omsætning = " + omsætning +
                ", pizzaNr = " + pizzaNr +
                '}';
    }
}

