class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum right side me hai
                left = mid + 1;
            } else {
                // minimum mid par ya left side me hai
                right = mid;
            }
        }

        return nums[left];
    }
}