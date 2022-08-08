class Solution {
    private int minNum;
    
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        minNum = tasks.length;
        assign(new int[tasks.length], 0, tasks, tasks.length - 1, sessionTime);
        return minNum;
    }
    
    private void assign(int [] bins, int used, int [] tasks, int index, int capacity){
        if(used >= minNum) return;
        if(index < 0){
            minNum = used;
            return;
        }
     
        for(int i = 0 ; i < used ; i++){
            if(bins[i] + tasks[index] <= capacity){
                bins[i] += tasks[index];
                assign(bins, used, tasks, index -1, capacity);
                bins[i] -= tasks[index];
            }
        }
        bins[used] = tasks[index];
        assign(bins, used + 1, tasks, index - 1, capacity);
        bins[used] = 0;
    }
}