package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("weitong", 2);
    }

    public int longestSubstring(String s, int k) {
        int lengthOfLongestSubstr = 0;
        int indexToIterateTill = s.length() - k;
        for (int i = 0; i < indexToIterateTill; i++) {
            for (int j = k; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                Map<Character, Integer> charToFrequency = new HashMap<>();
                for (char ch : substr.toCharArray()) {
                    charToFrequency.put(ch, charToFrequency.getOrDefault(ch, 0) + 1);
                }
                if (charToFrequency.values().stream().allMatch(frequency -> frequency >= k)) {
                    lengthOfLongestSubstr = Math.max(lengthOfLongestSubstr, substr.length());
                    indexToIterateTill = s.length() - lengthOfLongestSubstr;
                }
            }
            if (indexToIterateTill < i) {
                break;
            }
        }
        return lengthOfLongestSubstr;
    }
}
