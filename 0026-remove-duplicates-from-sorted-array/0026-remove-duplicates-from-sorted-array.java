class Solution {
    public int removeDuplicates(int[] nums) {

        int numberofdc = 1;
        int initial = nums[0];
        int cm = 1;

        while (cm < nums.length) {

            if (initial == nums[cm]) {
                cm++;
                continue;
            } else {
                nums[numberofdc] = nums[cm];
                initial = nums[cm];
                numberofdc++;
                cm++;
            }
        }

        return numberofdc;
    }
}