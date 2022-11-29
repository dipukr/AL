import java.io.*;
import java.util.*;

public class Paren {

	private static boolean left(char c) {return c=='('||c=='{'||c=='[';}
	private static boolean right(char c) {return c==')'||c=='}'||c==']';}

	private static boolean match(char a, char b) {
		switch (a) {
		case ')': return b == '(';
		case '}': return b == '{';
		case ']': return b == '[';
		}
		return false;
	}

	public static boolean valid(String input) {
		var stack = new Stack<Character>();
		for (char ch: input.toCharArray()) {
			if (left(ch)) stack.push(ch);
			else if (right(ch)) {
				if (stack.isEmpty() || !match(ch, stack.peek()))
					return false;
				else stack.pop();
			} else return false;
		}
		return stack.isEmpty();
	}

	public static void evaluate(String prefix) {
		Stack<Integer> stack;
		for (int i = prefix.length()-1; i >= 0; i--) {
			char ch = prefix.charAt(i);
			if (Character.isDigit(ch))
				stack.push(Integer.valueOf(ch));
			else if (ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			} else error("invalid prefix expression");
		}
	}

	public static void evaluate(String postfix) {
		Stack<Integer> stack;
		for (int i = 0; i < postfix.length(); i++) {
			char ch = prefix.charAt(i);
			if (Character.isDigit(ch))
				stack.push(Integer.valueOf(ch));
			else if (ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			} else error("invalid prefix expression");
		}
	}

	public static void main(String[] args) throws Exception
	{
		System.out.println(valid("(){}}"));
	}
}