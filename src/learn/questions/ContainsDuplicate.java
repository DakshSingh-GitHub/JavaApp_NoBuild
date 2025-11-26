package learn.questions;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i : nums) {
            if (seen.contains(i)) { return false; }
        }

        // The Arrays.sort() method sorts the array in-place in ascending order.
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length-1; i++) { if (nums[i] == nums[i+1]) { return true; }}
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        boolean t = containsDuplicate(arr);
        IO.println(t);
    }
}
