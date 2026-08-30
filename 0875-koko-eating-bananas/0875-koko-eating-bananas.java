class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Maximum pile find karo
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long totalHours = 0;

            for (int pile : piles) {

long hours = pile / mid;

if (pile % mid != 0) {
    hours++;
}

totalHours += hours;
                // Optional optimization
                if (totalHours > h) {
                    break;
                }
            }

            if (totalHours <= h) {

                // mid speed possible hai
                ans = mid;

                // aur chhoti speed try karo
                high = mid - 1;

            } else {

                // speed slow hai
                low = mid + 1;
            }
        }

        return ans;
    }
}