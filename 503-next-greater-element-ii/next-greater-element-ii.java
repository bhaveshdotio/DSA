class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = -1;

            for (int j = 1; j < n; j++) {

                int index = (i + j) % n;

                if (nums[index] > nums[i]) {
                    arr[i] = nums[index];
                    break;
                }
            }
        }

        return arr;
    }
}