package easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int expectedLength = nums.length + 1;
        int expectedSum = (expectedLength - 1) * expectedLength / 2;
        int actualSum = 0;
        for (int num: nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
