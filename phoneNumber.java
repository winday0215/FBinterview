class Solution {
    String[] chars = {"","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        helper(digits, 0, "", ans);
        return ans;
    }
    
    private void helper(String s, int index, String path, List<String> ans) {
        if (index == s.length()) {
            ans.add(path);
            return;
        }
        
        String ss = chars[s.charAt(index) - '0'];
        for (int i = 0; i < ss.length(); i++) {
            helper(s, index + 1, path + ss.charAt(i), ans);
        }
    }
}
