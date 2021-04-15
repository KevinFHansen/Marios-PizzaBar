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
    private LocalTime afhentningstidspunkt;
    private String kommentar;
    private ArrayList<Pizza> ordreListe = new ArrayList<Pizza>();

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

    public LocalTime getAfhentningstidspunkt(){
        return this.afhentningstidspunkt;
    }

    public ArrayList<Pizza> getOrdreListe(){
        return this.ordreListe;
    }

    public String getKommentar(){
        return this.kommentar;
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

    public void setAfhentningstidspunkt(LocalTime afhentningstidspunkt){
        this.afhentningstidspunkt = afhentningstidspunkt;
    }

    public void setKommentar(String ordreKommentar){
        this.kommentar = ordreKommentar;
    }


    public void opretOrdre(){

        Ordre nyOrdre = new Ordre();

        System.out.println("Indtast kundens navn");
        nyOrdre.setOrdreId(sc.nextLine());
        nyOrdre.setBestillingstidspunkt(bestillingstidspunkt.now());

        // ordreListe
        nyOrdre.tilføjPizza();

        // samletProduktionstid
        int samletTid = (nyOrdre.ordreListe.size() - 1) * 2 + 10;
        nyOrdre.setSamletProduktionstid(samletTid);

        // Tilføj kommentar
        nyOrdre.ordreKommentar();

        // afhentningstidspunkt - mangler ventetid
        nyOrdre.setAfhentningstidspunkt(bestillingstidspunkt.plusMinutes(nyOrdre.getSamletProduktionstid()));

        // godkend afhentningstidspunkt
        System.out.println("1. for at godkende afhentningstidspunktet \n2. for at ændre afhentningstidspunktet");

        if(sc.nextInt() == 2){
            nyOrdre.ændreAfhentningstidspunkt();
        }
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

    public void ændreAfhentningstidspunkt(){

        System.out.println("Indtast antal minutter til ordren skal afhentes");

        LocalTime bestemtTidFærdig = bestillingstidspunkt.plusMinutes(sc.nextInt());

        setAfhentningstidspunkt(bestemtTidFærdig);
    }

    public void ordreKommentar(){

        System.out.println("Indtast kommentar til ordre");
        String kommentar = (sc.nextLine());

        setKommentar(kommentar);
    }

    public void visOrdre(){
        System.out.println("[" + getOrdreId() + "] Afhentes: " + getAfhentningstidspunkt());

        for(int i = 0; i < ordreListe.size(); i++){
            System.out.println(ordreListe.get(i).toString());
        }

        System.out.println("Kommentar: " + getKommentar());
    }
}
