class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();
        for(String str: tokens) {
            if(!isOperator(str)) {
                // System.out.println("is operand - "+ str);
                stack.push(Integer.valueOf(str));
            } else {
                // System.out.println("is operator - "+ str);
                int rOperand = stack.pop();
                int lOperand = stack.pop();
                int val = evalExpr(lOperand, rOperand, str);
                // System.out.println("operand pushed - "+ val);
                stack.push(val);
            }
        }
        return stack.peek();
    }

private boolean isOperator(String token) {
    return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
}


    private int evalExpr(int l, int r, String op) {
        // System.out.println("op - "+ op);
        switch(op) {
            case "+" : return l + r;
            case "-" : return l - r;
            case "*" : return l * r;
            case "/" : return l / r;
        }
        return 0;
    }
}
