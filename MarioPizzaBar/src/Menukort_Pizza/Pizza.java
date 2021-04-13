package Menukort_Pizza;

import java.util.Scanner;

public class Pizza {
    private int pris;
    private String navn;
    private int pizzaNummer;
    private String fyld;
    private final int produktionstid = 10;



    public Pizza (int pris, String navn, int pizzaNummer, String fyld){
        this.pris = pris;
        this.navn = navn;
        this.pizzaNummer = pizzaNummer;
        this.fyld = fyld;

    }


    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNummer = pizzaNummer;
    }

    public String getFyld() {
        return fyld;
    }

    public void setFyld(String fyld) {
        this.fyld = fyld;
    }

    public int getProduktionstid() {
        return produktionstid;
    }




    public static void skiftPizza(){

    }

    public static void opretNyPizza1(){
        Scanner scanNewPizza = new Scanner(System.in);
        Pizza nyPizza = new Pizza(scanNewPizza.nextInt(), scanNewPizza.nextLine(), scanNewPizza.nextInt(), scanNewPizza.nextLine());
        System.out.println("Tast pris, navn, nummer, fyld, produktionstid på din nye Pizza");


    }
}
