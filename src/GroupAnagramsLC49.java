import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">LC49. Group Anagrams</a>
 */
public class GroupAnagramsLC49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupedAnagrams = groupAnagrams(strs);

        System.out.println(groupedAnagrams);

    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        Arrays.stream(strs).forEach(s -> {
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            anagramMap.computeIfAbsent(String.valueOf(cArray), k -> new ArrayList<>()).add(s);
        });

        return new ArrayList<>(anagramMap.values());
    }


}
