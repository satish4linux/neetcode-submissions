class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap();
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        List<Integer>[] freqArr = new List[nums.length + 1];
        for(int i = 0 ; i <= freqArr.length-1;i++) freqArr[i] = new ArrayList();
        for(Map.Entry<Integer,Integer> e : freqMap.entrySet()) {
            List<Integer> val = freqArr[e.getValue()];
            val.add(e.getKey());
            freqArr[e.getValue()] = val;
        }

        int[] res = new int[k];
        for(int i=freqArr.length-1, j=0 ; i>0; i--) {
            if(freqArr[i].size() != 0) {
                List<Integer> freqVal = freqArr[i];
                int m = 0;
                while(j<k && m < freqVal.size()) {
                    res[j++] = freqVal.get(m++);
                    if(j==k) return res;
                }
            }
        }
        return res;
    }
}
