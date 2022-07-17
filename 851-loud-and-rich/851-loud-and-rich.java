class Solution {
    ArrayList<Integer> [] graph;
    int [] ans;
    int [] quiet; 
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        graph = new ArrayList[N];
        ans = new int[N];
        this.quiet = quiet;
        
        for(int node = 0; node < N; ++node){
            graph[node] = new ArrayList<Integer>();
        }
        
        for(int [] edge : richer){
            graph[edge[1]].add(edge[0]);
        }
        
        Arrays.fill(ans, -1);
        
        for(int node = 0 ; node < N; node++){
            dfs(node);
        }
        return ans;
    }
    
    public int dfs(int node){
        if(ans[node] == -1){ //not visited yet
            ans[node] = node;
            for(int child: graph[node]){
                int cand = dfs(child);
                if(quiet[cand] < quiet[ans[node]])
                    ans[node] = cand;
            }
        }
        return ans[node];
    }
}