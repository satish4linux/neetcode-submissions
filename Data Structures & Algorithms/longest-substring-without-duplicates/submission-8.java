class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = -1;
        boolean isDistinct = true;
        if(s.toCharArray().length == 0) return 0;
        Map<Character,Integer> checkMap = new HashMap();
        int start=0;
        int i=0;

        for(;i<s.length();i++) {
            if(checkMap.containsKey(s.charAt(i)) && checkMap.get(s.charAt(i)) >= start) {
                if(isDistinct) isDistinct=false;
                int currLen = i-start;
                maxLen = Math.max(maxLen,currLen);
                start = checkMap.get(s.charAt(i))+1;
            }
            checkMap.put(s.charAt(i), i);
        }
        maxLen = Math.max(maxLen,i-start);
        return (isDistinct)?s.length():maxLen;
    }
}
