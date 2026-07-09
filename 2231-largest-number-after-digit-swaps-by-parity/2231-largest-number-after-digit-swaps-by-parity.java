class Solution {
    public int largestInteger(int num) {

        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        String s = Integer.toString(num);

        for(char c : s.toCharArray()){
            int digit = c - '0';

            if(digit % 2==0){
                even.offer(digit);
            }
            else{
                odd.offer(digit);
            }
        }
        int ans = 0;

        for(char c : s.toCharArray()){
            int digit = c-'0';
            ans*= 10;

            if(digit % 2==0){
               ans+= even.poll();
            }
            else{
                ans += odd.poll();
            }
        }
        return ans;
        
    }
}