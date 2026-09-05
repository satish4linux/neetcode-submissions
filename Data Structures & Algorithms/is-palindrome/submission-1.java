class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int h=s.length()-1;
        while(l< h) {
            while( l< h && !isAlphaNumeric(s.charAt(l))) l++;
            while( h>l && !isAlphaNumeric(s.charAt(h))) h--;
            if(Character.toLowerCase(s.charAt(l++)) != 
            Character.toLowerCase(s.charAt(h--))) return false;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c>='A' && c<= 'Z') || (c>= 'a' && c<= 'z')
        || (c>='0' && c<='9');
    }
}
