package Menukort_Pizza;

public class Drikkevarer {
    private String typeDrikkevare;
    private double pris;

    public Drikkevarer (String typeDrikkevare, double pris){
        this.typeDrikkevare = typeDrikkevare;
        this.pris = pris;
    }
    public String getTypeDrikkevare(){
        return this.typeDrikkevare = typeDrikkevare;
    }

    public void setTypeDrikkevare(){
        this.typeDrikkevare = typeDrikkevare;
    }
    public double getPris (){
        return this.pris = pris;
    }
    public void setPris(){
        this.pris = pris;
    }
}
