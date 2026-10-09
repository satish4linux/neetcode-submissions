class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int l=0;
        int len=nums.length-1;
        int r=len;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(mid==0) if(nums[mid]<nums[mid+1] && nums[mid]<nums[len]) return nums[mid];
            if(mid==len) if(nums[mid]<nums[mid-1] && nums[mid]<nums[0]) return nums[mid];
            if(nums[mid]<nums[mid+1] && nums[mid]< nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[r]) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
