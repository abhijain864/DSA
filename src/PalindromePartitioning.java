import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recurse(0, new ArrayList<>(), s.length(), s);
        return ans;
    }

    void recurse (int idx, List<String> currPartitions, int length, String s) {
        if (idx == length){
            ans.add(new ArrayList<>(currPartitions));
            return;
        }
        // Find all indices j, such that starting from idx till index j is a palindrome. For all such indices j, I need to make
        // recursive call for the remaining substring
        for (int j = idx ; j < length; j++) {
            if (isPalindrome(s, idx, j)) {
                currPartitions.add(s.substring(idx, j+1));
                recurse(j+1, currPartitions, length, s);
                currPartitions.remove(currPartitions.size()-1);
            }
        }

    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("a"));
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("abaaba"));
    }
}
