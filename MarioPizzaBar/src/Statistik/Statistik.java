package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Bestillingsliste;
import bestillingssystem.Ordre;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistik {

    private int omsætning;
    private Time periode;
    private ArrayList<Pizza> pizzaFraCSV = new ArrayList<>();
    private ArrayList<Pizza> pizzaStatistik = new ArrayList<>();

    public void setPeriode(Time periode, int omsætning) {
        this.periode = periode;
        this.omsætning = omsætning;
    }


    public void setOmsætning(int omsætning) {
        this.omsætning = omsætning;
    }

    public int getOmsætning(){
        return this.omsætning;
    }



    public static void main(String[] args) throws FileNotFoundException {
        Statistik sta = new Statistik();
        Ordre ordre = new Ordre();
        ordre.tilføjPizza();
        Bestillingsliste b = new Bestillingsliste();
        b.tilføjOrdreTilBestillinger(ordre);
        System.out.println(b);


        System.out.println();


        sta.tilføjPizzaTilStatistik(b.afslutOrdre(ordre));

        System.out.println(sta.pizzaStatistik);

        sta.tilføjPizzaTilCsv();


    }

   public void tilføjPizzaTilStatistik(ArrayList<Pizza> pizzaTilStat) {

        for (int i = 0; i < pizzaTilStat.size(); i ++){
            pizzaStatistik.add(pizzaTilStat.get(i));
        }
   }


    public void tilføjPizzaTilCsv() throws FileNotFoundException {

        File fout = new File("MarioPizzaBar/Ressourcer/Statistik.csv");


        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("nummer;pris");


        for(int i = 0; i < pizzaStatistik.size(); i++){
            writer.print(pizzaStatistik.get(i).getPizzaNummer() + ";");
            writer.println(pizzaStatistik.get(i).getPris());
        }
        writer.close();
    }

    public ArrayList<Pizza> læsPizzaFraFil() throws FileNotFoundException{

        File pizzaFil = new File("MarioPizzaBar/Ressourcer/Statistik.csv");

        Scanner filScanner = new Scanner(pizzaFil);

        filScanner.nextLine();

        while(filScanner.hasNext()){
            String denneLinje = filScanner.nextLine();

            String[] linjeSomArray = denneLinje.split(";");

            int nummer = Integer.parseInt(linjeSomArray[0].trim());
            int pris = Integer.parseInt(linjeSomArray[1].trim());

            Pizza tmpPizza = new Pizza();
            pizzaFraCSV.add(tmpPizza);
        }



    }


    @Override
    public String toString() {
        return "Statistik{" +
                "omsætning=" + omsætning +
                ", periode=" + periode +
                ", Pizzaer=" + pizzaNumre;
    }


}

