import java.util.HashMap;

public class LC_VerifyAlienDictionary953 {

    private final HashMap<Character, Integer> orderMap = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        // initialize order map
        for (int i=0; i<order.length(); i++) {
            this.orderMap.put(order.charAt(i), i+1);
        }

        // compare
        for (int i=0; i< words.length-1; i++) {
            if(!areStringsSorted(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean areStringsSorted(String str1, String str2) {
        for (int i=0; i<Math.min(str1.length(), str2.length()); i++) {
            if(orderMap.get(str1.charAt(i)) > orderMap.get(str2.charAt(i))) {
                return false;
            } else if (orderMap.get(str1.charAt(i)) < orderMap.get(str2.charAt(i))) {
                return true;
            }
        }
        return str1.length() <= str2.length();
    }

    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        System.out.println(new LC_VerifyAlienDictionary953().isAlienSorted(words,"worldabcefghijkmnpqstuvxyz"));
    }
}
