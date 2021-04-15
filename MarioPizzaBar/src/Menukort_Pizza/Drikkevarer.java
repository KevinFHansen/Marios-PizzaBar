package Menukort_Pizza;

public class Drikkevarer {
    private String typeDrikkevare;
    private int sodavandPris = 20;
    private int vinPris = 25;
    private int flaskeØlPris = 25;
    private int kandeVandPris = 20;

    public Drikkevarer (String typeDrikkevare){
        this.typeDrikkevare = typeDrikkevare;
    }
    public String getTypeDrikkevare(){
        return this.typeDrikkevare;
    }
    public void setTypeDrikkevare(){
        this.typeDrikkevare = typeDrikkevare;
    }

    public int getSodavandPris(){
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


}
