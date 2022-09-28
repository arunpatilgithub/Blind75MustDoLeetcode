import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">LC57. Insert Interval</a>
 */

public class InsertInterval57 {

    public static void main(String[] args) {

        int[][] intervals = {{1,5}};
        int[] newInterval = {2,3};

        int[][] response = insert(intervals, newInterval);
        System.out.println(response);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        for (int i=0; i<intervals.length; i++) {

            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                newInterval = intervals[i];

            } else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

}
