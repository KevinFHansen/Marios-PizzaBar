package bestillingssystem;

import java.util.ArrayList;
import Menukort_Pizza.Pizza;
import java.util.Scanner;
import java.time.LocalTime;

import static Menukort_Pizza.Menukort.pizzaListe;

public class Ordre {
    Scanner sc = new Scanner(System.in);

    // Atributter
    private String ordreId;
    private LocalTime bestillingstidspunkt;
    private int samletProduktionstid;
    private int afhentningstidspunkt;
    private ArrayList<Pizza> ordreListe = new ArrayList<Pizza>();

    // Constructor
    public Ordre(){
        this.ordreId = ordreId;
        this.bestillingstidspunkt = bestillingstidspunkt;
        this.samletProduktionstid = samletProduktionstid;
        this.afhentningstidspunkt = afhentningstidspunkt;
        this.ordreListe = ordreListe;

    }

    // Getters
    public String getOrdreId(){
        return this.ordreId;
    }

    public LocalTime getBestillingstidspunkt(){
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
    public void setOrdreId(String ordreId){
        this.ordreId = ordreId;
    }

    public void setBestillingstidspunkt(LocalTime bestillingstidspunkt){
        this.bestillingstidspunkt = bestillingstidspunkt;
    }

    public void setSamletProduktionstid(int samletProduktionstid){
        this.samletProduktionstid = samletProduktionstid;
    }

    public void setAfhentningstidspunkt(int afhentningstidspunkt){
        this.afhentningstidspunkt = afhentningstidspunkt;
    }


    public void opretOrdre(){

        Ordre nyOrdre = new Ordre();

        System.out.println("Indtast kundens navn");
        nyOrdre.setOrdreId(sc.nextLine());
        nyOrdre.setBestillingstidspunkt(bestillingstidspunkt.now());

        // ordreListe
        nyOrdre.tilføjPizza();

        // samletProduktionstid
        int samletTid = (nyOrdre.ordreListe.size() - 1) * 2 + nyOrdre.ordreListe(0).getProduktionstid;
        nyOrdre.setSamletProduktionstid();

        // afhentningstidspunkt


    }

    public void tilføjPizza(){
        boolean flag = true;

        while (flag) {

            System.out.println("1. Tilføj pizza til ordren \n2. Godkend ordren");

            if(sc.nextInt() == 1) {
                System.out.println("Tast nr. på den pizza du vil tilføje ordren");
                ordreListe.add(pizzaListe.get(sc.nextInt() - 1));

            }
            else {flag = false;}
        }
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
