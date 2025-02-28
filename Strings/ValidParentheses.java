import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution obj = new Solution();
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
class Solution {
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