package statistik;
import menukort_pizza.Drikkevarer;
import menukort_pizza.Pizza;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
        pizzaStatistik.clear();
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
        drikkevarerStat.clear();
    }


    @Override
    public String toString() {
        return "Statistik { " +
                " omsætning = " + omsætning +
                ", pizzaNr = " + pizzaNr +
                '}';
    }
}

