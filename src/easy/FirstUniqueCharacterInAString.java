package easy;

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        int[] charCount = new int[26];
        int length = s.length();
        for (int index = 0; index < length; index++) {
            char ch = s.charAt(index);
            charCount[ch - 'a']++;
        }

        for (int index = 0; index < length; index++) {
            int indexOfCharInCharCount = s.charAt(index) - 'a';
            if (charCount[indexOfCharInCharCount] == 1) {
                return index;
            }
        }
        return -1;
    }
}
