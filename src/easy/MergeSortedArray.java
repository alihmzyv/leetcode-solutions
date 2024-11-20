package easy;

public class MergeSortedArray {
    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{2, 0}, 2, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Pointer = m - 1;
        int num2Pointer = n - 1;
        int index = nums1.length - 1;
        while (num1Pointer >= 0 && num2Pointer >= 0) {
            int num1 = nums1[num1Pointer];
            int num2 = nums2[num2Pointer];
            if (num1 > num2) {
                nums1[index] = num1;
                num1Pointer--;
            } else {
                nums1[index] = num2;
                num2Pointer--;
            }
            index--;
        }
        if (num1Pointer < 0) {
            System.arraycopy(nums2, 0, nums1, 0, num2Pointer + 1);
        }
    }
}
