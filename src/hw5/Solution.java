package hw5;

public class Solution {
    public int[] runningSum(int[] nums) {
        int[] intArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                intArray[i] = nums[i];
            }

            if (i > 0) {
                intArray[i] = nums[i] + intArray[i - 1];
            }
        }

        return intArray;
    }
}