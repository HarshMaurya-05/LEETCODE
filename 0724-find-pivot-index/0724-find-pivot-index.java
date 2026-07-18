class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Check index 0
        if (sum - nums[0] == 0)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            int right = sum - nums[i] - left;

            if (left == right)
                return i;
        }

        return -1;
    }
}