class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        for(int count = 0 ; count <= nums.length; count++){
            backtrack(nums, count, 0, new ArrayList<>());
        }
        return ans;
    }
    
    void backtrack(int [] nums, int count ,int index, ArrayList<Integer> list){
        if(count == index){
            ans.add(new ArrayList<>(list));
        }else{
            for(int i = index ; i < nums.length; i++ ){
                list.add(nums[i]);
                backtrack(nums, count, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}