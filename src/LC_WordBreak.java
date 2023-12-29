import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC_WordBreak {

    public static void main(String[] args) {
        System.out.println(new LC_WordBreak().wordBreak("catsandog", new ArrayList<>(Arrays.asList("cat", "cats", "an", "dog"))));
        System.out.println(new LC_WordBreak().wordBreak("catsandog", new ArrayList<>(Arrays.asList( "catsan", "dog"))));
        System.out.println(new LC_WordBreak().wordBreak("catsandog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "og"))));
        System.out.println(new LC_WordBreak().wordBreak("catsandog", new ArrayList<>(Arrays.asList("cat", "cat", "and", "og"))));
    }

    // 1.............. plain recursion
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreak1(0, s, set);
    }
    boolean wordBreak1(int idx, String s, HashSet<String> wordDict) {
        if (idx == s.length()) return true;
        boolean flag = false;
        for (int i=idx; i<s.length(); i++) {
            String word = s.substring(idx, i+1);
            if (wordDict.contains(word)) {
                flag = flag || wordBreak1(i+1, s, wordDict);
            }
        }
        return flag;
    }



    // 2...............  memoized solution
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] isBreakable = new int[s.length()+1];
        Arrays.fill(isBreakable, -1);
        isBreakable[s.length()] = 1;
        return wordBreak(0, s, set, isBreakable);
    }

    boolean wordBreak(int idx, String s, HashSet<String> wordDict, int[] isBreakable) {
        if (isBreakable[idx]!=-1) {
            return isBreakable[idx] == 1;
        }
        boolean flag = false;
        for (int i=idx; i<s.length(); i++) {
            String word = s.substring(idx, i+1);
            if (wordDict.contains(word)) {
                flag = flag || wordBreak(i+1, s, wordDict, isBreakable);
            }
        }
        isBreakable[idx] = flag ? 1 : 0;
        return flag;
    }
}
