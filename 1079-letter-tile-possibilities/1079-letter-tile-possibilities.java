class Solution {
    
    public int numTilePossibilities(String tiles) {
        int [] charCounts = new int[26];
        for(char c : tiles.toCharArray()){
            charCounts[c-'A']++;
        }
        return dfs(charCounts);
    }
    
    int dfs(int [] charCounts){
        int count = 0; 
        for(int i = 0 ; i < charCounts.length; i++){
            if(charCounts[i] > 0){
                count++;
                charCounts[i]--;
                count += dfs(charCounts);
                charCounts[i]++;
            }
        }
        return count;
    }
    
    
    /* level by level 
    Set<ArrayList<Character>> seqSet = new HashSet<>();
    
    public int numTilePossibilities(String tiles) {
        int maxLength = tiles.length();
        char [] chars = tiles.toCharArray();
        for(int i = 1; i <= maxLength; i++){
            makeCombinations(0, i, new ArrayList<Character>(), chars, new boolean[chars.length] );
        }
        return seqSet.size();
    }
    
    public void makeCombinations(int count, int seqLength, ArrayList<Character> seq, char [] chars, boolean [] used){
          //base case
        if(count == seqLength){
            seqSet.add(new ArrayList<>(seq));
        }else{
            for(int i = 0 ; i < chars.length; i++){
                if(!used[i]){
                    seq.add(chars[i]);
                    used[i] = true;
                    makeCombinations(count + 1, seqLength, seq, chars, used);
                    seq.remove(count);
                    used[i] = false;
                }
            
        }
    }*/
}