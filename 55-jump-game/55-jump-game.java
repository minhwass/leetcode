class Solution {
    //greedy way 
    public boolean canJump(int[] nums) {
        int dest = nums.length-1; 
        for(int i = nums.length-2; i >= 0; i--){
            int dist = dest - i;
            if(nums[i] >= dist){
                dest = i;
            }
        }
        return dest == 0;
    }
    
    /*
    public boolean canJump(int[] nums) {
        int dest = nums.length-1;
        boolean [] memoCanVisit = new boolean[nums.length];
        Arrays.fill(memoCanVisit, true);
        return canJump(nums, memoCanVisit, 0, dest);
    }
    
    public boolean canJump(int [] nums, boolean [] memoCanVisit,  int start, int dest){
        if(start == dest) return true;
        if(!memoCanVisit[start]) return false;
        if(start > dest || nums[start] == 0){
            return memoCanVisit[start] = false;
        } 
        for(int i = 1; i <= nums[start]; i++){
            if(canJump(nums, memoCanVisit, start+i, dest)) return true;
        }
        return memoCanVisit[start] = false;
    }*/
}