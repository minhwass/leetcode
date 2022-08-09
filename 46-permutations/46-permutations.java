class Solution {
    boolean [] used;
    List<List<Integer>> perms = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permute(nums, 0, new ArrayList<Integer>());
        return perms;
    }
    
    public void permute(int [] nums, int count, ArrayList<Integer> list){
        if(count >= nums.length){
            perms.add(new ArrayList<>(list));
        }else{
            for(int i = 0 ; i < nums.length; i++){
                if(!used[i]){
                     used[i] = true;
                    list.add(nums[i]);
                    permute(nums, count + 1, list);
                    list.remove(count);
                    used[i] = false;
                }
            }
        }
    }
}