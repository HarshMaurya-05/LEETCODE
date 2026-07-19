import java.util.*;


class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int low = 0;
        int ans = 0;

        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

            if (map.containsKey(ch)) {
                low = Math.max(low, map.get(ch) + 1);
            }

            map.put(ch, high);

            ans = Math.max(ans, high - low + 1);
        }

        return ans;
    }
}
