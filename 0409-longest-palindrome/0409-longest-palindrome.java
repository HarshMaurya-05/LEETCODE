import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        for (int freq : map.values()) {

            // Use the even part
            length += (freq / 2) * 2;

            // Remember if any odd frequency exists
            if (freq % 2 == 1) {
                oddFound = true;
            }
        }

        // One odd character can be placed in the center
        if (oddFound) {
            length++;
        }

        return length;
    }
}