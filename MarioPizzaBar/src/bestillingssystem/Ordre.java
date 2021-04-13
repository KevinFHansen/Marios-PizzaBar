package bestillingssystem;

import java.util.ArrayList;
import Menukort_Pizza.Pizza;
import java.util.Scanner;
import java.time.LocalTime;

import static Menukort_Pizza.Menukort.pizzaListe;

public class Ordre {
    Scanner sc = new Scanner(System.in);

    // Atributter
    private int ordreId;
    private LocalTime bestillingstidspunkt;
    private int samletProduktionstid;
    private int afhentningstidspunkt;
    private ArrayList<Pizza> ordreListe = new ArrayList<Pizza>();

    // Constructor
    public Ordre(int ordreId, int samletProduktionstid,
                 int afhentningstidspunkt, ArrayList<Pizza> ordreListe){
        this.ordreId = ordreId;
        this.bestillingstidspunkt = bestillingstidspunkt.now();
        this.samletProduktionstid = samletProduktionstid;
        this.afhentningstidspunkt = afhentningstidspunkt;
        this.ordreListe = ordreListe;

    }

    // Getters
    public int getOrdreId(){
        return this.ordreId;
    }

    public int getBestillingstidspunkt(){
        return this.bestillingstidspunkt;
    }

    public int getSamletProduktionstid(){
        return this.samletProduktionstid;
    }

    public int getAfhentningstidspunkt(){
        return this.afhentningstidspunkt;
    }

    public ArrayList<Pizza> getOrdreListe(){
        return this.ordreListe;
    }

    // Setters
    public void setOrdreId(int ordreId){
        this.ordreId = ordreId;
    }

    public void setBestillingstidspunkt(int bestillingstidspunkt){
        this.bestillingstidspunkt = bestillingstidspunkt;
    }

    public void setSamletProduktionstid(int samletProduktionstid){
        this.samletProduktionstid = samletProduktionstid;
    }

    public void setAfhentningstidspunkt(int afhentningstidspunkt){
        this.afhentningstidspunkt = afhentningstidspunkt;
    }


    public void opretOrdre(){

        System.out.println(pizzaListe);

        Ordre nyOrdre = new Ordre();

    }

    public void tilføjPizza(){

    }

    public void anullerPizza(){

    }

    public void afslutOrdre(){

    }

    public void ændreAfhentningstidspunkt(){

    }

    public void ordreKommentar(){

    }
}
