class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> anagramMap = new HashMap();
        for(String str : strs) {
            int[] freqArr = new int[26];
            for(Character c: str.toCharArray()) {
                freqArr[c - 'a']++;
            }
            String freqStr = Arrays.toString(freqArr);
            anagramMap.computeIfAbsent(freqStr, v -> new ArrayList()).add(str);
        }
        List<List<String>> res = new ArrayList();
        anagramMap.forEach((k, v) -> res.add(v));
        return res;
    }
}
