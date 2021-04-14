package bestillingssystem;

import java.time.LocalTime;
import java.util.ArrayList;

public class Bestillingsliste {

    // attributter
    private ArrayList<Ordre> bestillinger = new ArrayList<Ordre>();
    private int ventetid = 10;


    // constructor
    public Bestillingsliste(ArrayList<Ordre> bestillinger, int ventetid){
        this.bestillinger = bestillinger;
        this.ventetid = ventetid;
    }

    // metoder
    public void tilføjOrdreTilBestillinger(Ordre ordreTilBestilling){
        bestillinger.add(ordreTilBestilling);
    }

    public static int beregnAfhentningsTidspunkt(int ventetid, int produktionstid, LocalTime bestillingstidspunkt){
        //LocalTime afhentningstidspunkt = bestillingstidspunkt + ventetid + produktionstid;
        //return afhentningstidspunkt;
    }

    public void visBestillinger(){
        System.out.println(bestillinger);
    }




}
