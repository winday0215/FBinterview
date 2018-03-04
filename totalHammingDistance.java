class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  
        }


        int ans = 0, n = nums.length;
        int[] cnt = new int[32];         // count of elements with a particular bit ON

        for (int num : nums) {         // loop over every element
            int i = 0;
            while (num > 0) {           // check every bit
                cnt[i] += (num & 0x1);
                num >>= 1;
                i++;
            }
        }

        for (int k : cnt) {           // loop over every bit count
            ans += k * (n - k);
        }

        return ans;
    }
    
}
