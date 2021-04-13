package Menukort_Pizza;
import java.awt.*;
import java.util.ArrayList;

public class Menukort{
    private String dato;
    public static ArrayList<Pizza> pizzaListe = new ArrayList<>();

    static {
        Pizza pizza1 = new Pizza(57, "Vesuvio", 1, "tomatsauce, ost, skinke og oregano");
        Pizza pizza2 = new Pizza(53, "Amerikaner", 2, "tomatsauce, ost, oksefars og oregano");
        Pizza pizza3 = new Pizza(57, "Cacciatore", 3, "tomatsauce, ost, kødsauce, cocktailpølser og oregano");
        Pizza pizza4 = new Pizza(63, "Carbona", 4, "tomatsauce, ost, skinke, pepperoni, cocktailpøler og oregano");
        Pizza pizza5 = new Pizza(57, "Bertil", 5, "tomatsauce, ost, bacon og oregano");
        Pizza pizza6 = new Pizza(63, "Dennis", 6, "tomatsauce, ost, pepperoni og oregano");
        Pizza pizza7 = new Pizza(61, "Silva", 7, "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano");
        Pizza pizza8 = new Pizza(61, "Victoria", 8, "tomatsauce, ost, skinke, ananas, champignon og oregano");
        Pizza pizza9 = new Pizza(61, "Toronfo", 9, "tomatsauce, ost, skinke, bacon kebab, chili og oregano");
        Pizza pizza10 = new Pizza(61, "Capricciosa", 10, "tomatsauce, ost, skinke, champignon og oregano");
        Pizza pizza11 = new Pizza(61, "Hawaii", 11, "tomatsauce, ost, skinke, ananas og oregano");
        Pizza pizza12 = new Pizza(61, "Le Blissola", 12, "tomatsauce, ost, skinke, rejer og oregano");
        Pizza pizza13 = new Pizza(61, "Venezia", 13, "tomatsauce, ost, skinke, bacon og oregano");
        Pizza pizza14 = new Pizza(64, "Mafia", 14, "tomatsauce, ost, pepperoni, bacon, løg og oregano");
        Pizza pizza15 = new Pizza(59, "Roma", 15, "tomatsauce, ost, skinke, bacon og æg");
        Pizza pizza16 = new Pizza(66, "Quatro", 16, "tomatsauce, ost, skinke, oliven og rejer");
        Pizza pizza17 = new Pizza(70, "Ramo", 17, "tomatsauce, ost og  løg");
        Pizza pizza18 = new Pizza(60, "Gorgonzola", 18, "tomatsauce, ost, champignon, paprika og gorgonzola");
        Pizza pizza19 = new Pizza(62, "Berfin", 19, "tomatsauce, ost, pepperoni, bacon og dressing");
        Pizza pizza20 = new Pizza(70, "Frederikssund", 20, "tomatsauce, ost, kebab, salat og dressing");
        Pizza pizza21 = new Pizza(72, "Nachos", 21, "tomatsauce, ost, kylling, nachos, jalapenos og dressing");
        Pizza pizza22 = new Pizza(68, "Pizza Spinat", 22, "tomatsauce, ost, spinat, kebab, paprika og fetaost");
        Pizza pizza23 = new Pizza(70, "Amigo", 23, "tomatsauce, ost, kebab, kylling og tacosauce");
        Pizza pizza24 = new Pizza(72, "Botan", 24, "tomatsauce, ost, kylling, hvidløg og dressing");
        Pizza pizza25 = new Pizza(75, "Apo", 25, "tomatsauce, ost, skinke og oksemørbrad");
        Pizza pizza26 = new Pizza(80, "Sepp", 26, "tomatsauce, ost, kødstrimler og bearnaise");
        Pizza pizza27 = new Pizza(79, "Parma", 27, "tomatsauce, ost, parmaskinke, pesto og salat");
        Pizza pizza28 = new Pizza(74, "Torino", 28, "tomatsauce, ost, kødstrimler og løg");
        Pizza pizza29 = new Pizza(70, "Nemrut", 29, "tomatsauce, ost, pepperoni og dressing");
        Pizza pizza30 = new Pizza(72, "Finale", 30, "tomatsauce, ost, kebab, bacon, bearnaise og dressing");


        pizzaListe.add(pizza1);
        pizzaListe.add(pizza2);
        pizzaListe.add(pizza3);
        pizzaListe.add(pizza4);
        pizzaListe.add(pizza5);
        pizzaListe.add(pizza5);
        pizzaListe.add(pizza6);
        pizzaListe.add(pizza7);
        pizzaListe.add(pizza8);
        pizzaListe.add(pizza9);
        pizzaListe.add(pizza10);
        pizzaListe.add(pizza11);
        pizzaListe.add(pizza12);
        pizzaListe.add(pizza13);
        pizzaListe.add(pizza14);
        pizzaListe.add(pizza15);
        pizzaListe.add(pizza16);
        pizzaListe.add(pizza17);
        pizzaListe.add(pizza18);
        pizzaListe.add(pizza19);
        pizzaListe.add(pizza20);
        pizzaListe.add(pizza21);
        pizzaListe.add(pizza22);
        pizzaListe.add(pizza23);
        pizzaListe.add(pizza23);
        pizzaListe.add(pizza24);
        pizzaListe.add(pizza25);
        pizzaListe.add(pizza26);
        pizzaListe.add(pizza27);
        pizzaListe.add(pizza28);
        pizzaListe.add(pizza29);
        pizzaListe.add(pizza30);
    }

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
