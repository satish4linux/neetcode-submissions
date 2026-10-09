class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0) return getMedian(nums2);
        if(nums2.length==0) return getMedian(nums1);
        int[] merged = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] <= nums2[j]) {
                merged[k]=nums1[i];
                k++;
                i++;
            } else {
                merged[k]=nums2[j];
                k++;
                j++;
            }
        }
        if(i<nums1.length) while(i!=nums1.length) merged[k++]=nums1[i++];
        if(j<nums2.length) while(j!=nums2.length) merged[k++]=nums2[j++];
        
        for(int l: merged) System.out.println(l);
        return getMedian(merged);
    }

    private double getMedian(int[] arr) {
        double median;
        if(arr.length%2==0) {
            int mid = arr.length/2;
            median = ((double)arr[mid-1]+(double)arr[mid])/2;
        } else {
            int mid = arr.length/2;
            median = (double) arr[mid];
        }
        return median;
    }
}
