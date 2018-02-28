class Solution {
    public String multiply(String num1, String num2) {
        // write your code here
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1 + l2 + 1];
        
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                 ans[i + j] += (num1.charAt(l1 - 1 - i) - '0') * (num2.charAt(l2 - 1 - j) - '0');
            }
        }
        
        for (int i = 0; i < l1 + l2; i++) {
            ans[i+1] += ans[i] / 10;
            ans[i] %= 10;
        }
        
        int i = l1 + l2;
        while (ans[i] == 0 && i > 0) {
            i--;
        }
        
        String result = "";
        while (i >= 0) {
            result += ans[i];
            i--;
        }
        
        return result;
    }
}
