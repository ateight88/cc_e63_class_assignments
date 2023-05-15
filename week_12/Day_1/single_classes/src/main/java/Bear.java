public class Bear {

    private final String name;
    private final int age;
    private final double weight;



    public Bear(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public boolean readyToHibernate() {
        return this.weight > 70.00;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
    
}
