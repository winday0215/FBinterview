//solve equation with _,+,(,)
class Solution {
    public int num = 0;
    public int coeff = 0;
    public String solveEquation(String equation) {
        equation.replace(" ","");
        
        String[] sides = equation.split("=");
        
        process(sides[0], 1);
        process(sides[1], -1);
        
        if (num == 0 && coeff == 0) return "Infinite Solutions";
        if (coeff == 0) return "No Solution";
        return "x=" + (num / coeff);
    }
    
    private void process(String eq, int side) {
        
        int curSign = 1;
        int number = 0, coefficient = 0;
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(1); //initialize sign as +1
        int i = 0;
        while (i < eq.length()) {
            char c = eq.charAt(i);
            
            if (c == '+') {
                curSign = 1;
                i++;
            } else if (c == '-') {
                curSign = -1;
                i++;
            } else if (c == '(') {
                curSign = curSign * st.peek(); // '(', push previous sign into stack， 因为后面可能会变号。-（3+x）= -3 - x
                st.push(curSign);
                curSign = 1;
                i++;
            } else if (c == ')') {
                st.pop();
                i++;
            } else {
                int curNum = 0;
                while (i < eq.length() && Character.isDigit(eq.charAt(i))) {
                        curNum = curNum * 10 + eq.charAt(i) - '0';
                        i++;
                }
                
                if (i < eq.length() && eq.charAt(i) == 'x') {
                    if (curNum == 0) {
                        coefficient += 1 * curSign * st.peek();
                    } else {
                        coefficient += curNum * curSign * st.peek();
                    }
                    i++;
                } else {
                    number += curNum * curSign * st.peek();
                }
            }
        }
        
        if (side == 1) { //left side, num reduce, coeff add
            num -= number;
            coeff += coefficient;
        } else {
            num += number;
            coeff -= coefficient;
        }
    }
}
