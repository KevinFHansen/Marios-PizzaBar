package bestillingssystem;

import java.util.ArrayList;

public class Ordre {
    // Atributter
    private int ordreId;
    private int bestillingstidspunkt;
    private int samletProduktionstid;
    private int afhentningstidspunkt;
    private ArrayList<Pizza> ordreListe = new ArrayList<>;

    // Constructor
    public Ordre(int ordreId, int bestillingstidspunkt, int samletProduktionstid,
                 int afhentningstidspunkt, ArrayList<Pizza> ordreListe;){
        this.ordreId = ordreId;
        this.bestillingstidspunkt = bestillingstidspunkt;
        this.samletProduktionstid = samletProduktionstid;
        this.afhentningstidspunkt = afhentningstidspunkt;
        this.ordreListe = ordreListe;

    }


}
