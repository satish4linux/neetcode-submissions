class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowCheck = new int[9];
        int[] colCheck = new int[9];
        Map<String,Integer> cellCheck = new HashMap();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) cellCheck.put(i+":"+j, 0);
        }
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    int mask = 1 << (Character.getNumericValue(board[i][j]) - 1);
                    // verify for rowCheck  
                    int rowSeen = rowCheck[i];
                    if((rowSeen & mask) !=0) return false;
                    else rowCheck[i] = rowSeen | mask;
                    // verify for colCheck
                    int colSeen = colCheck[j];
                    if((colSeen & mask) != 0) return false;
                    else colCheck[j] = colSeen | mask;
                    // verify for cellCheck
                    int cellI = i/3;
                    int cellJ = j/3;
                    int cellSeen = cellCheck.get(cellI+":"+cellJ);
                    if((cellSeen & mask) != 0) return false;
                    else cellCheck.put(cellI+":"+cellJ, cellSeen | mask);
                }
            }
        }
        return true;
    }
}
