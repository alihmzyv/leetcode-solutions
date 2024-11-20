package easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int indexToReplace = 0;
        int length = nums.length;
        for (int index = 0; index < length; index++) {
            int num = nums[index];
            if (num != 0) {
                nums[indexToReplace] = num;
                indexToReplace++;
            }
        }
        for (int index = indexToReplace; index < length; index++) {
            nums[index] = 0;
        }
    }
}
