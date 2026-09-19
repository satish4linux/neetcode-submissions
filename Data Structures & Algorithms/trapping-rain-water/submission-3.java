class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];
        for(int i=1; i<len; i++) leftMax[i] = Math.max(height[i],leftMax[i-1]);
        for(int j=len-2; j>=0; j--) rightMax[j] = Math.max(height[j],rightMax[j+1]);
        int water=0;
        for(int k=0;k<len;k++) water += Math.min(leftMax[k],rightMax[k]) - height[k];

        return water;
    }
}
