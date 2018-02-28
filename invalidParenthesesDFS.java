class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt1++;
            } else if (cnt1 == 0 && c == ')') {
                cnt2++;
            } else if (c == ')') {
                cnt1--;
            }
        }
        
        
        helper(s, 0, cnt1, cnt2, res);
        return res;
    }
    
    private void helper(String s, int index, int cnt1, int cnt2, List<String> res) {
        if (cnt1 == 0 && cnt2 == 0) {
            if (isValid(s)) {
                res.add(s);
                return;
            }
        }
            
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) { // only delete the first parentheses
                continue;
            }
            if (cnt1 > 0 && s.charAt(i) == '(') {
                helper(s.substring(0, i) + s.substring(i + 1), i, cnt1 - 1, cnt2, res);
            }
            if (cnt2 > 0 && s.charAt(i) == ')') {
                helper(s.substring(0, i) + s.substring(i + 1), i, cnt1, cnt2 - 1, res);
            }
        }
        
    }
    
    
    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}

// first remove extra ')', then remove extra '('
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, new char[]{'(', ')'}, res);
        return res;
    }
    
    private void helper(String s, int last_i, int last_j, char[] p, List<String> res) {
        int cnt = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) {
                cnt++;
            } else if (s.charAt(i) == p[1]) {
                cnt--;
            }
            if (cnt >= 0) { // parentheses p[0] > p[1]
                continue;
            }
            
            //begin delete extras
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == p[1] && (j == last_j || s.charAt(j) != s.charAt(j - 1))) {
                    helper(s.substring(0, j) + s.substring(j + 1), i, j, p, res);
                }
            }
            return;
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') 
            helper(reverse,  0, 0, new char[]{')', '('},res); // important: 0, 0
        else
            res.add(reverse);
    }
}

********变种********
简单版：只输出第一个valid的	

Time: O(n), 2 pass
// 思路：按照判断isValid的思路，只要遇到stack<0就remove，完了之后reverse再来一次。
public String removeInvalidParentheses(String s) {
	String r = remove(s, new char[]{'(', ')'});
	String tmp = remove(new StringBuilder(r).reverse().toString(), new char[]{')', '('});
	return new StringBuilder(tmp).reverse().toString();
}
private String remove(String s, char[] p) {
	int stack = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == p[0])		stack++;
		if (s.charAt(i) == p[1])		stack--;
		if (stack < 0) {
			s = s.substring(0, i) + s.substring(i + 1);
			i--;
			stack = 0;
		}
	}
	return s;
}
