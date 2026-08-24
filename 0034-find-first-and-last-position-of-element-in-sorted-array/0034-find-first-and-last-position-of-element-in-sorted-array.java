class Solution {
 public int[] searchRange(int[] nums, int target) {
        int firstIdx = firstOccurence(nums,target);
        if(firstIdx == -1){
            return new int[]{-1,-1};
        }
        int lastIdx = lastOccurence(nums,target);

        return new int[]{firstIdx,lastIdx};
    }
 public int firstOccurence(int []nums,int target ){
       int left = 0;
       int right = nums.length-1;
       int ans = -1;

       while(left<=right){
        int mid = left + (right - left)/2;
        if (nums[mid]==target){
           ans = mid ;
           right = mid - 1;
        }
        else if(target > nums[mid]){
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
        
       }
       return ans;
 }
 public int lastOccurence(int []nums,int target ){
       int left = 0;
       int right = nums.length-1;
       int ans = -1;

       while(left<=right){
        int mid = left + (right - left)/2;
        if (nums[mid]==target){
           ans = mid ;
           left = mid + 1;
        }
        else if(target > nums[mid]){
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
       
    }
    return ans;
 
}
}
