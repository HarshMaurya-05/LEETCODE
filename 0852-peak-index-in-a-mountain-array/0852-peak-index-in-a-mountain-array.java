class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // hum increasing slope par hain
                // peak right side me hai
                left = mid + 1;
            } else {
                // hum decreasing slope par hain
                // mid khud peak ho sakta hai
                right = mid;
            }
        }

        return left;
    }
}