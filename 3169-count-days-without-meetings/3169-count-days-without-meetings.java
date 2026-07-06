class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int ans = 0;
        int last = 0;

        for(int[] current :meetings){
            if(current[0]>last){
                ans += current[0]-last-1;
            }
            last = Math.max(last,current[1]);
           
        }
        ans += days - last;
        return ans;
        
    }
}