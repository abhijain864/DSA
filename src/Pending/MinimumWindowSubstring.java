package Pending;

import java.util.HashMap;

public class MinimumWindowSubstring {

    // Not done fully, on 28-12-2023, will do it later

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int minLengthTillNow = Integer.MAX_VALUE;
        int target = t.length();
        int noOfMatchedChars = 0;
        int start = 0, end=-1;
        while (end < s.length()) {
            while (end < s.length()-1 && noOfMatchedChars != target) {
                end++;
                Character c = s.charAt(end);
                if (sMap.containsKey(c)) {
                    noOfMatchedChars++;
                    if (!tMap.containsKey(c)) {
                        tMap.put(c, 1);
                    } else {
                        tMap.put(c, tMap.get(c)+1);
                    }
                }
            }

            while (start <= end && noOfMatchedChars == target ) {
                Character c = s.charAt(start);
                if (tMap.containsKey(c)) {
                    if (sMap.containsKey(c) && sMap.get(c) == tMap.get(c)) {
                        sMap.put(c, sMap.get(c)-1);
                        noOfMatchedChars--;
                    }
                }
                start++;
            }

            if (end - start + 1 < minLengthTillNow) {
                minLengthTillNow = end - start + 1;
            }

            if (end >= s.length()-1) {
                break;
            }
        }
        return "";
    }

}
