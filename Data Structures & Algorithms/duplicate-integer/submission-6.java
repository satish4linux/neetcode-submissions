

class Solution {
    public boolean hasDuplicate(int[] nums) {
         HashSet<Integer> numSet = new HashSet();
         for(int i: nums) {if(!numSet.add(i)) return true;}
         return false;
    }
}