package bestillingssystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Menukort_Pizza.Drikkevarer;
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
    private ArrayList<Drikkevarer> salgAfDrikkeVare = new ArrayList<>();
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
        String pizzaer = ordreListe.get(0).toString();

        for (int i = 1; i < ordreListe.size(); i++) {
            pizzaer = pizzaer + "\n" + ordreListe.get(i).toString();
        }

        String ordreStreng[] = {String.valueOf(afhentningstidspunkt), ordreId, pizzaer, kommentar};

        return ordreStreng;
    }

    public void tilføjDrikkevare() throws FileNotFoundException {
        System.out.println("Vil du tilføje drikkevare?");
        System.out.println("Tast 1 - JA");
        System.out.println("Tast 2 - NEJ");
        Menukort menukort = new Menukort();
        ArrayList<Drikkevarer> drikkevareListe = menukort.getDrikkevarerListe();

        Scanner scanDrikkevare = new Scanner(System.in);

        int valgDrikkevare = sc.nextInt();

        while (!stopDrikkevare)

            switch (valgDrikkevare) {

                case 1:
                    drikkevareMenu();

                    int valg1 = scanDrikkevare.nextInt();

                    if (valg1 < 5 || valg1 > 0) {
                        // salgAfDrikkeVare.add(drikkevareListe.get(scanDrikkevare.nextInt() - 1));
                        salgAfDrikkeVare.add(drikkevareListe.get(scanDrikkevare.nextInt() - 1));
                        System.out.println(drikkevareListe);
                        break;
                    } else if (valg1 == 5) {
                        break;
                    }

                case 2: {
                    stopDrikkevare = true;

                }
            }
    }

        public void drikkevareMenu () {
            System.out.println("Tast nr. på den drikkevare du vil tilføje ordren");
            System.out.println("Tast 1 - Tilføj Sodavand (20 kr.)");
            System.out.println("Tast 2 - Tilføj Vin (25 kr.)");
            System.out.println("Tast 3 - Tilføj Øl (25 kr.)");
            System.out.println("Tast 4 - Tilføj Vand (20 kr.)");
            System.out.println("Tast 5 - Gå tilbage");
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

