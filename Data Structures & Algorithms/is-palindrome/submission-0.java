class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l=0;
        int h=chars.length-1;
        while(l< h) {
            while( l< h && !isAlphaNumeric(chars[l])) l++;
            while( h>l && !isAlphaNumeric(chars[h])) h--;
            if(Character.toLowerCase(chars[l++]) != 
            Character.toLowerCase(chars[h--])) return false;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c>='A' && c<= 'Z') || (c>= 'a' && c<= 'z')
        || (c>='0' && c<='9');
    }
}
