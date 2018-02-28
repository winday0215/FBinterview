class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            while (i < j && nums[i] != 0) {
                i++;
            }
            while (i < j && nums[j] == 0) {
                j--;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }
    }
}
