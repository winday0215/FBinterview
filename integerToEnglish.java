ass Solution {
    public String numberToWords(int num) {
        String ans = convertHundred(num % 1000);
        String[] x = {"Thousand", "Million", "Billion"};
        for (int i = 0; i < 3; i++) {
            num /= 1000;
            ans = (num % 1000 > 0 ? convertHundred(num % 1000) + " " + x[i] + " " + ans : ans);
        }
        ans = ans.trim();
        return ans.equals("") ? "Zero" : ans;
    }
    
    private String convertHundred(int num) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] twos = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        int a = num / 100;
        int b = num % 100;
        int c = num % 10;
        
        String ans = "";
        ans = b < 20 ? ones[b] : twos[b / 10] + (c > 0 ? " " + ones[c] : "");
        if (a > 0) {
            ans = ones[a] + " Hundred" + (b > 0 ? " " + ans : ans );
        }
        
        return ans;
    }
}
