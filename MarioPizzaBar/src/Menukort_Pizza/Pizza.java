package Menukort_Pizza;

import java.util.ArrayList;
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

    public Pizza (){
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

    @Override
    public String toString() {
        return "Nr " + pizzaNummer + " " + navn + ": " + fyld + " kr:" + pris;
    }
}
