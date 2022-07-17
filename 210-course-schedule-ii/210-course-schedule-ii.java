class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> []  adjList = new ArrayList[numCourses];
        int [] ans = new int[numCourses];
        for(int i = 0 ; i < adjList.length; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int [] pair : prerequisites){
            int course = pair[0];
            int preReq = pair[1];
            adjList[preReq].add(course);
        }
        
        return getCourseSchedule(adjList, numCourses);
    }
    
    int [] getCourseSchedule(ArrayList<Integer>[] adjList, int numCourses){
        int [] ans = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        boolean [] visiting = new boolean[numCourses];
        boolean [] finished = new boolean[numCourses];
        for(int i = 0 ; i < adjList.length; i++){
            if(!dfs(i, adjList, visiting, finished, st)) return new int[0];
        }
        for(int i = 0 ; i < numCourses; i++){
            ans[i] = st.pop();
        }
        return ans;
    }
    
    boolean dfs(int course, ArrayList<Integer>[] adjList,  boolean[] visiting, boolean [] finished , Stack<Integer> st){
        if(finished[course]) return true;
        if(visiting[course]) return false;
        
        visiting[course] = true;
        
        for(int i = 0 ; i < adjList[course].size(); i++){
            if(!dfs(adjList[course].get(i), adjList, visiting, finished, st)) return false;
        }
    
        visiting[course] = false;
        finished[course] = true;
        st.push(course);
        return true;
    }
    
    
}