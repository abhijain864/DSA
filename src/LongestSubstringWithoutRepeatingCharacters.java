import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static String string = "abcde";

    public static int count = 0;

    public static void main(String[] args) {
//        recurse(0, "");
//        System.out.println(count);

//        System.out.println(new LongestSubstringWithoutRepeatingCharacters().romanToInt("IXL"));
        int s = -374 / 10;
        System.out.println(s);
    }

    public static void recurse (int idx, String ans) {
        if (idx == string.length()) {
            System.out.println(ans);
            count++;
            return;
        }
        // not take it
        recurse(idx+1, ans );
        // take it
        recurse(idx+1, ans + string.charAt(idx));
    }

    public int romanToInt(String s) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        String match = "";
        for (int i=0; i<s.length(); ) {
            if (i+1 < s.length() && map.containsKey(match = s.charAt(i) + String.valueOf(s.charAt(i+1)))) {
                ans += map.get(match);
                i+=2;
            } else {
                switch (s.charAt(i)) {
                    case 'I':
                        ans+=1;
                        break;
                    case 'V':
                        ans+=5;
                        break;
                    case 'X':
                        ans+=10;
                        break;
                    case 'L':
                        ans+=50;
                        break;
                    case 'C':
                        ans+=100;
                        break;
                    case 'D':
                        ans+=500;
                        break;
                    case 'M':
                        ans+=1000;
                        break;
                }
                i++;
            }
        }
        return ans;
    }



}
