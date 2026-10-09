class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Integer.MIN_VALUE;
        for(int i: piles) maxPile= Math.max(maxPile,i);
        int l=1;
        int r=maxPile;
        int minSpeed = Integer.MAX_VALUE;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(isValidSpeed(piles,h,mid)) {
                minSpeed = Math.min(minSpeed, mid);
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return minSpeed;
    }

    private boolean isValidSpeed(int[] piles, int h, int speed) {
        int sum=0;
        int i=0;
        while(i<piles.length) {
            sum+= (int)Math.ceil((double)piles[i]/speed);
            if(sum>h) return false;
            i++;
        }
        return sum<=h;
    }
}
