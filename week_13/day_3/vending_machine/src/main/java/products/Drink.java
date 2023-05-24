package products;

public class Drink extends Product {
    private DrinkType type;
    private String flavour;


    public Drink(String name, DrinkType type, String flavour) {
        super(name);
        this.type = type;
        this.flavour = flavour;
    }

    public DrinkType getType() {
        return type;
    }

    public String getFlavour(){
        return flavour;
    }
}
