class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int maxAmt = Integer.MIN_VALUE;
        while(l<r) {
            int amt = Math.min(heights[l], heights[r])*(r-l);
            maxAmt = Math.max(maxAmt,amt);
            if(heights[l] <heights[r]) l++;
            else r--;
        }
        return maxAmt;
    }
}
