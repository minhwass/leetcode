class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        
        while(left < right){
            if(numbers[right] + numbers[left] == target) return new int[]{left +1 , right +1};
            else if (numbers[right] + numbers[left] > target ) right--;
            else{
                left++;
            }
        }
        return new int[2];
    }
}