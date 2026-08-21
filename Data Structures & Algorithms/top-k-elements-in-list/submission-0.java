class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(),a.getValue()));
        HashMap<Integer,Integer> freqMap = new HashMap();

        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        pq.addAll(freqMap.entrySet());
        int[] res = new int[k];
        int i = 0;
        while(i<k){
            Map.Entry<Integer,Integer> p = pq.poll();
            res[i] = p.getKey();
            i++;
        }
        return res;
    }
}
