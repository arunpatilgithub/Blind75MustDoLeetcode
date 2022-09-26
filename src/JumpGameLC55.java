/**
 * <a href="https://leetcode.com/problems/jump-game/">LC55. Jump Game</a>
 */

public class JumpGameLC55 {

    public static void main(String[] args) {

        //int[] nums = {2,3,1,1,4};
        //int[] nums = {3,2,1,0,4};
        int[] nums = {0};

        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {

        int newTargetPosition = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= newTargetPosition) {
                newTargetPosition = i;
            }
        }

        //We reached starting position from the end.
        return newTargetPosition == 0;
    }
}
