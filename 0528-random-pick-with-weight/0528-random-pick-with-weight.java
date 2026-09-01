class Solution {
          int pSum[];
    public Solution(int[] w) {
         pSum = new int[w.length];
        pSum[0] = w[0];

        for(int i=1;i<w.length;i++){
            pSum[i] = pSum[i-1]+w[i];
        }
    }
    
    public int Binarysearch(){
       int low = 0,
        high = pSum.length-1;

        double rand = Math.random();
        double target = rand*pSum[pSum.length-1];


        while(low < high){
            int mid = low + (high - low)/2;

            if(target <= pSum[mid]){
                high = mid;
            }else{
                low = mid+1;
            }

        }
        return low;
    }
    public int pickIndex() {
      return Binarysearch();   
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */