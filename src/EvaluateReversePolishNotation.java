import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            Integer integer = null;
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = s.pop();
                int b = s.pop();
                switch (token) {
                    case "+" :
                        integer = b+a;
                        break;
                    case "-" :
                        integer = b-a;
                        break;
                    case "*" :
                        integer = b*a;
                        break;
                    case "/" :
                        integer = b/a;
                        break;
                }
            } else {
                integer = Integer.parseInt(token);
            }
            s.add(integer);
        }
        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
