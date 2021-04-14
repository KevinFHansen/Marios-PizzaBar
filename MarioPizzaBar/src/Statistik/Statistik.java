package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Ordre;


import java.sql.Time;
import java.util.ArrayList;

public class Statistik {

    private int omsætning;
    private Time periode;
    private int antalPizzaSolgt;
    public static ArrayList<Pizza> listeAfSolgtePizza = new ArrayList<>();

    Ordre Ordre = new Ordre();
    Pizza Pizza = new Pizza();


    public void visOmsætning(){


    }

    /*public void beregnOmsætning(){

        listeAfSolgtePizza.add(Pizza);
       // listeAfSolgtePizza.
       // Ordre.getOrdreListe();
      //  Pizza.getPris();


    }*/

    public void visAntalPizza(){

    }
}

