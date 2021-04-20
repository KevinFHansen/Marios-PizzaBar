package bestillingssystem;

import Menukort_Pizza.Pizza;
import Statistik.Statistik;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bestillingsliste {

    // attributter
    private ArrayList<Ordre> bestillinger = new ArrayList<>();
    static int ventetid;


    // getter
    public int getVentetid() {
        return ventetid;
    }

    public ArrayList<Ordre> getBestillinger(){
        return bestillinger;
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
            System.out.println((i+1) + ". " + "Afhentningstidspunkt: " + bestillinger.get(i).getAfhentningstidspunkt() + " Ordre: " +
                    bestillinger.get(i).getOrdreListe() + " ordreID: " + bestillinger.get(i).getOrdreId());
        }
    }


    public ArrayList<Pizza> afslutOrdre(Ordre ordreTilAfslut) {

        ArrayList<Pizza> pizTilStat = new ArrayList<>();

        for (int i = 0; i < ordreTilAfslut.getOrdreListe().size(); i++) {
            pizTilStat.add(ordreTilAfslut.getOrdreListe().get(i));
        }


        bestillinger.remove(ordreTilAfslut);
        return pizTilStat;

    }

    @Override
    public String toString() {
        return "Bestillingsliste{" +
                "bestillinger=" + bestillinger +
                ", ventetid=" + ventetid +
                '}';
    }
}

