package medium;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[] {2, 1, 1, 2}));
        ;
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int firstIncluded = nums[length - 2];
        int firstExcluded = nums[length - 1];
        for (int i = length - 3; i >= 0; i--) {
            int tempFirstIncluded = firstIncluded;
            firstIncluded = nums[i] + firstExcluded;
            firstExcluded = Math.max(tempFirstIncluded, firstExcluded);
        }
        return Math.max(firstIncluded, firstExcluded);
    }
}
