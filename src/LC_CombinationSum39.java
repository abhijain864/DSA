import java.util.*;

class LC_CombinationSum39 {
    /*
        WHAT IS THE TIME COMPLEXITY OF YOUR SOLUTION. PLEASE PONDER OVER IT FOR ONCE.
     */

    private int[] arr;

    private int target;

    private Set<List<Integer>> solutionArr = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        arr = candidates;
        this.target = target;
        List<Integer> freq = new ArrayList<>(Collections.nCopies(candidates.length, 0));
        giveList(freq, 0);
        return mapSolution();
    }

    private void giveList(List<Integer> freq, int runningSum) {
        if (runningSum == this.target) {
            solutionArr.add(new ArrayList<>(freq));
            return;
        } else if (runningSum > this.target) {
            return;
        }
        for(int i=0; i<arr.length ; i++) {
            freq.set(i, freq.get(i)+1);
            giveList(freq, runningSum + arr[i]);
            freq.set(i, freq.get(i)-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC_CombinationSum39().combinationSum(new int[]{2, 3, 5}, 8));
    }

    private List<List<Integer>> mapSolution() {
        List<List<Integer>> mappedSoln = new ArrayList<>();
        for (List<Integer> freqList : solutionArr) {
            List<Integer> listToAdd = new ArrayList<>();
            for (int i=0; i<freqList.size(); i++) {
                listToAdd.addAll(Collections.nCopies(freqList.get(i),arr[i]));
            }
            mappedSoln.add(listToAdd);
        }
        return mappedSoln;
    }


}