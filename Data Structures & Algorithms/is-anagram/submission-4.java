class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        String sortedS = new String(sChars);
        String sortedT = new String(tChars);
        return sortedS.equals(sortedT);
    }
}
