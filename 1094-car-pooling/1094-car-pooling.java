class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int diff[] = new int [1001];
        for(int []trip : trips){
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int passengers = 0;
        for(int i=0;i<=1000;i++){
            passengers += diff[i];

            if(passengers>capacity){
                return false;
            }
        }
        return true;
    }
}