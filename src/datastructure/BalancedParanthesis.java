package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string:");
        String str = sc.nextLine();
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String s) throws Exception {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);

            } else if (stack.size() > 0 && (c == '}' && stack.peek() == '{')
                    || c == ']' && stack.peek() == '['
                    || c == ')' && stack.peek() == ')') {
                stack.pop();

            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }

}
