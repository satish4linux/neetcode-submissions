class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> numsMap = new HashMap();
        for(int i=0; i<nums.length;i++) {
            ArrayList<Integer> val = numsMap.get(nums[i]);
            if (val == null) val = new ArrayList();
            val.add(i);
            numsMap.put(nums[i],val);
            }
        System.out.println(numsMap.toString());
        int idx0 = Integer.MAX_VALUE,idx1 = Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++) {
            int rem = target - nums[j];
            ArrayList<Integer> checkVal = numsMap.get(rem);
            if(checkVal == null) continue;
            if(checkVal.size() == 1) {
                System.out.println("check 1");
                if(checkVal.get(0) == j) continue;
                else {idx0=j;idx1=checkVal.get(0);break;}
            } else {
                System.out.println("check 2");
                Iterator<Integer> itr = checkVal.iterator();
                while(itr.hasNext()) {
                    int curr = itr.next();
                    if(curr != j) {
                        idx0=j;
                        idx1=curr;
                        break;
                    }
                }
                break;
            }
        }
        return (idx0<idx1)?new int[]{idx0,idx1}:new int[]{idx1,idx0};
    }
}
