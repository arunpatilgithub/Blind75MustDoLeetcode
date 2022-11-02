import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">
 * LC128. Longest Consecutive Sequence</a>
 */
public class LongestConsecutiveSequence128 {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        //int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {

        int maxLength = 0;
        Map<Integer, Boolean> elementToVisitedMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            elementToVisitedMap.put(nums[i], false);
        }

        for (int i = 0; i < nums.length; i++) {

            if (!elementToVisitedMap.get(nums[i])) {

                elementToVisitedMap.put(nums[i], true);
                int tempMaxLength = 1;

                int backWardDirection = nums[i] - 1;

                while (elementToVisitedMap.get(backWardDirection) != null &&
                        !elementToVisitedMap.get(backWardDirection) &&
                        tempMaxLength < nums.length) {
                    tempMaxLength++;
                    elementToVisitedMap.put(backWardDirection, true);
                    backWardDirection = backWardDirection - 1;
                }

                int forwardDirection = nums[i] + 1;

                while (elementToVisitedMap.get(forwardDirection) != null &&
                        !elementToVisitedMap.get(forwardDirection) && maxLength < nums.length) {
                    tempMaxLength++;
                    elementToVisitedMap.put(forwardDirection, true);
                    forwardDirection = forwardDirection + 1;
                }

                maxLength = Math.max(maxLength, tempMaxLength);

            }
        }

        return maxLength;

//        Stream.of(nums).collect(toMap(i -> i, i -> false));
//
//        Map<String, Double> kvs =
//                Arrays.asList("a:1.0", "b:2.0", "c:3.0")
//                      .stream()
//                      .map(elem -> elem.split(":"))
//                      .filter(elem -> elem.length == 2)
//                      .collect(Collectors.toMap(e -> e[0], e -> Double.parseDouble(e[1])));
    }

}
