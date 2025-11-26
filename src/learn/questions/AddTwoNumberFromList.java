package learn.questions;

import java.util.ArrayList;

public class AddTwoNumberFromList {
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    // Explanation: 342 + 465 = 807.
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>() {{ add(2);add(4);add(3); add(6); }};
        ArrayList<Integer> l2 = new ArrayList<Integer>() {{ add(5);add(6);add(4); }};

        int n1 = l1.size()-1, sum1 = 0;
        for (int c : l1.reversed()) { sum1 = sum1 + c*(Math.powExact(10, n1)); n1--; }

        int n2 = l2.size()-1, sum2 = 0;
        for (int c : l2.reversed()) { sum2 = sum2 + c*(Math.powExact(10, n2)); n2--; }

        IO.println(sum1 + sum2);
    }

}
