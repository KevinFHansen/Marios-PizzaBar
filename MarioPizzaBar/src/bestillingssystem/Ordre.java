package bestillingssystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Menukort_Pizza.Menukort;
import Menukort_Pizza.Pizza;
import java.util.Scanner;
import java.time.LocalTime;

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


    public Ordre opretOrdre()throws FileNotFoundException{

        Ordre nyOrdre = new Ordre();

        System.out.println("Indtast kundens navn");
        nyOrdre.setOrdreId(sc.nextLine());
        nyOrdre.setBestillingstidspunkt(bestillingstidspunkt.now());

        // ordreListe
        nyOrdre.tilføjPizza();

        // samletProduktionstid
        nyOrdre.setSamletProduktionstid(8 + (ordreListe.size() * 2));

        // Tilføj kommentar
        nyOrdre.ordreKommentar();

        // afhentningstidspunkt - mangler ventetid
        nyOrdre.setAfhentningstidspunkt(bestillingstidspunkt.plusMinutes(Bestillingsliste.ventetid + nyOrdre.getSamletProduktionstid()));

        // godkend afhentningstidspunkt
        System.out.println("1. for at godkende afhentningstidspunktet \n2. for at ændre afhentningstidspunktet");

        if(sc.nextInt() == 2){
            nyOrdre.ændreAfhentningstidspunkt();
        }

        return nyOrdre;
    }

    public void tilføjPizza()throws FileNotFoundException {
        boolean flag = true;

        Menukort menukort = new Menukort();

        ArrayList<Pizza> pizzaListe = menukort.indlæsMenukort();

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

    public String[] ordreStreng() {
        String pizzaer = ordreListe.get(0).toString();

        for (int i = 1; i < ordreListe.size(); i++) {
            pizzaer = pizzaer + "\n" +  ordreListe.get(i).toString();
        }

        String ordreStreng[] = {String.valueOf(afhentningstidspunkt), ordreId, pizzaer, kommentar};

        return ordreStreng;
    }


    @Override
    public String toString() {
        return "Ordre{" +
                "ordreId='" + ordreId + '\'' +
                ", bestillingstidspunkt=" + bestillingstidspunkt +
                ", samletProduktionstid=" + samletProduktionstid +
                ", afhentningstidspunkt=" + afhentningstidspunkt +
                ", kommentar='" + kommentar + '\'' +
                ", ordreListe=" + ordreListe +
                '}';
    }
}
