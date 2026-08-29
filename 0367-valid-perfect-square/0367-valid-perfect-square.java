class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num/2;

        if(num==1){
            return true;
        }

        while(left<=right){
            int mid = left + (right - left)/2;

            if(mid * mid == num){
                return true;
            }
            if(mid < num/mid ){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        return false;
    }
}