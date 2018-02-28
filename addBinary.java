class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
            }
            
            sb.append((char)(carry % 2 + '0')); // 0, 2 -> 0; 1, 3 -> 1
            
            carry /= 2; // 0, 1 -> 0, 2, 3 -> 1
            
            i--;
            j--;
        }
        
        if (carry != 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
