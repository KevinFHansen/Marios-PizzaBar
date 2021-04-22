package menukort_pizza;

public class Drikkevarer {
    private String typeDrikkevare;
    private int prisPåDrikkevare;
    private int nummerPåDrikkevare;

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

    @Override
    public String toString() {
        return "" +
                nummerPåDrikkevare + " " + typeDrikkevare +
                " " + prisPåDrikkevare + "Kr";
    }

}
