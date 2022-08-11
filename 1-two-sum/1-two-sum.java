class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key = number, value = index
        
        for(int i = 0 ; i < nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)) return new int[]{i, map.get(complement)};
            map.put(nums[i], i);
        }
        return new int[2];
    }
}