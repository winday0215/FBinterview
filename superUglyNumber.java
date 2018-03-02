class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        int[] index = new int[primes.length]; // store the index in ans that primes[j] should multiply with.
        
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (min > primes[j] * ans[index[j]]) {
                    min = primes[j] * ans[index[j]];
                }
            }
            ans[i] = min;
            //能去重，比如2*7和7*2
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ans[index[j]] == min) {
                    index[j]++;
                }
            }
        }
        return ans[n - 1];
    }
}
