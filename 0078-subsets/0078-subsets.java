class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> curr) {

        // Every state is a subset
        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {

            // Choose
            curr.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, curr);

            // Unchoose (Backtrack)
            curr.remove(curr.size() - 1);
        }
    }
}