/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">LC42. Trapping Rain Water</a>
 *
 */
public class TrappingRainWaterLC42 {

    public static void main(String[] args) {

        //int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{4,2,0,3,2,5};

        System.out.println(calculateWater(height));

    }

    private static int calculateWater(int[] height) {

        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        int arrayLength = height.length;

        maxLeftHeight[0] = 0;
        maxRightHeight[arrayLength-1] = 0;

        int maxOnLeftSoFar = height[0];
        int maxOnRightSoFar = height[arrayLength-1];
        for (int i=1; i<arrayLength; i++) {

            maxLeftHeight[i] = maxOnLeftSoFar;
            maxRightHeight[arrayLength-i] = maxOnRightSoFar;

            if (height[i] > maxOnLeftSoFar) {
                maxOnLeftSoFar = height[i];
            }

            if (height[arrayLength-i] > maxOnRightSoFar) {
                maxOnRightSoFar = height[arrayLength-i];
            }
        }

        int waterAmount = 0;

        for (int i=1; i<arrayLength-1; i++) {

            int tempWater = Math.min(maxLeftHeight[i], maxRightHeight[i]);
            if (tempWater - height[i] > 0) {
                waterAmount = waterAmount + (tempWater - height[i]);
            }

        }


        return waterAmount;
    }

}
