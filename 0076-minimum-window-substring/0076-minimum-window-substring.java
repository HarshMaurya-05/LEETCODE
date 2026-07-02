class Solution {
    public String minWindow(String s, String t) {

        // Frequency of characters required from t
        int[] need = new int[128];

        // Frequency of characters in current window
        int[] window = new int[128];

        // Store frequency of t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        // Count unique required characters
        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) {
                required++;
            }
        }

        int formed = 0;                 // Number of characters currently satisfying required frequency
        int low = 0;                    // Left pointer

        int minLength = Integer.MAX_VALUE;
        int start = 0;                  // Starting index of minimum window

        // Expand the window
        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

            // Include current character
            window[ch]++;

            // Requirement for this character is now satisfied
            if (need[ch] > 0 && window[ch] == need[ch]) {
                formed++;
            }

            // Shrink while window is valid
            while (formed == required) {

                // Update minimum answer
                if (high - low + 1 < minLength) {
                    minLength = high - low + 1;
                    start = low;
                }

                // Remove left character
                char left = s.charAt(low);
                window[left]--;

                // Window becomes invalid
                if (need[left] > 0 && window[left] < need[left]) {
                    formed--;
                }

                low++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLength);
    }
}