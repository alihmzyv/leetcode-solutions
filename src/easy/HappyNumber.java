package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        new HappyNumber().isHappy(19);
    }

    public boolean isHappy(int n) {
        Set<Integer> numbersGenerated = new HashSet<>();
        int sumOfSquareOfDigits = getSumOfSquareOfDigits(n);
        while (!numbersGenerated.contains(sumOfSquareOfDigits)) {
            if (sumOfSquareOfDigits == 1) {
                return true;
            } else {
                numbersGenerated.add(sumOfSquareOfDigits);
                sumOfSquareOfDigits = getSumOfSquareOfDigits(sumOfSquareOfDigits);
            }
        }
        return false;
    }

    private int getSumOfSquareOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
