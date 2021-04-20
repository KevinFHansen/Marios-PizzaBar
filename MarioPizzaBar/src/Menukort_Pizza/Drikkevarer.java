package Menukort_Pizza;

import java.util.ArrayList;

public class Drikkevarer {
    private String typeDrikkevare;
    private int prisPåDrikkevare;
    private int nummerPåDrikkevare;
    /*private int sodavandPris = 20;
    private int vinPris = 25;
    private int flaskeØlPris = 25;
    private int kandeVandPris = 20;*/

    //Constructor
    public Drikkevarer (int nummerPåDrikkevare, String typeDrikkevare, int prisPåDrikkevare){
        this.typeDrikkevare = typeDrikkevare;
        this.prisPåDrikkevare = prisPåDrikkevare;
        this.nummerPåDrikkevare = nummerPåDrikkevare;
    }

    //Getters og setters
    public int getPrisPåDrikkevare(){
        return this.prisPåDrikkevare;
    }
    public void setPrisPåDrikkevare(){
        this.prisPåDrikkevare = prisPåDrikkevare;
    }
    public String getTypeDrikkevare(){
        return this.typeDrikkevare;
    }
    public void setTypeDrikkevare(){
        this.typeDrikkevare = typeDrikkevare;
    }

    public int getNummerPåDrikkevare(){
        return this.nummerPåDrikkevare;
    }


    /*public int getSodavandPris(){
        return this.sodavandPris;
    }
    public void setSodavandPris(){
        this.sodavandPris = sodavandPris;
    }
    public int getVinPris(){
        return this.vinPris = vinPris;
    }
    public void setVinPris(){
        this.vinPris = vinPris;
    }
    public int getFlaskeØlPris(){
        return this.flaskeØlPris;
    }
    public void setFlaskeØlPris(){
        this.flaskeØlPris = flaskeØlPris;
    }
    public int getKandeVandPris(){
        this.kandeVandPris = kandeVandPris;
        return this.kandeVandPris;
    }

     */
    @Override
    public String toString() {
        return "" +
                "Nr " + nummerPåDrikkevare + " " + typeDrikkevare +
                " " + prisPåDrikkevare + "Kr";
    }

}
