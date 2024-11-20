package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) {
            int digit = digits[index];
            if (digit == 9) {
                digits[index] = 0;
            } else {
                digits[index]++;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}
