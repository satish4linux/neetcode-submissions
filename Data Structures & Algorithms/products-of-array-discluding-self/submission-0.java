class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            int pl = 1; int pr = 1;
            int l=0; int h=i+1;
            while(l!=i) pl*=nums[l++];
            while(h!=nums.length) pr*=nums[h++];
            out[i] = pl*pr;
        }
        return out;
    }
}  
