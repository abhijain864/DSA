package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recurse(0, 0, "", n);
        return ans;
    }

    void recurse (int lc, int rc, String str, int n) {
        if (n==0) {
            if (lc == rc) {
                ans.add(str);
            }
            return;
        }
        recurse(lc+1, rc, str + "(", n-1);
        if (lc > rc) {
            recurse(lc, rc+1, str+")", n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(6));
    }


}
