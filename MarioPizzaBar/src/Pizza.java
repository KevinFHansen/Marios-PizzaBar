import java.util.Scanner;

public class Pizza {
    private int pris;
    private String navn;
    private int pizzaNummer;
    private String fyld;
    private int produktionstid;

    public Pizza (int pris, String navn, int pizzaNummer, String fyld, int produktionstid){
        this.pris = pris;
        this.navn = navn;
        this.pizzaNummer = pizzaNummer;
        this.fyld = fyld;
        this.produktionstid = produktionstid;
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

    public void setProduktionstid(int produktionstid) {
        this.produktionstid = produktionstid;
    }


    public static void skiftPizza(){

    }

    public static void opretNyPizza(){
        Scanner scanNewPizza = new Scanner(System.in);
        Pizza nyPizza = new Pizza(scanNewPizza.nextInt(), scanNewPizza.nextLine(), scanNewPizza.nextInt(), scanNewPizza.nextLine(), scanNewPizza.nextInt());



    }
}
