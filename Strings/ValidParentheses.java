import java.util.*;

//leetcode 20. Valid Parentheses
public class ValidParentheses {
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
        System.out.println("()");
        System.out.println(obj.isValid("()"));
        System.out.println("()[]{}");
        System.out.println(obj.isValid("()[]{}"));
        System.out.println("(]");
        System.out.println(obj.isValid("(]"));
        System.out.println("([])");
        System.out.println(obj.isValid("([])"));
    }
}
class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){

            switch(c){
                case ')' :
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                        break;
                    }else{
                        return false;
                    }
                case ']' :
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                        break;
                    }else{
                        return false;
                    }
                case '}' :
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                        break;
                    }else{
                        return false;
                    }
                default : 
                    stack.push(c);
            }

        }
        return stack.isEmpty() ? true : false;
    }
}

//using hashmap and stack
class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();        
    }
}