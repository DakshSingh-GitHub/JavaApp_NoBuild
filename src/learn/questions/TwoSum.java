package learn.questions;

public class TwoSum {

    public static int[] twosum() {
        int[] nums = {2, 7, 11, 15};
        int [] out = null;
        int target = 9;
        // We have to return indices of the two numbers which adds up to target
        for (int i = 0; i < nums.length; i++) {
            int cnum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (cnum + nums[j] == target) {
                    out = new int[] {i, j};
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        for (int i : twosum()) { IO.println(i); }
    }
}
