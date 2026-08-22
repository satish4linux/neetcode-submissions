class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        out[0]=1;
        for(int i=1; i< nums.length; i++) out[i] = out[i-1]*nums[i-1];
        int postfix=1;
        for(int i=nums.length-1; i >=0; i--) {
            out[i] *= postfix;
            postfix *= nums[i];
        }
        return out;
    }
}  

// first pass - 1,1,2,8
// second pass -
// right -1 = 8
// right -2 = 2 * 6 = 12
// right -3 = 