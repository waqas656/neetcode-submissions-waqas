/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Map<Integer, Integer> changes = new TreeMap<>();

        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            if (changes.containsKey(start)) return false;
            changes.put(start, end);
        }

        int lastEnd = 0;
        for (Map.Entry<Integer, Integer> entry : changes.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();

            if (lastEnd > start) return false;
            else lastEnd = end;
        }

        return true;
    }
}
