package bestillingssystem;

import java.util.ArrayList;
import Menukort_Pizza.Pizza;
import java.util.Scanner;

public class Ordre {
    Scanner sc = new Scanner(System.in);

    // Atributter
    private int ordreId;
    private int bestillingstidspunkt;
    private int samletProduktionstid;
    private int afhentningstidspunkt;
    private ArrayList<Pizza> ordreListe = new ArrayList<Pizza>();

    // Constructor
    public Ordre(int ordreId, int bestillingstidspunkt, int samletProduktionstid,
                 int afhentningstidspunkt, ArrayList<Pizza> ordreListe){
        this.ordreId = ordreId;
        this.bestillingstidspunkt = bestillingstidspunkt;
        this.samletProduktionstid = samletProduktionstid;
        this.afhentningstidspunkt = afhentningstidspunkt;
        this.ordreListe = ordreListe;

    }

    public void opretOrdre(){
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
