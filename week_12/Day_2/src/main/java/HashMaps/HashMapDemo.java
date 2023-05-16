package HashMaps;

import java.util.HashMap;

public class HashMapDemo {

    /*
     * first hash map example
     * */

    public static void main(String[] args) {
//        HashMap favouriteFruits = new HashMap(); - raw use of parameterized class 'HashMap'
        HashMap<String, String> favouriteFruits = new HashMap<>();

        favouriteFruits.put("Alice", "Apple");
        favouriteFruits.put("Sarah", "Banana");
        favouriteFruits.put("Bob", "Strawberry");

        System.out.println(favouriteFruits.get("Alice"));

        /*
        * second hash map example
        * */

        HashMap<String, Integer> ages = new HashMap<String, Integer>();

        ages.put("Alice", 52);
        ages.put("Bob", 24);

        Integer aliceAge = ages.get("Alice");

        String output = "Alice's age is " + aliceAge.toString();
        System.out.println(output);

        /*
         * task...
         * */

        HashMap<String, Country> countryMap = new HashMap<>();

        Country country1 = new Country("UK", 64_100_000, "Europe", "London");
        Country country2 = new Country("Germany", 80_620_000, "Europe", "Berlin");
        Country country3 = new Country("France", 66_030_000, "Europe", "Paris");
        Country country4 = new Country("Japan", 127_300_000, "Asia", "Tokyo");

        countryMap.put(country1.getName(), country1);
        countryMap.put(country2.getName(), country2);
        countryMap.put(country3.getName(), country3);
        countryMap.put(country4.getName(), country4);

        // Output values
        System.out.println(countryMap.get("UK").getPopulation());
        System.out.println(countryMap.get("France").getCapital());

        // Using .values() and .keySet() methods
        System.out.println(countryMap.values()); // Print values - Country objects
        System.out.println(countryMap.keySet()); // Print  keys - country names

        // Outputting country information
        for (Country country : countryMap.values()) {
            System.out.println(country);
        }
    }
}


/*
* common methods...
* favouriteFruits.put(key, value) // inserts a new entry into the HashMap
  favouriteFruits.get(key) // gets the value for the given key
  favouriteFruits.size() // returns the size of the HashMap as an integer
  favouriteFruits.clear() // clears all entries from the HashMap
  favouriteFruits.containsValue(value) // returns true if the HashMap contains the value
  favouriteFruits.remove(key)
* */