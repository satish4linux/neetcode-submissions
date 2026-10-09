class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) return (nums[0]==target)?0:-1;
        int l=0;
        int len=nums.length-1;
        int r=len;

        while(l<=r) {
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) {
                if(nums[mid]>nums[len]) l=mid+1;
                else {
                    if(target<=nums[len]) l=mid+1;
                    else r=mid-1;
                }
            } else {
                if(nums[mid]<nums[0]) r=mid-1;
                else {
                    if(target>=nums[0]) r=mid-1;
                    else l=mid+1;
                }
            }
        }
        return -1;
    }
}
