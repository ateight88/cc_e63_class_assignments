package products;

public class ChocBars extends Product{
    private ChocBarType type;
    private String flavour;

    public ChocBars(String name, ChocBarType type, String flavour) {
        super(name);
        this.type = type;
        this.flavour = flavour;
    }

    public ChocBarType getType() {
        return type;
    }

    public String getFlavour() {
        return flavour;
    }
}
