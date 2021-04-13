package Menukort_Pizza;
import java.util.ArrayList;

public class Menukort {
    private String dato;
    private ArrayList<Pizza> pizzaListe = new ArrayList<Pizza>();

    public ArrayList<Pizza> getPizzaListe(){
        return this.pizzaListe;
    }




    public void visPizzaListe(){
        System.out.println(getPizzaListe());
    }

    public int fjernPizza(int indexAfPizza){
    getPizzaListe().remove(indexAfPizza);
    return indexAfPizza;
    }


}
