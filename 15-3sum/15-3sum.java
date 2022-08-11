class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int cur = nums[i];
            int left = i+1; 
            int right = nums.length-1;
            int complement = 0 - nums[i];
            
            while(left < right){
                while(left < nums.length && left != i+1 && nums[left] == nums[left-1]) left++;
                while(right >= 0 && right < nums.length-1 && nums[right] == nums[right+1]) right--;
                if(left < right){
                     int twoSum = nums[left] + nums[right];
                    if(twoSum == complement){
                        ans.add(Arrays.asList(cur,nums[left], nums[right]));
                        left++;
                        right--;
                    }
                    else if (twoSum > complement) right--;
                    else left++;
                }
            }
        }
        return ans;
    }
}