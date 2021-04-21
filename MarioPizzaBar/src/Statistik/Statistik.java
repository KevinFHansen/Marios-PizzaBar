package Statistik;
import Menukort_Pizza.Drikkevarer;
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
    private ArrayList<Drikkevarer> drikkevarerStat = new ArrayList<>();

    public Statistik(int pizzaNr, int omsætning) {
        this.omsætning = omsætning;
        this.pizzaNr = pizzaNr;

    }

    // getters og setters
    public void setOmsætning(int omsætning) {
        this.omsætning = omsætning;
    }

    public int getOmsætning(){
        return this.omsætning;
    }

    public int getPizzaNr(){
        return this.pizzaNr;
    }



   public void tilføjPizzaTilStatistik(ArrayList<Pizza> pizzaTilStat) {

        for (int i = 0; i < pizzaTilStat.size(); i ++){
            pizzaStatistik.add(pizzaTilStat.get(i));
        }
   }

  public void tilføjDrikkevarerTilStat(ArrayList<Drikkevarer> drikkeStat){

        for (int i = 0; i < drikkeStat.size(); i++){
            drikkevarerStat.add(drikkeStat.get(i));
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

    public void tilføjDrikkeTilFil() throws IOException {

        File fout = new File("MarioPizzaBar/Ressourcer/Statistik.csv");

        FileWriter writer = new FileWriter(fout, true);


        for(int i = 0; i < drikkevarerStat.size(); i++){
            writer.append(drikkevarerStat.get(i).getTypeDrikkevare() + ";");
            writer.append(drikkevarerStat.get(i).getPrisPåDrikkevare() + ";");
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
            String dato = linjeSomArray[2].trim();


            Statistik tmpStat = new Statistik(nummer, pris);
            nummerOgPris.add(tmpStat);


        }
        return nummerOgPris;

    }


    public String beregnOmsætningFraFil(ArrayList<Statistik> priserFraFil){
        int omsætningFraFil = 0;
        for (int i = 0; i < priserFraFil.size(); i ++){
            omsætningFraFil = omsætningFraFil + priserFraFil.get(i).getOmsætning();

        }
        return "Omsætning: " + omsætningFraFil + " kr.";
    }

    /* mest solgte og samlet antal pizzaer
    public String mestSolgtePizza(ArrayList<Statistik> numreFraFil){

        int antalPizza = 0;

        for (int i = 0 ; i < numreFraFil.size(); i++){
            antalPizza++;
        }
        int element = 0;
        int count = 0;

        for( int i = 0 ; i < numreFraFil.size(); i ++){

            int tempEl = numreFraFil.get(i).getPizzaNr();
            int tempCount = 0;

            for (int j = 0; j < numreFraFil.size(); j++)
                if (numreFraFil.get(i).getPizzaNr() == tempEl)
                    tempCount++;
            if (tempCount>count){
                element = tempEl;
                count = tempCount;
            }
        }

        return "Total antal pizza: " + antalPizza + "\n" +
                "Den mest solgte pizza er nr: " + element + " Antal: " + count;
    }
*/
    @Override
    public String toString() {
        return "Statistik { " +
                " omsætning = " + omsætning +
                ", pizzaNr = " + pizzaNr +
                '}';
    }
}

