package bestillingssystem;

import Menukort_Pizza.Pizza;
import Statistik.Statistik;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bestillingsliste {

    // attributter
    private ArrayList<Ordre> bestillinger;
    private int ventetid;


    // constructor
    public Bestillingsliste(){
        this.bestillinger = new ArrayList<>();
    }

    // getter
    public int getVentetid() {
        return ventetid;
    }

    // setter
    public void setVentetid(int ventetid) {
        this.ventetid = ventetid;
    }


    // metoder

    // opretter instans af Bestillingsliste

    public void opretBestillingsliste(){
        Bestillingsliste nyBestillingsliste = new Bestillingsliste();
    }


    public void tilføjOrdreTilBestillinger(Ordre ordreTilBestillingsListe){
        bestillinger.add(ordreTilBestillingsListe);
    }


    public int beregnVentetid(){
        int ventetid = 0;
        for (int i = 0; i < bestillinger.size(); i++){
            ventetid = ventetid + bestillinger.get(i).getSamletProduktionstid();
            setVentetid(ventetid);
        } return ventetid;
    }

    public void visBestillinger(){
        Collections.sort(bestillinger, new Comparator<Ordre>() {
            @Override
            public int compare(Ordre o1, Ordre o2) {
                return Integer.valueOf(o1.getAfhentningstidspunkt().compareTo(o2.getAfhentningstidspunkt()));
            }
        });
        for (int i = 0; i < bestillinger.size(); i++){
            System.out.println("Afhentningstidspunkt: " + bestillinger.get(i).getAfhentningstidspunkt() + " Ordre: " +
                    bestillinger.get(i).getOrdreListe() + " ordreID: " + bestillinger.get(i).getOrdreId());
        }
    }

    public ArrayList<Pizza> afslutOrdre(Ordre ordreAfslut){

        ArrayList<Pizza> pizzaTilStatistik = new ArrayList<>();

        for (int i = 0; i < bestillinger.size(); i ++ ){
            pizzaTilStatistik.add(bestillinger.get(i).getOrdreListe().get(i));
        }

        bestillinger.remove(ordreAfslut);
        return pizzaTilStatistik;
    }

    @Override
    public String toString() {
        return " Bestillingsliste{" +
                "bestillinger=" + bestillinger +
                ", ventetid=" + ventetid +
                '}';
    }
}

