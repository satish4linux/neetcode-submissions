class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> dmis = new ArrayDeque();
        int[] out = new int[temperatures.length];

        for(int i=0;i<temperatures.length; i++) {
            if(!dmis.isEmpty()) {
                while(!dmis.isEmpty() && temperatures[dmis.peek()] < temperatures[i]) {
                    int topIdx = dmis.pop();
                    out[topIdx] = i - topIdx;
                }
            }
            dmis.push(i);
        }
        while(!dmis.isEmpty()) {
            int topIdx = dmis.pop();
            out[topIdx] = 0;
        }
        return out;
    }
}
