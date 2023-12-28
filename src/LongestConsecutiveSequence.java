import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int ans = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int start = i, currAns = 0;
                while (set.contains(start)) {
                    start++;
                    currAns++;
                }
                ans = Math.max(ans, currAns);
            }
        }
        return nums.length!=0 ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
