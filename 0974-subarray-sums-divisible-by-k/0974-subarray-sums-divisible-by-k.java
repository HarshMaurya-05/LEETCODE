import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 occurs once before starting
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            int rem = prefixSum % k;

            // Handle negative remainder
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}