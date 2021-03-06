package bestillingssystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import menukort_pizza.Drikkevarer;
import menukort_pizza.Menukort;
import menukort_pizza.Pizza;
import statistik.Statistik;

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
    static ArrayList<Drikkevarer> salgAfDrikkeVare = new ArrayList<>();
    boolean stopDrikkevare = false;

    // Getters
    public String getOrdreId() {
        return this.ordreId;
    }

    public LocalTime getBestillingstidspunkt() {
        return this.bestillingstidspunkt;
    }

    public int getSamletProduktionstid() {
        return this.samletProduktionstid;
    }

    public LocalTime getAfhentningstidspunkt() {
        return this.afhentningstidspunkt;
    }

    public ArrayList<Pizza> getOrdreListe() {
        return this.ordreListe;
    }

    public String getKommentar() {
        return this.kommentar;
    }

    public ArrayList<Drikkevarer> getSalgAfDrikkeVare() {
        return salgAfDrikkeVare;
    }

    // Setters
    public void setOrdreId(String ordreId) {
        this.ordreId = ordreId;
    }

    public void setBestillingstidspunkt(LocalTime bestillingstidspunkt) {
        this.bestillingstidspunkt = bestillingstidspunkt;
    }

    public void setSamletProduktionstid(int samletProduktionstid) {
        this.samletProduktionstid = samletProduktionstid;
    }

    public void setAfhentningstidspunkt(LocalTime afhentningstidspunkt) {
        this.afhentningstidspunkt = afhentningstidspunkt;
    }

    public void setKommentar(String ordreKommentar) {
        this.kommentar = ordreKommentar;
    }

    public void setSalgAfDrikkeVare(ArrayList<Drikkevarer> salgAfDrikkeVare) {
        this.salgAfDrikkeVare = salgAfDrikkeVare;
    }

    // Metoder
    public Ordre opretOrdre() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Ordre nyOrdre = new Ordre();

        System.out.println("Indtast kundens navn");

        nyOrdre.setOrdreId(sc.nextLine());

        nyOrdre.setBestillingstidspunkt(bestillingstidspunkt.now());

        // ordreListe
        nyOrdre.tilføjPizza();

        // samletProduktionstid
        nyOrdre.setSamletProduktionstid(8 + (ordreListe.size() * 2));

        // Tilføj kommentar
        System.out.println("Indtast kommentar til ordre");
        nyOrdre.setKommentar(sc.nextLine());

        // afhentningstidspunkt
        nyOrdre.setAfhentningstidspunkt(nyOrdre.getBestillingstidspunkt().plusMinutes(Bestillingsliste.ventetid + nyOrdre.getSamletProduktionstid()));
        nyOrdre.visOrdre();

        // godkend afhentningstidspunkt
        System.out.println("1. for at godkende afhentningstidspunktet \n2. for at ændre afhentningstidspunktet");

        if (sc.nextInt() == 2) {
            nyOrdre.ændreAfhentningstidspunkt();
        }

        return nyOrdre;
    }

    public void tilføjPizza() throws FileNotFoundException {
        boolean flag = true;

        Menukort menukort = new Menukort();

        ArrayList<Pizza> pizzaListe = menukort.indlæsMenukort();

        while (flag) {

            System.out.println("1. Tilføj pizza til ordren \n2. Godkend ordren");

            if (sc.nextInt() == 1) {
                System.out.println("Tast nr. på den pizza du vil tilføje ordren");
                ordreListe.add(pizzaListe.get(sc.nextInt() - 1));
            } else {
                flag = false;
            }

        }

    }

    public void ændreAfhentningstidspunkt() {

        System.out.println("Indtast antal minutter til ordren skal afhentes");

        LocalTime bestemtTidFærdig = bestillingstidspunkt.plusMinutes(sc.nextInt());

        setAfhentningstidspunkt(bestemtTidFærdig);
    }

    public void visOrdre() {
        System.out.println("[" + getOrdreId() + "] Afhentes: " + getAfhentningstidspunkt());

        for (int i = 0; i < ordreListe.size(); i++) {
            System.out.println(ordreListe.get(i).toString());
        }

        System.out.println("Kommentar: " + getKommentar());
    }

    public String[] ordreStreng() {
        String pizzaer = "Nr. " + String.valueOf(ordreListe.get(0).getPizzaNummer());

        for (int i = 1; i < ordreListe.size(); i++) {
            pizzaer = pizzaer + "\n" + "Nr. " + String.valueOf(ordreListe.get(i).getPizzaNummer());
        }

        String ordreStreng[] = {String.valueOf(afhentningstidspunkt), ordreId, pizzaer, kommentar};

        return ordreStreng;
    }

    public void tilføjDrikkevare() throws IOException {

        Menukort menukort = new Menukort();
        Statistik statistik = new Statistik(0,0);
        ArrayList<Drikkevarer> drikkevareListe = menukort.indlæsDrikkevare();

        System.out.println("Tast nummer på drikkevare");

        System.out.println("0. for at afslutte");

        menukort.visDrikkevarer();

        Scanner scnTypeDrikkevare = new Scanner(System.in);
        int valg1 = scnTypeDrikkevare.nextInt();


        if (valg1 <= drikkevareListe.size() && valg1 > 0) {
            salgAfDrikkeVare.add(drikkevareListe.get(valg1 - 1));
            statistik.tilføjDrikkevarerTilStat(salgAfDrikkeVare);
            statistik.tilføjDrikkeTilFil();
            salgAfDrikkeVare.clear();
        }

        else if (valg1 == 0) {
                stopDrikkevare = true;
        }

    }


        @Override
        public String toString () {
            return " Ordre {" +
                    "ordre Id=' " + ordreId + '\'' +
                    ", bestillingstidspunkt= " + bestillingstidspunkt +
                    ", samletProduktionstid= " + samletProduktionstid +
                    ", afhentningstidspunkt= " + afhentningstidspunkt +
                    ", kommentar=' " + kommentar + '\'' +
                    ", ordreListe= " + ordreListe +
                    '}';
        }
}

