import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">LC39. Combination Sum</a>
 */
public class CombinationSumLC39 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println(result);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        combinationSumBacktrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumBacktrack(int[] candidates, int target, int currentIndex, List<Integer> temp,
                                                List<List<Integer>> result) {
        //We probably have a solution or overshot the target.
        if (target <= 0) {
            //Yes we have a solution.
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        //We have visited all indexes.
        if (currentIndex > candidates.length - 1) {
            return;
        }

        temp.add(candidates[currentIndex]);
        combinationSumBacktrack(candidates, target - candidates[currentIndex], currentIndex, temp, result);
        temp.remove(temp.size() - 1);
        combinationSumBacktrack(candidates, target, currentIndex + 1, temp, result);

    }

}
