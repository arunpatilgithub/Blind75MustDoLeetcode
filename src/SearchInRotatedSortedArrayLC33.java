/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">LC33. Search in Rotated Sorted Array</a>
 */
public class SearchInRotatedSortedArrayLC33 {

    public static void main(String[] args) {

        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {5, 1};
        //int[] nums = {5, 3};
        int[] nums = {1};
        int target = 3;

        System.out.println(search(nums, target));
    }

    private static int searchIterative(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (target >= nums[mid + 1] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

    private static int search(int[] nums, int target) {
        return searchRecursion(nums, 0, nums.length - 1, target);
    }

    private static int searchRecursion(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {

            if (target >= nums[left] && target <= nums[mid]) {
                right = mid - 1;
                return searchRecursion(nums, left, right, target);
            } else {
                left = mid + 1;
                return searchRecursion(nums, left, right, target);
            }

        } else {
            if (target >= nums[mid + 1] && target <= nums[right]) {
                left = mid + 1;
                return searchRecursion(nums, left, right, target);
            } else {
                right = mid - 1;
                return searchRecursion(nums, left, right, target);
            }
        }
    }

}
