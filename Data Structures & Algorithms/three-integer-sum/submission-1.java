class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0) return new ArrayList();
        Set<List<Integer>> resSet = new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            int rem = 0 - nums[i];
            int l=i+1;
            int r=nums.length-1;
            while(l<r) {
                if(nums[l]+nums[r] > rem) r--;
                else if(nums[l]+nums[r] < rem) l++;
                else {resSet.add(List.of(nums[i],nums[l],nums[r]));l++;r--;}
            }
        }
        return new ArrayList(resSet);
    }
}
