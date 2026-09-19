class MinStack {

    private ArrayDeque<Long> stack;
    private Long currentMin;

    public MinStack() {
        stack = new ArrayDeque();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(Long.valueOf(val));
            currentMin=Long.valueOf(val);
            return;
        }
        if(val >= currentMin) stack.push(Long.valueOf(val));
        else {
            Long valToPush = 2*Long.valueOf(val) - currentMin;
            stack.push(valToPush);
            System.out.println("current min - "+val+", prev min - "+currentMin);
            currentMin = Long.valueOf(val);
        }
    }
    
    public void pop() {
        Long peekVal = stack.peekFirst();
        System.out.println("peek at pop - " + peekVal);
        if(peekVal >= currentMin) stack.pop();
        else {
            Long prevMin = 2*currentMin - peekVal;
            stack.pop();
            System.out.println("current min - "+prevMin+", prev min - "+currentMin);
            currentMin = prevMin;
        }
    }
    
    public int top() {
        Long peekTop = stack.peekFirst();
        if(peekTop >= currentMin) return peekTop.intValue();
        else return currentMin.intValue();
    }
    
    public int getMin() {
        return currentMin.intValue();
    }
}
