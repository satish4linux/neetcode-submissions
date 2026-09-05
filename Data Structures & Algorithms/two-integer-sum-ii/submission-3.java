class Solution {
    public int[] twoSum(int[] nums, int target) {
        int gh = nums.length-1;
        int gl = 0;
        for(int i=0;i<nums.length;i++) {
                int rem = target - nums[i];
                int idx2=-1;
                boolean isIdx2Smaller=false;
                if(rem < nums[i]) {
                    idx2=binSearch(gl,i-1,rem, nums); 
                    if(idx2 !=-1) isIdx2Smaller=true;}
                else if(rem > nums[i]) idx2=binSearch(i+1,gh, rem, nums);
                else {
                    int lc = binSearch(gl,i-1,rem, nums);
                    if(lc != -1) {idx2=lc;isIdx2Smaller=true;}
                    else idx2=binSearch(i+1,gh, rem, nums);
                }

                if(idx2 != -1) return (isIdx2Smaller)?new int[]{idx2+1,i+1}:new int[]{i+1,idx2+1};
            }
        return new int[2];
    }

    private int binSearch(int l, int h, int val, int[] nums) {
        int idx = -1;
        int mid = l;
        while(l<=h) {
            mid = (h-l)/2 +l;
            if (nums[mid] == val) return mid;
            else if(nums[mid] > val) h=mid-1;
            else l=mid+1;
        }
        return idx;
    }
}
