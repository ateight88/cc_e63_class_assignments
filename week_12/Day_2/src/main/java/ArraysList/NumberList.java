package ArraysList;

import java.util.ArrayList;

public class NumberList {

    private final ArrayList<Integer> numbers;

//    public NumberList(){
//        this.numbers = new ArrayList<>();
//    }
public NumberList(ArrayList<Integer> numbers){
    this.numbers = numbers;
}

    public int getNumberCount() {
        return this.numbers.size();
    }

    public void addNumber(int i) {
        this.numbers.add(i);
    }

    public int getNumberAtIndex(int i) {
        return this.numbers.get(i);
    }

    public int getTotal() {
        int total = 0;
//        for (int j = 0; j < getNumberCount(); j++){
//            total += getNumberAtIndex(j);
//        }
//        "for-each" loop or an "enhanced for" loop - can only be used for iterating forward over a collection
        for (int number : this.numbers){
            total += number;
        }
        return total;
    }
}
