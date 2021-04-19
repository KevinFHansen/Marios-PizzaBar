package Statistik;
import Menukort_Pizza.Pizza;
import bestillingssystem.Bestillingsliste;
import bestillingssystem.Ordre;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;

public class Statistik {

    private int omsætning = 0;
    private Time periode;
    private int antalPizzaSolgt = 0;
    private ArrayList<Ordre> ordreStatistik = new ArrayList<>();



    public void setPeriode(Time periode) {
        this.periode = periode;
    }

    public void opretStatistik(){
        Statistik nyStatistik = new Statistik();


    }

    public void setOmsætning(int omsætning) {
        this.omsætning = omsætning;
    }

    public void setAntalPizzaSolgt(int antalPizzaSolgt) {
        this.antalPizzaSolgt = antalPizzaSolgt;
    }

    /*public ArrayList<Ordre> indlæsStatistik()throws FileNotFoundException{
        File Statistik = new File(MarioPizzaBar/Ressourcer/Statistik.csv);
    }*/

    public static void main(String[] args) throws FileNotFoundException {
        Statistik sta = new Statistik();
        Ordre n = new Ordre();
        n.tilføjPizza();
        Bestillingsliste b = new Bestillingsliste();
        b.afslutOrdre(n);
        System.out.println(sta.ordreStatistik);
        sta.tilføjOrdreTilCsv();
    }





    public void tilføjOrdreTilStatisk(Ordre ordreTilStatistik){
        ordreStatistik.add(ordreTilStatistik);
        /*int countPizza = 0;
        int countOmsætning = 0;
        for (int i = 0; i < ordreTilStatistik.getOrdreListe().size(); i++){
            ordreTilStatistik.getOrdreListe().get(i).getPizzaNummer();
            countPizza++;
            countOmsætning = countOmsætning + ordreTilStatistik.getOrdreListe().get(i).getPris();
        }
        setAntalPizzaSolgt(countPizza);
        setOmsætning(countOmsætning);*/
    }

    public void visOmsætning(){
        System.out.println(omsætning);

    }

    public void beregnOmsætning(){

       // listeAfSolgtePizza.
       // Ordre.getOrdreListe();
      //  Pizza.getPris();

    }

    public ArrayList<Integer> visAntalPizza() throws FileNotFoundException {


        ArrayList<Integer> pizzaNrListe = new ArrayList<>();
        for (int i = 0; i < ordreStatistik.size(); i ++){
            pizzaNrListe.add(ordreStatistik.get(i).getOrdreListe().get(i).getPizzaNummer());
        }
        return pizzaNrListe;

    }

    public void tilføjOrdreTilCsv() throws FileNotFoundException {
        File fout = new File("MarioPizzaBar/Ressourcer/Statistik.csv");

        PrintWriter writer = new PrintWriter(fout);

        for(int i = 0; i < ordreStatistik.size(); i++){
            writer.print(ordreStatistik.get(i).getOrdreListe().get(i).getPizzaNummer() + ";");
            writer.println(ordreStatistik.get(i).getOrdreListe().get(i).getPris());
        }
        writer.close();
    }




    @Override
    public String toString() {
        return "Statistik{" +
                "omsætning=" + omsætning +
                ", periode=" + periode +
                ", antalPizzaSolgt=" + antalPizzaSolgt +
                '}';
    }


}

