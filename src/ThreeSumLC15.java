import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/">LC15. 3 Sum</a>
 */
public class ThreeSumLC15 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {0, 1, 1};
        //int[] nums = {0, 0, 0, 0};

        List<List<Integer>> threeSum = threeSumArray(nums);
        System.out.println(threeSum);
    }

    //Mine
    private static List<List<Integer>> threeSumArray(int[] nums) {

        Arrays.sort(nums);
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }

        List<List<Integer>> threeSums = new ArrayList<>();
        for (int k = 1; k < nums.length; k++) {
            if (k == 0 || nums[k] != nums[k - 1]) {
                twoSumArray(nums, maps, k, -1 * nums[k], threeSums);
            }
        }

        return threeSums;
    }

    private static List<List<Integer>> twoSumArray(int[] nums, Map<Integer, Integer> maps, int start, int target,
                                                   List<List<Integer>> threeSums) {

        for (int j = start + 1; j < nums.length; j++) {

            if (j > start + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            Integer temp = maps.get(target - nums[j]);
            if (temp != null && temp > j) {
                List<Integer> tempList = Arrays.asList(-1 * target, target - nums[j], nums[j]);
                threeSums.add(tempList);
            }
        }

        return threeSums;
    }

    //Someone else's solution.
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }
        return new ArrayList<>(res);

    }

}
