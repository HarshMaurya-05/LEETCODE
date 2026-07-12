class Solution {
    public int maximumSum(int[] arr) {

        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int prevNoDel = noDel;

            noDel = Math.max(arr[i], noDel + arr[i]);

            if (oneDel == Integer.MIN_VALUE)
                oneDel = prevNoDel;
            else
                oneDel = Math.max(prevNoDel, oneDel + arr[i]);

            ans = Math.max(ans, Math.max(noDel, oneDel));
        }

        return ans;
    }
}