package niuke.双指针.bm89;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int index = 0;
        intervals.sort((o1, o2) -> o1.start-o2.start);
//        intervals.sort(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start-o2.start;
//            }
//        });
        while(index<intervals.size()-1){
            if(intervals.get(index).end>intervals.get(index+1).start){
                if(intervals.get(index).end<intervals.get(index+1).end){
                    intervals.get(index).end = intervals.get(index+1).end;
                    if(intervals.get(index).start>intervals.get(index+1).start)
                        intervals.get(index).start = intervals.get(index+1).start;
                    intervals.remove(index+1);
//                    ++index;
                    continue;
                }else{
                    if(intervals.get(index).start>intervals.get(index+1).start)
                        intervals.get(index).start = intervals.get(index+1).start;
                    intervals.remove(index+1);
//                    ++index;
                    continue;
                }
            }else{
                ++index;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        Interval interval = new Interval(1, 4);
        Interval interval1 = new Interval(0, 2);
        Interval interval2 = new Interval(3, 5);
//        Interval interval3 = new Interval(150, 180);
        Solution solution = new Solution();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval);
        list.add(interval1);
        list.add(interval2);
//        list.add(interval3);
        solution.merge(list);
    }
}
