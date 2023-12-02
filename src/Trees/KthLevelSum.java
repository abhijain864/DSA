package Trees;
/* BINARY TREE K LEVEL SUM */
public class KthLevelSum {

    public static void main(String[] args) {
        kLevelSum(2,"(0(5(6()())(4()(9()())))(7(1()())(3()())))");
    }

    static int kLevelSum(int K, String S) {
        int level = 0;
        int ans = 0;
        for (int i=1; i<S.length()-1; i++) {
            String str = "";
            while (S.charAt(i)!='(' && S.charAt(i)!=')') {
                str += S.charAt(i);
                i++;
            }
            if (!str.equals("") && (level == K)) {
                ans += Integer.parseInt(str);
            }
            if (S.charAt(i) == ')') level-=1;
            else if (S.charAt(i) == '(') level+=1;
        }
        return ans;
    }

}
