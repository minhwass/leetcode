class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0 ; c < board[0].length; c++){
                if(board[r][c] == word.charAt(0)){
                    if(doSearch(board, word, 0, r, c)) return true;
                }
            }
        }
        return false;
            
    }
    
    public boolean doSearch(char [][] board, String word, int index, int row, int col){
        if(index >= word.length()){
            return true;
        }
        
        
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || !Character.isAlphabetic(board[row][col])) return false;
        
        if(word.charAt(index) == board[row][col]){
            
            board[row][col] = ' ';
            if
            (
            //check left
            doSearch(board, word, index+1, row, col-1) || 
            //check right
            doSearch(board, word, index+1, row, col+1) || 
            //check up
            doSearch(board, word, index+1, row-1, col) ||
            //check down
            doSearch(board, word, index+1, row+1, col)) return true;
            
            board[row][col] = word.charAt(index);
        }
        
        return false;
    }
}