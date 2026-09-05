class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        Set<Integer> check = new HashSet(nums.length);
        for(int n: nums) check.add(n);
        Map<Integer, Integer> window = new HashMap();
        int res = Integer.MIN_VALUE;

        for(int n: nums) {
            boolean toContinue = true;
            for(Map.Entry<Integer,Integer> entry: window.entrySet()) {
                if(n >= entry.getKey() && n<= entry.getValue()) 
                toContinue = false;
            }
            if(toContinue) {
                int nextElm = n+1;
                while(check.contains(nextElm)) nextElm++;
                window.put(n, nextElm-1);
                res = Math.max(res, nextElm-n);
            }
        }
        return res;
    }
}
