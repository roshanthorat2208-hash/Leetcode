class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();

        for(int[] current : intervals)
        {
            if(ans.isEmpty()){
                ans.add(current);
            }
            int[] last = ans.get(ans.size()-1);
            if(current[0]<=last[1]){
                last[1] = Math.max(last[1],current[1]);
            }
            else{
                ans.add(current);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}