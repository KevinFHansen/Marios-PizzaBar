package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Ordre;


import java.sql.Time;
import java.util.ArrayList;

public class Statistik {

    private int omsætning = 0;
    private Time periode;
    private int antalPizzaSolgt = 0;
    private ArrayList<Ordre> listeAfOrdre = new ArrayList<>();


    public void opretStatistik(){
        Statistik nyStatistik = new Statistik();

    }

    public void setOmsætning(int omsætning) {
        this.omsætning = omsætning;
    }

    public void setAntalPizzaSolgt(int antalPizzaSolgt) {
        this.antalPizzaSolgt = antalPizzaSolgt;
    }

    public void tilføjOrdreTilStatisk(Ordre ordreTilStatistik){
        listeAfOrdre.add(ordreTilStatistik);
        int countPizza = 0;
        int countOmsætning = 0;
        for (int i = 0; i < ordreTilStatistik.getOrdreListe().size(); i++){
            ordreTilStatistik.getOrdreListe().get(i).getPizzaNummer();
            countPizza++;
            countOmsætning = countOmsætning + ordreTilStatistik.getOrdreListe().get(i).getPris();
        }
        setAntalPizzaSolgt(countPizza);
        setOmsætning(countOmsætning);

    }

    public void visOmsætning(){
        System.out.println(omsætning);

    }

    public void beregnOmsætning(){


       // listeAfSolgtePizza.
       // Ordre.getOrdreListe();
      //  Pizza.getPris();


    }

    public void visAntalPizza(){


    }

    @Override
    public String toString() {
        return "Statistik{" +
                "omsætning=" + omsætning +
                ", periode=" + periode +
                ", antalPizzaSolgt=" + antalPizzaSolgt +
                '}';
    }
}

