/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class Node {
        int t;
        boolean isStart;
        public Node (int t, boolean isStart) {
            this.t = t;
            this.isStart = isStart;
        }
    }
    
    class timeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.t == b.t) {
                return a.isStart ? 1 : -1;
            }
            return a.t - b.t;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Node> times = new ArrayList<>();
        for (Interval i : intervals) {
            times.add(new Node(i.start, true));
            times.add(new Node(i.end, false));
        }
        Collections.sort(times, new timeComparator());
        
        int ans = 0;
        int count = 0;
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).isStart) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}
