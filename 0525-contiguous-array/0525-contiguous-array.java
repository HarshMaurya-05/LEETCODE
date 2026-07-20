import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 is seen before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            // Treat 0 as -1 and 1 as +1
            if (nums[i] == 0)
                sum--;
            else
                sum++;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                // Store first occurrence only
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}