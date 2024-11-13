package easy;

public class No3105 {
    public static int longestMonotonicSubarray(int[] nums) {
        int prevMax = 1;
        int currMax = 1;
        Integer currComparisonResult = null;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                boolean comparisonResultChanged = false;
                if (nums[i] > nums[i - 1]) {
                    if (currComparisonResult == null || currComparisonResult != 1) {
                        comparisonResultChanged = true;
                        currComparisonResult = 1;
                    }
                } else if (nums[i] < nums[i - 1]) {
                    if (currComparisonResult == null || currComparisonResult != -1) {
                        comparisonResultChanged = true;
                        currComparisonResult = -1;
                    }
                } else {
                    if (currComparisonResult != null) {
                        comparisonResultChanged = true;
                        currComparisonResult = null;
                    }
                }
                if (comparisonResultChanged) {
                    if (currMax > prevMax) {
                        prevMax = currMax;
                    }
                    if (currComparisonResult == null) {
                        currMax = 1;
                    } else {
                        currMax = 2;
                    }
                } else if (currComparisonResult != null) {
                    currMax++;
                }
            }
        }
        return Math.max(prevMax, currMax);
    }
}
