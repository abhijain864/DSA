import java.util.*;

public class Trying {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ans.add(new ArrayList<>(l));
        System.out.println(ans);
        l.add(6);
        System.out.println(ans);
    }

    public static void traverse(Integer b) {
        b+=2;
    }
}
