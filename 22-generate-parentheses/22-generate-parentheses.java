class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int fullLength = n + n;
        generate(fullLength, 0, n, n,  new char[fullLength]);
        return list;
    }
    
    void generate(int fullLength, int index, int openCount, int closeCount, char [] combination){
        if(index == fullLength){
            list.add(String.valueOf(combination));
            return;
        }
        
        if(openCount > 0){
                combination[index] = '(';
                generate(fullLength, index+1, openCount - 1, closeCount, combination);
        }
        
        if(openCount < closeCount){
            if(closeCount > 0){
                combination[index] = ')';
                generate(fullLength, index+1, openCount, closeCount -1, combination);
            }
        }
        
    }
}