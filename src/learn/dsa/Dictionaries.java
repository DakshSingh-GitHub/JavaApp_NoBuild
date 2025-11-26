package learn.dsa;

import java.util.*;

public class Dictionaries {
    public static void main(String[] args) {
        Map<Object, Object> dictionary = new HashMap<>();
        dictionary.put("one", 1);
        dictionary.put("two", 2);
        dictionary.put("three", "3");
        dictionary.put(4, "four");

        IO.println(dictionary);
        // IO.println(dictionary.entrySet());
        IO.println(dictionary.get("three"));
        IO.println(dictionary.putIfAbsent("three", 3.00));
        IO.println(dictionary.replace("three", 3.00));
        IO.println(dictionary.containsKey("three"));
        IO.println(dictionary.containsValue(4));
        IO.println(dictionary.remove(4));
        IO.println(dictionary.size());
        IO.println(dictionary.values());
        dictionary.forEach((k, v) -> IO.println(k + " -> " + v));
        dictionary.clear(); // gives no output
        IO.println(dictionary.isEmpty());

        IO.println(dictionary.entrySet());

        // for (Map.Entry<Object, Object> entry : dictionary.entrySet()) {
        //     IO.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        // }
    }
}
