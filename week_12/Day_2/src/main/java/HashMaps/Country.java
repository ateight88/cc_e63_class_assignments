package HashMaps;

import java.util.HashMap;

public class Country {
    private final String name;
    private final long population;
    private final String continent;
    private final String capital;

    public Country(String name, long population, String continent, String capital) {
        this.name = name;
        this.population = population;
        this.continent = continent;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "In " + name + " there are " + population + " people. The capital of " + name + " is " + capital
                + " and it is in " + continent + ".";
    }
}


