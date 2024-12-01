package medium;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int expectedSum = nums.length * (nums.length - 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return actualSum - expectedSum;
    }
}
