class Solution {
    public int countHillValley(int[] nums) {
        int i = 1;
        int ans = 0;
        while(i<nums.length){
            int a = i-1;
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            if(i==nums.length-1) break;
            int b = i+1;
            ans+= ((nums[b]<nums[i] && nums[i]>nums[a])||(nums[b]>nums[i] && nums[i]<nums[a]))?1:0;
            i=b;
        }
        return ans;
    }
}
