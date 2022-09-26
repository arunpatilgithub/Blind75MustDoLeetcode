import java.util.*;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">LC56. Merge Intervals</a>
 */
public class MergeIntervalsLC56 {

    public static void main(String[] args) {

        //int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals={{1,4},{2,3}};
        int[][] output = merge(intervals);
        System.out.println(output);
    }

    private static int[][] merge(int[][] intervals) {

        //Sort by start time.
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<intervals.length; i++) {
            if (stack.empty()) {
                stack.push(intervals[i]);
            } else {
                int[] temp = stack.peek();
                if (intervals[i][0] >= temp[0] && intervals[i][0] <= temp[1]) {
                    stack.pop();
                    stack.push(new int[]{temp[0], Math.max(intervals[i][1], temp[1])});
                } else {
                    stack.push(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
        }

        int[][] result = new int[stack.size()][];
        for (int j=0; j<stack.size(); j++) {
            result[j] = stack.get(j);
        }

        return result;
    }

}
