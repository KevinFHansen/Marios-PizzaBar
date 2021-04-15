package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Ordre;


import java.sql.Time;
import java.util.ArrayList;

public class Statistik {

    private int omsætning;
    private Time periode;
    private int antalPizzaSolgt;
    public static ArrayList<Ordre> listeAfOrdre = new ArrayList<>();


    public void opretStatistik(){
        Statistik nyStatistik = new Statistik();

    }


    public void tilføjOrdreTilStatisk(Ordre ordreTilStatistik){



        listeAfOrdre.add(ordreTilStatistik);


    }

    public void visOmsætning(){


    }

    public void beregnOmsætning(){


       // listeAfSolgtePizza.
       // Ordre.getOrdreListe();
      //  Pizza.getPris();


    }

    public void visAntalPizza(){

    }
}

