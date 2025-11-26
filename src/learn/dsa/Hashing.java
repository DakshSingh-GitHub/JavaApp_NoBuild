package learn.dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class Hashing {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        double load_factor;
        HashMap<Integer, ArrayList<Integer>> numbersorter = new HashMap();
        numbersorter.put(0, new ArrayList<Integer>());
        numbersorter.put(1, new ArrayList<Integer>());
        numbersorter.put(2, new ArrayList<Integer>());
        numbersorter.put(3, new ArrayList<Integer>());
        numbersorter.put(4, new ArrayList<Integer>());

        int[] numbers = { 12, 34, 45, 9, 8, 90, 3, 24, 56, 78, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
        
        for (int number : numbers) {
            switch (number%5) {
                case 0 -> numbersorter.get(0).add(number);
                case 1 -> numbersorter.get(1).add(number);
                case 2 -> numbersorter.get(2).add(number);
                case 3 -> numbersorter.get(3).add(number);
                case 4 -> numbersorter.get(4).add(number);
                default -> {}
            }
        }

        numbersorter.forEach((key, item) -> { IO.println(key + " : " + item); });
        load_factor = numbersorter.values().size() / numbersorter.keySet().size();
        IO.println(load_factor);
    }
}
