import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">LC1. Two Sum</a>
 */
public class TwoSumLC1 {

    public static void main(String[] args) {

        //int[] nums = {2,7,11,15};
        //int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(getTwoSum(nums, target));

    }

    private static int[] getTwoSum(int[] nums, int target) {

        Map<Integer, Integer> positionMapping = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (positionMapping.containsKey(target - nums[i]) && i != positionMapping.get(target - nums[i])) {
                return new int[]{i, positionMapping.get(target - nums[i])};
            } else {
                positionMapping.put(nums[i], i);
            }
        }

        return new int[]{0, 0};
    }

}
