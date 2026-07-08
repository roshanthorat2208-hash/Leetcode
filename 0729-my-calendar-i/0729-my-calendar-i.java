class MyCalendar {
    List<int []>calender;

    public MyCalendar() {
        calender = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {

     for(int []interval : calender)
     {
        int s = interval[0];
        int e = interval[1];

        if(startTime<e && endTime>s){
            return false;
        }
        
        
     }
     calender.add(new int[]{startTime,endTime});
     return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */