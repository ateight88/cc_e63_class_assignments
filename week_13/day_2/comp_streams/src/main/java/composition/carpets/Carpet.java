package composition.carpets;

public abstract class Carpet {

    String colour;

    public Carpet(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return this.colour;
    }
}