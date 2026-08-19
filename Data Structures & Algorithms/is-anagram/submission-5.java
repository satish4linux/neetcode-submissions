class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> sFreq = new HashMap();
        for(char a : s.toCharArray()){
            sFreq.put(a,(sFreq.get(a) == null)?1:sFreq.get(a)+1);
        }
        for(char b : t.toCharArray()){
            if(sFreq.get(b) == null || sFreq.get(b) <=0) return false;
            sFreq.put(b,sFreq.get(b)-1);
        }
        for(Map.Entry<Character,Integer> e: sFreq.entrySet()){
            if(e.getValue() !=0) return false;
        }
        return true;
    }
}
