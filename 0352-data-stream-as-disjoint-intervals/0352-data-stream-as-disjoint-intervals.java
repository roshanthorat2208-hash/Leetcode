class SummaryRanges {
      TreeMap<Integer, int[]> map;
    public SummaryRanges() {
         map = new TreeMap<>();
    }
    
    public void addNum(int value) {
     if (map.containsKey(value))
            return;

        Integer leftKey = map.floorKey(value);
        Integer rightKey = map.ceilingKey(value);

        
        if (leftKey != null && rightKey != null &&
            map.get(leftKey)[1] + 1 == value &&
            rightKey == value + 1) {

            map.get(leftKey)[1] = map.get(rightKey)[1];
            map.remove(rightKey);
        }

        
        else if (leftKey != null &&
                 map.get(leftKey)[1] + 1 >= value) {

            map.get(leftKey)[1] =
                Math.max(map.get(leftKey)[1], value);
        }

        
        else if (rightKey != null &&
                 rightKey == value + 1) {

            int[] interval = map.remove(rightKey);
            interval[0] = value;
            map.put(value, interval);
        }

       
        else {
            map.put(value, new int[]{value, value});
        }
    }
    
    
    
    public int[][] getIntervals() {
         return map.values().toArray(new int[map.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */