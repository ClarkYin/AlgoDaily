import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }


}

class Solution {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else stack.push(c);
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}