import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFG_PermutationsOfString {

    public static void main(String[] args) {
        new GFG_PermutationsOfString().find_permutation("ABCD");
    }

    public List<String> find_permutation(String S) {
        List<Character> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i=0; i<S.length(); i++) {
            list.add(S.charAt(i));
        }
        recurse("", list, ans);
        Collections.sort(ans);
        return ans;
    }

    public void recurse(String tillNow, List<Character> remaining, List<String> ans) {
        if (remaining.size()==0 && !ans.contains(tillNow)) {
            ans.add(tillNow);
            return;
        }
        for (int i=0; i<remaining.size(); i++) {
            Character remove = remaining.get(i);
            remaining.remove(i);
            recurse(tillNow + remove, remaining, ans);
            remaining.add(i,remove);
        }
    }
}
