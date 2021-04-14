package bestillingssystem;

import java.time.LocalTime;
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


    public int getVentetid() {
        return ventetid;
    }

    public void setVentetid(int ventetid) {
        this.ventetid = ventetid;
    }


    // metoder afslut ordre
    public void tilføjOrdreTilBestillinger(Ordre ordreTilBestilling){
        bestillinger.add(ordreTilBestilling);
    }

    public int beregnVentetid(ArrayList<Ordre> bestillinger){
        int ventetid = 0;
        for (int i = 0; i < bestillinger.size(); i++){
            ventetid = ventetid + bestillinger.get(i).getSamletProduktionstid();
        }

        return ventetid;
    }

    public void visBestillinger(){
        Collections.sort(bestillinger, new Comparator<Ordre>() {
            @Override
            public int compare(Ordre o1, Ordre o2) {
                return Integer.valueOf(o1.getAfhentningstidspunkt().compareTo(o2.getAfhentningstidspunkt()));
            }
        });
        for (int i = 0; i < bestillinger.size(); i++){
            System.out.println("Afhentningstidspunkt: " + bestillinger.get(i).getBestillingstidspunkt() + " Bestillinger: " +
                    bestillinger.get(i).getOrdreListe() + " ordreID: " + bestillinger.get(i).getOrdreId());

        }

    }

    public void afslutOrdre(Ordre ordreAfslut){
        // tilføj ordre til statistik
        bestillinger.remove(ordreAfslut);





    }


}
