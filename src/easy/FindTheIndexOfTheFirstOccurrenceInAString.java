package easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        for (int index = 0; index <= haystack.length() - needle.length(); index++) {
            if (haystack.startsWith(needle, index)) {
                return index;
            }
        }
        return -1;
    }
}
