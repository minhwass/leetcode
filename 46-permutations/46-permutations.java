class Solution {
   
    List<List<Integer>> permutations = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean [] used = new boolean[nums.length];
        permute(new ArrayList<Integer>(), nums, used, 0);
        return permutations;
    }
    
    public void permute(ArrayList<Integer> perm, int [] nums,  boolean [] used, int count){
        if(count == nums.length){
            permutations.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(!used[i]){
                perm.add(nums[i]);
                used[i] = true;
                permute(perm, nums, used, count+1);
                used[i] = false;
                perm.remove(count);
            }
        }
    }
    
    
}