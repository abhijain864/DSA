package Pending;

public class LC_LongestMountainInArray {

    public int longestMountain(int[] arr) {
        int ans = 0, n = arr.length, start = 0, end;
        while (start < n) {
            end = start;
            if (arr[end+1] > arr[start]) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC_LongestMountainInArray().longestMountain(new int[]{2,2,2}));
        System.out.println("sdjnfjnjfn");
    }
}
