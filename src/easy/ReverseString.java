package easy;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tempLeft = s[left];
            s[left] = s[right];
            s[right] = tempLeft;
            left++;
            right--;
        }
    }

    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        reverseStringRecursive(s, left, right);
    }

    private void reverseStringRecursive(char[] s, int left, int right) {
        if (left < right) {
            char tempLeft = s[left];
            s[left] = s[right];
            s[right] = tempLeft;
            reverseStringRecursive(s, left + 1, right - 1);
        }
    }
}
