package easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] countOfLetters = new int[26];
        char[] charsInS = s.toCharArray();
        for (char c : charsInS) {
            countOfLetters[c - 'a']++;
        }

        char[] charsInT = t.toCharArray();
        for (char c : charsInT) {
            countOfLetters[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (countOfLetters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
