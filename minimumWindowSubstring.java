class Solution {
    public String minWindow(String s, String t) {
        int[] hashT = new int[256];
        hashT = initializeT(t);
        
        int[] hashS = new int[256];
        String str = "";
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashS[c]++;
            while (j <= i && valid(hashS, hashT)) {
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    str = s.substring(j, i + 1);
                }
                
                hashS[s.charAt(j)]--;
                j++;
            }
        }
        return str;
    }
    
    private int[] initializeT(String t) {
        int[] hash = new int[256];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        return hash;
    }
    
    private boolean valid(int[] hashS, int[] hashT) {
        for (int i = 0; i < 256; i++) {
            if (hashT[i] > hashS[i]) {
                return false;
            }
        }
        return true;
    }
}
