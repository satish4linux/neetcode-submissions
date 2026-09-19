class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        ArrayDeque<Character> adq = new ArrayDeque(s.length());
        for(Character c: s.toCharArray()) {
            Character peek = adq.peekFirst();
            if(peek != null && closesEachOther(peek,c)) {
                adq.pop();
            } else {
                adq.push(c);
            }
        }
        return adq.isEmpty();
    }
    private boolean closesEachOther(char a, char b) {
        return (a=='[' && b==']')||(a=='{' && b=='}')||(a=='(' && b==')');
    }
}
