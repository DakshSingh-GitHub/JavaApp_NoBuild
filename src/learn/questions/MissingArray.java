package learn.questions;

import java.util.Arrays;
import java.util.ArrayList;

// [1, 3, 7, 4, 2, 5] Missing = 6

public class MissingArray {
    public static int missingArray(int[] arr) {
        ArrayList<Integer> main_array = new ArrayList<Integer>();
        ArrayList<Integer> check_array = new ArrayList<Integer>();

        Arrays.sort(arr);
        for (int i : arr) main_array.add(i);
        for ( int i = 1; i <= main_array.get(main_array.size()-1); i++ ) check_array.add(i);

        for ( int i = 0; i < check_array.size(); i++ ) { 
            if (check_array.get(i) != main_array.get(i)) return check_array.get(i);
        }

        return check_array.get(check_array.size()-1) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 2, 5};
        int m_n = missingArray(arr);
        IO.println("missing Number: " + m_n);
    }
}
