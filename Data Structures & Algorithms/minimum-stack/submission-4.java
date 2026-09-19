class MinStack {

    private ArrayDeque<Long> stack;
    private Integer currentMin;

    public MinStack() {
        stack = new ArrayDeque();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(Long.valueOf(val));
            currentMin=val;
            return;
        }
        if(val >= currentMin) stack.push(Long.valueOf(val));
        else {
            Long valToPush = 2*Long.valueOf(val) - currentMin;
            stack.push(valToPush);
            currentMin = val;
        }
    }
    
    public void pop() {
        Long peekVal = stack.peekFirst();
        if(peekVal >= currentMin) stack.pop();
        else {
            Long prevMin = 2*currentMin - peekVal;
            stack.pop();
            currentMin = prevMin.intValue();
        }
    }
    
    public int top() {
        Long peekTop = stack.peekFirst();
        if(peekTop >= currentMin) return peekTop.intValue();
        else return currentMin;
    }
    
    public int getMin() {
        return currentMin;
    }
}
