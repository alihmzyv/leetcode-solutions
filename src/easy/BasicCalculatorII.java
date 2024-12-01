package easy;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("4  +  2  *  500 / 100 + 3/ 2"));
        ;
    }

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char ZERO = '0';

    public int calculate(String s) {
        int num = 0;
        char sign = PLUS;
        Stack<Integer> numsToSum = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - ZERO;
            }
            if (index == s.length() - 1 || ch  == PLUS || ch == MINUS || ch == MULTIPLY || ch == DIVIDE) {
                if (sign == PLUS) {
                    numsToSum.push(num);
                } else if (sign == MINUS) {
                    numsToSum.push(-num);
                } else if (sign == MULTIPLY) {
                    numsToSum.push(numsToSum.pop() * num);
                } else if (sign == DIVIDE) {
                    numsToSum.push(numsToSum.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        final int[] sum = {0};
        numsToSum.forEach(n -> {
            sum[0] += n;
        });
        return sum[0];
    }

    private int calculate(int num1, int num2, Character op) {
        return switch (op) {
            case PLUS -> num1 + num2;
            case MINUS -> num1 - num2;
            case MULTIPLY -> num1 * num2;
            default -> num1 / num2;
        };
    }
}
