class Solution {
    public boolean isPossible(int[] nums, int k,int maxsum){
        int parts = 1;
        int currentSum = 0;

        for(int num: nums){
            if(currentSum+num>maxsum){
                parts++;
                currentSum = num;
            }
            else{
                currentSum += num;
            }
        }
        return parts<=k;
    }
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
         for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
         while (left < right) {

            int mid = left + (right - left) / 2;

            if (isPossible(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;



    }
}