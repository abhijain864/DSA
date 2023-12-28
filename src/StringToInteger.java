public class StringToInteger {

    public int myAtoi(String s) {
        int ans = 0;
        boolean positive = true;
        int i= 0;
        // whitespace
        while (i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        // +/-
        if (i<s.length() && s.charAt(i) == '-') {
            positive = false;
            i++;
        } else if (i<s.length() && s.charAt(i) == '+') {
            i++;
        }
        // leading zeros
        while (i<s.length() && s.charAt(i) == '0') {
            i++;
        }
        // valid digits
        while (i<s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (ans > Integer.MAX_VALUE/10 ||
                    (ans == Integer.MAX_VALUE/10 && (digit > Integer.MAX_VALUE % 10))) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return positive ? ans: -1* ans;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi(""));
    }

}
