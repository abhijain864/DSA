import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_AnagramsInString438 {

    public static void main(String[] args) {
        System.out.println(new LC_AnagramsInString438().findAnagrams("cbaebabacd","abc"));

    }

    public List<Integer> findAnagrams(String s, String p) {
        // ans list
        List<Integer> ans = new ArrayList<>();
        if (s.length()>=p.length()) {
            HashMap<Character, Integer> hashMapP = buildHashMap(p);
            HashMap<Character, Integer> hashMapS = buildHashMap(s.substring(0, p.length()));
            for(int i=0; i<=s.length()-p.length(); i++) {
                char c = s.charAt(i);
                if(i>0) {
                    char prevChar = s.charAt(i-1);
                    int freq = hashMapS.get(prevChar);

                    if(freq == 1){
                        hashMapS.remove(prevChar);
                    } else {
                        hashMapS.put(prevChar, freq-1);
                    }

                    char fdwChar = s.charAt(p.length()-1+i);
                    hashMapS.compute(fdwChar, (key, value) -> (value == null) ? 1 : value + 1);
                }
                if(hashMapS.equals(hashMapP)) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    private HashMap<Character, Integer> buildHashMap(String p) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            hashMap.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
        }
        return hashMap;
    }

}
