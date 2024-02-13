import java.util.*;

public class Project {
    static ArrayList<String> stack = new ArrayList<String>();
    static String infix;
    static boolean donotcheckpriority = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your arithmetic expression in infix notation: ");
        infix = sc.nextLine();
        System.out.println("User entered expression is: " + infix);
        sc.close();
        postfix_expression(infix);
    }

    public static void postfix_expression(String infix) {
        Stack<Character> s = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();
        StringBuilder postfixWithoutZero = new StringBuilder();
        boolean lastWasOperatorOrParen = true;
        if(infix.charAt(0)=='-'){
            postfixWithoutZero.append('^');
            postfixWithoutZero.append(' ');
        }
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int numStart = i;
                while (i+1 < infix.length() && (Character.isDigit(infix.charAt(i+1)) || infix.charAt(i+1) == '.')) {
                    i++;
                }
                postfix.append(infix.substring(numStart, i+1)).append(' ');
                postfixWithoutZero.append(infix.substring(numStart, i+1)).append(' ');
                lastWasOperatorOrParen = false;
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                 if (c == '-' && lastWasOperatorOrParen) {
                    postfix.append('0').append(' ');
                    s.push('-');
                } 
                 else {
                    while (!s.isEmpty() && s.peek() != '(' &&
                           ((c == '+' || c == '-' || c == '^'|| c == '*' || c == '/') && (s.peek() == '+' || s.peek() == '-' || s.peek() == '*' || s.peek() == '/' || s.peek() == '^')) ||
                           ((c == ' ' ) && (s.peek() == ' ' ))) {
                        char op = s.pop();
                        postfix.append(op).append(' ');
                        if(infix.charAt(0)!='-'){
                        postfixWithoutZero.append(op).append(' ');
                        }
                        
                    }
                    s.push(c);
                }
                lastWasOperatorOrParen = true;
            } else if (c == '(') {
                s.push(c);
                lastWasOperatorOrParen = true;
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    char op = s.pop();
                    postfix.append(op).append(' ');
                    postfixWithoutZero.append(op).append(' ');
                }
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop();
                }
                lastWasOperatorOrParen = false;
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        while (!s.isEmpty()) {
            char op = s.pop();
            postfix.append(op).append(' ');
            postfixWithoutZero.append(op).append(' ');
        }
        System.out.println("Postfix notation: " + postfixWithoutZero.toString());
        postfix_expression_evaluation(postfix.toString());
    }

    public static void postfix_expression_evaluation(String postfix) {
        long result = 0;  // changed data type from int to long
        int twocompl=256;
        Stack<Long> stack = new Stack<Long>();  // changed data type from Integer to Long
        String[] tokens = postfix.split("\\s+");
        for (String token : tokens) {
            if (token.equals("+")) {
                long b = stack.pop();  // changed data type from int to long
                long a = stack.pop();  // changed data type from int to long
                long sum = a + b;
                long val=sum-twocompl;
                if ((sum < -128) || (sum > 127)) {
                    System.out.println("Overflow occurred by "+val);
                    
                    return;
                }
                stack.push(sum);
            } else if (token.equals("-")) {
                long b = stack.pop();  // changed data type from int to long
                long a = stack.pop();  // changed data type from int to long
                long diff = a - b;
                long val=(byte)(a-b);
                if (val<0){
                    val+=256;
                }
                if ((diff < -128) || (diff > 127)) {
                    System.out.println("Overflow occurred by "+val);
                    return;
                }
                stack.push(diff);
            } else if (token.equals("*")) {
                long b = stack.pop();  // changed data type from int to long
                long a = stack.pop();  // changed data type from int to long
                long mult = a * b;  // changed data type from int to long
                long val=((mult-128))%128;
                if (mult < -128 || mult > 127) {
                    System.out.println("Overflow occurred by"+val);
                    return;
                }
                stack.push(mult);
            } else if (token.equals("/")) {
                long b = stack.pop();  // changed data type from int to long
                long a = stack.pop();  // changed data type from int to long
                if (b == 0) {
                    System.out.println("Cannot divide by zero!");
                    return;
                }
                long quotient = a / b;  // changed data type from int to long
                stack.push(quotient);
            } else {
                // Parse integer values
                if (token.startsWith("-")) {
                    // Parse negative integer values using two's complement
                    String binary = token.substring(1);
                    String complement = "";
                    for (int i = 0; i < binary.length(); i++) {
                        complement += binary.charAt(i) == '0' ? '1' : '0';
                    }
                    long value = Long.parseLong(complement, 2) + 1;  // changed data type from int to long
                    stack.push(-value);
                } else {
                    stack.push(Long.parseLong(token));  // changed data type from int to long
                }
            }
        }
        result = stack.pop();
        if (!stack.isEmpty()) {
            System.out.println("Invalid expression!");
            return;
        }
        System.out.println("Result: " + result);
    }
    
}