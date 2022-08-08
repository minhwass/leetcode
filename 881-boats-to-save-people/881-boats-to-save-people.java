class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length-1;
        
        while(light <= heavy){
            ans++;
            if(people[light] + people[heavy] <= limit) light++;
            heavy--;
        }
        
        return ans;
        
    }
}