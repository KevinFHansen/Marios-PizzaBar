package bestillingssystem;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;


public class Bestillingsliste {


    // attributter
    private ArrayList<Ordre> bestillinger = new ArrayList<Ordre>();
    private int ventetid;


    // constructor
    public Bestillingsliste(ArrayList<Ordre> bestillinger, int ventetid){
        this.bestillinger = bestillinger;
        this.ventetid = ventetid;
    }


    // metoder

    public void tilføjOrdreTilBestillinger(Ordre ordreTilBestillinger){
        bestillinger.add(ordreTilBestillinger);

    }

    public int beregnAfhentningstidspunkt(int ventetid, int getsamletProduktionstid){
        int afhentningstidspunkt = ventetid + getsamletProduktionstid;
        return afhentningstidspunkt;
    }

    public void printBestillinger(){
        System.out.println(bestillinger);
    }


    public static void main(String[] args) {
        Ordre nyOdre = new Ordre();

        System.out.println(nyOdre);

        Bestillingsliste første = new Bestillingsliste(null,20);

        første.printBestillinger();

    }



}
